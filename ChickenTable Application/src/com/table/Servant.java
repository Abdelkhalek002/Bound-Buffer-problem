package com.table;

public class Servant implements Runnable {

    private final Table table;

    public Servant(Table buffer) {
        this.table = buffer;

    }

    @Override
    public void run() {
        int i = 1;
        while(i <=4){
        try {
            table.addToTable(i);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            i++;
        }
    }

}
