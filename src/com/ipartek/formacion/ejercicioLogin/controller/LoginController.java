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
@WebServlet(urlPatterns = { "/login" }, initParams = {
		@WebInitParam(name = "userNameCredential", value = "admin"),
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
		String ruta = null;
		HttpSession session;
		try {
			String nombre = request.getParameter("user");
			String pass = request.getParameter("pass");

			User userValidado = validarUsuario(nombre, pass);
			if (userValidado == null) {
				ruta="login.jsp?error=1";
			}else{
				session=request.getSession(true);
				session.setAttribute("user", nombre);
				session.setAttribute("pass", pass);
				session.setAttribute("image", getInitParameter("userImage"));
				ruta="index.jsp";
			}
		} catch (Exception e) {
			response.sendRedirect("../error.jsp");
		} finally {
			response.sendRedirect(ruta);

		}
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
