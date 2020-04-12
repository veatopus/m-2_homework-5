package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloader extends Thread {

    private CountDownLatch countDownLatch;
    private CountDownLatch countDownLatch1;
    private Semaphore semaphore;

    public Downloader(String name, CountDownLatch countDownLatch, CountDownLatch countDownLatch1, Semaphore semaphore) {
        super(name);
        this.countDownLatch = countDownLatch;
        this.countDownLatch1 = countDownLatch1;
        this.semaphore = semaphore;
        this.start();
    }

    @Override
    public synchronized void run() {
        try {

            countDownLatch.await();
            semaphore.acquire();
            System.out.println(getName() + " скачивает файл с сервера");
            sleep(500 / 100* 1000);
            System.out.println(getName() + " скачал файл");
            countDownLatch1.countDown();
            semaphore.release();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
