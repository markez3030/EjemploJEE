package com.ipartek.formacion.utilidades;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VehiculoDB extends AccesoBD {

	
	
	
	public static void insertarVehiculo(String sql,String modelo,int plazas,int potencia,int dimensiones) throws SQLException {
		statement = con.prepareStatement(sql);
		statement.setString(1, modelo);
		statement.setInt(2, plazas);
		statement.setInt(3, potencia);
		statement.setInt(4, dimensiones);
		statement.executeUpdate();
	}
	
	public static void  deleteVehiculo(String sql,int id) throws SQLException {
		statement = con.prepareStatement(sql);
		statement.setInt(1, id);
		statement.executeUpdate();

	}
	
	public static ResultSet buscarUnCoche(String sql,int id) throws SQLException {
		ResultSet rs = null;
		statement =  con.prepareStatement(sql);
		statement.setInt(1, id);
		rs = statement.executeQuery();
		return rs;

	}
	
	public static void modificarVehiculo(String sql,String modelo,int plazas,int potencia,int dimensiones,int id) throws SQLException {
		// TODO Auto-generated method stub
		statement =  con.prepareStatement(sql);
		statement.setString(1, modelo);
		statement.setInt(2, plazas);
		statement.setInt(3, potencia);
		statement.setInt(4, dimensiones);
		statement.setInt(5, id);
		statement.executeUpdate();
	}
}
