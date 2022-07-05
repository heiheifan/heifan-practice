package com.heifan.multithreading._1_create;

public class ExtendsThread extends Thread{
    public static volatile int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        ExtendsThread t1 = new ExtendsThread();
        ExtendsThread t2 = new ExtendsThread();
        t1.setName("t1");
        t2.setName("t2");
        t1.setPriority(10);
        t2.setPriority(1);
        t2.setDaemon(Boolean.TRUE);
        t1.start();
        t2.start();
    }
}
