package com.gbz.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gbz.config.security.jwt.JwtAuthenticationFilter;
import com.gbz.config.security.jwt.JwtLoginFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.headers().cacheControl();

		http.csrf().disable().authorizeRequests().antMatchers("/", "/customers", "/customer/*", "/customer").permitAll()
				.anyRequest().authenticated().and()
				// We filter the api/login requests
				.addFilterBefore(new JwtLoginFilter("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)
				// And filter other requests to check the presence of JWT in
				// header
				.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

		/*
		 * http.csrf().disable() .authorizeRequests().antMatchers("/",
		 * "/customers", "/customer/*", "/customer").permitAll()
		 * .anyRequest().authenticated().and().;
		 */
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Create a default account
		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
	}

}
