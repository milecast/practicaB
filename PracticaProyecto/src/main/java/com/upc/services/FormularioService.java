package com.upc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.Filtro;
import com.upc.model.Formulario;
import com.upc.model.Usuario;
import com.upc.repository.FormularioRepository;
import com.upc.repository.UsuarioRepository;

@Service
public class FormularioService implements IFormularioService {

	@Autowired
	private FormularioRepository formularioRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public String registrar(Formulario formulario) {
		if (formularioRepository.ifExistsRelacion(formulario.getUsuario_id(), formulario.getSkill_id())) {
			return "300";
		} else {
			formularioRepository.save(formulario);
			return "200";
		}
	}

	@Override
	public List<Usuario> buscar(int s1, int s2, int s3, int s4) {
		List<Integer> usuario_id = formularioRepository.selectDataFromFormulario(s1, s2, s3, s4);
		if (usuario_id.isEmpty()) {
			return null;
		} else {
			List<Usuario> user = new ArrayList<Usuario>();
			Usuario user1 = null;
			for (int i = 0; i < usuario_id.size(); i++) {
				user1 = usuarioRepository.encontrarPorID(usuario_id.get(i));
				if (user1 != null) {
					user.add(new Usuario(user1.getNombre(), user1.getIdentificacion(), user1.getCorreo()));
				}
			}

			return user;

		}

	}
}
