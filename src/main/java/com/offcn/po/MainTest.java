package com.offcn.po;

import javax.servlet.Servlet;

public class MainTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest());

        thread.start();
        thread.setName("第一线程");

    }
}
