package br.com.gx.controller;

import br.com.gx.dao.EmpresaDAO;
import br.com.gx.model.Empresa;

/**
 * Controller para manutenção das empresas.
 * 
 * @author Guilherme Faht (GURUX)
 */
public class NovaEmpresa extends AbstractController {

	@Override
	public void index() {
				
		String nome = this.getRequest().getParameter("nome");

		Empresa empresa = new Empresa(nome);
		EmpresaDAO empresaDAO = new EmpresaDAO();
		empresaDAO.adiciona(empresa);
		
		this.getRequest().setAttribute("empresa", empresa);
	}
}