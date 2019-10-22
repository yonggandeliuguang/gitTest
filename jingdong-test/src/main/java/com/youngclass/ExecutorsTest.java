package com.youngclass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池测试
 */
public class ExecutorsTest {

    public static void main(String[] args) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(run);
        executorService.shutdown();
        System.out.println(executorService.isShutdown());
    }
}
