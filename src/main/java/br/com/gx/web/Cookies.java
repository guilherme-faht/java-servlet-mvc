package br.com.gx.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}

	public Cookie getUsuarioLogado() {

		Cookie usuario = null;

		if (this.cookies != null) {

			for (Cookie cookie : this.cookies) {

				if ("usuarioLogado".equals(cookie.getName())) {
					usuario = cookie;
					break;
				}
			}
		}

		return usuario;
	}
}