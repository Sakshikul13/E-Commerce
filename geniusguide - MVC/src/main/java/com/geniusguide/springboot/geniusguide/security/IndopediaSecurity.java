package com.geniusguide.springboot.geniusguide.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class IndopediaSecurity {


		@Bean
		public InMemoryUserDetailsManager userdetailsmanager() {
			
			UserDetails vinay = User.builder()
					.username("vinay")
					.password("{noop}test@123")
					.roles("USER", "SELLER", "ADMIN")
					.build();
			
			UserDetails yesh = User.builder()
					.username("yesh")
					.password("{noop}test@123")
					.roles("SELLER")
					.build();
			
			UserDetails sakshi = User.builder()
					.username("sakshi")
					.password("{noop}test@123")
					.roles("USER")
					.build();         
			
			return new InMemoryUserDetailsManager(vinay, yesh, sakshi);
		}
		
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
			
			http.authorizeHttpRequests(configurer ->
									configurer.anyRequest().authenticated()
					
					).formLogin(form ->
							form.loginPage("/showLoginPage")
								.loginProcessingUrl("/authenticateTheUser")
								.permitAll()
								).logout(logout -> logout.permitAll()
							);
			
			return http.build();
			
		}
		
		
}
