package com.upc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upc.model.Skill;
import com.upc.model.Usuario;
import com.upc.services.SkillService;

@RestController
@CrossOrigin
public class SkillController {
	@Autowired
	private SkillService skillService;

	// Servicio para seleccionar una skill
	@RequestMapping(value = "/skill", method = RequestMethod.GET)
	public List<Skill> filtrarPorCarreraSkill(HttpServletResponse response,
			@Valid @RequestParam("carrera_id") int carrera_id, @RequestParam("tipo_id") int tipo_id) {

		return skillService.getAll(carrera_id, tipo_id);

	}

	// servicio para registrar una skill
	@RequestMapping(value = "/skill/registro", method = RequestMethod.POST)
	public Skill registro(HttpServletResponse response, @Valid @RequestBody Skill skill) throws IOException {

		Skill validation = skillService.registrar(skill);
		if (validation != null) {
			return validation;
		} else {
			return null;
		}

	}

}
