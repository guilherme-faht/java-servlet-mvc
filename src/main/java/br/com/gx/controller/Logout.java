package br.com.gx.controller;

import javax.servlet.http.Cookie;

import br.com.gx.web.Cookies;

/**
 * Permite sair da aplicação.
 * 
 * @author Guilherme Faht (GURUX)
 */
public class Logout extends AbstractController {

	@Override
	public void index() {

		Cookie usuario = new Cookies(this.getRequest().getCookies()).getUsuarioLogado();

		if (usuario != null) {
			usuario.setMaxAge(0);
			this.getResponse().addCookie(usuario);
		}
	}
}