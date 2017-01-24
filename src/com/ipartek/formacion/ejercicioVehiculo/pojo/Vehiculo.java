package com.ipartek.formacion.ejercicioVehiculo.pojo;

import com.ipartek.formacion.ejercicioVehiculo.exception.NumeroNegativoException;

public class Vehiculo {

	private String modelo;
	private int plazas;
	private float dimensiones;
	private float potencia;

	public Vehiculo() {
		super();
		this.modelo = "";
		this.plazas = 1;
		this.dimensiones = 0;
		this.potencia = 100;
	}

	public Vehiculo(String modelo) {
		this();
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) throws NumeroNegativoException {
		if(plazas<2)
			throw new NumeroNegativoException("El numero de plazas tiene que ser mayor que 2");
		else
		this.plazas = plazas;
	}

	public float getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(float dimensiones) throws NumeroNegativoException {
		if(dimensiones<0)
			throw new NumeroNegativoException("La dimension que ser mayor que 0");
		else
			this.dimensiones = dimensiones;
	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) throws NumeroNegativoException {
		if(potencia<0)
			throw new NumeroNegativoException("La potencia tiene que ser mayor que 0");
		else
			this.potencia = potencia;
	}

	@Override
	public String toString() {
		return "Vehiculo [modelo=" + modelo + ", plazas=" + plazas + ", dimensiones=" + dimensiones + ", potencia="
				+ potencia + "]";
	}

	

}
