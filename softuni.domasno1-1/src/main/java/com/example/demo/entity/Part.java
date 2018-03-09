package com.example.demo.entity;

import java.util.ArrayList;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="parts")
public class Part {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price; 
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= 
		{CascadeType.DETACH,
		CascadeType.MERGE,
		CascadeType.PERSIST,
		CascadeType.REFRESH})
	@JoinTable(
			name="parts_cars",
			joinColumns=@JoinColumn(name="part_id"),
			inverseJoinColumns=@JoinColumn(name="car_id")
			)
	private List<Car>cars;
	
	@OneToOne(cascade= 
		{CascadeType.DETACH,
		CascadeType.MERGE,
		CascadeType.PERSIST,
		CascadeType.REFRESH})
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
	
	public Part() {
		
	}

	public Part(String name, double price, int quantity) {
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
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier suppliers) {
		this.supplier = suppliers;
	}
	//add method for adding cars
		public void addCar(Car s) {
				if(cars==null) {
					cars= new ArrayList<Car>();
				}
				cars.add(s);
		}
	@Override
	public String toString() {
		return "Parts [name=" + name + ", price=" + price + ", quantity=" + quantity + ", cars=" + cars + ", suppliers="
				+ supplier + "]";
	}
	
	
	
}
