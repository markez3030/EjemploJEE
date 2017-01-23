package com.ipartek.formacion.ejercicioVehiculo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejercicioVehiculo.exception.NumeroDePasajerosException;
import com.ipartek.formacion.ejercicioVehiculo.pojo.Vehiculo;

/**
 * Servlet implementation class VehiculoController
 */
@WebServlet("/ejercicioVehiculo/vehiculo")
public class VehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VehiculoController() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			request.setAttribute("modelo", request.getParameter("modelo"));
			if (Integer.parseInt(request.getParameter("plazas")) < 0) {
				throw new NumeroDePasajerosException("El numero de plazas tiene que ser mayor que 0");
			}
			if (Integer.parseInt(request.getParameter("dimensiones")) < 0) {
				throw new NumeroDePasajerosException("La dimension que ser mayor que 0");
			}
			if (Integer.parseInt( request.getParameter("potencia")) < 0) {
				throw new NumeroDePasajerosException("La potencia tiene que ser mayor que 0");
			}
			Vehiculo vehiculo=new Vehiculo();
			vehiculo.setModelo(request.getParameter("modelo"));
			vehiculo.setPlazas(Integer.parseInt(request.getParameter("plazas")));
			vehiculo.setDimensiones(Float.parseFloat(request.getParameter("dimensiones")));
			vehiculo.setPotencia(Float.parseFloat(request.getParameter("potencia")));
			request.setAttribute("vehiculo",vehiculo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e.getMessage());
		}finally
		{
			request.getRequestDispatcher("indexVehiculo.jsp").forward(request, response);
		}


	}

}
