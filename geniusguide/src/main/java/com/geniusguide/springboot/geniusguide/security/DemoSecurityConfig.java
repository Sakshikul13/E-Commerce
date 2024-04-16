package com.geniusguide.springboot.geniusguide.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	@Bean
	public UserDetailsManager userdetailsManager(DataSource dataSource) {
		
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(configurer ->
				configurer
				.requestMatchers(HttpMethod.GET, "/api/users").hasRole("USER")
				.requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("USER")
				.requestMatchers(HttpMethod.POST, "/api/user").hasRole("USER")
				.requestMatchers(HttpMethod.PUT, "/api/user").hasRole("USER")
				.requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("USER")
				
				.requestMatchers(HttpMethod.GET, "/api/users").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.POST, "/api/user").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/api/user").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
				
				.requestMatchers(HttpMethod.GET, "/api/sellers").hasRole("SELLER")
				.requestMatchers(HttpMethod.GET, "/api/sellers/**").hasRole("SELLER")
				.requestMatchers(HttpMethod.POST, "/api/seller").hasRole("SELLER")
				.requestMatchers(HttpMethod.PUT, "/api/seller/**").hasRole("SELLER")
				.requestMatchers(HttpMethod.DELETE, "/api/sellers/**").hasRole("SELLER")
				
				.requestMatchers(HttpMethod.GET, "/api/sellers").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/api/sellers/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.POST, "/api/seller").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/api/seller").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/api/sellers/**").hasRole("ADMIN")
				
				.requestMatchers(HttpMethod.GET, "/api/admins").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/api/admins/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.POST, "/api/admins").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/api/admins/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/api/admins/**").hasRole("ADMIN")
				
				);
		
		http.httpBasic(Customizer.withDefaults());

		http.csrf(csrf -> csrf.disable());
		return http.build();
		
	}
	
	
/*	@Bean
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
*/
}
