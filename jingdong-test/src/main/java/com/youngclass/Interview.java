package com.youngclass;

import org.junit.Test;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Interview implements Cloneable {


    protected int i;

    public static void main(String[] args) {
//        int[] arrays = new int[]{5,2,6,3,8,10,1,9,7,4};
        try {
            Interview interview = new Interview();
            interview.i = 1;
            Interview clone = (Interview) interview.clone();
            clone.i=2;
            System.out.println(interview.i);
            System.out.println(clone.i);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public int[] quickSort(int[] arrays){
        if (arrays.length==1){
            return arrays;
        }
        return new int[]{quickSort(arrays)[0]};
    }






}
