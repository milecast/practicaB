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

import com.upc.model.Carrera;
import com.upc.model.Skill;
import com.upc.services.CarreraService;

@RestController
@CrossOrigin
public class CarreraController {
	
	@Autowired
	private CarreraService carreraService;
	
	//Servicio de registro de carrera
	@RequestMapping(value = "/carrera/registro", method = RequestMethod.POST)
	public void registro(HttpServletResponse response, @Valid @RequestBody Carrera carrera) throws IOException {

		String validation = carreraService.registrar(carrera);
		if (validation == "200") {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("Carrera registrada");
		} else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("Carrera ya existe");
		}

	}
}
