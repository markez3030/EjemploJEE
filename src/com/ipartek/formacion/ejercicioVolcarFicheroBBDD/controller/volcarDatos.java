package com.ipartek.formacion.ejercicioVolcarFicheroBBDD.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.utilidades.AccesoBD;
import com.ipartek.formacion.utilidades.PersonasBD;

/**
 * Servlet implementation class volcarDatos
 */
@WebServlet("/ejercicioVolcarDatos/volcarDatos")
public class volcarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String PATH_DIRECTORIO_PERSONAS = "C:\\Desarrollo\\workspace\\EjemploJEE\\data\\personas.txt";

	public static final String PATH_DIRECTORIO_INCORRECTO = "C:\\Desarrollo\\workspace\\EjemploJEE\\data\\personasIncorrecto.txt";

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
		// VARIABLES
		long TInicio, TFin, tiempo;
		TInicio = System.currentTimeMillis();
		int contadorCorrecto = 0;
		int contadorIncorrecto = 0;
		ArrayList<String> listIncorrectos = new ArrayList<String>();
		try {
			AccesoBD.establecerConexion("concesionario", "root", "");
			// Poner Autocommit a false
			AccesoBD.getCon().setAutoCommit(false);
			// realizar proceso de migración
			String contenidoFichero = null;
			BufferedReader br = new BufferedReader(new FileReader(PATH_DIRECTORIO_PERSONAS));
			while ((contenidoFichero = br.readLine()) != null) {
				String[] aDatos = contenidoFichero.split(",");
				if (aDatos.length == 7) {
					if (aDatos[5].length() == 9) {
						PersonasBD.insertarPersona(
								"INSERT INTO  persona (nombre,apellido1,apellido2,edad,email,dni,puesto) "
										+ "VALUES(?,?,?,?,?,?,?)",
								aDatos[0], aDatos[1], aDatos[2], Integer.parseInt(aDatos[3]), aDatos[4], aDatos[5],
								aDatos[6]);
						contadorCorrecto++;
					} else {
						listIncorrectos.add(contenidoFichero + "-->El DNI tiene una longitud incorrecta");
						contadorIncorrecto++;
					}
				} else {
					listIncorrectos.add(contenidoFichero + "-->El registo no tiene una estructura correcta");
					contadorIncorrecto++;
				}
			}
			AccesoBD.getCon().commit();
		} catch (SQLException e) {
			if (AccesoBD.getCon() != null) {
				// En caso de Fallo
				try {
					AccesoBD.getCon().rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (AccesoBD.getCon() != null && !AccesoBD.getCon().isClosed()) {
					AccesoBD.cerrarConexion();
				}
				TFin = System.currentTimeMillis(); // Tomamos la hora en que
													// finalizó el algoritmo y
													// la almacenamos en la
													// variable T
				tiempo = (int) (TFin - TInicio) / 1000; // Calculamos los
														// milisegundos de
				// diferencia
				escribirIncorrectosEnFichero(listIncorrectos);
				request.setAttribute("tiempo", tiempo);
				request.setAttribute("registrosCorrectos", contadorCorrecto);
				request.setAttribute("registrosIncorrectos", contadorIncorrecto);
				request.setAttribute("ficheroIncorrecto", PATH_DIRECTORIO_INCORRECTO);
				request.setAttribute("exito", "El volcado se ha realizado correctamente");
				request.getRequestDispatcher("/ejercicioVolcadoFicheroABBDD/indexVolcado.jsp").forward(request,
						response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

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
}
