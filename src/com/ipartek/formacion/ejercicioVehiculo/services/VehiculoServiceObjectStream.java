package com.ipartek.formacion.ejercicioVehiculo.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.ipartek.formacion.ejercicioVehiculo.pojo.Vehiculo;

public class VehiculoServiceObjectStream implements ServiceVehiculo {

	// TODO patron singleton
	// TODO cuidado hay que comprobar que el fichero existe, si no existe
	// crearlo
	// TODO Path relativo al proyecto
	public static final String PATH_DIRECTORIO = "C:\\Desarrollo\\workspace\\EjemploJEE\\data\\";
	public static final String PATH_FICHERO = "vehiculo.txt";
	public static final String PATH = PATH_DIRECTORIO + PATH_FICHERO;
	private static VehiculoServiceObjectStream INSTANCE;
	static File archivo = new File(PATH);
	static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VehiculoServiceObjectStream();
		}
	}

	public static VehiculoServiceObjectStream getInstance() {
		if (INSTANCE == null) {
			createInstance();
			chekear();
		}
		return INSTANCE;
	}

	public static void chekear() {

		try {
			if (archivo.exists()) {

			} else {

				File f2 = new File(PATH_DIRECTORIO);
				f2.mkdirs();
				new File(PATH_FICHERO);
				// create a new file with an ObjectOutputStream
				FileOutputStream out = new FileOutputStream(PATH);
				ObjectOutputStream oout = new ObjectOutputStream(out);

				vehiculos.add(new Vehiculo("Seat Panda"));
				vehiculos.add(new Vehiculo("Lamborghini"));
				vehiculos.add(new Vehiculo("Ford K2"));
				vehiculos.add(new Vehiculo("Citroen Xsara"));
				vehiculos.add(new Vehiculo("Ferrari"));
				vehiculos.add(new Vehiculo("Tesla"));

				for (Vehiculo v : vehiculos) {
					oout.writeObject(v);
				}
				oout.writeObject(null);
				oout.close();

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	@Override
	public ArrayList<Vehiculo> getAll() {
		vehiculos.clear();
		try {

			FileInputStream fis = new FileInputStream(PATH);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object objeto;

			while ((objeto = ois.readObject()) != null) {
				vehiculos.add((Vehiculo) objeto);
			}

			ois.close();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehiculos;
	}

	@Override
	public Vehiculo getById(long id) {
		Vehiculo v = null;
		try {

			Object objeto;
			FileInputStream fis = new FileInputStream(PATH);
			ObjectInputStream ois = new ObjectInputStream(fis);

			while ((objeto = ois.readObject()) != null) {
				v = (Vehiculo) objeto;
				if (v.getId() == id) {
					break;
				}
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return v;
	}

	@Override
	public boolean removeVehiculo(long id) {
		boolean resul = false;
		for (Vehiculo v : vehiculos) {
			if (v.getId() == id) {

				archivo.delete();
				vehiculos.remove(v);

				escribir();
				resul = true;
				break;

			}
		}

		return resul;
	}

	@Override
	public boolean update(Vehiculo v) {
		boolean resul = false;
		for (Vehiculo v1 : vehiculos) {
			if (v.getId() == v1.getId()) {
				archivo.delete();
				int posicion = vehiculos.indexOf(v1);
				vehiculos.remove(v1);
				vehiculos.add(posicion, v);
				escribir();
				resul = true;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean createVehiculo(Vehiculo v) {
		boolean resul = false;
		archivo.delete();
		v.setId(vehiculos.size() + 1);
		vehiculos.add(v);

		try {

			archivo = new File(PATH);
			FileOutputStream out = new FileOutputStream(PATH);
			ObjectOutputStream oout = new ObjectOutputStream(out);

			for (Vehiculo v1 : vehiculos) {
				oout.writeObject(v1);
			}
			oout.writeObject(null);
			oout.flush();

			resul = true;

		} catch (Exception e) {

		}

		return resul;
	}

	public void escribir() {
		try {
			archivo = new File(PATH);
			FileOutputStream out = new FileOutputStream(PATH);
			ObjectOutputStream oout = new ObjectOutputStream(out);

			for (Vehiculo v2 : vehiculos) {
				oout.writeObject(v2);
			}
			oout.writeObject(null);
			oout.flush();

		} catch (IOException e) {

		}
	}

}
