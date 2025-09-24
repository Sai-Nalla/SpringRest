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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	//Secuirty Filter configurer
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.
			authorizeHttpRequests(auth->auth
					.requestMatchers("/bank/","/bank/register","/bank/showlogin").permitAll()			//permits all no auth or auhtor
					.requestMatchers("/bank/offers").authenticated()		//permits only authentication users
					.requestMatchers("/bank/balance").hasAnyRole("USER","ADMIN")		// Customer and manager
					.requestMatchers("/bank/approve").hasRole("ADMIN")
					.anyRequest().authenticated()
					)
			//specify authentication mode
			.httpBasic(Customizer.withDefaults())	
			//.formLogin(Customizer.withDefaults())
			
				.formLogin(form->form
						.loginPage("/bank/showlogin")		//specify you login page url
						.defaultSuccessUrl("/bank/",true)		//default succed url after login
						.failureUrl("/bank/showlogin?error")	
						.loginProcessingUrl("/login")
						.permitAll()
						)
			//sample logout customization
				.logout(logout -> logout
					    .logoutUrl("/logout")   // still POST by default
					    .deleteCookies("JSESSIONID")
					    .invalidateHttpSession(true)
					    .logoutSuccessUrl("/bank/showlogin?logout")
					    .permitAll()
					)
			//exception handling 
			.exceptionHandling((exceptionHandling) ->
				exceptionHandling
					.accessDeniedPage("/bank/denied")
				
			
			
					
			);
		return http.build();
	}

	 // 🔑 Password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
    	
    PasswordEncoder encoder= new BCryptPasswordEncoder();
	return encoder;
    
    }
    
}
