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
@Table(name = "carrera")
public class Carrera implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carrera_id")
	private int carrera_id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "carrera", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Usuario> usuario;

	@OneToMany(mappedBy = "carrera", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Filtro> filtro;

	public Carrera() {

	}

	public Carrera(String nombre) {
		this.nombre = nombre;
	}

	public Carrera(int carrera_id, String nombre) {
		this.carrera_id = carrera_id;
		this.nombre = nombre;
	}

	public int getCarrera_id() {
		return carrera_id;
	}

	public void setCarrera_id(int carrera_id) {
		this.carrera_id = carrera_id;
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

	public List<Filtro> getFiltro() {
		List<Filtro> result = new ArrayList<Filtro>();
		if (filtro != null) {
			for (Filtro temp : filtro) {
				Filtro tempForm = new Filtro(temp.getFiltro_id(), temp.getCarrera_id(), temp.getSkill_id());
				result.add(tempForm);
			}
			return result;
		} else {
			return null;
		}
	}

	public void setFiltro(List<Filtro> filtro) {
		this.filtro = filtro;
	}

}
