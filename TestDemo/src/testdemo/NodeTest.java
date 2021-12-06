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
            try{
                int i=1/0;
            }catch (ArithmeticException e){//捕捉异常，不做处理的话，系统也不会抛出该异常，就给没有出现过一样，“一切正常”

            }
        }
    }

    public static void main(String[] args) {
        MyTheadPool myTheadPool = new MyTheadPool(1, 1, 0, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
        myTheadPool.execute(()->System.out.println("1"));
        myTheadPool.execute(()->System.out.println("1"));
        myTheadPool.execute(()->System.out.println("1"));


    }
}
