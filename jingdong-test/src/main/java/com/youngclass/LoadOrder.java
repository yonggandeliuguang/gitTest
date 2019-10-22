package com.youngclass;

import org.junit.Test;

public class LoadOrder {

    public static void main(String[] args) {
        System.out.println(fun());
    }

    public static int fun(){
        int i = 10;
        try{
            i = i/0;
            return i--;
        }catch (Exception e){
            --i;
            return fun2();
        }finally {
            System.out.println(i);
            --i;
            return i--;
        }
    }
    public static int fun2(){
        System.out.println("hello java");
        return 1;
    }

    static class AClass{
        public static int a = 1;
    }

    @Test
    public void test(){
        AClass.a++;
        System.out.println(AClass.a);
    }


}


