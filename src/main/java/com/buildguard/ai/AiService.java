package com.buildguard.ai;

public interface AiService {

    String health();

    String status();

    String analyze(Object request);

    String warning(Object request);

}