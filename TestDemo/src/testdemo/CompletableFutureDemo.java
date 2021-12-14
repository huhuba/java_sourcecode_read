package testdemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            commonAction("动作1");
        });
/*        completableFuture.thenRunAsync(() -> System.out.println("1"));
        completableFuture.thenRunAsync(() -> System.out.println("2"));
        completableFuture.thenRunAsync(() -> System.out.println("3"));
        completableFuture.thenRunAsync(() -> System.out.println("4"));*/

        /**
         * thenRun（）方法是同步执行，
         */
/*
        completableFuture.thenRun(() -> System.out.println("1"))
        .thenRun(() -> System.out.println("2"))
        .thenRun(() -> System.out.println("3"))
        .thenRun(() -> System.out.println("4"))
        .get();
*/
        completableFuture.thenRun(() -> System.out.println("1"))
                .thenRun(() -> System.out.println("2"))
                .thenRun(() -> System.out.println("3"))
                .thenRun(() -> System.out.println("4"))
                .get();

    }
    public static void commonAction(String actionName) {
        System.out.println(actionName + ":start...");
/*        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(actionName + ":end...");
    }
}
