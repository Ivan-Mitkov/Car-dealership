package com.example.demo.entity;

import java.math.BigInteger;
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
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class Cars {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="make")
	private String make;
	
	@Column(name="model")
	private String model;
	
	@Column(name="travelled_distance")
	private long travelledDistance;
	
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
	private List<Parts>parts;

	public List<Parts> getParts() {
		return parts;
	}

	public Cars() {
		
	}

	@Override
	public String toString() {
		return "Cars [make=" + make + ", model=" + model + ", travelledDistance=" + travelledDistance + "]";
	}

	public Cars(String make, String model, long travelledDistance) {
		this.make = make;
		this.model = model;
		this.travelledDistance = travelledDistance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getTravelledDistance() {
		return travelledDistance;
	}

	public void setTravelledDistance(long travelledDistance) {
		this.travelledDistance = travelledDistance;
	}
	
	public void setParts(List<Parts> parts) {
		this.parts = parts;
	}

	//add method for adding parts
	public void addCourse(Parts s) {
			if(parts==null) {
				parts= new ArrayList<Parts>();
			}
			parts.add(s);
	}
	
	public double calculatePrice(List<Parts>parts) {
		double price=0.0;
				if(parts==null) {
					return price;
				}
				else {
					price=parts.stream()
							.mapToDouble(a->a.getPrice())
							.reduce((a,b)->a+b).getAsDouble();
				}
				return price;
		}
	
	
}
