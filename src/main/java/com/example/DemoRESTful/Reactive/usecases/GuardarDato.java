package com.example.DemoRESTful.Reactive.usecases;

import com.example.DemoRESTful.Reactive.collections.Dato;
import com.example.DemoRESTful.Reactive.model.DatoDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface GuardarDato {

    public Mono<String> apply(DatoDTO datoDTO);
}
