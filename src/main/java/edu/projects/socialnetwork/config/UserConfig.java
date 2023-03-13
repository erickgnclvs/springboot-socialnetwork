package edu.projects.socialnetwork.config;

import edu.projects.socialnetwork.models.User;
import edu.projects.socialnetwork.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Configuration
@EnableJpaRepositories
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User erick = new User("erick@mail.com", "username1", "password1");
            User nati = new User("nati@mail.com", "natiuser", "password1");
            userRepository.saveAll(List.of(erick, nati));
        };
    }
}
