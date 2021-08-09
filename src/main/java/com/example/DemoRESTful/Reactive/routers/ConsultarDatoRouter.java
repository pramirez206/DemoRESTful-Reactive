package com.example.DemoRESTful.Reactive.routers;

import com.example.DemoRESTful.Reactive.model.DatoDTO;
import com.example.DemoRESTful.Reactive.usecases.UseCaseListar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class ConsultarDatoRouter {

    @Bean
    public RouterFunction<ServerResponse> getAll(UseCaseListar useCaseListar) {
        return route(
                GET("/consultar").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseListar.get(), DatoDTO.class))
        );
    }



}
