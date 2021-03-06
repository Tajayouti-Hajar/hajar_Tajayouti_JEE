package ma.tajayouti.activiteetudiantmvcspring.security;

import ma.tajayouti.activiteetudiantmvcspring.security.service.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

//tte classe avec cette annotation va etre instancier au 1er lieu
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService); //chercher les users
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin(); //formul de login par defaut ... si je veux personnalis√© ce form http.formLogin().loginPage("/login")
  // droits d accees
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/admin/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/user/**").hasAnyAuthority("USER");
        http.authorizeRequests().antMatchers("/webjars/**").permitAll();

        http.authorizeRequests().anyRequest().authenticated();

        http.exceptionHandling().accessDeniedPage("/403");
    }


}
