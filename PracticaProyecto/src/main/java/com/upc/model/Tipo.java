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
@Table(name = "tipo")
public class Tipo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipo_id")
	private int tipo_id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "tipo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Skill> skill;

	public Tipo() {
	}

	public Tipo(String nombre) {
		this.nombre = nombre;
	}

	public Tipo(int tipo_id, String nombre) {
		this.tipo_id = tipo_id;
		this.nombre = nombre;
	}

	public int getTipo_id() {
		return tipo_id;
	}

	public void setTipo_id(int tipo_id) {
		this.tipo_id = tipo_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Skill> getSkill() {
		List<Skill> result = new ArrayList<Skill>();
		if(skill !=null) {
			for(Skill temp: skill) {
				Skill tempForm = new Skill(temp.getSkill_id(), temp.getNombre(), temp.getTipo_id());
			result.add(tempForm);
			}
			return result;
		}else {
		return null;
		}
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}

	

}
