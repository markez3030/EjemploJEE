package com.ipartek.formacion.ejercicioVehiculo.pojo;


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

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public float getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(float dimensiones) {
		this.dimensiones = dimensiones;
	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return "Vehiculo [modelo=" + modelo + ", plazas=" + plazas + ", dimensiones=" + dimensiones + ", potencia="
				+ potencia + "]";
	}

	

}
