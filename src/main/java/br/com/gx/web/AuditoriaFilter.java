package br.com.gx.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class AuditoriaFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

		Cookie usuario = new Cookies(httpServletRequest.getCookies()).getUsuarioLogado();

		if (usuario != null) {

			usuario.setMaxAge(60 * 10);

			System.out.println(
					"Usuario " + usuario.getValue() + " acessando a URI " + httpServletRequest.getRequestURI());

			httpServletResponse.addCookie(usuario);

		}

		chain.doFilter(httpServletRequest, httpServletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}