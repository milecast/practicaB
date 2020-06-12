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

import com.upc.model.Formulario;
import com.upc.model.Skill;
import com.upc.model.Usuario;
import com.upc.services.FormularioService;

@RestController
@CrossOrigin
public class FormularioController {

	@Autowired
	private FormularioService formularioService;

	@RequestMapping(value = "/formulario/registro", method = RequestMethod.POST)
	public void registro(HttpServletResponse response, @Valid @RequestBody Formulario formulario) throws IOException {

		String validation = formularioService.registrar(formulario);
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

	// Servicio que realiza la busqueda de estudiantes
	@RequestMapping(value = "/busqueda", method = RequestMethod.GET)
	public List<Usuario> busqueda(HttpServletResponse response, @Valid @RequestParam("s1") int s1,
			@RequestParam("s2") int s2, @RequestParam("s3") int s3, @RequestParam("s4") int s4)
			throws IOException {
		
		return formularioService.buscar(s1, s2, s3, s4);

	}

}
