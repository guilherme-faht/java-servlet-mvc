package br.com.gx.controller;

import javax.servlet.http.Cookie;

import br.com.gx.dao.UsuarioDAO;
import br.com.gx.model.Usuario;

/**
 * Controller para autenticação na aplicação.
 * 
 * @author Guilherme Faht (GURUX)
 */
public class Login extends AbstractController {

	public void index() {

		String email = this.getRequest().getParameter("email");
		String senha = this.getRequest().getParameter("senha");

		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

		String mensagem = "";

		if (usuario == null) {
			mensagem = "Usuário ou senha inválidos!";
		} else {

			Cookie cookie = new Cookie("usuarioLogado", usuario.getEmail());
			cookie.setMaxAge(60 * 10);
			this.getResponse().addCookie(cookie);

			mensagem = "Autenticação feita com sucesso!";
		}

		this.getRequest().setAttribute("usuario", usuario);
		this.getRequest().setAttribute("mensagem", mensagem);
	}

}
