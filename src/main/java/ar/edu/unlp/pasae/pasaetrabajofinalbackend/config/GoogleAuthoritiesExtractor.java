package ar.edu.unlp.pasae.pasaetrabajofinalbackend.config;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;


import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.User;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.UserRepository;


@Component
public class GoogleAuthoritiesExtractor implements AuthoritiesExtractor {
	
	@Inject
	private UserRepository userRepository;

	@Override
	public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {
		final String email = (String) map.get("email");
		final User user = getUserRepository().findByEmail(email);
		if (user == null)
			return Collections.<GrantedAuthority>emptyList();
		return AuthorityUtils.createAuthorityList(user.getAuthorities());
	}

	private UserRepository getUserRepository() {
		return userRepository;
	}

}