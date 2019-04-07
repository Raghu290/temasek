package com.hackathon.temasek.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 
	@Autowired
	private TemasekUserDetailsService userDetailsService;
	 
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("i am in security classs configAuthentication");
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("config..........");
		http.csrf().disable()
			.authorizeRequests()
     		.antMatchers("/registerUser","/mfaAuthentication").permitAll()
     		//.antMatchers("/searchFlights").hasAuthority("USER")
       		.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.logout()
			.permitAll();
	}
}
