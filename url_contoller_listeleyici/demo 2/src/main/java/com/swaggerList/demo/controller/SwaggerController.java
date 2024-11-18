package com.swaggerList.demo.controller;

import com.swaggerList.demo.service.SwaggerService;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;




@RestController
public class SwaggerController {

    private final SwaggerService swaggerService;

    public SwaggerController(SwaggerService swaggerService) {
        this.swaggerService = swaggerService;
    }

    @GetMapping("/list-controllers")
    public Mono<String> listControllers() {
        return swaggerService.getControllers();
    }
}



