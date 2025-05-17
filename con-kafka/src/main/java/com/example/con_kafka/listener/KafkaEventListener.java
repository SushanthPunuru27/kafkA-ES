package com.example.con_kafka.listener;

import com.example.con_kafka.model.Event;
import com.example.con_kafka.repository.EventRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class KafkaEventListener {

    private final EventRepository repository;

    public KafkaEventListener(EventRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "events-topic", groupId = "event-group")
    public void consume(String message) {
        Event event = new Event(UUID.randomUUID().toString(), message);
        repository.save(event);
        System.out.println("Saved to Elasticsearch: " + message);
    }
}

