package com.example.demo.Service;

import com.example.demo.Model.Bonus;
import com.example.demo.repository.BonusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonusService {
    @Autowired
    private final BonusRepository bonusRepository;

    public BonusService(BonusRepository bonusRepository) {
        this.bonusRepository = bonusRepository;
    }

    public List<Bonus> getBonus()
    {
        return bonusRepository.findAll();
    }
    public void addNewBonus(Bonus bonus)
    {
        bonusRepository.save(bonus);
    }

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC = "bonus_topic";

    public void incrementBonus() {



        // Envoi d'un message Kafka pour notifier l'étudiant
        String message = "you received a bonus  ";
        kafkaTemplate.send(TOPIC,message);
    }


}
