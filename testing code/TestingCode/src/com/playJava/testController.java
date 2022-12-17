package com.playJava;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class testController extends Application{


    @FXML
    Button RunID;
    @FXML
    Spinner producerID;
    @FXML
    Spinner ConsumerID;
    @FXML
    TextArea TextAreaID;

    public int getDataFromProducer(){
        int x;
        x = (int)producerID.getValue();
        return x;
    }
    public int getDataFromConsumer(){
        int y ;
        y = (int)ConsumerID.getValue();
        return y;
    }
    public void run() throws InterruptedException {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);


        Thread ProducerThread = new Thread(producer);
        Thread ConsumerThread = new Thread(consumer);
        ProducerThread.start();
        ConsumerThread.start();
        ProducerThread.join();
        ConsumerThread.join();
        System.out.println(buffer.count);
    }
    public void Check() throws InterruptedException {
        int a = getDataFromProducer();
        int b = getDataFromConsumer();
        if(a>=b){
            for (int i = 1; i<=a;i++){
                Buffer buffer = new Buffer();
                Producer producer = new Producer(buffer);
                Consumer consumer = new Consumer(buffer);
                Thread ProducerThread = new Thread(producer);
                Thread ConsumerThread = new Thread(consumer);
                ProducerThread.start();
                if(b != 0 && b > 0){
                ConsumerThread.start();
                ConsumerThread.join();
                }
                b--;
                ProducerThread.join();
            }
        }
        else{
            for (int i = 0; i<=(b%a);i++){
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
            System.out.println("there is no more consumers to consume " +(b%a)+ " items in the buffer!");
        }
    }
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(testController.class.getResource("test.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setResizable(false);
        stage.setTitle("Bounded-Buffer problem");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {

        launch();

    }


}