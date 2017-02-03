package com.ipartek.formacion.utilidades;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoBD {
	static final int MYSQL = 1;
	static final int ACCESS = 2;
	static final int ORACLE = 3;
	public static final String DRIVER_GEN = "sun.jdbc.odbc.JdbcOdbcDriver";
	public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	public static final String DRIVER_ORACLE = "oracle.jdbc.driver.oracledriver";

	protected static Connection con = null;
	protected static PreparedStatement statement;

	/**
	 * Mtodo que establecel a conexin con la base de datos Permite conectar con
	 * cualquier tipo de base de datos
	 * 
	 * @param tipoBBDD =1(TRABAJAMOS CON MYSQL)
	 * @param url nombre de la base de datos
	 * @param usu usuario de la BBDD
	 * @param pass contraseña del usuario de la BBDD
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void establecerConexion(String url,String usuario,String password) throws ClassNotFoundException, SQLException {
		// En caso que el tipo de BBDD seleccionado sea distinto de los
		// establecidos,
		// se utilizar por defecto MYSQL.
		int tipoBBDD = 1;
		String ruta = "localhost:3306/"+url;
		String usu = usuario;
		String pass = password;

		switch (tipoBBDD) {
		case MYSQL:
			// -->Cadena de conexiï¿½n de MYSQL
			Class.forName(DRIVER_MYSQL);
			con = DriverManager.getConnection("jdbc:mysql://"+ruta, usu, pass);

			break;
		case ACCESS:
			// -->Cadena de conexin de ACCESS
			Class.forName(DRIVER_GEN);
			con = DriverManager.getConnection(
					"jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; " + "DBQ=" + ruta, usu, pass);
			break;
		case ORACLE:
			// -->Cadena de conexin de ORACLE
			Class.forName(DRIVER_ORACLE);
			con = DriverManager.getConnection("jdbc:oracle:thin:@//" + ruta, usu, pass);
			break;
		default:
			// Cadena de conexin de MYSQL
			Class.forName(DRIVER_MYSQL);
			con = DriverManager.getConnection("jdbc:mysql://" + ruta, usu, pass);
			break;
		}
	}

	public static void cerrarConexion() throws SQLException {
			con.close();
	}

	public static ResultSet lanzarSelect(String sql) throws SQLException {
		ResultSet rs = null;
		statement =  con.prepareStatement(sql);
		rs = statement.executeQuery();
		return rs;

	}

	public static void insertarQuery(String sql) throws SQLException {
		statement = con.prepareStatement(sql);
		statement.executeUpdate();
	}

	public static void modificarQuery(String sql) throws SQLException {
		// TODO Auto-generated method stub
		statement = con.prepareStatement(sql);
		statement.executeUpdate();
	}

	public static void borrarQuery(String sql) throws SQLException {
		// TODO Auto-generated method stub
		statement = con.prepareStatement(sql);
		statement.executeUpdate();
	}


	public static Connection getCon() {
		return con;
	}

}
