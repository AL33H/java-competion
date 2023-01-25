

import exception.ThreadExceptionGeneric;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryImpl implements ThreadFactory {

    private static int numero = 1;

    @Override
    public Thread newThread(Runnable tarefa) {
        Thread thread = new Thread(tarefa, "THREAD: " + numero);
        numero++;
        thread.setUncaughtExceptionHandler(new ThreadExceptionGeneric());
        return thread;
    }
}
