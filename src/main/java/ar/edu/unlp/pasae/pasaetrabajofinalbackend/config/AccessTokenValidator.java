package ar.edu.unlp.pasae.pasaetrabajofinalbackend.config;

public interface AccessTokenValidator {
    AccessTokenValidationResult validate(String accessToken);
}
