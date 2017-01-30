package com.ipartek.formacion.ejercicioLogin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.ejercicioLogin.exception.UserNoEncontradoException;
import com.ipartek.formacion.ejercicioLogin.pojo.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = { "/login" }, initParams = { @WebInitParam(name = "userNameCredential", value = "admin"),
		@WebInitParam(name = "userPassCredential", value = "123"),
		@WebInitParam(name = "userImage", value = "http://pre10.deviantart.net/cfcd/th/pre/i/2004/03/2/8/rolling_stone_bart.jpg") })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Venimos desde una pagina que no es login.jsp
		String ruta = null;
		HttpSession session;
		session = request.getSession(true);
		// Si el usuario es distinto de null-->No venimos desde login.jsp
		if (request.getParameter("user") == null) {
			// Miramos que hemos venido desde una pagina que no es login.jsp
			if (request.getParameter("log") != null) {
				// Miramos cual es el parametro de log para ponerle la ruta
				// deseada.
				// En este caso venimos del 2 osea que hay que redirigir a
				// ejercicioCRUDVehiculo/vehiculo
				if (request.getParameter("log").equals("2"))
					// añadimos a la session desde donde se ha llamado a la
					// pagina de login para
					// que vuelva a esa ruta
					session.setAttribute("redirectLogin", "ejercicioCRUDVehiculo/vehiculo");
			}
		}
		response.sendRedirect("ejercicioLogin/login.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Si venimos desde login.jps (Hemos enviado los datos del usuario)
		String ruta = null;
		HttpSession session;
		session = request.getSession(true);
		try {
			String nombre = request.getParameter("user");
			String pass = request.getParameter("pass");

			User userValidado = validarUsuario(nombre, pass);
			if (userValidado == null) {
				ruta = "login.jsp?error=1";
			} else {

				session.setAttribute("user", nombre);
				session.setAttribute("pass", pass);
				session.setAttribute("image", getInitParameter("userImage"));
				//Si hemos llegado a login.jsp mediante una pagina que no es index.jsp metemos en 
				//la variable RUTA el atributo redirectLogin(contiene la pagina por la cual se 
				//accedio a login.jsp)
				if (session.getAttribute("redirectLogin") != null)
					ruta = (String) session.getAttribute("redirectLogin");
				else
					ruta = "index.jsp";
			}
		} catch (

		Exception e) {
			response.sendRedirect("../error.jsp");
		} finally {
			response.sendRedirect(ruta);

		}
	}

	
	
	private User validarUsuario(String nombre, String pass) {
		// TODO Auto-generated method stub
		User user = null;
		if (nombre.equalsIgnoreCase(getInitParameter("userNameCredential"))
				&& pass.equalsIgnoreCase(getInitParameter("userPassCredential"))) {
			user = new User(nombre, pass);
		}
		return user;
	}

}
