package tech.ada.java.todolist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile("!password-encoder")
public class NoopPasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        //É um password encoder fake, pois não altera a senha. Use somente para estudos.
        return NoOpPasswordEncoder.getInstance();
    }

}
