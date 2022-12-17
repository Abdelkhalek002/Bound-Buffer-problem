package com.playJava;

public class Semaphore {
    private int value;

    public Semaphore(int value) {
        this.value = value;
    }

    public  synchronized void acquire() {
        while (value <= 0) {
            try {
                wait();
            } catch (Exception e) {
            }
        }

        value--;
    }

    public synchronized void release() {
        ++value;
        notify();
    }
}
