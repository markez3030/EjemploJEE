package com.ipartek.formacion.ejercicioFichero.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FicheroController
 */
@WebServlet("/ejercicioFichero/fichero")
public class FicheroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String EXTENSION = ".txt";
	private static final String PATH = "C:\\Desarrollo\\Workspace\\EjemploJEE\\WebContent\\ficheros\\";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FicheroController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Para escribir el fichero
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(PATH + request.getParameter("nombre2") + EXTENSION));

			// One way of reading the file
			String contentLine = br.readLine();
			while (contentLine != null) {
				contentLine = br.readLine();
			}
			request.setAttribute("contenidoFichero", contentLine);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ioe) {
			}
		}
		request.getRequestDispatcher("/ejercicioFichero/accionesFichero.jsp").forward(request, response);
	}

	/**
	 * Para escribir en el fichero
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(PATH + request.getParameter("nombre") + EXTENSION);
			bw = new BufferedWriter(fw);
			bw.write(request.getParameter("contenido"));
			bw.write(request.getParameter("contenido").length());
			request.setAttribute("exito", "El fichero<b>" + request.getParameter("nombre") + EXTENSION
					+ "</b> se ha creado " + "correctamente en la ruta <b>" + PATH + "</b>");
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		} finally {
			try {
				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				request.setAttribute("error", ex.getMessage());
			}
			request.getRequestDispatcher("/ejercicioFichero/accionesFichero.jsp").forward(request, response);
		}
	}

}
