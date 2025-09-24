package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	//Secuirty Filter configurer
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.
			authorizeHttpRequests(auth->auth
					.requestMatchers("/bank/").permitAll()			//permits all no auth or auhtor
					.requestMatchers("/bank/offers").authenticated()		//permits only authentication users
					.requestMatchers("/bank/balance").hasAnyRole("CUSTOMER","MANAGER")		// Customer and manager
					.requestMatchers("/bank/approve").hasRole("MANAGER")
					.anyRequest().authenticated()
					)
			//specify authentication mode
			.httpBasic(Customizer.withDefaults())	
			.formLogin(Customizer.withDefaults())
			
			//sample logout customization
 			.logout((logout) ->
 				logout.deleteCookies("JSESSIONID")
 					.invalidateHttpSession(true)
 					.logoutUrl("/logout")
 					.logoutSuccessUrl("/bank/")
 			)
			//exception handling 
			.exceptionHandling((exceptionHandling) ->
				exceptionHandling
					.accessDeniedPage("/bank/denied")
					
			//
			
			
					
			);
		return http.build();
	}
	
	// 🔑 JDBC authentication
	@Bean
	UserDetailsService userDetailsService(DataSource dataSource) {
	    JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

	    users.setUsersByUsernameQuery(
	        "SELECT name AS username, pwd AS password, status AS enabled FROM security_user WHERE name = ?");
	    users.setAuthoritiesByUsernameQuery(
	        "SELECT name As username, role As authority FROM security_role WHERE name = ?");

	    return users;
	}
	 // 🔑 Password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
    	
    PasswordEncoder encoder= new BCryptPasswordEncoder();
	return encoder;
    
    }
}
