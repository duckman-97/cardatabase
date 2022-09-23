package com.ezdesign.cardatabase.domain;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Car {
	@Id
	@GeneratedValue(generator = "CarSeq")
	@SequenceGenerator(name = "CarSeq",sequenceName = "CARDB_SEQ",allocationSize = 0)
	private long id;
	private String brand,model,color,registerNumber;
	private int year1, price;
	


	public Car() {}
	
	public Car(String brand,String model,String color,String registerNumber,
			int year1,int price,Owner owner) {
		super();
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registerNumber = registerNumber;
		this.year1 = year1;
		this.price = price;
		this.owner = owner;
		
		
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="owner")
	private Owner owner;
	
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public int getYear() {
		return year1;
	}

	public void setYear(int year1) {
		this.year1 = year1;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
}

