package com.jabyun.yeshow.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.jabyun.yeshow.Security.handler.AuthenticationEntryPointHandler;
import com.jabyun.yeshow.Security.handler.SuccessHandler;

@Configuration
@EnableWebSecurity
public class MultiHttpSecurityConfig{

	@Autowired
	@Qualifier("UserDetailsServiceImpl")
	UserDetailsService userDetailsServiceImpl;
	
	private static SuccessHandler successhandler = new SuccessHandler();
	private static AuthenticationEntryPoint authenticationEntryPoint=new AuthenticationEntryPointHandler();
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl);
	}
	
	@Configuration
	public static class UserSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			
			http
				.authorizeRequests()
					.antMatchers("/admin/**").hasRole("ADMIN")
					.antMatchers("/**").permitAll()
					.and()
				.logout()
					.logoutUrl("/logout")
					.and()
				.exceptionHandling()
					.authenticationEntryPoint(authenticationEntryPoint)
					.and()
				.formLogin()
					.loginPage("/login.html").permitAll()
					.loginProcessingUrl("/login")
					.successHandler(successhandler)
					.and()
				.csrf()
					.disable();
			http.sessionManagement()
				.sessionFixation()
				.migrateSession()
				.maximumSessions(1)
				.maxSessionsPreventsLogin(false)
				.expiredUrl("/expiredSession.do");
		}
	}
}
