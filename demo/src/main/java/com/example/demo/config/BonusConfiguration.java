package com.example.demo.config;

import com.example.demo.Model.Bonus;
import com.example.demo.repository.BonusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BonusConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(BonusRepository repo)
    {
        return args -> {
            Bonus bonus1=new Bonus(
                    1,
                    1,
                    200
            );
            Bonus bonus2=new Bonus(
                    2,2,300
            );
            repo.saveAll(List.of(bonus1,bonus2));
        };
    }
}
