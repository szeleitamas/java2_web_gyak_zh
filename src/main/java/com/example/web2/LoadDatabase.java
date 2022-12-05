package com.example.web2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(OprendszerekRepo repo) {
        return args -> {
            if(false) {
                repo.save(new Oprendszerek("MS Server 2012", 3));
            }
        };
    }
}