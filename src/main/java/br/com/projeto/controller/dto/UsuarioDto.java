package br.com.projeto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.projeto.modelo.Usuario;

public class UsuarioDto {

	private Long id;
	private String login; 
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.login = usuario.getLogin();
	}

	public Long getId() {
		return id;
	}

	 

	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
 
}
