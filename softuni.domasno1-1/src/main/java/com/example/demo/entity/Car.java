package com.example.demo.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
public class Car {

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
			joinColumns=@JoinColumn(name="car_id"),
			inverseJoinColumns=@JoinColumn(name="part_id")
			)
	private List<Part>parts;

	public List<Part> getParts() {
		return parts;
	}

	public Car() {
		
	}

	
	public Car(String make, String model, long travelledDistance) {
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
	
	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	//add method for adding parts
	public void addPart(Part s) {
			if(parts==null) {
				parts= new ArrayList<Part>();
			}
			parts.add(s);
	}
	
	public double calculatePrice() {
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
	public List<Double> getPartPrice(){
		List<Double>carParts=new ArrayList<>();
		carParts=parts.stream()
				.map(a->a.getPrice())
				.collect(Collectors.toList());
		return carParts;
	}
	@Override
	public String toString() {
		return "Cars [make=" + make + ", model=" + model + ", travelledDistance=" + travelledDistance + "]";
	}

}
