package org.java.project.auth.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AuthConfiguration {

	@Bean
	PasswordEncoder passwordEncoder() {
		
//	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    
		return 
			http.authorizeHttpRequests(a -> a
			        .requestMatchers("/pizza/delete/**").hasAuthority("ADMIN")
			        .requestMatchers("/pizza/update/**").hasAuthority("ADMIN")
			        .requestMatchers("/pizza/create/**").hasAuthority("ADMIN")
			        .requestMatchers("/new-offerte/**").hasAuthority("ADMIN")
			        .requestMatchers("/ingrediente/**").hasAuthority("ADMIN")
			        .requestMatchers("/pizza/**").permitAll()
			        .requestMatchers("/**").permitAll()
			).formLogin(f -> f.permitAll()
			).logout(l -> l.logoutSuccessUrl("/home-login")
			).exceptionHandling(e -> e.accessDeniedPage("/index")
			).build();
	}
}
