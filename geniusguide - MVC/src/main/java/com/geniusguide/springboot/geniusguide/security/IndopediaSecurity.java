package com.geniusguide.springboot.geniusguide.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class IndopediaSecurity {


	 @Bean
	    public UserDetailsManager userDetailsManager(DataSource datasource) {
	    	
	    	return new JdbcUserDetailsManager(datasource);
	    }
	    
//	    @Bean
//	    public UserDetailsManager userdetailsmanager(DataSource dataSource) {
//
//	        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//	        // define query to retrieve a user by username
//	        jdbcUserDetailsManager.setUsersByUsernameQuery(
//	                "select email, password, active from user where user_id=?");
//
//	        // define query to retrieve the authorities/roles by username
//	        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
//	                "select email, role from user where user_id=?");
//
//	        return jdbcUserDetailsManager;
//	    }
	
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
			
			http.authorizeHttpRequests(configurer ->
									
									configurer
									.requestMatchers("/").hasRole("USER")
									.requestMatchers("/producer/addproducer").hasRole("SELLER")
									.requestMatchers("/producer/**").hasRole("ADMIN")
									.anyRequest().authenticated()
					
					)
					.formLogin(form ->
							form
							.loginPage("/showLoginPage")
								.loginProcessingUrl("/authenticateTheUser")
								.permitAll()
								)
						.logout(logout -> logout.permitAll()
						).exceptionHandling(configurer ->
									configurer.accessDeniedPage("/access-denied"));
			
			return http.build();
		}
		
		
}
