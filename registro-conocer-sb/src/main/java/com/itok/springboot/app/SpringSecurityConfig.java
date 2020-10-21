package com.itok.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.itok.springboot.app.models.service.JpaUserDetailsService;
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/public/**","/css/**","/img/**","/plugins/**","/dist/**","/uploads/**").permitAll()
				
				  .antMatchers("/estandar/**").hasAnyRole("ADMIN")
				  .antMatchers("/inicio/**").hasAnyRole("USER")
				  .antMatchers("/operaciones/**").hasAnyRole("ADMIN")
				  .antMatchers("/emision/**").hasAnyRole("USER")
				  .antMatchers("/reportes/**").hasAnyRole("USER")
				  .antMatchers("/reportes/**").hasAnyRole("USER")
				  .antMatchers("/operaciones/**").hasAnyRole("ADMIN")
				  .antMatchers("/procesos/**").hasAnyRole("ADMIN")
				  .antMatchers("/finanzas/**").hasAnyRole("ADMIN")
				  .antMatchers("/lote/**").hasAnyRole("ADMIN")
				  .antMatchers("/evaluadores/**").hasAnyRole("ADMIN")
				  .antMatchers("/certificados/**").hasAnyRole("ADMIN")
				 
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login")
		.permitAll()
		.and()
		.logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/error/error_403");
	}


	@Autowired 
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
		/*
		PasswordEncoder encoder = passwordEncoder();
		
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		builder.inMemoryAuthentication()
		.withUser(users.username("admin").password("12345").roles("ADMIN","USER"))
		.withUser(users.username("sandra").password("12345").roles("ADMIN","USER"))
		.withUser(users.username("sarahi").password("12345").roles("ADMIN","USER"))
		.withUser(users.username("diego").password("12345").roles("ADMIN","USER"))
		.withUser(users.username("hector").password("12345").roles("USER"));*/
		
	
		builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		
	}
	
}
