package com.upc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.Carrera;
import com.upc.model.Skill;
import com.upc.repository.CarreraRepository;

@Service
public class CarreraService implements ICarreraService{

	@Autowired
	private CarreraRepository carreraRepository;

	@Override
	public String registrar(Carrera carrera) {
		if(carreraRepository.ifExistsCarreraByNombre(carrera.getNombre())) {
			return "300";
		}else
		{
			carreraRepository.save(carrera);
			return "200";
		}
	}
}
