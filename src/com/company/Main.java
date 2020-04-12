package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch countDownLatch1 = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(3);
        new Uploader(countDownLatch);

        for (int i = 0; i < 10; i++) {
            new Downloader("Downloader" + i,countDownLatch,countDownLatch1,semaphore);
        }
        try {
            countDownLatch1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("файл удален с сервера");
    }
}
