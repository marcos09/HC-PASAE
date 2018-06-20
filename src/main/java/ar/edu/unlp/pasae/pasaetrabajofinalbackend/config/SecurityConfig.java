package ar.edu.unlp.pasae.pasaetrabajofinalbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@Order(1)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware {
  
 
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Override
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//		auth.parentAuthenticationManager(authenticationManager).inMemoryAuthentication().withUser("pasae")
//				.password("pasae").roles("USER");
//	}
//
//	@Override
//	protected void configure(final HttpSecurity http) throws Exception {
//		http.requestMatchers().antMatchers("/login", "/oauth/authorize").and().authorizeRequests().anyRequest()
//				.authenticated().and().formLogin().permitAll();
//	}
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }

    
}