package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sales")
public class Sales {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="discount")
	private double discount;
	
	@Column(name="car_id")
	private long carId;
	
	@Column(name="customer_id")
	private long customerId;

	public Sales() {
		
	}

	public Sales(double discount, long carId, long customerId) {
		this.discount = discount;
		this.carId = carId;
		this.customerId = customerId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Sales [discount=" + discount + ", carId=" + carId + ", customerId=" + customerId + "]";
	}
	
	
	
	
}
