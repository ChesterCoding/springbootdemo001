package com.offcn.po;



public class MainTest {

    public static void main(String[] args) {
        Thread thread = new Thread();

        thread.start();
        thread.setName("第一线程");

        System.out.println("测试github test");

    }
}
