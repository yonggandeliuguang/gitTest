package com.youngclass;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

public class EqualsTest {

    private static final int[] a = new int[5];


    @Test
    public void test(){

        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("111111");
            }
        };

        Thread thread = new Thread();
        thread.start();


    }

    public static void main(String[] args) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("111111");
            }
        };

        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("55");
                Thread.currentThread().getName();
            }
        };
        thread.start();
    }

}
