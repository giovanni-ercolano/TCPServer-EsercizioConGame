package org.example;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private static GameModel INSTANCE;
    List<ClientHandler> clientList = new ArrayList<>();
    private MyTimer myTimer;

    private GameModel() {
        this.myTimer = new MyTimer();
        this.myTimer.start();
    }

    public static GameModel getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new GameModel();
        }

        return INSTANCE;
    }

    void addClient(ClientHandler client) {
        this.clientList.add(client);
    }

    void removeClient(ClientHandler client){
        this.clientList.remove(client);
        System.out.println("client connected : " + this.clientList.size());
    }
    void sendToAll(String msg){
        for (ClientHandler c : this.clientList){
            c.sendMsg(msg);
        }
    }
}
