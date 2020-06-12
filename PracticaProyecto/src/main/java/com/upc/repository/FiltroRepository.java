package com.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.upc.model.Filtro;

public interface FiltroRepository extends CrudRepository<Filtro, Integer>{

	//Selecciona todos los skill_ID que sean parte de esa carrera
	@Query(value="SELECT f.skill_id FROM filtro f WHERE f.carrera_id= ?1", nativeQuery = true)
	List<Integer> selectDataFromFiltro(int carrera_id);
	
	//Evalua si existe un registro con esos dos ID
	@Query(value = "SELECT EXISTS(SELECT f.* FROM filtro f WHERE f.carrera_id=?1 AND f.skill_id=?2)", nativeQuery = true)
	boolean ifExistsRelacion(int carrera_id, int skill_id);
	
	
}
