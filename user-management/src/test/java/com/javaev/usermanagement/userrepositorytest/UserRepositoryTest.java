/*package com.javaev.usermanagement.userrepositorytest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.javaev.usermanagement.model.User;
import com.javaev.usermanagement.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByEmail_thenReturnsUser() {
        // given
        User user = new User();
        user.setName("Test User");
        user.setEmail("test@example.com");

        userRepository.save(user);

        // when
        Optional<User> foundUser = userRepository.findByEmail(user.getEmail());

        // then
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getEmail()).isEqualTo(user.getEmail());
    }
}
*/