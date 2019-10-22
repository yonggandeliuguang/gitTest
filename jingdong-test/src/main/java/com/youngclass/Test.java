package com.youngclass;

import java.util.*;

public class Test {

    public static void main(String[] args) {
//        new B("张三");
//        System.out.println(B.astr2);
//        new B();
//        System.out.println(B.astr1);
    }

    @org.junit.Test
    public void test() {
        String s0 = "helloworld";
        String s1 = new String("helloworld");
        String s2 = "hello" + new String("world");
        System.out.println("===========test4============");
        System.out.println(s0 == s1); //false
        System.out.println(s0 == s2); //false
        System.out.println(s1 == s2); //false
    }

    @org.junit.Test
    public void test2() {
        Random random = new Random();
        int index;
        List<Integer> numbers = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            for (int k = 0; k < 33; k++) {
                numbers.add(k + 1);
            }
            for (int j = 0; j < 6; j++) {
                index = random.nextInt(numbers.size());
                builder.append(numbers.get(index) + " ");
                numbers.remove(index);
            }
            builder.deleteCharAt(builder.lastIndexOf(" "));
            builder.append("-" + (random.nextInt(16) + 1));
            System.out.println(builder.toString());
            builder.delete(0, builder.length());
            numbers.clear();
        }

    }

    @org.junit.Test
    public void test4() {
        Random random = new Random();
        int index;
        List<Integer> numbers = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        List<Integer> rights = new LinkedList<>();
        List<Integer> all = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            for (int k = 0; k < 35; k++) {
                numbers.add(k + 1);
            }
            for (int j = 0; j < 5; j++) {
                index = random.nextInt(numbers.size());
                all.add(numbers.remove(index));
            }
            for (int n = 0; n < 12; n++) {
                rights.add(n + 1);
            }
            numbers.clear();
            for (int j = 0; j < 2; j++) {
                index = random.nextInt(rights.size());
                numbers.add(rights.remove(index));
            }
            Collections.sort(all);
            Collections.sort(numbers);
            builder.append(all.toString().replace("[","").replace("]","").replace(",",""));
            builder.append("-");
            builder.append(numbers.toString().replace("[","").replace("]","").replace(",",""));
            System.out.println(builder.toString());
            rights.clear();
            builder.delete(0,builder.length());
            all.clear();
            numbers.clear();
        }

    }

    @org.junit.Test
    public void test5() {
        Random random = new Random();
        int index;
        List<Integer> numbers = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        List<Integer> rights = new LinkedList<>();
        List<Integer> all = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 35; k++) {
                numbers.add(k + 1);
            }
            for (int j = 0; j < 12; j++) {
                index = random.nextInt(numbers.size());
                all.add(numbers.remove(index));
            }
            for (int n = 0; n < 12; n++) {
                rights.add(n + 1);
            }
            numbers.clear();
            for (int j = 0; j < 3; j++) {
                index = random.nextInt(rights.size());
                numbers.add(rights.remove(index));
            }
            Collections.sort(all);
            Collections.sort(numbers);
            builder.append(all.toString().replace("[","").replace("]","").replace(",",""));
            builder.append("-");
            builder.append(numbers.toString().replace("[","").replace("]","").replace(",",""));
            System.out.println(builder.toString());
            rights.clear();
            builder.delete(0,builder.length());
            all.clear();
            numbers.clear();
        }

    }


    @org.junit.Test
    public void test3() {
        StringBuilder builder = new StringBuilder();
        builder.append("4433");
        System.out.println(builder.indexOf("3"));
    }


}

class A {
    A() {
        System.out.println("父亲构造函数被调用！");
    }

    A(String name) {
        System.out.println("父亲带参构造函数被调用：" + name);
    }

//    public static B b = new B();

    public static String astr2 = "父亲静态普通字符串";

    public static final String astr1 = "父亲静态常量字符串";


    static {
        System.out.println("执行父类静态函数");
    }

    {
        System.out.println("父亲普通函数被调用！");
    }

    private static String str = "123456";
}

class B extends A {
    B() {
        System.out.println("孩子构造函数被调用！");
    }

    B(String name) {
        super(name);
        System.out.println("孩子带参构造函数被调用：" + name);
    }

    public static final String str2 = "孩子静态常量字符串！";

    static {
        System.out.println("执行子类静态函数");
    }

    {
        System.out.println("孩子普通函数被调用！");
    }


}


abstract class D{
    public static final String str = "abc";
}

class E extends D{


}
