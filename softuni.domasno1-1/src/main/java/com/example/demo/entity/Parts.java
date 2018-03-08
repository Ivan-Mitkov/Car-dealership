package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="parts")
public class Parts {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price; 
	
	@Column(name="price")
	private int quantity;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= 
		{CascadeType.DETACH,
		CascadeType.MERGE,
		CascadeType.PERSIST,
		CascadeType.REFRESH})
	@JoinTable(
			name="parts_cars",
			joinColumns=@JoinColumn(name="car_id"),
			inverseJoinColumns=@JoinColumn(name="part_id")
			)
	private List<Cars>cars;
	
	private Suppliers suppliers;
	
	

	public Parts() {
		
	}

	public Parts(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Parts [name=" + name + ", price=" + price + ", quantity=" + quantity + ", cars=" + cars + ", suppliers="
				+ suppliers + "]";
	}
	
	
	
}
