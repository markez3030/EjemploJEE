package com.ipartek.formacion.ejercicioVehiculoBBDD.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejercicioVehiculo.pojo.Vehiculo;
import com.ipartek.formacion.utilidades.VehiculoDB;

import sun.awt.image.ByteBandedRaster;

/**
 * Servlet implementation class JDBCController
 */
@WebServlet("/ejercicioVehiculoBBDD/vehiculo")
public class JDBCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String OP_LISTAR = "1";

	public static final String OP_MOSTRAR_ADD_COCHE = "3";
	public static final String OP_REMOVE_COCHE = "4";
	public static final String OP_ADD_COCHE = "5";
	public static final String OP_MOSTRAR_SET_COCHE = "6";
	public static final String OP_SET_COCHE = "7";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JDBCController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ruta = "indexVehiculo.jsp";
		String op = request.getParameter("op");
		ArrayList<Vehiculo> listV = new ArrayList<Vehiculo>();
		try {
			VehiculoDB.establecerConexion("concesionario", "root", "");
			if (op == null || op.equals(OP_LISTAR)) {
				op = OP_LISTAR;
				listV = listar();
				request.setAttribute("listaVehiculo", listV);
			}
			switch (op) {
			case OP_MOSTRAR_ADD_COCHE:
				ruta = "añadirVehiculo.jsp";
				break;
			case OP_REMOVE_COCHE:
				VehiculoDB.deleteVehiculo("DELETE FROM vehiculo WHERE id=?",
						Integer.parseInt(request.getParameter("id")));
				request.setAttribute("exito", "El coche " + request.getParameter("modelo") + " "
						+ " con el identificador " + request.getParameter("id") + " ha sido borrado correctamente");
				listV = listar();
				request.setAttribute("listaVehiculo", listV);
				break;
			case OP_ADD_COCHE:
				try {
					VehiculoDB.insertarVehiculo(
							"INSERT INTO  vehiculo (modelo,plazas,potencia,dimensiones) VALUES(?,?,?,?)",
							request.getParameter("modelo"), Integer.parseInt(request.getParameter("plazas")),
							Integer.parseInt(request.getParameter("potencia")),
							Integer.parseInt(request.getParameter("dimensiones")));
					listV = listar();
					request.setAttribute("listaVehiculo", listV);
					request.setAttribute("exito",
							"El coche " + request.getParameter("modelo") + " ha sido ceado correctamente");
				} catch (NumberFormatException e1) {
					request.setAttribute("error", "Ha introducido texto en un campo númerico");
					ruta = "añadirVehiculo.jsp";
				}
				break;
			case OP_MOSTRAR_SET_COCHE:
				request.setAttribute("vehiculoDetalle", buscarUnVehiculo("SELECT * FROM vehiculo WHERE id=?",
						Integer.parseInt(request.getParameter("id"))));
				ruta = "modificarVehiculo.jsp";
				break;
			case OP_SET_COCHE:
				try {
					VehiculoDB.modificarVehiculo(
							"UPDATE vehiculo SET modelo=?,plazas=?,potencia=?,dimensiones=? WHERE id=?; ",
							request.getParameter("modelo"), Integer.parseInt(request.getParameter("plazas")),
							Integer.parseInt(request.getParameter("potencia")),
							Integer.parseInt(request.getParameter("dimensiones")),
							Integer.parseInt(request.getParameter("id")));
					request.setAttribute("exito",
							"El coche " + request.getParameter("modelo") + " " + " con el identificador "
									+ request.getParameter("id") + " ha sido modificado correctamente");
					listV = listar();
					request.setAttribute("listaVehiculo", listV);
				} catch (NumberFormatException e1) {
					request.setAttribute("vehiculoDetalle", buscarUnVehiculo("SELECT * FROM vehiculo WHERE id=?",
							Integer.parseInt(request.getParameter("id"))));
					request.setAttribute("error", "Ha introducido texto en un campo númerico");
					ruta = "modificarVehiculo.jsp";
				}
				break;
			default:
				break;
			}
			VehiculoDB.cerrarConexion();
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "No se ha podido realizar la conexion a la BBDD");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e3.getMessage());
		}
		request.getRequestDispatcher("/ejercicioVehiculoBBDD/" + ruta).forward(request, response);
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

	private ArrayList<Vehiculo> listar() {
		ArrayList<Vehiculo> listV = new ArrayList<Vehiculo>();
		ResultSet rs;
		try {
			rs = VehiculoDB.lanzarSelect("SELECT * FROM vehiculo");
			Vehiculo v;
			while (rs.next()) {
				v = new Vehiculo();
				v.setId(rs.getInt(1));
				v.setModelo(rs.getString(2));
				v.setPlazas(rs.getInt(3));
				v.setPotencia(rs.getInt(4));
				v.setDimensiones(rs.getInt(5));
				Vehiculo.setNumero_coches(rs.getInt(1));
				listV.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listV;
	}

	private Vehiculo buscarUnVehiculo(String sql, int id) throws SQLException {
		Vehiculo v = new Vehiculo();
		ResultSet rs = VehiculoDB.buscarUnCoche(sql, id);
		if (rs.next()) {
			v.setId(rs.getInt(1));
			v.setModelo(rs.getString(2));
			v.setPlazas(rs.getInt(3));
			v.setPotencia(rs.getInt(4));
			v.setDimensiones(rs.getInt(5));
		}
		return v;
	}
}
