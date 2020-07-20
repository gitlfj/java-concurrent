package com.lfj.concurrent.createthread;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 创建多线程的四种方法
 */
public class CreateThreadExample {

    public static void main(String[] args) {

        // 创建多线程方式1
        Thread1 thread1 = new Thread1();
        thread1.start();

        Thread1 thread2 = new Thread1();
        thread2.start();

        Thread1 thread3 = new Thread1();
        thread3.start();

        thread1.interrupt();


        // 创建多线程方式2

        Thread2 thread21 = new Thread2();
        new Thread(thread21).start();


        // 创建多线程方式3
        Thread3 thread31 = new Thread3();
        FutureTask<Integer> futureTask = new FutureTask<>(thread31);
        new Thread(futureTask).start();


        // 创建多线程方式4
        Thread4 thread4 = new Thread4();
        thread4.createThead4();

    }

}

/**
 *  创建多线程方式1,继承Thread类，重写run方法
 */
class Thread1 extends Thread{

    @Override
    public void run() {
        System.out.println("我是创建多线程的方式1");
    }
}

/**
 *  创建多线程方式2,实现Runnable接口
 */
class Thread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("我是创建多线程的方式2");
    }
}

/**
 *  创建多线程方式3,实现Callable接口
 */
class Thread3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("我是创建线程的方式3");
        return 3;
    }
}

/**
 *  创建多线程方式4,使用线程池
 */
class Thread4 {

    public void createThead4() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(() -> {
            System.out.println("我是创建线程的方式4");
        });
    }

}
