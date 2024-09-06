package com.example.advancedspring.trace.logtrace;

import com.example.advancedspring.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception ex);
}
