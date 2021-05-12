

package network;

import javafx.application.Platform;


import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server extends Thread{

    private String roomCode;
    private ArrayList<Player> playerList = new ArrayList<>();
    private ArrayList<HandleAClient> socketList = new ArrayList<>();
    private int playerNum;

    public Server(String playerName){

        this.playerNum = 0;
        this.roomCode = generateRoomCode();
        System.out.println(this.roomCode);

    }
    @Override
    public void run(){

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(()->{

            try {

                ServerSocket serverSocket = new ServerSocket(8080);
                System.out.println("Server is running");

                while(true){

                    Socket socket = serverSocket.accept();
                    this.playerNum++;

                    System.out.println("Starting thread for client " + playerNum + "at" + new Date() + '\n');
                    InetAddress inetAddress = socket.getInetAddress();
                    System.out.println("Client" + playerNum + "'s IP Address is " + inetAddress.getHostAddress() + "\n");

                    DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());

                    byte[] bytes = new byte[1024];
                    String playerName = new String(bytes,0,inputFromClient.read(bytes));

                    Player newPlayer = new Player(playerName,Integer.toString(1000+playerNum));
                    playerList.add(newPlayer);

                    HandleAClient handleAclient = new HandleAClient(socket,newPlayer);
                    executor.execute(handleAclient);
                    socketList.add(handleAclient);


                    informPlayerListToAllPlayers();
                }


            }catch (IOException ex1){

                ex1.printStackTrace();

            }

        });
    }

    public synchronized void delectOnePlayer(Player player){
        playerNum--;

        int playerId = Integer.parseInt(player.getPlayerId()) - 1000;
        playerList.remove(playerId-1);
        System.out.println("successfully removed one player");
    }


    public void broadcastChat(String message){


        for(int i = 0 ; i < socketList.size(); i++){

            socketList.get(i).s2cReceiveChat(message);
        }

    }

    public void informPlayerListToAllPlayers(){


        for(int i = 0 ; i < socketList.size(); i++){

            socketList.get(i).s2cUpdatePlayerlist();
        }
    }


    //Generate a random roomCode according to IP address
    public String generateRoomCode(){

        try {

            InetAddress inetAddress = InetAddress.getLocalHost();
            String ip = inetAddress.getHostAddress();

            String roomCode = PublicFunctions.encryptAndDecrypt(ip);

            System.out.println("Room code is : " + roomCode);
            return roomCode;

        }catch (UnknownHostException ex){
            ex.printStackTrace();
            return "error!";
        }

    }


    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

}
