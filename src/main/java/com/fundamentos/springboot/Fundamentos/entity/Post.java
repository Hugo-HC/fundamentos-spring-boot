package com.fundamentos.springboot.Fundamentos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_post", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "descripcion", length = 255)
	private String descripcion;
	
	@ManyToOne
	private User user;

	public Post() {
		super();
	}

	public Post(String descripcion, User user) {
		super();
		this.descripcion = descripcion;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", descripcion=" + descripcion + ", user=" + user + "]";
	}

}
