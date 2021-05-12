package network;

import java.util.Random;

public class Player implements java.io.Serializable {


    private int cordinate_X;
    private int cordinate_Y;
    private String playerName;
    private String playerId;





    public Player(String playerName,String playerId){

        this.playerId = playerId;
        this.playerName = playerName;


        long seed = System.currentTimeMillis();
        Random r = new Random(seed);
        this.cordinate_X = r.nextInt(200);
        this.cordinate_Y = r.nextInt(200);

    }


    public boolean changeXCoordinate(int xChange){


        int currentX = getCordinate_X();
        setCordinate_X(currentX+xChange);

        if(currentX != getCordinate_X()){
            return true;

        }else {
            return false;

        }
    }


    public boolean changeYCoordinate(int YChange){


        int currentY = getCordinate_Y();
        setCordinate_X(currentY+YChange);

        if(currentY != getCordinate_Y()){
            return true;

        }else {
            return false;
        }
    }




    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getCordinate_X() {
        return cordinate_X;
    }

    public void setCordinate_X(int cordinate_X) {
        this.cordinate_X = cordinate_X;
    }

    public int getCordinate_Y() {
        return cordinate_Y;
    }

    public void setCordinate_Y(int cordinate_Y) {
        this.cordinate_Y = cordinate_Y;
    }




}
