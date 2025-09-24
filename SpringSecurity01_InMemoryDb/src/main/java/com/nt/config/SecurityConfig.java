package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//authorizing based on the roles
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
			//form page 
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
	//specify the userdetails and roles 
	@Bean
	 UserDetailsService userDetails(PasswordEncoder encoder) {
		UserDetails customer =User.builder()
				.username("Vinay")
				.password(encoder.encode("123"))
				.roles("CUSTOMER")
				.build();
		/*System.out.println(encoder.encode("Abhi@123"));
		System.out.println(encoder.encode("Hari@123"));
		System.out.println(encoder.encode("Vijay@123"));*/
		UserDetails manager=User.builder()
				.username("Karthik")
				.password(encoder.encode("456"))
				.roles("MANAGER")
				.build();
		
		return new InMemoryUserDetailsManager(customer,manager);
	}
	 // 🔑 Password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
