package com.ezdesign.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface carRepository extends CrudRepository<Car, Long> {
	
	//Fetch cars by brand
	List<Car> findByBrand(@Param("brand")String brand);
	//Fetch cars by color
	List<Car> findByColor(@Param("color")String color);
	//Fetch cars by year
	List<Car> findByYear1(@Param("year")int year);
	
	//Fetch cars by Brand and Model
	List<Car> findByBrandAndModel(String brand , String model);
	//Fetch cars by brand or color
	List<Car> findByBrandOrColor(String brand , String color);
	
	//Fetch cars by brand and sort by year
	List<Car> findByBrandOrderByYear1Asc(String brand);
	
	//Fetch cars by brand using SQL
	@Query("select  c from Car c where c.brand = ?1")
	List<Car> findByBrand1(String brand);
	
	//Fetch cars by brand using SQL
	@Query("select c from Car c where c.brand like %?1")
	List<Car> findByBrandEndsWith(String brand);
	
	
	
	
}
