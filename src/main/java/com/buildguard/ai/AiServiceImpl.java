package com.buildguard.ai;

import org.springframework.stereotype.Service;

@Service
public class AiServiceImpl implements AiService {

    private final AIClient aiClient;

    public AiServiceImpl(AIClient aiClient) {
        this.aiClient = aiClient;
    }

    @Override
    public String health() {
        return aiClient.health();
    }

    @Override
    public String status() {
        return aiClient.status();
    }

    @Override
    public String analyze(Object request) {
        return aiClient.analyze(request);
    }

    @Override
    public String warning(Object request) {
        return aiClient.warning(request);
    }
}