package com.playJava;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Buffer {
    private static final int BUFFER_SIZE = 4;
    private final Semaphore mutex;
    private final Semaphore empty;
    private final Semaphore full;
    public Object[] buffer;
    private int in, out;
    int count = 0;


    public Buffer() {
        // buffer is initially empty
        in = 0;
        out = 0;
        buffer = new Object[BUFFER_SIZE];
        mutex = new Semaphore(1);
        empty = new Semaphore(BUFFER_SIZE);
        full = new Semaphore(0);

    }

    public Object get() throws InterruptedException {
        full.acquire();
        mutex.acquire();
        // remove an item from the buffer
        Date date= new Date();

        System.out.println("Consumer: "+Thread.currentThread().getName()  +" in critical section "+ date);
        Object item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;
        count --;
        mutex.release();
        System.out.println("Consumer: "+Thread.currentThread().getName()  +" left critical section");
        empty.release();
        System.out.println("Consumer has finished");
        return item;
    }

    public void put(Object item) throws InterruptedException {
        empty.acquire();
        mutex.acquire();
        // add an item to the buffer
        Date date= new Date();
        System.out.println("Producer: "+Thread.currentThread().getName()  +" in critical section " + date);
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;
        count ++;
        mutex.release();
        System.out.println("Producer: "+Thread.currentThread().getName()  +" left critical section");
        System.out.println("Producer has finished");
        full.release();
        Thread.sleep(2000);
    }
}
