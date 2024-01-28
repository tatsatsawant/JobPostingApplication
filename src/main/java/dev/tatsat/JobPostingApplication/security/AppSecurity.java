package dev.tatsat.JobPostingApplication.security;

import dev.tatsat.JobPostingApplication.exception.CustomeAccessDeniedHandler;
import dev.tatsat.JobPostingApplication.exception.DelagatedAuthenticationEntryPoint;
import dev.tatsat.JobPostingApplication.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class AppSecurity {

    @Autowired
    DelagatedAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable().cors().and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST).hasRole(UserRole.HR.name())
                .anyRequest().authenticated().and()
                .httpBasic(Customizer.withDefaults())
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(accessDeniedHandler());

        http.headers().frameOptions().sameOrigin();

        return http.build();

    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user1 = User.builder()
                .username("hr")
                .password(encoder().encode("test"))
                .roles(UserRole.HR.name())
                .build();
        UserDetails user2 = User.builder()
                .username("reader")
                .password(encoder().encode("test"))
                .roles(UserRole.READER.name())
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomeAccessDeniedHandler();
    }
}
