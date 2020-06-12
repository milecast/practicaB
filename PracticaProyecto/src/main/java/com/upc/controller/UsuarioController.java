package com.upc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upc.model.Usuario;
import com.upc.services.UsuarioService;

@RestController
@CrossOrigin
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	// Servicio de Registro de usuario
	@RequestMapping(value = "/usuario/registro", method = RequestMethod.POST)
	public void registro(HttpServletResponse response, @Valid @RequestBody Usuario usuario) throws IOException {

		String validation = usuarioService.registrar(usuario);
		if (validation == "200") {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(200);
			response.getWriter().println("Usuario registrado");
		} else {
			response.setHeader("Custom-Header", "foo");
			response.setStatus(400);
			response.getWriter().println("Usuario ya existe");
		}

	}

	// Servicio de logueo
	@RequestMapping(value = "/usuario/login", method = RequestMethod.POST)
	public Usuario login(HttpServletResponse response, @Valid @RequestParam("nick") String nick,
			@RequestParam("password") String pssw) throws IOException {
		Usuario user = usuarioService.login(nick, pssw);
		if (user != null) {
			return user;
		} else {
			return null;
		}

	}

}
