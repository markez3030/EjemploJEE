package com.ipartek.formacion.ejercicioVehiculo.services;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.ejercicioVehiculo.exception.NumeroNegativoException;
import com.ipartek.formacion.ejercicioVehiculo.pojo.Vehiculo;


public interface ServiceVehiculo {

	public ArrayList<Vehiculo> getAll();
	
	public Vehiculo getById(long id);
	
	public boolean createVehiculo(Vehiculo vehiculo);
	
	public boolean removeVehiculo(long id);
	
	public boolean update(Vehiculo vehiculo) throws NumeroNegativoException ;
}
