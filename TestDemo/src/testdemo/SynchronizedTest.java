package testdemo;

/**
 * 总结： 使用 sleep(1000)不释放同步锁，执行的是10*100+1=1001，wait(1000)释放了锁，执行的顺序是(10+1)x100=1100，所以sleep不释放锁，wait释放锁。
 */
public class SynchronizedTest extends Thread {
    int number = 10;

    public synchronized void first() {
        System.out.println("this is first!");
        number = number + 1;
    }

    public synchronized void secord() throws InterruptedException {
        System.out.println("this is secord!!");
//        Thread.sleep(1000);
        this.wait(1000);
        number = number * 100;
    }

    @Override
    public void run() {
        System.out.println("this is run!!");
        first();
    }


    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        synchronizedTest.start();
        synchronizedTest.secord();
        // 主线程稍等10毫秒
        Thread.sleep(10);
        System.out.println(synchronizedTest.number);
    }
}