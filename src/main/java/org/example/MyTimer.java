package org.example;

import java.util.Date;

public class MyTimer extends Thread{
    @Override
    public void run() {
        while (true) {
            Date d = new Date();
            System.out.println(d.toString());
            GameModel.getInstance().sendToAll(d.toString());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
