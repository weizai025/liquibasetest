package com.example.multithread;

/**
 * @author maw-b
 * @date 2021/11/13 16:49
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 依次打印 foobar n次  一个线程打印foo 一个线程打印bar
 */
public class OrderExecution3 {

    public static void main(String[] args) {
        Semaphore switch1 = new Semaphore(1);
        Semaphore switch2 = new Semaphore(0);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Foo(switch1,switch2,5));
        executorService.submit(new Bar(switch1,switch2,5));
        executorService.shutdown();
    }
}



class Foo implements Runnable{
    Semaphore switch1;
    Semaphore switch2;
    int n=0;
    public Foo(Semaphore switch1,Semaphore switch2,int n){
        this.switch1=switch1;
        this.switch2=switch2;
        this.n=n;
    }

    @Override
    public void run() {
        for(int i=0;i<n;i++){
            try {
                switch1.acquire();
                System.out.print(i+":"+"foo");
                switch2.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

class Bar implements Runnable{

    Semaphore switch1;
    Semaphore switch2;
    int n=0;

    public Bar(Semaphore switch1,Semaphore switch2,int n){
        this.switch1=switch1;
        this.switch2=switch2;
        this.n=n;
    }

    @Override
    public void run() {
        for(int i=0;i<n;i++){
            try {
                switch2.acquire();
                System.out.println("bar");
                switch1.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
