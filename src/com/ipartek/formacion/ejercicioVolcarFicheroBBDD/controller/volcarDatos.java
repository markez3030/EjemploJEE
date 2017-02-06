package com.ipartek.formacion.ejercicioVolcarFicheroBBDD.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.BBDD.DataBaseConnectionImp;
import com.ipartek.formacion.ejercicioVolcarFicheroBBDD.pojo.Persona;
import com.ipartek.formacion.utilidades.PersonasBD;
import com.ipartek.formacion.utilidades.VehiculoDB;

/**
 * Servlet implementation class volcarDatos
 */
@WebServlet("/ejercicioVolcarDatos/volcarDatos")
public class volcarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String PATH_DIRECTORIO_PERSONAS = "C:\\Desarrollo\\workspace\\EjemploJEE\\data\\personas.txt";

	public static final String PATH_DIRECTORIO_INCORRECTO = "C:\\Desarrollo\\workspace\\EjemploJEE\\WebContent\\data\\personasIncorrecto.txt";

	public static final String UBICACION_RELATIVA_FICHERO= "data/personasIncorrecto.txt";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public volcarDatos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if (request.getParameter("op") != null) {
				if (request.getParameter("op").equals("2")) {
						request.setAttribute("exito", "Consulta realizada con exito");
						request.setAttribute("ficheroIncorrecto", UBICACION_RELATIVA_FICHERO);
				}
				if (request.getParameter("op").equals("3")) {
				
						DataBaseConnectionImp.establecerConexion("concesionario", "root", "");
						if (PersonasBD.deleteAll() != 0) {
							File f = new File(PATH_DIRECTORIO_INCORRECTO);
							f.delete();
							request.setAttribute("exito", "La tabla ha sido borrada. ficheroIncorrecto.txt borrado");
						}
						DataBaseConnectionImp.cerrarConexion();
				}
			}
			request.setAttribute("listaPersonas", selectListaPersonas());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "No se pudo realizar la consulta");
		}
		finally{
			request.getRequestDispatcher("/ejercicioVolcadoFicheroABBDD/indexVolcado.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// VARIABLES
		long TInicio, TFin, tiempo;
		TInicio = System.currentTimeMillis();
		// Contador de registros añadidosCorrectamente
		int contadorCorrecto = 0;
		// Lista en la que se añadiran los registros que por algun motivo sean
		// incorrectos
		ArrayList<String> listIncorrectos = new ArrayList<String>();
		try {
			// Establecemos la conexion con la BBDD concesionario
			DataBaseConnectionImp.establecerConexion("concesionario", "root", "");
			// Poner Autocommit a false
			DataBaseConnectionImp.getCon().setAutoCommit(false);
			// En este metodo se realiza el proceso de migracion
			contadorCorrecto = migracionTXTaBBDD(listIncorrectos);
			// lanzamos toda las querys que se han realizado desde que se ha
			// echo
			// AccesoBD.getCon().setAutoCommit(false);
			DataBaseConnectionImp.getCon().commit();
			// SI SE HA REALIZADO EL COMIT
			// 1.-Caluclamos el tiempo que ha tardado en hacer el proceso
			TFin = System.currentTimeMillis();
			tiempo = (int) (TFin - TInicio) / 1000;
			// 2.-Llamamos la metodo
			// escribirIncorrectosEnFichero(listIncorrectos);
			// Coge la lista de registros incorrectos y la añade a un
			// fichero.
			escribirIncorrectosEnFichero(listIncorrectos);

			// 3.-Una vez que se han realizado todas las operaciones se
			// añaden los parametros que
			// Se quieren mostrar en la jsp
			request.setAttribute("tiempo", tiempo);
			request.setAttribute("registrosCorrectos", contadorCorrecto);
			request.setAttribute("registrosIncorrectos", listIncorrectos.size());
			request.setAttribute("ficheroIncorrecto", UBICACION_RELATIVA_FICHERO);
			request.setAttribute("exito", "El volcado se ha realizado correctamente.<br/>Creado:ficheroIncorrecto.txt");

		} catch (SQLException e) {
			if (DataBaseConnectionImp.getCon() != null) {
				// En caso de Fallo
				try {
					DataBaseConnectionImp.getCon().rollback();
					request.setAttribute("error", "No se han podido añadir todos los registros.(ROLLBACK)");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					request.setAttribute("error", "Conexion cerrada");
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "No se han podido establecer la conexion a la base de datos");
		} finally {
			try {
				// Intentamos cerrar la conexion
				if (DataBaseConnectionImp.getCon() != null && !DataBaseConnectionImp.getCon().isClosed()) {
					DataBaseConnectionImp.cerrarConexion();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				request.setAttribute("error", "No se han cerrar la conexion");
			} finally {
				// Una vez se haya realizado todo el proceso(falle o no),
				// volvemos a indexVolcado.jsp
				request.getRequestDispatcher("/ejercicioVolcadoFicheroABBDD/indexVolcado.jsp").forward(request,
						response);
			}
		}
	}

	/**
	 * Metodo que recibe una lista de mensajes y lo añade a un directorio para
	 * mostrar los registros que han sido incorrectos en la migracion deseada
	 * 
	 * @param listIncorrectos
	 *            lista de <{@code String} que contiene los mensajes incorrectos
	 */
	private void escribirIncorrectosEnFichero(ArrayList<String> listIncorrectos) {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(PATH_DIRECTORIO_INCORRECTO);
			bw = new BufferedWriter(fw);
			for (String motivo : listIncorrectos) {
				bw.write(motivo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

			}
		}
	}

	/**
	 * Metodo que añade a una BBDD los datos de un .txt. Recibe una lista en la
	 * que se insertara el motivo por el cual no se puede añadir el registro(NO
	 * HACE FALTA DEVOLVERLO.REFERENCIA) y devuelve el contador de registros
	 * añadidos correctamente.
	 *
	 * @param listIncorrectos
	 *            lista que contiene los mensajes de registro incorrectos
	 * @return contadorCorrecto (contador de registros que se han añadido
	 *         correctamente)
	 * @throws NumberFormatException
	 * @throws SQLException
	 * @throws IOException
	 */
	private int migracionTXTaBBDD(ArrayList<String> listIncorrectos)
			throws NumberFormatException, SQLException, IOException {
		// TODO Auto-generated method stub
		int contadorCorrecto = 0;
		// realizar proceso de migración
		String contenidoFichero = null;
		// Procedemos a leer el fichero personas.tx
		BufferedReader br = new BufferedReader(new FileReader(PATH_DIRECTORIO_PERSONAS));
		while ((contenidoFichero = br.readLine()) != null) {
			String[] aDatos = contenidoFichero.split(",");
			// Si tiene 7 campos: Correcto
			if (aDatos.length == 7) {
				// Si tiene la longitud del DNI correcto(Añadimos)-->Todos los
				// casos de error superados
				// Añadimos uno al contador de registros correctos
				if (aDatos[5].length() == 9) {
					PersonasBD.insertarPersona(
							"INSERT INTO  persona (nombre,apellido1,apellido2,edad,email,dni,puesto) "
									+ "VALUES(?,?,?,?,?,?,?)",
							aDatos[0], aDatos[1], aDatos[2], Integer.parseInt(aDatos[3]), aDatos[4], aDatos[5],
							aDatos[6]);
					contadorCorrecto++;
					// El DNI esta mal introducido
				} else {
					listIncorrectos.add(contenidoFichero + "--> El DNI tiene una longitud incorrecta\n");
				}
				// Si no tiene 7 campos: Incorrecto(Estructura incorrecta)
			} else {
				listIncorrectos.add(contenidoFichero + "--> El registo no tiene una estructura correcta\n");
			}
		}
		return contadorCorrecto;
	}

	private ArrayList<Persona> selectListaPersonas() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		DataBaseConnectionImp.establecerConexion("concesionario", "root", "");
		ArrayList<Persona> listPersona = new ArrayList<Persona>();
		ResultSet rs = PersonasBD.selectAll("SELECT * FROM persona");
		Persona p;
		while (rs.next()) {
			p = new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getString(6), rs.getString(7), rs.getString(8));
			listPersona.add(p);
			if (listPersona.size() == 500)
				break;
		}
		DataBaseConnectionImp.cerrarConexion();
		return listPersona;
	}
}
