

package network;

import java.io.*;
import java.lang.reflect.Method;
import java.net.*;
import java.util.ArrayList;


public class Client extends Thread {

    private String playerId;
    private String playerName;
    private String roomCode;

    private DataInputStream fromServer;
    private DataOutputStream toServer;

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    private Socket socket;


//
//            this.objectInputStream = new ObjectInputStream(socket.getInputStream());
//            this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

    public Client(String roomCode, String playerName) {

        this.roomCode = roomCode;
        this.playerName = playerName;

    }

    @Override
    public void run() {

        try {

            String ip = PublicFunctions.encryptAndDecrypt(roomCode);

            Socket socket1 = new Socket(ip, 8080);

            setSocket(socket1);

            this.toServer = new DataOutputStream(socket.getOutputStream());
            this.toServer.write(playerName.getBytes());

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        while (true) {

            try {

                byte[] bytes = new byte[1024];

                this.fromServer = new DataInputStream(socket.getInputStream());
                String messageMaster = new String(bytes, 0, fromServer.read(bytes));
                String[] message = messageMaster.split("\\|");
                String methodName = message[0];


                if (message.length == 1) {

                    Method targetMethod = this.getClass().getMethod(methodName);
                    targetMethod.invoke(this);
                } else {

                    Method targetMethod = this.getClass().getMethod(methodName, Class.forName("java.lang.String"));
                    targetMethod.invoke(this, messageMaster);
                }

                fromServer = null;

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }


    public ArrayList<Player> c2sAskPlayerList() {

        ArrayList<Player> playerArrayList = new ArrayList<>();
        String method = "c2sAskPlayerList";


        try {

            toServer = new DataOutputStream(this.socket.getOutputStream());
            if (this.toServer == null) {
                System.out.println("toServer is null");

                if (this.socket == null) {
                    System.out.println("socket is null");
                }

            } else {
                this.toServer.write(method.getBytes());
            }

            objectInputStream = new ObjectInputStream(socket.getInputStream());
            playerArrayList = (ArrayList<Player>) objectInputStream.readObject();


        } catch (ClassNotFoundException ex) {

            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return playerArrayList;
    }

    public void c2sSendChat(String chat) {

        String message = "c2sSendChat|" + chat;

        try {
            toServer = new DataOutputStream(socket.getOutputStream());
            toServer.write(message.getBytes());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    public void s2cUpdatePlayerlist() {

        ArrayList<Player> playerArrayList = c2sAskPlayerList();
        System.out.println("Now the Players are: ");

        for (int i = 0; i < playerArrayList.size(); i++) {
            System.out.println(playerArrayList.get(i).getPlayerName());
        }

    }

    public void s2cReceiveChat(String messageMaster) {

        String[] message = messageMaster.split("\\|");
        String chatMessage = message[1];

        System.out.println(chatMessage);

    }


    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public DataInputStream getFromServer() {
        return fromServer;
    }

    public void setFromServer(DataInputStream fromServer) {
        this.fromServer = fromServer;
    }

    public DataOutputStream getToServer() {
        return toServer;
    }

    public void setToServer(DataOutputStream toServer) {
        this.toServer = toServer;
    }
}
