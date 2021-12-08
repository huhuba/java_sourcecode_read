package testdemo;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorDemo {
    public static void main(String[] args) {

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
/*
        //execute():该方法立即执行 任务
        System.out.println("start:"+new Date());
        executor.execute(()->System.out.println("start:"+new Date()));
        System.out.println("start:"+new Date());
*/
/*
        //第一种用法：延迟 delay（数量）的 unit（单位）时间后开始执行 command
        executor.schedule(()->System.out.println("hello"),1, TimeUnit.SECONDS);
*/
        //第二种用法：延迟initialDelay(数量) unit(时间)后开始执行任务，之后延迟 delay（数量）的 unit（单位）时间后开始以固定的period(频率)循环执行 command
        //FixedRate：固定频率
        //Q:period:是否包含 command的执行时间？ command的执行时间> period 怎么样？
        //A:  如果 period>=command的执行时间 ,固定频率为 period;
        //    如果  period<command的执行时间 ,固定频率为 command的执行时间 ;
        System.out.println("start:"+new Date());
        executor.scheduleAtFixedRate(()->{
            System.out.println(new Date());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1,2,TimeUnit.SECONDS);
/*

        //第三种用法：
        //FixedDelay：固定延迟
        //延迟 initialDelay 后开始执行第一个任务，任务执行后（开始计时）固定延迟delay(数量) unit(单位)的时间后，开始执行下一个任务
        System.out.println("start:"+new Date());
        executor.scheduleWithFixedDelay(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date());

        },1,2,TimeUnit.SECONDS);*/
    }
}
