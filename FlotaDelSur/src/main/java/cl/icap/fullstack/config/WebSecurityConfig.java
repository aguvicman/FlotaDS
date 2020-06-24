package cl.icap.fullstack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import cl.icap.fullstack.service.MyUserDetailsServiceImp;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers( "/css/*", "/js/*", "/images/*", "/fonts/*", "/valores/*","/agenda_viajes/**").permitAll()
				.antMatchers( "/adminPage","/valores/**").hasAnyRole("ADMIN")
				.anyRequest()
				.authenticated()
				.and()
			.formLogin()
				.loginPage("/index")
				.permitAll()
				.and()
			    .logout()
			    .logoutSuccessUrl("/")
				.permitAll();
		}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	/*
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
				User.withDefaultPasswordEncoder()
					.username("user")
					.password("1234")
					.roles("USER")
					.build();
		
		return new InMemoryUserDetailsManager(user);
		
		
	}
*/
}
