package com.company;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("введите номер домашки которую хотите проверить");
            System.out.println("1.А)   2.Б)");
            int userChoice = new Scanner(System.in).nextInt();
            switch (userChoice) {
                case 1:
                    a();
                    break;
                case 2:
                    b();
                    break;

            }
        }
    }

    public static void a() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch countDownLatch1 = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(3, true);
        new Uploader(countDownLatch);

        for (int i = 1; i <= 10; i++) {
            new Downloader("Downloader" + i, countDownLatch, countDownLatch1, semaphore);
        }
        try {
            countDownLatch1.await();
            System.out.println("файл удален с сервера");
            Thread.sleep(45*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void b() {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        Semaphore semaphore = new Semaphore(4, true);

        for (int i = 1; i <= 100; i++) {
            new PassengerThread("Пассажир " + i, semaphore, countDownLatch);
        }
        try {
            countDownLatch.await();
            System.out.println("Ура, наконец-то автобус отправляется в город Ош");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}