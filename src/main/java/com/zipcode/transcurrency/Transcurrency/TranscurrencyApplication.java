package com.zipcode.transcurrency.Transcurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class TranscurrencyApplication extends WebSecurityConfigurerAdapter {
	private static final Logger logger = LogManager.getLogger(TranscurrencyApplication.class);

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		logger.info("Call to user page.");
		return principal;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("http config. complete.");
		http
				.antMatcher("/**")
				.authorizeRequests()
				.antMatchers("/", "/login**", "/webjars/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and().logout().logoutSuccessUrl("/").permitAll()
				.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}


	public static void main(String[] args) {
		logger.info("Application running.");
		SpringApplication.run(TranscurrencyApplication.class, args);
	}
}
