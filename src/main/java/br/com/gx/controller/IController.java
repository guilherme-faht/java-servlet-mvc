package br.com.gx.controller;

/**
 * Interface para Controllers.
 * @author Guilherme Faht (GURUX)
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IController {

	public void init(HttpServletRequest req, HttpServletResponse resp, String method);

	public void dispatcher() throws ServletException, IOException;

	public void index();

}
