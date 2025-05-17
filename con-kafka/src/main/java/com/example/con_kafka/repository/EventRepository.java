package com.example.con_kafka.repository;

import com.example.con_kafka.model.Event;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EventRepository extends ElasticsearchRepository<Event, String> {
}
