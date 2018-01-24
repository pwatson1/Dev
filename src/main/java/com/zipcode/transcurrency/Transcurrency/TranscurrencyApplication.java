package com.zipcode.transcurrency.Transcurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(TranscurrencyApplication.class);

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
		logger.info("Application running.");
		logger.warn("This is a warning log");
		logger.error("This is an error log.");
		logger.debug("This is a debug log.");
		SpringApplication.run(TranscurrencyApplication.class, args);
	}
}
