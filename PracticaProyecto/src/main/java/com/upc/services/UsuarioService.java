package com.upc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.Usuario;
import com.upc.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	// Determina primero si exite un usuario con ese nick y/o con esa
	// identificación. Si no encuentra ninguno, registra en la BD
	public String registrar(Usuario usuario) {
		if (usuarioRepository.ifExistsUsuarioByNick(usuario.getNick()) == false
				|| usuarioRepository.ifExistsUsuarioByIdentificacion(usuario.getIdentificacion()) == false) {
			usuarioRepository.save(usuario);
			return "200";
		} else {
			return "300";
		}

	}

	// determina si existe un usuario con ese nick y esa contrseña
	public Usuario login(String nick, String pssw) {
		Usuario user = null;
		if (usuarioRepository.ifExistsUsuarioByNick(nick) == true) {
			user = usuarioRepository.getUsuarioByNick(nick);
			if (user.getPassword().equals(pssw)) {
				Usuario user1 = new Usuario(user.getUsuario_id(), user.getNombre(), user.getNick(),
						user.getIdentificacion(), user.getCorreo(), user.getRol_id(), user.getCarrera_id());
				return user1;
			}
		}

		return null;
	}
}
