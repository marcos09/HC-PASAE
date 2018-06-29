package ar.edu.unlp.pasae.pasaetrabajofinalbackend.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
@EnableOAuth2Sso
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/h2-console/**").permitAll().and()
			.authorizeRequests()
				.antMatchers("/", "/home").permitAll()
				.anyRequest().fullyAuthenticated()
				.and()
	        .formLogin()
	            .loginPage("/login")
	            .permitAll()
	            .and()
	        .logout()
	            .permitAll()
	            .and()
			.csrf().disable().headers().frameOptions().disable();
	}
}
