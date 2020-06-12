package com.upc.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.upc.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	// Determina si existe un usuario con ese nick
	@Query(value = "SELECT EXISTS(SELECT u.* FROM usuario u WHERE u.nick=(?1))", nativeQuery = true)
	boolean ifExistsUsuarioByNick(String nick);

	// Determina si existe un usuario con esa identificacion
	@Query(value = "SELECT EXISTS(SELECT u.* FROM usuario u WHERE u.identificacion=(?1))", nativeQuery = true)
	boolean ifExistsUsuarioByIdentificacion(String identificacion);

	// Obtiene usuario con ese nick
	@Query(value = "SELECT u.* FROM usuario u WHERE u.nick=?1", nativeQuery = true)
	Usuario getUsuarioByNick(String nick);

	// Buscar usuario con ese ID
	@Query(value = "SELECT * FROM usuario where usuario_id=?1", nativeQuery = true)
	Usuario encontrarPorID(int id);
}
