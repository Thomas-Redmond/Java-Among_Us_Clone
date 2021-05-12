package Classes;
import javax.swing.*;


public class Global {

    static MulticastSocketClient network = null;
    static gameScreen gameScreen = null;
    //

    public static Classes.gameScreen getGameScreen() {
        return gameScreen;
    }

    public static void setGameScreen(Classes.gameScreen gameScreen) {
        Global.gameScreen = gameScreen;
    }


    public static MulticastSocketClient getNetwork() {
        return network;
    }

    public static void setNetwork(MulticastSocketClient network) {
        Global.network = network;
    }


}
