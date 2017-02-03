package com.ipartek.formacion.utilidades;

import java.sql.SQLException;

public class PersonasBD extends AccesoBD {
	
	
	public static void insertarPersona(String sql,String nombre,String ape1,String ape2,
			int edad,String email,String dni,String puesto ) throws SQLException{
		statement = con.prepareStatement(sql);
		statement.setString(1, nombre);
		statement.setString(2, ape1);
		statement.setString(3, ape2);
		statement.setInt(4, edad);
		statement.setString(5, email);
		statement.setString(6, dni);
		statement.setString(7, puesto);
		statement.executeUpdate();
	}

}
