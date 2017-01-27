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
@WebServlet("/ejercicioVehiculo/vehiculo")
public class VehiculoController extends HttpServlet {
	
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
			vehiculo.setDimensiones(Integer.parseInt(request.getParameter("dimensiones")));
			vehiculo.setPotencia(Integer.parseInt(request.getParameter("potencia")));
			request.setAttribute("vehiculo", vehiculo);
		} catch (NumberFormatException e1) {
			if(request.getParameter("modelo")!=null)
				request.setAttribute("error", "Ha introducido texto en un campo númerico");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e.getMessage());
		} finally {
			request.getRequestDispatcher("indexVehiculo.jsp").forward(request, response);
		}

	}

}
