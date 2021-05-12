package network;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;

public class HandleAClient implements Runnable {

    private Socket socket;
    private Player player;
    private boolean isConnected;
    private DataInputStream fromclient;
    private DataOutputStream toclient;

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;


    public HandleAClient(Socket socket, Player player) {
        this.socket = socket;
        this.player = player;
        this.isConnected = true;

    }
    @Override
    public void run() {

        try {
            while (isConnected) {

                this.fromclient = new DataInputStream(socket.getInputStream());

                try {
                    socket.sendUrgentData(0);
                } catch (IOException e) {
                    isConnected = false;
                    closeSocket();
                    break;
                }

                try {

                    byte[] bytes = new byte[1024];

                    String messageMaster = new String(bytes, 0, fromclient.read(bytes));
                    String[] message = messageMaster.split("\\|");
                    String methodName = message[0];

                    System.out.println("MethodName: " + methodName);


                    if (message.length == 1) {

                        Method targetMethod = this.getClass().getMethod(methodName);
                        targetMethod.invoke(this);
                    } else {

                        Method targetMethod = this.getClass().getMethod(methodName, Class.forName("java.lang.String"));
                        targetMethod.invoke(this, messageMaster);
                    }

                } catch (Exception ex) {

                    ex.printStackTrace();
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void closeSocket() {

        try {

            Server server = Global.getServer();

            server.delectOnePlayer(this.player);

            socket.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }




    public void changeXcoordinate(String message) {

        System.out.println("Successfully change");
    }


    public void c2sAskPlayerList() {

        try {

            ArrayList<Player> playerArrayList = Global.getServer().getPlayerList();

            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(playerArrayList);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void c2sSendChat(String messageMaster) {

        String[] message = messageMaster.split("\\|");
        String chatMessage = message[1];

        Global.getServer().broadcastChat(chatMessage);
    }


    public void s2cReceiveChat(String message) {

        String messageMaster = "s2cReceiveChat|" + message;
        System.out.println("MessageMaster_receiveChat: " + messageMaster);
        try {

            this.toclient = new DataOutputStream(socket.getOutputStream());
            toclient.write(messageMaster.getBytes());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    public void s2cUpdatePlayerlist() {

        try {

            String method = "s2cUpdatePlayerlist";
            this.toclient = new DataOutputStream(socket.getOutputStream());
            toclient.write(method.getBytes());

            System.out.println("One socket has been informed");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
