package com.ezdesign.cardatabase.domain;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Owner {
	@Id
	@GeneratedValue(generator = "CarSeq")
	@SequenceGenerator(name = "CarSeq",sequenceName = "CARDB_SEQ",allocationSize = 0)
	private long ownerid;
	private String firstname, lastname;

	
	public Owner() {}
	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		
	}
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="owner")
	private List<Car> cars;
	public List<Car>getCars(){
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars=cars;
		
	}
	
	
	
	
	
	public long getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(long ownerid) {
		this.ownerid = ownerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
