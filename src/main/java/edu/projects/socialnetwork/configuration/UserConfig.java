package edu.projects.socialnetwork.configuration;

import edu.projects.socialnetwork.model.User;
import edu.projects.socialnetwork.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {



    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User erick = new User("erickusername", "passhash", "erick", "erick@mail.io", "im a bio");
            User nati = new User("natiusername", "passhash", "nati", "nati@mail.io", "im a bio");

            repository.saveAll(List.of(erick, nati));
        };
    }
}
