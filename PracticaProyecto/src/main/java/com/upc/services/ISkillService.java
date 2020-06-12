package com.upc.services;

import java.util.List;

import com.upc.model.Skill;

public interface ISkillService {
	List<Skill> getAll(int carrera_id, int tipo_id); 
	Skill registrar(Skill skill);

}
