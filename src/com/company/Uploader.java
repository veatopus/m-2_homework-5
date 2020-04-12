package com.company;

import java.util.concurrent.CountDownLatch;

public class Uploader extends Thread {
    CountDownLatch countDownLatch;

    public Uploader(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        System.out.println("проект загружается на сервер");
        try {
            sleep(50/20*1000);
            System.out.print("*");
            sleep(50/20*1000);
            System.out.print("*");
            sleep(50/20*1000);
            System.out.print("*");
            sleep(50/20*1000);
            System.out.print("*");
            sleep(50/20*1000);
            System.out.print("*");
            sleep(50/20*1000);
            System.out.print("*");
            sleep(50/20*1000);
            System.out.print("*");
            sleep(50/20*1000);
            System.out.print("*");
            sleep(50/20*1000);
            System.out.print("*");
            sleep(50/20*1000);
            System.out.println("*");
            sleep(50/20*1000);
            System.out.println("проект загружен на сервер");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}