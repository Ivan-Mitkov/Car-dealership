package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="birth_date")
	private LocalDateTime birthDate;
	
	@Column(name="is_young_driver")
	private boolean isYoungDriver;

	public Customers() {
		
	}

	public Customers(String name, LocalDateTime birthDate, boolean isYoungDriver) {
		this.name = name;
		this.birthDate = birthDate;
		this.isYoungDriver = isYoungDriver;
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

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isYoungDriver() {
		return isYoungDriver;
	}

	public void setYoungDriver(boolean isYoungDriver) {
		this.isYoungDriver = isYoungDriver;
	}
	
	
	
	
}
