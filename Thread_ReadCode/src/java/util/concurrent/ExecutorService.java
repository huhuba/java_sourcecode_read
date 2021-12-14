/*
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

/*
 *
 *
 *
 *
 *
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;

import java.util.Collection;
import java.util.List;

public interface ExecutorService extends Executor {

    /**     关闭服务     */
    void shutdown();

    /** 立刻关闭服务*/
    List<Runnable> shutdownNow();

    /** 判断服务是否调用了 shutdown */
    boolean isShutdown();
    /** 判断服务是否完全终止 */
    boolean isTerminated();
    /**  等待当前服务停止,等待一定的时间*/
    boolean awaitTermination(long timeout, TimeUnit unit)
        throws InterruptedException;

     /** 提交一个任务 Callable task,返回一个存根 */
    <T> Future<T> submit(Callable<T> task);

    /** 提交一个任务 Runnable task,返回一个存根 ,result 为执行完返回的值*/
    <T> Future<T> submit(Runnable task, T result);

    /** 提交一个任务 Runnable task,返回一个存根 */
    Future<?> submit(Runnable task);
    /** 提交一组Callable执行，并返回所有任务的存根 */
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
        throws InterruptedException;

    /** 提交一组Callable执行，并返回所有任务的存根，注意：这个包含了等该执行的时间，等待一定的时间就返回 */
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                  long timeout, TimeUnit unit)
        throws InterruptedException;

    /** 提交一组任务，等待其中任何一个执行完毕并返回 */
    <T> T invokeAny(Collection<? extends Callable<T>> tasks)
        throws InterruptedException, ExecutionException;

    /** 提交一组任务，等待其中任何一个执行完毕并返回,注意：这个包含了等该执行的时间，等待一定的时间就返回  */
    <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                    long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
}
