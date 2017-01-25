package com.ipartek.formacion.ejercicioVehiculo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejercicioVehiculo.pojo.Vehiculo;
import com.ipartek.formacion.ejercicioVehiculo.services.ServiceVehiculo;
import com.ipartek.formacion.ejercicioVehiculo.services.VehiculoDao;


/**
 * Servlet implementation class VehiculoController
 */
@WebServlet("/ejercicioVehiculo/vehiculo")
public class VehiculoCRUDController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServiceVehiculo service = VehiculoDao.getInstance();
		ArrayList<Vehiculo> list=service.getAll();
		request.setAttribute("vehiculos", list);
		request.getRequestDispatcher("indexVehiculo.jsp").forward(request, response);

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

}


