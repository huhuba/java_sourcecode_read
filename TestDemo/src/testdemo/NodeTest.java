package testdemo;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NodeTest {

    static  class  MyTheadPool extends ThreadPoolExecutor {

        public MyTheadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            int i=1/0;
        }
    }

    public static void main(String[] args) {
        MyTheadPool myTheadPool = new MyTheadPool(1, 1, 0, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
        myTheadPool.execute(()->System.out.println("1"));
        myTheadPool.execute(()->System.out.println("1"));
        myTheadPool.execute(()->System.out.println("1"));


    }
}
