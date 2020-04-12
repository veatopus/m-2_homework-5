package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {
    Semaphore semaphore;
    CountDownLatch countDownLatch;

    public PassengerThread(String name, Semaphore semaphore, CountDownLatch countDownLatch) {
        super(name);
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        try {
            System.out.println(this.getName() + " пришел на вакзал и ждет очереди на кассе");
            sleep(5*1000);
            semaphore.acquire();
            System.out.println(getName() + " подошел к кассе и покупает билет");
            sleep(5*1000);
            System.out.println(getName() + " купил билет и садится на автобус");
            countDownLatch.countDown();
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
