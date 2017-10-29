package edu.uade.sam.config;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import edu.uade.sam.model.UserAccount;
import edu.uade.sam.service.UserService;

@Configuration
public class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

	private static final HashFunction ENCODER = Hashing.sha256();

	@Autowired
	private UserService userService;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	AuthenticationProvider authenticationProvider() {
		return new AuthenticationProvider() {

			@Override
			public boolean supports(Class<?> authentication) {
				return authentication.equals(UsernamePasswordAuthenticationToken.class);
			}

			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				String name = authentication.getName();
				String password = (String) authentication.getCredentials();
				UserDetails userDetails = userDetailsService().loadUserByUsername(name);
				
				if (userDetails != null && userDetails.getPassword().equals(AuthenticationConfiguration.ENCODE(password))) {
					return new UsernamePasswordAuthenticationToken(name, password, userDetails.getAuthorities());
				}

				return null;
			}
		};

	}
	
	public static final String ENCODE(String password) {
		return ENCODER
		        .hashString(password, StandardCharsets.UTF_8)
		        .toString();
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				UserAccount account = userService.findByUsername(username);
				if (account != null) {
					return new User(account.getUsername(), account.getPassword(), true, true, true, true,
							AuthorityUtils.createAuthorityList(account.getRole().toString()));
				} else {
					throw new UsernameNotFoundException("could not find the user '" + username + "'");
				}
			}

		};
	}
}
