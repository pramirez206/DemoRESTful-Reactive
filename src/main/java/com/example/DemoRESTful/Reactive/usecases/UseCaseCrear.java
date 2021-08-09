package com.example.DemoRESTful.Reactive.usecases;

import com.example.DemoRESTful.Reactive.collections.Dato;
import com.example.DemoRESTful.Reactive.mapper.MapperUtils;
import com.example.DemoRESTful.Reactive.model.DatoDTO;
import com.example.DemoRESTful.Reactive.repositories.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCrear {

    private final Repositorio repositorio;
    private final MapperUtils mapperUtils;

    @Autowired
    public UseCaseCrear(MapperUtils mapperUtils, Repositorio repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    public Mono<String> apply(DatoDTO datoDTO) {
        return repositorio.save(mapperUtils.mapperToDato(null).apply(datoDTO)).map(Dato::getId);
    }
}
