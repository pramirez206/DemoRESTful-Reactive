package com.example.DemoRESTful.Reactive.repositories;

import com.example.DemoRESTful.Reactive.collections.Dato;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface Repositorio extends ReactiveMongoRepository<Dato, String> {
}
