package com.upc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.upc.model.Filtro;
import com.upc.model.Skill;
import com.upc.repository.FiltroRepository;
import com.upc.services.FiltroService;

@RestController
@CrossOrigin
public class FiltroController {
	
	@Autowired
	private FiltroService filtroService;
	
	//Servicio para registrar un relacion skill-carrera
	@RequestMapping(value = "/filtro/registro", method = RequestMethod.POST)
	public void registroFiltro(HttpServletResponse response, @Valid @RequestBody Filtro filtro) throws IOException {

		String validation = filtroService.registrar(filtro);
		if (validation == "200") {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("Relacion registrada");
		} else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("Relacion ya existe");
		}

	}
}
