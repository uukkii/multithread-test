package ru.netology.multitreading.homework.task1;

public class Application {

    private static final String THREAD_GROUP_NAME = "mainGroup";

    private static final String THREAD_1_NAME = "Thread #1";
    private static final String THREAD_2_NAME = "Thread #2";
    private static final String THREAD_3_NAME = "Thread #3";
    private static final String THREAD_4_NAME = "Thread #4";

    private static final long SLEEP_TIME = 15000L;

    public static void main(String[] args) throws InterruptedException {

        final ThreadGroup mainGroup = new ThreadGroup(THREAD_GROUP_NAME);

        fillAndStartThreadGroup(mainGroup);
        Thread.sleep(SLEEP_TIME);

        mainGroup.interrupt();
    }

    private static void fillAndStartThreadGroup (ThreadGroup name) {
        final Thread thread1 = new Thread(name, new ThreadSetting(), THREAD_1_NAME);
        final Thread thread2 = new Thread(name, new ThreadSetting(), THREAD_2_NAME);
        final Thread thread3 = new Thread(name, new ThreadSetting(), THREAD_3_NAME);
        final Thread thread4 = new Thread(name, new ThreadSetting(), THREAD_4_NAME);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}
