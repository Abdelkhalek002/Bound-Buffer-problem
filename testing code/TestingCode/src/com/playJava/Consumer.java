package com.playJava;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable{
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
            // consume an item from the buffer
            try {
                //message = (Integer)
                buffer.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }
}
