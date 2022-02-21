package ru.netology.multitreading.homework.task1;

public class ThreadSetting extends Thread {

    private static final long SLEEP_TIME = 2500L;

    @Override
    public void run() {
        try {
            System.out.printf("%s is started...\n", currentThread().getName());
            while(!isInterrupted()) {
                Thread.sleep(SLEEP_TIME);
                System.out.printf("I'm %s!\n", currentThread().getName());
            }
        } catch (InterruptedException err) {
            err.printStackTrace();
        } finally{
            System.out.printf("%s is finished...\n", currentThread().getName());
        }
    }
}
