package com.table;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Table table = new  Table();
        Servant service= new Servant(table);
        TheCleaner clean = new TheCleaner(table);

        Thread ServantThread = new Thread(service);
        Thread TheCleanerthread = new Thread(clean);
        ServantThread.start();
        TheCleanerthread.start();
        ServantThread.join();
        TheCleanerthread.join();
        System.out.println("\n\n");
        System.out.println("you have "+table.count+" Chicken in your Table!");
    }
}