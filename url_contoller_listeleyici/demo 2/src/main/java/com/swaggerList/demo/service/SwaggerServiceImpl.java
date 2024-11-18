package com.swaggerList.demo.service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@Service
public class SwaggerServiceImpl implements SwaggerService {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    @Value("${swagger.url}")
    private String swaggerUrl;

    public SwaggerServiceImpl(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder.build();
        this.objectMapper = objectMapper;
    }

    /*@Override
    public Mono<String> getControllers() {
        return webClient.get()
                .uri(swaggerUrl)
                .retrieve()
                .bodyToMono(String.class)
                .map(this::extractSpecificTags);
    }*/

    @Override
    public Mono<String> getControllers() {
        return retrieveSwaggerJson(swaggerUrl)
                .onErrorResume(e -> tryAlternativeEndpoints(swaggerUrl))
                .map(this::extractSpecificTags);
    }

    private Mono<String> retrieveSwaggerJson(String url) {
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
    }

    private Mono<String> tryAlternativeEndpoints(String baseUrl) {
        // Try /v3/api-docs first
        return retrieveSwaggerJson(baseUrl + "/v3/api-docs")
                .onErrorResume(e -> retrieveSwaggerJson(baseUrl + "/swagger.json"));
    }

    private String extractSpecificTags(String swaggerJson) {
        try {
            JsonNode root = objectMapper.readTree(swaggerJson);
            JsonNode tagsNode = root.path("tags");
            StringBuilder tags = new StringBuilder("Controllers:\n");

            if (tagsNode.isArray()) {
                for (JsonNode tag : tagsNode) {
                    String tagName = tag.path("name").asText();
                    tags.append(tagName).append("\n");
                }
            } else {
                tags.append("No controllers found.");
            }

            return tags.toString();
        } catch (Exception e) {
            return "Failed to parse the Swagger JSON: " + e.getMessage();
        }
    }
}


/*@Service
public class SwaggerServiceImpl implements SwaggerService {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    @Value("${swagger.url}")
    private String swaggerUrl;

    public SwaggerServiceImpl(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder.build();
        this.objectMapper = objectMapper;
    }

    @Override
    public Mono<String> getControllers() {
        return fetchSwaggerJsonFromHtml(swaggerUrl)
                .flatMap(this::retrieveSwaggerJson)
                .map(this::extractSpecificTags)
                .onErrorResume(e -> Mono.just("Failed to retrieve Swagger JSON: " + e.getMessage()));
    }

    private Mono<String> fetchSwaggerJsonFromHtml(String url) {
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .map(this::extractJsonUrlFromHtml);
    }

    private String extractJsonUrlFromHtml(String htmlContent) {
        // Regex to find Swagger JSON URL
        Pattern pattern = Pattern.compile("url: \"(.*?)\"", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlContent);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new RuntimeException("Swagger JSON URL not found in HTML content.");
        }
    }

    private Mono<String> retrieveSwaggerJson(String jsonUrl) {
        return webClient.get()
                .uri(jsonUrl)
                .retrieve()
                .bodyToMono(String.class);
    }

    private String extractSpecificTags(String swaggerJson) {
        try {
            JsonNode root = objectMapper.readTree(swaggerJson);
            JsonNode tagsNode = root.path("tags");
            StringBuilder tags = new StringBuilder("Controllers:\n");

            if (tagsNode.isArray()) {
                for (JsonNode tag : tagsNode) {
                    String tagName = tag.path("name").asText();
                    tags.append(tagName).append("\n");
                }
            } else {
                tags.append("No controllers found.");
            }

            return tags.toString();
        } catch (Exception e) {
            return "Failed to parse the Swagger JSON: " + e.getMessage();
        }
    }
}*/


/*@Service
public class SwaggerServiceImpl implements SwaggerService {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    @Value("${swagger.url}")
    private String swaggerUrl;

    public SwaggerServiceImpl(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder.build();
        this.objectMapper = objectMapper;
    }

    @Override
    public Mono<String> getControllers() {
        return fetchSwaggerResources()
                .flatMapMany(Flux::fromIterable)
                .flatMap(this::retrieveSwaggerJson)
                .map(this::extractSpecificTags)
                .collectList()
                .map(tagsList -> String.join("\n", tagsList))
                .onErrorResume(e -> Mono.just("Failed to retrieve Swagger JSON: " + e.getMessage()));
    }

    private Mono<List<JsonNode>> fetchSwaggerResources() {
        return webClient.get()
                .uri(swaggerUrl + "/swagger-resources")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<JsonNode>>() {});
    }

    private Mono<String> retrieveSwaggerJson(JsonNode resource) {
        String url = resource.path("url").asText();
        if (!url.startsWith("http")) {
            url = swaggerUrl + url;
        }
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
    }

    private String extractSpecificTags(String swaggerJson) {
        try {
            JsonNode root = objectMapper.readTree(swaggerJson);
            JsonNode tagsNode = root.path("tags");
            StringBuilder tags = new StringBuilder("Controllers:\n");

            if (tagsNode.isArray()) {
                for (JsonNode tag : tagsNode) {
                    String tagName = tag.path("name").asText();
                    tags.append(tagName).append("\n");
                }
            } else {
                tags.append("No controllers found.");
            }

            return tags.toString();
        } catch (Exception e) {
            return "Failed to parse the Swagger JSON: " + e.getMessage();
        }
    }
}*/



