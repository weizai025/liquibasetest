package com.example.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author maw-b
 * @date 2021/11/13 15:34
 */
public class OrderExecution2 {

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Task11(integer));
        executorService.submit(new Task33(integer));
        executorService.submit(new Task22(integer));
    }

}

class Task11 implements Runnable{

    private AtomicInteger atomicInteger;

    public Task11(AtomicInteger atomicInteger){
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {

        System.out.println(1);
        atomicInteger.incrementAndGet();
    }
}

class Task22 implements Runnable{

    private AtomicInteger atomicInteger;

    public Task22(AtomicInteger atomicInteger){
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        while(atomicInteger.get()%3!=1){

        }

        System.out.println(2);
        atomicInteger.incrementAndGet();

    }
}


class Task33 implements Runnable{

    private AtomicInteger atomicInteger;

    public Task33(AtomicInteger atomicInteger){
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        while(atomicInteger.get()%3!=2){

        }
        System.out.println(3);
        atomicInteger.incrementAndGet();
        System.exit(0);
    }
}



