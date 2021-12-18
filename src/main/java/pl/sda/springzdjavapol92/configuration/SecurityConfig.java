package pl.sda.springzdjavapol92.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

     @Autowired
     private AppDefaults appDefaults;

//    @Value("${app.defaults.username}")
//    public String defaultUsername;
//
//    @Value("${app.defaults.password}")
//    public String defaultPassword;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .realmName("realm")
                .and()
                .csrf()
                .disable()
                .headers()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/api/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/api/**").hasRole("USER")
                .antMatchers(HttpMethod.PATCH, "/api/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser(defaultUsername).password(defaultPassword).roles("USER")
//                .and()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
        auth.inMemoryAuthentication()
                .withUser(appDefaults.getUsername()).password(appDefaults.getPassword()).roles("USER")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
