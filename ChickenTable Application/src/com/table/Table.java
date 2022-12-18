package com.table;

import java.util.Date;
import java.util.concurrent.Semaphore;

public class Table {
    private static final int TABLE_SIZE = 5;
    private final Semaphore mutex;
    private final Semaphore empty;
    private final Semaphore full;
    public Object[] table;
    private int in, out;
    int count = 0;


    public Table() {
        // table is initially empty
        in = 0;
        out = 0;
        table = new Object[TABLE_SIZE];
        mutex = new Semaphore(1);
        empty = new Semaphore(TABLE_SIZE);
        full = new Semaphore(0);

    }


    public Object removeFromTable() throws InterruptedException {
        full.acquire();
        mutex.acquire();
        Date date= new Date();
        Object item = table[out];
        out = (out + 1) % TABLE_SIZE;
        count --;
        mutex.release();
        System.out.println("TheCleaner: the Chicken has been removed from  table at "+date);
        empty.release();
        System.out.println("one chicken has been removed from table!");
        //System.out.println("\n");
        return item;
    }

    public void addToTable(Object item) throws InterruptedException {
        empty.acquire();
        mutex.acquire();
        Date date= new Date();
        table[in] = item;
        in = (in + 1) % TABLE_SIZE;
        count ++;
        mutex.release();
        System.out.println("Servant: the chicken has been added to your table at "+date);
        System.out.println("one chicken has been added to your table !");
        full.release();
        Thread.sleep(1000);
    }
}
