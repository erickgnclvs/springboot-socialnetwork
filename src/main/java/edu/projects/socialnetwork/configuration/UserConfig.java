package edu.projects.socialnetwork.configuration;

import edu.projects.socialnetwork.model.Post;
import edu.projects.socialnetwork.model.User;
import edu.projects.socialnetwork.repository.PostRepository;
import edu.projects.socialnetwork.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class UserConfig {



    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, PostRepository postRepository) {
        return args -> {
            User erick = new User("erickusername", "passhash", "erick", "erick@mail.io", "im a bio");
            User nati = new User("natiusername", "passhash", "nati", "nati@mail.io", "im a bio");

            userRepository.saveAll(List.of(erick, nati));
            Post post1 = new Post("first post", LocalDateTime.now(), erick);
            postRepository.save(post1);
        };
    }
}
