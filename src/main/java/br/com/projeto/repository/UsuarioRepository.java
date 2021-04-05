package br.com.projeto.repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.projeto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
	Usuario findByLogin(@NotNull @NotEmpty String login);

	@Query("SELECT u FROM Usuario u where u.senha like '%:senha%'")
	Usuario buscarUsuarioPelaSenhaCriptografada(@Param(value = "senha") String senha); 

}
