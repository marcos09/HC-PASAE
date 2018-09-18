package ar.edu.unlp.pasae.pasaetrabajofinalbackend.config;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;



@Configuration
@EnableOAuth2Sso
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@Lazy
public class SecurityConfig extends WebSecurityConfigurerAdapter  implements WebMvcConfigurer{
	

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("login").setViewName("login");
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

      registry.addResourceHandler("/**/*")
        .addResourceLocations("classpath:/static/")
        .resourceChain(true)
        .addResolver(new PathResourceResolver() {
            @Override
            protected Resource getResource(String resourcePath,
                Resource location) throws IOException {
                Resource requestedResource = location.createRelative(resourcePath);
                return requestedResource.exists() && requestedResource.isReadable() ? requestedResource
                : new ClassPathResource("/static/index.html");
            }
        });
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAfter(new CustomOauth2AuthenticationFilter(), BasicAuthenticationFilter.class)
		.authorizeRequests().antMatchers("/h2-console/**").permitAll().and()
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
			.csrf().disable().cors().and()
			.headers().frameOptions().disable();
	}
	
	
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("https://localhost:4200", "https://localhost:8090"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
