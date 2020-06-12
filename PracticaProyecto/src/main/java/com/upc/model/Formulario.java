package com.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "formulario")
public class Formulario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "formulario_id")
	private int formulario_id;

	@Column(name = "usuario_id")
	private int usuario_id;

	@Column(name = "skill_id")
	private int skill_id;

	@ManyToOne
	@JoinColumn(name = "usuario_id", insertable = false, updatable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "skill_id", insertable = false, updatable = false)
	private Skill skill;

	public Formulario() {
	}

	public Formulario(int usuario_id, int skill_id) {
		this.usuario_id = usuario_id;
		this.skill_id = skill_id;
	}

	public Formulario(int formulario_id) {
		this.formulario_id = formulario_id;
	}

	public Formulario(int formulario_id, int usuario_id, int skill_id) {
		this.formulario_id = formulario_id;
		this.usuario_id = usuario_id;
		this.skill_id = skill_id;
	}

	public int getFormulario_id() {
		return formulario_id;
	}

	public void setFormulario_id(int formulario_id) {
		this.formulario_id = formulario_id;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

	public Usuario getUsuario() {
		if (usuario != null) {
			Usuario result = new Usuario(usuario.getUsuario_id(), usuario.getNombre(), usuario.getNick(),
					usuario.getIdentificacion(), usuario.getCorreo(), usuario.getRol_id(), usuario.getCarrera_id());
			return result;
		}
		return null;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Skill getSkill() {
		if (skill != null) {
			Skill result = new Skill(skill.getSkill_id(), skill.getNombre(), skill.getTipo_id());
			return result;
		}
		return null;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
