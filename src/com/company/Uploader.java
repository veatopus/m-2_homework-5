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
            sleep(500/20*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}