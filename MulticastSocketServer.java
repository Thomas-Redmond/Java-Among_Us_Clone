package compiledGame;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MulticastSocketServer{
  String INET_ADDR;
  int PORT;
  InetAddress addr;
  DatagramSocket serverSocket;

  public static void main(String[] args) throws UnknownHostException, InterruptedException{
    MulticastSocketServer newServer = new MulticastSocketServer();
    newServer.sendToAll("Hello There");
  }

  private MulticastSocketServer() throws UnknownHostException{
    // constructor class
    INET_ADDR = "224.0.0.3";
    PORT = 8888;

    // Get address we are going to connect to
    addr = InetAddress.getByName(INET_ADDR);
  }

  private void sendToAll(String msg) throws InterruptedException{
    try{
      serverSocket = new DatagramSocket();
      // Create packet which will contain the data
      DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, PORT);
      serverSocket.send(msgPacket);

      System.out.println("Server sent packet with msg: "+ msg);
      Thread.sleep(500);
    } catch (IOException e){
      e.printStackTrace();
    }
    shutdownSocket();
  }

  private void shutdownSocket(){
    serverSocket.close();
  }
}
