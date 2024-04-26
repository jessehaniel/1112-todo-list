package tech.ada.java.todolist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import tech.ada.java.todolist.login.AuthService;

@Configuration
public class DatabaseAuthConfig {

    @Bean
    public AuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder, AuthService authService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(authService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

}
