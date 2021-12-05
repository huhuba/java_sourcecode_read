package testdemo;


import java.util.concurrent.*;

public class NodeTest2 {

    static  class  MyTheadPool extends ThreadPoolExecutor {


        public MyTheadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            int i=1/0;
        }
    }

    public static void main(String[] args) {
        MyTheadPool myTheadPool = new MyTheadPool(1, 1, 0, TimeUnit.MINUTES, new LinkedBlockingQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println(t.getName()+"出错了："+e.toString());
                    }
                });
                return thread;
            }
        },new ThreadPoolExecutor.CallerRunsPolicy());
        myTheadPool.execute(()->System.out.println("1"));
        myTheadPool.execute(()->System.out.println("1"));
        myTheadPool.execute(()->System.out.println("1"));


    }
}
