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
@Table(name = "filtro")
public class Filtro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "filtro_id")
	private int filtro_id;

	@Column(name = "carrera_id")
	private int carrera_id;

	@Column(name = "skill_id")
	private int skill_id;

	@ManyToOne
	@JoinColumn(name = "skill_id", insertable = false, updatable = false)
	private Skill skill;

	@ManyToOne
	@JoinColumn(name = "carrera_id", insertable = false, updatable = false)
	private Carrera carrera;

	public Filtro() {
	}

	public Filtro(int carrera_id, int skill_id) {
		this.carrera_id = carrera_id;
		this.skill_id = skill_id;
	}

	public Filtro(int filtro_id, int carrera_id, int skill_id) {
		this.filtro_id = filtro_id;
		this.carrera_id = carrera_id;
		this.skill_id = skill_id;
	}

	public int getFiltro_id() {
		return filtro_id;
	}

	public void setFiltro_id(int filtro_id) {
		this.filtro_id = filtro_id;
	}

	public int getCarrera_id() {
		return carrera_id;
	}

	public void setCarrera_id(int carrera_id) {
		this.carrera_id = carrera_id;
	}

	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

}
