package com.ezdesign.cardatabase;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ezdesign.cardatabase.domain.Car;
import com.ezdesign.cardatabase.domain.Owner;
import com.ezdesign.cardatabase.domain.OwnerRepository;
import com.ezdesign.cardatabase.domain.UserRepository;
import com.ezdesign.cardatabase.domain.Usr;
import com.ezdesign.cardatabase.domain.carRepository;

import java.util.Arrays;

import java.util.List;

import org.slf4j.Logger;


@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner{
	

	
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private carRepository repository;
	
	@Autowired
	private OwnerRepository orepository;
	
	@Autowired
	private UserRepository urepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}
	
	@Override
	public void run(String... args)throws Exception{
		
		Owner owner1 = new Owner("John","Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		orepository.saveAll(Arrays.asList(owner1,owner2));
		

		repository.save(new Car("Ford","Mustang","red","ADF-1121",2021,59000,owner1));
		repository.save(new Car("Nissan", "Leaf", "White","SSJ-3002", 2019, 29000,owner2));
		repository.save(new Car("Toyota", "Prius","Silver","KKO-0212", 2020, 39000,owner2));
		List<Car> cars = repository.findByBrandEndsWith("Ford");
		for(Car car:cars) {
			System.out.println(car.getRegisterNumber() + " "+ car.getColor());
		}
		
		
		for (Car car : repository.findAll()) {
			
			logger.info(car.getBrand() + " " + car.getModel());
		
		}
	
		
		
		urepository.save(new Usr("user",
				"$2a$10$TBobccrd0KtkUIwQE4cEgeyR29NUKQK0rtTDJZXhmumSnD6sjvYe.","USER"));
		
		
	urepository.save(new Usr("admin", "$2a$10$UKJY2fU7jT4Lpm8CXWBWmuT3kbCjGYiLo2bRq8VUKNdI6tOJR/7SC", "ADMIN"));
	}

		


		
	

	}
	
		
	


