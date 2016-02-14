package br.com.gx.controller;

import java.util.Collection;

import br.com.gx.dao.EmpresaDAO;
import br.com.gx.model.Empresa;

/**
 * Controller para busca de empresas.
 * 
 * @author Guilherme Faht (GURUX)
 */
public class BuscaEmpresa extends AbstractController {

	public void index() {

		String filtro = this.getRequest().getParameter("filtro");

		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);

		this.getRequest().setAttribute("empresas", empresas);
	}
}