package testdemo;

import java.util.concurrent.*;

public class ThreadDemo {

    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                try {

                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return 1;
            }
        });

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(futureTask);


    }
}
