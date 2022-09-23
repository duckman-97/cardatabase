package com.dzdesign.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ezdesign.cardatabase.domain.Owner;
import com.ezdesign.cardatabase.domain.OwnerRepository;

@DataJpaTest
public class OwnerRepositoryTest {
	@Autowired
	private OwnerRepository repository;
	
	@Test
	void saveOwners() {
		repository.save(new Owner("Lucy","Smith"));
		assertThat(repository.findByFirstName("Lucy").isPresent())
		.isTrue();
		
	}
	
	@Test
	void deleteOwners() {
		repository.save(new Owner("Lisa","Morison"));
		repository.deleteAll();
		assertThat(repository.count()).isEqualTo(0);
		
	}
	
	
	

}
