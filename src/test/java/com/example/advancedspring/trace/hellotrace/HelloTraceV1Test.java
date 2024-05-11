package com.example.advancedspring.trace.hellotrace;

import static org.junit.jupiter.api.Assertions.*;

import com.example.advancedspring.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloTraceV1Test {

    @Test
    @DisplayName("")
    void begin_end() {
        //given
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus traceStatus = trace.begin("hello");

        //when
        trace.end(traceStatus);

        //then
    }

    @Test
    @DisplayName("")
    void begin_exception() {
        //given
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus traceStatus = trace.begin("hello");

        //when
        trace.exception(traceStatus, new IllegalArgumentException());

        //then
    }

}
