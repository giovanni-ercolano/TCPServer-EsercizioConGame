package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer
{
    static int portNumber = 1234;
    static ServerSocket serverSocket;

    static boolean startServer(){
        try{
            serverSocket = new ServerSocket(portNumber);
            return true;
        }catch (Exception e){
            return false;
        }

    }


    public static void main( String[] args )
    {
        if(!startServer()){
            return;
        }

        while (true){

            Socket clientSocket;
            try{
                clientSocket = serverSocket.accept();
            } catch(IOException e){
                throw new RuntimeException(e);
            }

            ClientHandler clientHandler = new ClientHandler(clientSocket);
            GameModel.getInstance().addClient(clientHandler);
            clientHandler.start();
        }
    }

}