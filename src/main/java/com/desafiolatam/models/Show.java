package com.desafiolatam.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="shows")

public class Show {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String cadena;
	private Integer calificacion;
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(updatable=false) //
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt; 
	
	public Show() {
		super();
	}

	//Constructor para la creación
	public Show(String name, String cadena) {
		super();
		this.name = name;
		this.cadena = cadena;
	}
	//Constructor cuando agregue la calificación
	public Show(String name, String cadena, Integer calificacion) {
		super();
		this.name = name;
		this.cadena = cadena;
		this.calificacion = calificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
}
