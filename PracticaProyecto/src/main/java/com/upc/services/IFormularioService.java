package com.upc.services;

import java.util.List;

import com.upc.model.Filtro;
import com.upc.model.Formulario;
import com.upc.model.Usuario;

public interface IFormularioService {
	String registrar(Formulario formulario);
	List<Usuario> buscar(int s1, int s2, int s3, int s4);
}
