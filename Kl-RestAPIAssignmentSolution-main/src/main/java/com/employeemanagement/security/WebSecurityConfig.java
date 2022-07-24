package com.employeemanagement.security;

import com.employeemanagement.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	 @Bean
	    public UserDetailsService userDetailsService() {
	        return new UserDetailsServiceImpl();
	    }

	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//			The below line links authentication provider with data base by using UserDetailsService
	        authProvider.setUserDetailsService(userDetailsService());
//			Password encoder is Set by below statement
	        authProvider.setPasswordEncoder(passwordEncoder());

	        return authProvider;
	    }

	    @Override
//		Authentication Config for Spring Security

	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());


			PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			// In-memory authentication, method chaining
//			auth.inMemoryAuthentication()
//                .withUser("admin")
////				.password(encoder.encode("admin"))
//				.password(passwordEncoder().encode("admin"))
//			    .authorities("ADMIN");
//			auth.inMemoryAuthentication()
//				.withUser("user")
//				.password(passwordEncoder().encode("user"))
////				.password(encoder.encode("user"))
//				.authorities("USER") ;
////				.withUser("user").password(encoder.encode("user")).roles("USER");
//					.withUser("admin").password("admin").roles("ADMIN")

	    }
	//		Authorization Config for Spring Security
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {


		 http.authorizeRequests()
//          Ant matcher should not include context path in this case /api
//			wrong ant matcher --> .antMatchers("/api/employees/").hasAnyAuthority("ADMIN","USER")

				 .antMatchers("/employees/add").hasAuthority("ADMIN")
				 .antMatchers(HttpMethod.DELETE,"/employees/*").hasAuthority("ADMIN")
//				 .antMatchers("/roles/*").hasAuthority("ADMIN")
//				 .antMatchers("/users/*").hasAuthority("ADMIN")
                 .antMatchers("/roles/*").permitAll()
				 .antMatchers("/users/*").permitAll()
				 .anyRequest().authenticated()
				 .and() .formLogin()
				 .and() .httpBasic().and().cors().and().csrf().disable();

//			http.authorizeRequests()
////					.antMatchers("api/employees/add").hasRole("ADMIN")
////
////					.antMatchers("/api/employees/","/api/employees/*").hasAuthority("ADMIN")
//					.antMatchers("/**").hasAuthority("ADMIN")
//
////					.anyRequest().authenticated()
//					.and().httpBasic()
////					csrf needs to be disabled for performing post requests
//					.and().cors() .and().csrf().disable();

	    }
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(new String[]{"/h2-console/**"});
	}

}
