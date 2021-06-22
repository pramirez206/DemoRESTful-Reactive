package com.example.DemoRESTful.Reactive.usecases;

import com.example.DemoRESTful.Reactive.collections.Dato;
import com.example.DemoRESTful.Reactive.mapper.MapperUtils;
import com.example.DemoRESTful.Reactive.model.DatoDTO;
import com.example.DemoRESTful.Reactive.repositories.Repositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCrear implements GuardarDato {

    private final Repositorio repositorio;
    private final MapperUtils mapperUtils;

    public UseCaseCrear(MapperUtils mapperUtils, Repositorio repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }


    @Override
    public Mono<String> apply(DatoDTO datoDTO) {
        return repositorio.save(mapperUtils.mapperToDato(null).apply(datoDTO)).map(Dato::getId);
    }
}
