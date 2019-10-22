package com.youngclass;

public class ThreadTest extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("多线程："+i);
            if (i==6) {
                try {
                    Thread.sleep(10l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        try {
            ThreadTest threadTest = new ThreadTest();
            threadTest.start();
            for (int i = 0; i < 10; i++) {
                System.out.println("主线程："+i);
                if (i==4) {
                    Thread.sleep(10);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
