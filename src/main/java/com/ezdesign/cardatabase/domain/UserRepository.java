package com.ezdesign.cardatabase.domain;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Usr,Long>{
	
		Optional<Usr>findByUsername(String username);
		

}

