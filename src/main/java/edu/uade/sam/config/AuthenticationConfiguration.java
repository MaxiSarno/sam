package edu.uade.sam.config;

import java.util.ArrayList;

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

import edu.uade.sam.dao.UserAccountRepository;

@Configuration
public class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

  @Autowired
  UserAccountRepository accountRepository;

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
//			BCryptPasswordEncoder encoder = new 
			UserDetails userDetails = userDetailsService().loadUserByUsername(name);
			
			if (userDetails!=null && userDetails.getPassword().equals(password)) {
				return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
			}

			return null;
		}
	};
	  
  }

  @Bean
  UserDetailsService userDetailsService() {
    return new UserDetailsService() {

      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount account = accountRepository.findByUsername(username);
        if(account != null) {
        return new User(account.getUsername(), account.getPassword(), true, true, true, true,
                AuthorityUtils.createAuthorityList("USER"));
        } else {
          throw new UsernameNotFoundException("could not find the user '"
                  + username + "'");
        }
      }
      
    };
  }
}
