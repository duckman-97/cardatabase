package com.ezdesign.cardatabase.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ezdesign.cardatabase.domain.UserRepository;
import com.ezdesign.cardatabase.domain.Usr;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {                                                                                                                                                                                                                                                                                    
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
	throws UsernameNotFoundException {
	Optional<Usr> user = repository.findByUsername(username);
	
	UserBuilder builder = null;
	
	if(user.isPresent()) {
		Usr currentUser = user.get();
		builder = org.springframework.security.core.userdetails.User.withUsername(username);
		builder.password(currentUser.getPassword());
		builder.roles(currentUser.getRole());
		}else {
			throw new UsernameNotFoundException("User not found.");
			
		}
	return builder.build();
	
	
	
	}
	
}
