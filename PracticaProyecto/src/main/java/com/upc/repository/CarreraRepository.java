package com.upc.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.upc.model.Carrera;

public interface CarreraRepository extends CrudRepository<Carrera, Integer>{
	@Query(value = "SELECT EXISTS(SELECT c.* FROM carrera c WHERE LOWER(c.nombre)=LOWER(?1))", nativeQuery = true)
	boolean ifExistsCarreraByNombre(String nombre);
}
