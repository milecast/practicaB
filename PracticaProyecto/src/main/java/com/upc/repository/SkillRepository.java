package com.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.upc.model.Skill;

public interface SkillRepository extends CrudRepository<Skill, Integer>{
	@Query(value = "SELECT EXISTS(SELECT s.* FROM skill s WHERE LOWER(s.nombre)=LOWER(?1))", nativeQuery = true)
	boolean ifExistsSkillByNombre(String nombre);
	
	@Query(value="SELECT * FROM skill WHERE skill_id=?1 AND tipo_id=?2", nativeQuery = true)
	Skill findAllByIdAndTipo(int skill_id, int tipo_id);
	
	@Query(value="SELECT * FROM skill WHERE nombre=?1", nativeQuery = true)
	Skill getSkill(String nombre);
	
}
