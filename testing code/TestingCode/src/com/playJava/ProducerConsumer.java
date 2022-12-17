package com.playJava;
public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Thread ProducerThread = new Thread(producer);
        Thread ConsumerThread = new Thread(consumer);
        ProducerThread.start();
        ConsumerThread.start();
        ProducerThread.join();
        ConsumerThread.join();
    }
}