package com.ezdesign.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ezdesign.cardatabase.domain.AccountCredentials;
import com.ezdesign.cardatabase.service.JwtService;

@RestController
public class LoginController {
	
	@Autowired
	private JwtService jwtService;

	
	@Autowired
	AuthenticationManager  authenticationManager;
	
	@RequestMapping(value="/login",method =RequestMethod.POST)
	public ResponseEntity<?> getToKen(@RequestBody
			AccountCredentials  credentials){
	
		UsernamePasswordAuthenticationToken creds =
				new UsernamePasswordAuthenticationToken(
						credentials.getUsername(),
						credentials.getPassword());

		Authentication auth = authenticationManager.authenticate(creds);


		
		String jwts = jwtService.getToken(auth.getName());
		
		return ResponseEntity.ok()
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwts)
				.header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS,"Authorization")
				.build();


}
}
