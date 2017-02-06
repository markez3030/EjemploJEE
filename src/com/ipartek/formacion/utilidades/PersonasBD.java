package com.ipartek.formacion.utilidades;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.BBDD.DataBaseConnectionImp;

public class PersonasBD extends DataBaseConnectionImp {
	
	
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

	public static ResultSet selectAll(String sql) throws SQLException {
		// TODO Auto-generated method stub
		statement =  con.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		return rs;
	}

	public static int  deleteAll() throws SQLException {
		statement = con.prepareStatement("DELETE FROM persona WHERE 1");
		int row= statement.executeUpdate();
		return row;

	}

}
