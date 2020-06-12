package com.upc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.Formulario;
import com.upc.model.Skill;
import com.upc.repository.CarreraRepository;
import com.upc.repository.FiltroRepository;
import com.upc.repository.SkillRepository;

@Service
public class SkillService implements ISkillService {

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private FiltroRepository filtroRepository;

	@Autowired
	private CarreraRepository carreraRepository;

	//Obtiene todas las skill de una carrera y un tipo especifico
	@Override
	public List<Skill> getAll(int carrera_id, int tipo_id) {

		List<Integer> skill = filtroRepository.selectDataFromFiltro(carrera_id);
		List<Skill> result = new ArrayList<Skill>();
		Skill uno = new Skill();
		for (int i = 0; i < skill.size(); i++) {
			uno = skillRepository.findAllByIdAndTipo(skill.get(i), tipo_id);
			if(uno!= null) {
			result.add(uno);
			}
			uno = new Skill();
		}

		return result;
	}
	
	// Registra en la BD las skill
	@Override
	public Skill registrar(Skill skill) {
		Skill temp = null;
		if (skillRepository.ifExistsSkillByNombre(skill.getNombre())) {
			return temp;
		} else {
			skillRepository.save(skill);// inserta en la BD
			temp = skillRepository.getSkill(skill.getNombre());
			return temp;
		}
	}
}
