package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="suppliers")
public class Suppliers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="is_imported")
	private int isImported;

	public Suppliers() {
		
	}

	public Suppliers(String name, int isImported) {
		this.name = name;
		this.isImported = isImported;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int isImported() {
		return isImported;
	}

	public void setImported(int isImported) {
		this.isImported = isImported;
	}
	
}
