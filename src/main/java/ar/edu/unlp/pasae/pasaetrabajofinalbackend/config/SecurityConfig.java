package ar.edu.unlp.pasae.pasaetrabajofinalbackend.config;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableOAuth2Sso
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/h2-console/**", "/user/*").permitAll().and()
			.authorizeRequests()
				.antMatchers("/", "/home", "/h2-console").permitAll()
				.anyRequest().fullyAuthenticated()
				.and()
	        .formLogin()
	            .loginPage("/login")
	            .permitAll()
	            .and()
	        .logout()
	            .permitAll()
	            .and()
			.csrf().disable()
			.headers().frameOptions().disable();
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("https://localhost:4200"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
