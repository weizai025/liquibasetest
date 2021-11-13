package com.example.multithread;



import java.util.concurrent.Semaphore;

/**
 * @author maw-b
 * @date 2021/11/13 15:01
 */
public class OrderExecution {

    private static Semaphore switch2 = new Semaphore(0);
    private static Semaphore switch3 = new Semaphore(0);

    public static void main(String[] args) {

        Task2 task2 = new Task2(switch2,switch3);
        Task1 task1 = new Task1(switch2,switch3);
        Task3 task3 = new Task3(switch2,switch3);
        new Thread(task3).start();
        new Thread(task1).start();
        new Thread(task2).start();
    }


}

class Task1 implements Runnable {

    private Semaphore switch2;
    private Semaphore switch3;
    public Task1(Semaphore switch2,Semaphore switch3){
        this.switch2=switch2;
        this.switch3=switch3;
    }

    @Override
    public void run() {
        System.out.println("1");
        switch2.release();

    }
}

class Task2 implements Runnable {

    private Semaphore switch2;
    private Semaphore switch3;
    public Task2(Semaphore switch2,Semaphore switch3){
        this.switch2=switch2;
        this.switch3=switch3;
    }

    @Override
    public void run() {
        try {
            switch2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2");
        switch3.release();
    }
}

class Task3 implements Runnable {

    private Semaphore switch2;
    private Semaphore switch3;
    public Task3(Semaphore switch2,Semaphore switch3){
        this.switch2=switch2;
        this.switch3=switch3;
    }

    @Override
    public void run() {
        try {
            switch3.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3");
    }
}
