package com.example.demo.contollers;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled=true)
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

	@Autowired
	PasswordEncoder encoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("india").password(encoder.encode("india")).roles("ADMIN").and()
		.withUser("nepal").password(encoder.encode("nepal")).roles("GUEST");
	}
@Override
protected void configure(HttpSecurity http) throws Exception {
	//super.configure(http);
	http.authorizeRequests().antMatchers("/api/v1/students/**").authenticated().and().csrf().disable().httpBasic();
	//http.authorizeRequests().antMatchers("/api/v1/students/**").authenticated().and().httpBasic();
	//http.authorizeRequests().antMatchers("/api/v1/students/**").authenticated().and().formLogin();

}



@Bean
public PasswordEncoder encoder() {
	return new BCryptPasswordEncoder();
}
	
}
