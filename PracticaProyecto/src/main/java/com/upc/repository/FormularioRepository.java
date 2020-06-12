package com.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.upc.model.Formulario;

public interface FormularioRepository extends CrudRepository<Formulario, Integer> {
	@Query(value = "SELECT EXISTS(SELECT f.* FROM formulario f WHERE f.usuario_id=?1 AND f.skill_id=?2)", nativeQuery = true)
	boolean ifExistsRelacion(int usuario_id, int skill_id);

	@Query(value = "SELECT f.usuario_id FROM formulario f WHERE (f.skill_id=?1) OR (f.skill_id=?2) OR (f.skill_id=?3) OR (f.skill_id=?4) "
			+ "GROUP BY usuario_id HAVING COUNT (usuario_id) = 4", nativeQuery = true)
	List<Integer> selectDataFromFormulario(int skill1, int skill2, int skill3, int skill4);
}
