package com.ipartek.formacion.ejercicioVehiculo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejercicioVehiculo.exception.NumeroNegativoException;
import com.ipartek.formacion.ejercicioVehiculo.pojo.Vehiculo;

/**
 * Servlet implementation class VehiculoController
 */
@WebServlet("/ejercicioChorra")
public class VehiculoController2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setModelo(request.getParameter("modelo"));
			vehiculo.setPlazas(Integer.parseInt(request.getParameter("plazas")));
			vehiculo.setDimensiones(Float.parseFloat(request.getParameter("dimensiones")));
			vehiculo.setPotencia(Float.parseFloat(request.getParameter("potencia")));
			request.setAttribute("vehiculo", vehiculo);
		} catch (NumberFormatException e1) {
			request.setAttribute("error", "Ha introducido texto en un campo númerico");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e.getMessage());
		} finally {
			request.getRequestDispatcher("indexVehiculo.jsp").forward(request, response);
		}

	}

}
