package com.playJava;
import java.util.Random;

import javax.swing.*;
import java.util.Random;

public class Producer implements Runnable {

    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;

    }

    @Override
    public void run() {
        int i = 1;
            // produce an item & enter it into the buffer
            try {
                buffer.put(i);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


    }

}
