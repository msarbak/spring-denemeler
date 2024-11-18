package com.swaggerList.demo.service;


import reactor.core.publisher.Mono;

public interface SwaggerService {
    Mono<String> getControllers();
}


