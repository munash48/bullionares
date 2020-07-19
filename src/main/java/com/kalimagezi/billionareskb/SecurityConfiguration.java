package com.kalimagezi.billionareskb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements ApplicationContextAware{
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
		

			
		
	}
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/uploads/**").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/home/**").hasAnyRole("ADMIN","USER")
			.antMatchers("/events/**").hasAnyRole("ADMIN","USER")
			.antMatchers("/jobs/**").hasAnyRole("ADMIN","USER")
			.antMatchers("/message/**").hasAnyRole("ADMIN","USER")
			.antMatchers("/profile/**").hasAnyRole("ADMIN","USER")
			.antMatchers("/profile-print/**").hasAnyRole("ADMIN","USER")
			.antMatchers("/chart/**").hasAnyRole("ADMIN","USER")
			.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
			.antMatchers("/").permitAll()						
			.and()
			 .formLogin().loginPage("/login").defaultSuccessUrl("/home",true)
			.and().exceptionHandling().accessDeniedPage("/accessdenied")
			;
		

	}

	

}
