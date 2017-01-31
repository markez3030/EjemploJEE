package com.ipartek.formacion.ejercicioCRUDVehiculo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
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
@WebServlet("/ejercicioCRUDVehiculo/vehiculo")
public class VehiculoCRUDFicheroController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static ServiceVehiculo service;
	public static final String OP_LISTAR = "1";

	public static final String OP_MOSTRAR_ADD_COCHE = "3";
	public static final String OP_REMOVE_COCHE = "4";
	public static final String OP_ADD_COCHE = "5";
	public static final String OP_MOSTRAR_SET_COCHE = "6";
	public static final String OP_SET_COCHE = "7";

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		service = VehiculoDao.getInstance();

	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ANTES DE REALIZAR DOGET Y DOPOST
		super.service(arg0, arg1);
		// DESPUES DE REALIZAR DOGET Y DOPOST

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ruta = "indexVehiculo.jsp";
		String op = request.getParameter("op");
		if (op == null || op.equals(OP_LISTAR)) {
			op = OP_LISTAR;
			ArrayList<Vehiculo> list = service.getAll();
			request.setAttribute("vehiculos", list);
		}
		switch (op) {
		case OP_MOSTRAR_ADD_COCHE:
			ruta = "añadirVehiculo.jsp";
			break;
		case OP_REMOVE_COCHE:
			ArrayList<Vehiculo> list = service.getAll();
			request.setAttribute("vehiculos", list);
			service.removeVehiculo(Integer.parseInt(request.getParameter("id")));
			break;
		case OP_ADD_COCHE:
			ArrayList<Vehiculo> list1 = service.getAll();
			request.setAttribute("vehiculos", list1);
			Vehiculo v2 = new Vehiculo(request.getParameter("modelo"));
			try {
				v2.setPlazas(Integer.parseInt(request.getParameter("plazas")));
				v2.setDimensiones(Integer.parseInt(request.getParameter("dimensiones")));
				v2.setPotencia(Integer.parseInt(request.getParameter("potencia")));
				request.setAttribute("exito","El coche "+request.getParameter("modelo")+" "
						+ " con el identificador "+v2.getId()+" ha sido ceado correctamente"
						);
				service.createVehiculo(v2);
			} catch (NumberFormatException e1) {
				request.setAttribute("error", "Ha introducido texto en un campo númerico");
				ruta = "añadirVehiculo.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				ruta = "añadirVehiculo.jsp";
				request.setAttribute("error", e.getMessage());
			}
			break;
		case OP_MOSTRAR_SET_COCHE:
			Vehiculo v7 = service.getById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("vehiculoDetalle", v7);
			ruta = "modificarVehiculo.jsp";
			break;
		case OP_SET_COCHE:
			ArrayList<Vehiculo> list2 = service.getAll();
			request.setAttribute("vehiculos", list2);
			try {
				Vehiculo v3 = new Vehiculo(request.getParameter("modelo"));
				v3.setId(Integer.parseInt(request.getParameter("id")));
				v3.setPlazas(Integer.parseInt(request.getParameter("plazas")));
				v3.setDimensiones(Integer.parseInt(request.getParameter("dimensiones")));
				v3.setPotencia(Integer.parseInt(request.getParameter("potencia")));
				request.setAttribute("exito","El coche "+request.getParameter("modelo")+" "
						+ " con el identificador "+request.getParameter("id")+" ha sido modificado correctamente"
						);
				service.update(v3);
			} catch (NumberFormatException e1) {
				v7 = service.getById(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("vehiculoDetalle", v7);
				request.setAttribute("error", "Ha introducido texto en un campo númerico");
				ruta = "modificarVehiculo.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				v7 = service.getById(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("vehiculoDetalle", v7);
				ruta = "modificarVehiculo.jsp";
				request.setAttribute("error", e.getMessage());
			}
			break;
		default:
			break;
		}
		request.getRequestDispatcher("/ejercicioCRUDVehiculos/" + ruta).forward(request, response);
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

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		service = null;
	}

}
