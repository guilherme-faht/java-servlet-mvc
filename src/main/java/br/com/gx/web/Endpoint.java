package br.com.gx.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gx.controller.IController;

/**
 * Representa o Endpoint da aplicação.
 * 
 * @author Guilherme Faht (GURUX)
 */
@WebServlet(urlPatterns = "/")
public class Endpoint extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String className = req.getParameter("controller");
		String methodName = req.getParameter("method");

		if (className == null) {
			className = "Index";
		}

		if (methodName == null) {
			methodName = "index";
		}

		try {

			className = "br.com.gx.controller." + className;
			Class<?> clazz = Class.forName(className);

			IController instance = (IController) clazz.newInstance();
			instance.init(req, resp, methodName);

			Method method = clazz.getMethod("index");
			method.invoke(instance);

			instance.dispatcher();

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}