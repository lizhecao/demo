package com.test;

import com.test.dao.RoleRepository;
import com.test.dao.UserRepository;
import com.test.model.Role;
import com.test.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner makeData(UserRepository userRepository, RoleRepository roleRepository) {
        return (args -> {
            String passwd = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("ryan");
            User user1 = new User(1, "ryan", passwd);
            Role role1 = new Role("USER", 1);
           userRepository.save(user1);
           roleRepository.save(role1);
        });
    }
}
