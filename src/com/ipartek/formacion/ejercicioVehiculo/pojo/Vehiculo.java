package com.ipartek.formacion.ejercicioVehiculo.pojo;

import java.io.Serializable;

import com.ipartek.formacion.ejercicioVehiculo.exception.NumeroNegativoException;

public class Vehiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int numero_coches=0;
	private float id;
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
		numero_coches+=1;
		this.setId(numero_coches);
	}

	public Vehiculo(String modelo) {
		super();
		this.modelo = modelo;
		numero_coches=numero_coches+1;
		this.setId(numero_coches);
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

	
	public static int getNumero_coches() {
		return numero_coches;
	}

	public static void setNumero_coches(int numero_coches) {
		Vehiculo.numero_coches = numero_coches;
	}
	

	public float getId() {
		return id;
	}

	public void setId(float id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Vehiculo [modelo=" + modelo + ", plazas=" + plazas + ", dimensiones=" + dimensiones + ", potencia="
				+ potencia + "]";
	}

}
