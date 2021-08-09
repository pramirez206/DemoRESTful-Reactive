package com.example.DemoRESTful.Reactive.routers;

import com.example.DemoRESTful.Reactive.model.DatoDTO;
import com.example.DemoRESTful.Reactive.usecases.UseCaseCrear;
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
public class CrearDatoRouter {

    @Bean
    public RouterFunction<ServerResponse> createQuestion(UseCaseCrear useCaseCrear) {
        return route(POST("/crear").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(DatoDTO.class)
                        .flatMap(questionDTO -> useCaseCrear.apply(questionDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.TEXT_PLAIN)
                                        .bodyValue(result))
                        )
        );
    }

}