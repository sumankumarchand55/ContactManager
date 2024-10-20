package com.smart.contact.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.smart.contact.service.impl.SecurityCustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private SecurityCustomUserDetailService userDetailService;
	@Autowired
	private OAuthAuthenticationSuccessHandler handler;
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		// user details service's object
		daoAuthenticationProvider.setUserDetailsService(userDetailService);
		// password encoder's object
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

	// security pages configuration

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(
				authorize -> authorize.requestMatchers("/user/**").authenticated().anyRequest().permitAll());
		httpSecurity.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/authenticate")
				/*
				 * .successForwardUrl("/user/index") .failureForwardUrl("/login?error=true")
				 */
				.defaultSuccessUrl("/user/index", true).failureUrl("/login?error=true").usernameParameter("email")
				.passwordParameter("password").failureHandler(authenticationFailureHandler)

		).csrf(csrf -> csrf.disable());
		httpSecurity.authenticationProvider(authenticationProvider());
		httpSecurity.logout(logoutForm -> {
			logoutForm.logoutUrl("/logout");
		});
		// OAuth2 configurations
		httpSecurity.oauth2Login(oauth -> {
			oauth.loginPage("/login");
			oauth.successHandler(handler);

		});

		return httpSecurity.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
