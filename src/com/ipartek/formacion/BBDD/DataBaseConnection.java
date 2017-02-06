package com.ipartek.formacion.BBDD;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataBaseConnection {

	public static void establecerConexion(String url,String usuario,String password) throws ClassNotFoundException, SQLException {
	}

	public static void cerrarConexion() throws SQLException {
	}

	public static Connection getCon() {
		return null;
	}

}
