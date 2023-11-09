package goit.spring.data;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

class BCryptPasswordEncoderTest {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Test
    void decrypt(){
        assertThat(bCryptPasswordEncoder.matches("jdbcDefault","$2a$10$zdDs5iv7hv8XJWK748heZOWUJ/06QIGXuKjJf/pQaFSg0iAdeOUIC")).isTrue();
    }
}
