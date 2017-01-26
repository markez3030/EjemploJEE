package com.ipartek.formacion.ejercicioCRUDVehiculo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.ejercicioVehiculo.pojo.Vehiculo;
import com.ipartek.formacion.ejercicioVehiculo.services.ServiceVehiculo;
import com.ipartek.formacion.ejercicioVehiculo.services.VehiculoDao;


/**
 * Servlet implementation class VehiculoController
 */
@WebServlet("/ejercicioCRUDVehiculo/vehiculo")
public class VehiculoCRUDController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static ServiceVehiculo service;
	public static final String OP_LISTAR="1";
	public static final String OP_VER_DETALLE="2";
	public static final String OP_ADD_COCHE="3";

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		service = VehiculoDao.getInstance();

	}
	
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ANTES DE REALIZAR DOGET Y DOPOST
		super.service(arg0, arg1);
		//DESPUES DE REALIZAR DOGET Y DOPOST

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ruta="indexVehiculo.jsp";
		String op=request.getParameter("op");
		System.out.println(op);
		if(op==null || op.equals(OP_LISTAR))
		{
			op=OP_LISTAR;
			ArrayList<Vehiculo> list=service.getAll();
			request.setAttribute("vehiculos", list);
		}
		switch (op) {
		case OP_VER_DETALLE:
			Vehiculo v=service.getById(Long.parseLong(request.getParameter("id").split(".")[0]));
			request.setAttribute("vehiculoDetalle",v);
			ruta="verVehiculo.jsp";
			break;
		case OP_ADD_COCHE:
			ruta="añadirVehiculo.jsp";
			break;
		default:
			break;
		}
		request.getRequestDispatcher("/ejercicioCRUDVehiculos/"+ruta).forward(request, response);
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
		service=null;
	}

}


