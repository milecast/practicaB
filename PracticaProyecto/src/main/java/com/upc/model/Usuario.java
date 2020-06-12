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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private int usuario_id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "nick")
	private String nick;

	@Column(name = "password")
	private String password;

	@Column(name = "identificacion")
	private String identificacion;

	@Column(name = "correo")
	private String correo;

	@Column(name = "rol_id")
	private int rol_id;

	@Column(name = "carrera_id")
	private int carrera_id;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Formulario> formulario;

	@ManyToOne
	@JoinColumn(name = "carrera_id", insertable = false, updatable = false)
	private Carrera carrera;

	@ManyToOne
	@JoinColumn(name = "rol_id", insertable = false, updatable = false)
	private Rol rol;

	public Usuario() {
	}

	public Usuario(String nombre, String nick, String password, String identificacion, String correo, int rol_id,
			int carrera_id) {
		this.nombre = nombre;
		this.nick = nick;
		this.password = password;
		this.identificacion = identificacion;
		this.correo = correo;
		this.rol_id = rol_id;
		this.carrera_id = carrera_id;
	}

	public Usuario(int usuario_id, String nombre, String nick, String password, String identificacion, String correo,
			int rol_id, int carrera_id) {
		this.usuario_id = usuario_id;
		this.nombre = nombre;
		this.nick = nick;
		this.password = password;
		this.identificacion = identificacion;
		this.correo = correo;
		this.rol_id = rol_id;
		this.carrera_id = carrera_id;
	}

	public Usuario(int usuario_id, String nombre, String nick, String identificacion, String correo, int rol_id,
			int carrera_id) {

		this.usuario_id = usuario_id;
		this.nombre = nombre;
		this.nick = nick;
		this.identificacion = identificacion;
		this.correo = correo;
		this.rol_id = rol_id;
		this.carrera_id = carrera_id;
	}

	public Usuario(String nombre, String identificacion, String correo) {

		this.nombre = nombre;
		this.identificacion = identificacion;
		this.correo = correo;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getRol_id() {
		return rol_id;
	}

	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}

	public int getCarrera_id() {
		return carrera_id;
	}

	public void setCarrera_id(int carrera_id) {
		this.carrera_id = carrera_id;
	}

	public List<Formulario> getFormulario() {
		List<Formulario> rest = new ArrayList<Formulario>();
		if (formulario != null) {
			for (Formulario temp : formulario) {
				Formulario tempForm = new Formulario(temp.getFormulario_id(), temp.getSkill_id(), temp.getUsuario_id());
				rest.add(tempForm);
			}
			return rest;
		} else {
			return null;
		}
	}

	public void setFormulario(List<Formulario> formulario) {
		this.formulario = formulario;
	}

	public Carrera getCarrera() {
		if (carrera != null) {
			Carrera result = new Carrera(carrera.getCarrera_id(), carrera.getNombre());
			return result;
		}
		return null;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Rol getRol() {
		if (rol != null) {
			Rol result = new Rol(rol.getRol_id(), rol.getNombre());
			return result;
		}
		return null;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
