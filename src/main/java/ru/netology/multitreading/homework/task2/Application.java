package ru.netology.multitreading.homework.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Application {

    private static ExecutorService threadPool;

    private static final String ONE_SWITCH_ANSWER = "one";
    private static final String SUM_SWITCH_ANSWER = "sum";

    private static long result = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        final List<Callable<Long>> listOfCallable = fillListOfTasks();

        final List<Future<Long>> tasks = threadPool.invokeAll(listOfCallable);

        showResult(getResultByOne(listOfCallable), ONE_SWITCH_ANSWER);
        showResult(getResult(tasks), SUM_SWITCH_ANSWER);

        threadPool.shutdown();
    }

    private static List<Callable<Long>> fillListOfTasks() {
        final Callable<Long> myCallable1 = new CallableSetting();
        final Callable<Long> myCallable2 = new CallableSetting();
        final Callable<Long> myCallable3 = new CallableSetting();
        final Callable<Long> myCallable4 = new CallableSetting();

        final List<Callable<Long>> listOfCallable = new ArrayList<>();

        listOfCallable.add(myCallable1);
        listOfCallable.add(myCallable2);
        listOfCallable.add(myCallable3);
        listOfCallable.add(myCallable4);

        return listOfCallable;
    }

    private static void showResult(Long result, String choose) {
        switch (choose) {
            case "one" -> System.out.printf("\nNumber of one random thread messages: %d\n", result);
            case "sum" -> System.out.printf("Summary messages was sent: %d\n", result);
            default -> System.out.println("Invalid input!");
        }
    }

    private static Long getResult(List<Future<Long>> tasks) throws ExecutionException, InterruptedException {
        for (Future<Long> task : tasks) {
            result += task.get();
        } return result;
    }

    private static Long getResultByOne(List<Callable<Long>> listOfCallable) throws ExecutionException, InterruptedException {
        return threadPool.invokeAny(listOfCallable);
    }
}
