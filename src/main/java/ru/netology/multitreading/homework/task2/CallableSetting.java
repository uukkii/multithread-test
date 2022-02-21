package ru.netology.multitreading.homework.task2;

import java.util.concurrent.Callable;

public class CallableSetting implements Callable<Long> {

    private static final long SLEEP_TIME = 2500L;
    private static long initialExecutionTime = 15000L;

    private Long msgCounter = 0L;

    @Override
    public Long call() {
        try {
            while (initialExecutionTime >= 0L) {
                System.out.printf("I'm %s!\n", Thread.currentThread().getName());
                Thread.sleep(SLEEP_TIME);

                msgCounter++;
                initialExecutionTime -= SLEEP_TIME;
            }
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return msgCounter;
    }
}
