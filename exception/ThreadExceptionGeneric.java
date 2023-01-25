package exception;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadExceptionGeneric implements UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        System.out.println("Exceção na thread " + thread.getName() + ": " + ex.getMessage());
    }
}