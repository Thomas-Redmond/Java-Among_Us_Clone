package Classes;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.net.SocketTimeoutException;

public class MulticastSocketClient extends Thread{

  String INET_ADDR;
  int PORT;
  InetAddress addr;
  MulticastSocket clientSocket;
  DatagramSocket outSocket;
  String playerName;
  /*
  Create a buffer of bytes, which will be used to store
  Incoming bytes containing the information from the server
  Since the message should be small 256 bytes should be enough
  */

  byte[] buf = new byte[256];
  boolean flag = false;

  public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException{
    // Get address of attempting connection
    //InetAddress address = InetAddress.getByName(INET_ADDR);
    MulticastSocketClient newClient = new MulticastSocketClient("123");
    newClient.recieveMessage();


    // byte[] buf = new byte[256];
  }

  public MulticastSocketClient(String playerName) throws IOException, UnknownHostException, InterruptedException{
    // constructor class

    INET_ADDR = "224.0.2.0";                  // address of group
    PORT = 8888;                              // port number for send/receive
    addr = InetAddress.getByName(INET_ADDR);  // convert address into usable format
    this.playerName = playerName;

    try{
      // Create a new multicast socket - which will allow others to join too
      clientSocket = new MulticastSocket(PORT);
      clientSocket.joinGroup(addr);

    } catch(IOException e){
      e.printStackTrace();
    }

  }

  private void setFlag(){
    flag = true;
  }

  @Override

  public void run(){

    try{

      recieveMessage();

    }catch (IOException ex){
      ex.printStackTrace();

    }catch (InterruptedException ex){
      ex.printStackTrace();

    }

  }



  private void recieveMessage() throws IOException, InterruptedException{
    clientSocket.setSoTimeout(1000); // set timeout in milliseconds
    try{

      while(true){

        buf = new byte[256];
        DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
        clientSocket.receive(msgPacket);

        String msg = new String(buf, 0, buf.length);
        System.out.println("Receive message");
        try{

          String[] message = msg.split("\\|");
          String methodName = message[0];

//          System.out.println("message: "+message[1]);

          if (message.length == 1){

            Method targetMethod = this.getClass().getMethod(methodName);
            targetMethod.invoke(this);
          }else {

            Method targetMethod = this.getClass().getMethod(methodName,Class.forName("java.lang.String"));
            targetMethod.invoke(this,message[1]);

          }

        }catch (Exception ex){

          ex.printStackTrace();

        }

      }

    } catch (SocketTimeoutException e) {

      // Intentional Timeout Exception :)
      // check if this device wants anything transmitting, if yes transmit, else and after go back to loop
      //System.out.println("Timeout Reached. Checking for messages");
      // transmit game data here [playerId x y -abilities]
      //sendGameData();
      // loop back to start of function
      recieveMessage();
    }


  }



  private void transmit(String msg) throws InterruptedException{

    try{

      outSocket = new DatagramSocket();
      DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, PORT);
      clientSocket.send(msgPacket);

      //System.out.println("Transmitting: " +msg);
      Thread.sleep(500);

    } catch (Exception e){
      e.printStackTrace();
    }

  }
//
//  private void checkFlag() throws InterruptedException{
//
//
//    if(flag == true){
//      // transmit text to chat
//      sendChat();
//      flag = false;
//    } else{
//      // nothing
//      return;
//    }
//
//    return;
//
//  }

  public void sendChat(String text) throws InterruptedException{

    // get message from gui chatbox - or where saved
    String newMessage = text;
    // prefix with receiveChat| to designate as chat message
    transmit("receiveChat|"+ newMessage);

    return;

  }


  public void receiveChat(String chat){

    System.out.println(playerName + "has receive chat");
    System.out.println(chat);

    Global.getGameScreen().appendTextToChatLog(chat);

  }


  private void sendGameData() throws InterruptedException{

    // get game data from gui
    // get id
    // get x
    // get y
    String message = "playerID x y 1";
    transmit("receiveGameData|" + message);
    return;

  }


  public void receiveGameData(String data){

    //System.out.println(data);

  }

}
