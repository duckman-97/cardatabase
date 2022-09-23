package com.ezdesign.cardatabase;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ezdesign.cardatabase.service.JwtService;

@Component
public class AuthenticationFilter extends
OncePerRequestFilter{
	@Autowired
	private JwtService jwtService;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse reponse,FilterChain filterChain)
	throws ServletException, java.io.IOException{
		String jws = request.getHeader
				(HttpHeaders.AUTHORIZATION);
		if(jws !=null) {
			String user = jwtService.getAuthUser(request);
			Authentication authentication=
					new UsernamePasswordAuthenticationToken(user,null,
							java.util.Collections.emptyList());
			SecurityContextHolder.getContext()
			.setAuthentication(authentication);
		}
		filterChain.doFilter(request, reponse);

		}
	}

