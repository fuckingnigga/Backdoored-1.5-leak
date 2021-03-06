package com.backdoored.utils;

public class NoStackTraceThrowable extends RuntimeException
{
    public NoStackTraceThrowable() {
        this("");
    }
    
    public NoStackTraceThrowable(final String msg) {
        super(msg);
        this.setStackTrace(new StackTraceElement[0]);
    }
    
    @Override
    public String toString() {
        return "Go away john";
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
