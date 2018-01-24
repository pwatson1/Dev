package com.zipcode.transcurrency.Transcurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class TranscurrencyApplication extends WebSecurityConfigurerAdapter {

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.antMatcher("/**")
				.authorizeRequests()
				.antMatchers("/", "/login**", "/webjars/**")
				.permitAll()
				.and()
				.authorizeRequests()
				.antMatchers( "/console/*")//for H2 console
				.permitAll()
				.and().logout().logoutSuccessUrl("/").permitAll();
//				.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

		http.exceptionHandling().accessDeniedPage("/403");
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

	public static void main(String[] args) {
		SpringApplication.run(TranscurrencyApplication.class, args);
	}
}
