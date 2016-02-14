package br.com.gx.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe abstrata para criação dos controllers.
 * 
 * @author Guilherme Faht (GURUX)
 */
public abstract class AbstractController implements IController {

	private String viewFile; // Nome do arquivo JSP.
	private HttpServletRequest req; // Requisição
	private HttpServletResponse resp; // Resposta

	/**
	 * Inicializa o controller.
	 */
	@Override
	public void init(HttpServletRequest req, HttpServletResponse resp, String method) {
		this.req = req;
		this.resp = resp;

		StringBuilder sb = new StringBuilder();
		sb.append("/WEB-INF/paginas/");
		sb.append(this.getClass().getSimpleName().toLowerCase());
		sb.append("/" + method.toLowerCase() + ".jsp");

		this.viewFile = sb.toString();
	}

	/**
	 * Carrega a view.
	 */
	@Override
	public void dispatcher() throws ServletException, IOException {

		RequestDispatcher dispatcher = this.req.getRequestDispatcher(this.viewFile);
		dispatcher.forward(req, resp);
	}
	
	/**
	 * Retorna o request.
	 * @return HttpServletRequest
	 */
	protected HttpServletRequest getRequest() {
		return this.req;
	}
	
	/**
	 * Retorna o response.
	 * @return HttpServletResponse
	 */
	protected HttpServletResponse getResponse() {
		return this.resp;
	}
	
	/**
	 * Método que deve ser implementado.
	 */
	public abstract void index();
}