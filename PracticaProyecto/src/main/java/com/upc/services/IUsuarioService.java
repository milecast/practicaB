package com.upc.services;

import com.upc.model.Usuario;

public interface IUsuarioService {
	String registrar(Usuario usuario); 
	Usuario login(String nick, String pssw);
}
