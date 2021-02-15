package compiledGame;

// compilation help
// javac -d . network.java
// running help for testing on local machines
// java compiledGame.network -parameter

import java.io.*;
import java.net.*;

public class network{

  private network(String[] args){ // passes by reference
    try{
      String type = args[0];
      if (type.equals("-client")){
        // new client instance created
        client clientInstance = new client();

      } else if (type.equals("-server")){
        // new server instance created
        server serverInstance = new server();

      } else{
        // improper parameter given - fails safe
        System.out.println("Parameter not recognized, use either -client or -server");
      }
  } catch(Exception e){
    // unknown error - most likely forgot to add parameter
    System.out.println(e);
    System.out.println("Hint: Parameters are mandatory, either -client or -server");
    }
  }


  public static void main(String[] args){
    // create instance of network controller - to make instances of client or server
    // REQUIRED else errors galore
    network controller = new network(args);

  }

  private class client{
    // variables declared prior to reduce errors
    private DatagramSocket socket;
    private InetAddress address;
    private int portNum = 4445;
    private byte[] buf;

    private client() throws SocketException, UnknownHostException, IOException{
      // constructor
      socket = new DatagramSocket();
      address = InetAddress.getByName("localhost"); // localhost will be changed to IP address given by user
      sendMsg("This is text"); // message to be sent, again given by user in later versions
      close();
    }

    private void sendMsg(String message) throws IOException{
      buf = message.getBytes(); // convert message to bytes
      DatagramPacket packet = new DatagramPacket(buf, buf.length, address, portNum); // create packet to transmit
      socket.send(packet); // transmitting
      // UDP hence no checking for reply, could be implemented by recursively calling sendMsg
      // unless proper response given
    }

    private void close(){
      socket.close();
      // closing socket - required for safe shut down
    }

  }

  private class server{
    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];

    private server() throws SocketException, IOException{
      // constructor
      socket = new DatagramSocket(4445);
      run();
    }

    private void run() throws IOException{
      // always runs until told otherwise
      running = true;

      while(running){
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        String recieved = new String(packet.getData(), 0, packet.getLength());
        System.out.println(recieved);
        running = false;
      }
      socket.close();
    }

  }
}
