package testdemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            commonAction("动作1");
        });

        //completableFuture是执行体的源:src
        //completableFuture1是执行体的依赖：dep,可以进行回调
        completableFuture.thenRun(() -> System.out.print("1 "));
        completableFuture.thenRun(() -> System.out.print("2 "));
        completableFuture.thenRun(() -> System.out.print("3 "));
        CompletableFuture<Void> completableFuture1 = completableFuture.thenRun(() -> {
//            commonAction("动作2");
        });//此时不入栈，是stage
        completableFuture1.thenRun(() -> System.out.print("5 "));
        completableFuture1.thenRun(() -> System.out.print("6 "));
        completableFuture1.thenRun(() -> System.out.print("7 "));

        CompletableFuture<Void> completableFuture2 = completableFuture1.thenRun(() ->{
//            commonAction("动作3");

        });
        completableFuture2.thenRun(() -> System.out.print("9 "));
        completableFuture2.thenRun(() -> System.out.print("10 "));
        completableFuture2.thenRun(() -> System.out.print("11 "));

        CompletableFuture<Void> completableFuture3 = completableFuture2.thenRun(() ->{
//            commonAction("动作4");

        });
        completableFuture3.thenRun(() -> System.out.print("12 "));
        completableFuture3.thenRun(() -> System.out.print("13 "));
        completableFuture3.thenRun(() -> System.out.print("14 "));

//        completableFuture3.get();
        completableFuture2.get();
    }

    public static void commonAction(String actionName) {
        System.out.println();
        System.out.println(actionName + ":start...");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(actionName + ":end...");

    }
}
