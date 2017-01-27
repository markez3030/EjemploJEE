package com.ipartek.formacion.ejercicioVehiculo.services;

import java.util.ArrayList;

import com.ipartek.formacion.ejercicioVehiculo.pojo.Vehiculo;

public class VehiculoDao implements ServiceVehiculo {

	private static VehiculoDao INSTANCE;
	private static ArrayList<Vehiculo> vehiculos = null;
	// simular el indice en la BaseDatos

	// Private constructor suppresses
	private VehiculoDao() {

		vehiculos = new ArrayList<Vehiculo>();
		vehiculos.add(new Vehiculo("Seat Panda"));
		vehiculos.add(new Vehiculo("Lamborgini"));
		vehiculos.add(new Vehiculo("Ford K2"));
		vehiculos.add(new Vehiculo("Citoren Shara"));
		vehiculos.add(new Vehiculo("Ferrari"));
		vehiculos.add(new Vehiculo("Tesla"));

	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VehiculoDao();
		}
	}

	public static VehiculoDao getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	@Override
	public ArrayList<Vehiculo> getAll() {
		return this.vehiculos;
	}

	@Override
	public Vehiculo getById(long id) {
		Vehiculo resul = null;
		for (Vehiculo v : vehiculos) {
			if (id == v.getId()) {
				resul = v;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean removeVehiculo(long id) {
		boolean resul = false;
		for (Vehiculo v : vehiculos) {
			if (id == v.getId()) {
				resul = true;
				vehiculos.remove(v);
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean update(Vehiculo vModificar) {
		boolean resul = false;
		for (Vehiculo v : vehiculos) {
			if (vModificar.getId() == v.getId()) {
				resul = true;
				int pos = vehiculos.indexOf(v);
				vehiculos.remove(v);
				vehiculos.add(pos, vModificar);
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean createVehiculo(Vehiculo v) {
		return vehiculos.add(v);
	}

}
