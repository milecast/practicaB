package com.upc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rol_id")
	private int rol_id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "rol", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Usuario> usuario;

	public Rol() {
	}

	public Rol(String nombre) {
		this.nombre = nombre;
	}

	public Rol(int rol_id, String nombre) {
		this.rol_id = rol_id;
		this.nombre = nombre;
	}

	public int getRol_id() {
		return rol_id;
	}

	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuario() {
		List<Usuario> result = new ArrayList<Usuario>();
		if (usuario != null) {
			for (Usuario temp : usuario) {
				Usuario tempForm = new Usuario(temp.getUsuario_id(), temp.getNombre(), temp.getNick(),
						temp.getIdentificacion(), temp.getCorreo(), temp.getRol_id(), temp.getCarrera_id());
				result.add(tempForm);
			}
			return result;
		} else {
			return null;
		}
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

}
