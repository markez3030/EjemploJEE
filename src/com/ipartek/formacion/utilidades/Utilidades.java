package com.ipartek.formacion.utilidades;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.ipartek.formacion.ejercicioVehiculo.pojo.Vehiculo;

public class Utilidades implements Serializable {

	private static final long serialVersionUID = 1L;

	
	public static void escribirEnFichero(String file, Object o) throws IOException {
		// create a new file with an ObjectOutputStream
		FileOutputStream out = new FileOutputStream(file);
		ObjectOutputStream ois=new ObjectOutputStream(out);
		ois.writeObject(o);
		ois.close();
		

	}

	public static ArrayList<Vehiculo> leerDeFichero(String file) throws ClassNotFoundException, IOException {
		FileInputStream istream = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(istream);
		ArrayList<Vehiculo> list = new ArrayList<Vehiculo>();
		try {
			while(true) {
				list.add((Vehiculo)ois.readObject());
			}
		} catch (EOFException e) {
			ois.close();
			return list;
		}
	}
}
