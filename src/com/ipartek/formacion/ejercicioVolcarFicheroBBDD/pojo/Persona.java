package com.ipartek.formacion.ejercicioVolcarFicheroBBDD.pojo;

public class Persona {
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private String email;
	private String dni;
	private String tipo;
	private String descripcionFallido;
	
	
	public Persona(String nombre, String apellido1, String apellido2, int edad, String email, String dni, String tipo) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.email = email;
		this.dni = dni;
		this.tipo = tipo;
	}
	
	public Persona(String nombre, String apellido1, String apellido2, int edad, String email, String dni, String tipo,String descripcion) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.email = email;
		this.dni = dni;
		this.tipo = tipo;
		this.setDescripcionFallido(descripcion);
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}





	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getApellido1() {
		return apellido1;
	}



	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}



	public String getApellido2() {
		return apellido2;
	}



	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDescripcionFallido() {
		return descripcionFallido;
	}

	public void setDescripcionFallido(String descripcionFallido) {
		this.descripcionFallido = descripcionFallido;
	}
	
	
	
}
