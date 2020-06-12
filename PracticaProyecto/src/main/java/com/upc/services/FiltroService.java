package com.upc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.Filtro;
import com.upc.repository.FiltroRepository;

@Service
public class FiltroService implements IFiltroService{

	@Autowired
	private FiltroRepository filtroRepository;

	//Registra relación entre carrera y skill
	@Override
	public String registrar(Filtro filtro) {
		if (filtroRepository.ifExistsRelacion(filtro.getCarrera_id(), filtro.getSkill_id())) {
			return "300";
		} else {
			filtroRepository.save(filtro);
			return "200";
		}
	}
}
