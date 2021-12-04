package pl.sda.springzdjavapol92.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .headers()
                .and()
                .authorizeRequests()
                 //USER ma dostęp do /todo/list, ale nie ma dostepu do /todo/add
                 //ADMIN ma dostęp do /todo/**
                .antMatchers("/todo/list").hasAnyRole("USER", "ADMIN")
                .antMatchers("/todo/**", "/person/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.PATCH, "/api/v2/todos/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/v2/todos").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/v2/todos").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("$2a$12$3oNS46NJ2ElY79uZ7MikvOObXJnqiKfmF9aaNVezyyz9n9lQjcTs6").roles("USER", "ADMIN").and()
                .withUser("ewa").password("abcd").roles("USER").and()
                .withUser("admin").password("4321").roles("ADMIN");
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
