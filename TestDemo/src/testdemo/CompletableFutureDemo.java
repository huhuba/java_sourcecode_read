package testdemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            commonAction("动作1");
        });

        //completableFuture是执行体的源:src
        //completableFuture1是执行体的依赖：dep,可以进行回调
        completableFuture.thenRun(() -> System.out.println("1"));
        completableFuture.thenRun(() -> System.out.println("2"));
        completableFuture.thenRun(() -> System.out.println("3"));
        completableFuture.thenRun(() -> System.out.println("4"));
        completableFuture.get();

    }

    public static void commonAction(String actionName) {
        System.out.println(actionName + ":start...");
        try {
            TimeUnit.SECONDS.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(actionName + ":end...");
    }
}
