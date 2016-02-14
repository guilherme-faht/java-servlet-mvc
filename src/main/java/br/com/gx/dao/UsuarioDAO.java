package br.com.gx.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.gx.model.Usuario;

public class UsuarioDAO {

	private final static Map<String, Usuario> USUARIOS = new HashMap<>();
	static {
		USUARIOS.put("guilherme.silveira@alura.com.br", new Usuario("guilherme.silveira@alura.com.br","silveira"));
		USUARIOS.put("rodrigo.turini@alura.com.br", new Usuario("rodrigo.turini@alura.com.br","turini"));
		USUARIOS.put("guilherme@etextil.com.br", new Usuario("guilherme@etextil.com.br","123"));
	}

	public Usuario buscaPorEmailESenha(String email, String senha) {
		if (!USUARIOS.containsKey(email))
			return null;

		Usuario usuario = USUARIOS.get(email);
		if (usuario.getSenha().equals(senha))
			return usuario;
		
		return null;
	}

}
