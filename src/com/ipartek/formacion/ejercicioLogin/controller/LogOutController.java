package com.ipartek.formacion.ejercicioLogin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutController
 */
@WebServlet("/ejercicioLogin/logout")
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	HttpSession session=request.getSession();
	session.invalidate();
	String ruta="../index.jsp";
	if(request.getParameter("log")!=null)
	{
		if(request.getParameter("log").equals("2"))
		{
			ruta="../ejercicioCRUDVehiculo/vehiculo";
		}
		if(request.getParameter("log").equals("3"))
		{
			ruta="../ejercicioCRUDVehiculoFichero/vehiculo";
		}
		if(request.getParameter("log").equals("4"))
		{
			ruta="../ejercicioVehiculoBBDD/vehiculo";
		}
	}
	
	response.sendRedirect(ruta);
	}

}
