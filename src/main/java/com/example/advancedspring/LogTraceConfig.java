package com.example.advancedspring;

import com.example.advancedspring.trace.logtrace.FieldLogTrace;
import com.example.advancedspring.trace.logtrace.LogTrace;
import com.example.advancedspring.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
//        return new FieldLogTrace();
        return new ThreadLocalLogTrace();
    }
}
