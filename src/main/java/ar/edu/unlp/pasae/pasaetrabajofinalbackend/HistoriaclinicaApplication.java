package ar.edu.unlp.pasae.pasaetrabajofinalbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableOAuth2Sso

public class HistoriaclinicaApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(HistoriaclinicaApplication.class, args);
	}

	
}
