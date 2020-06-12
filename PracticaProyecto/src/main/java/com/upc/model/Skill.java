package com.upc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	private int skill_id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "tipo_id")
	private int tipo_id;

	@OneToMany(mappedBy = "skill", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Formulario> formulario;

	@ManyToOne
	@JoinColumn(name = "tipo_id", insertable = false, updatable = false)
	private Tipo tipo;

	public Skill() {
	}

	public Skill(String nombre, int tipo_id) {
		this.nombre = nombre;
		this.tipo_id = tipo_id;
	}

	public Skill(int skill_id, String nombre, int tipo_id) {
		this.skill_id = skill_id;
		this.nombre = nombre;
		this.tipo_id = tipo_id;
	}

	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTipo_id() {
		return tipo_id;
	}

	public void setTipo_id(int tipo_id) {
		this.tipo_id = tipo_id;
	}

	public List<Formulario> getFormulario() {
		List<Formulario> result = new ArrayList<Formulario>();
		if (formulario != null) {
			for (Formulario temp : formulario) {
				Formulario tempForm = new Formulario(temp.getFormulario_id(), temp.getSkill_id(), temp.getUsuario_id());
				result.add(tempForm);
			}
			return result;
		} else {
			return null;
		}
	}

	public void setFormulario(List<Formulario> formulario) {
		this.formulario = formulario;
	}

	public Tipo getTipo() {
		if (tipo != null) {
			Tipo result = new Tipo(tipo.getTipo_id(), tipo.getNombre());
			return result;
		}
		return null;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
