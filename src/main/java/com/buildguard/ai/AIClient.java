package com.buildguard.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AIClient {

    private final WebClient webClient;

    @Value("${ai.base-url}")
    private String baseUrl;

    public AIClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public String health() {
        return callGet("/health");
    }

    public String status() {
        return callGet("/status");
    }

    public String analyze(Object request) {
        return callPost("/analyze", request);
    }

    public String warning(Object request) {
        return callPost("/warning", request);
    }

    private String callGet(String endpoint) {
        try {
            return webClient.get()
                    .uri(baseUrl + endpoint)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (Exception e) {
            return "{\"status\":\"ERROR\",\"message\":\"" + e.getMessage() + "\"}";
        }
    }

    private String callPost(String endpoint, Object body) {
        try {
            return webClient.post()
                    .uri(baseUrl + endpoint)
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (Exception e) {
            return "{\"status\":\"ERROR\",\"message\":\"" + e.getMessage() + "\"}";
        }
    }
}