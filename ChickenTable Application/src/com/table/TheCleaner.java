package com.table;

public class TheCleaner implements Runnable{
    private final Table table;

    public TheCleaner(Table table) {
        this.table = table;
    }
    public void run() {
    int i = 1;
    while(i<=4){
        try {
            table.removeFromTable();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        i++;
    }
    }
}
