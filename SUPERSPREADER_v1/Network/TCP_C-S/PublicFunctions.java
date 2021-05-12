package network;

public class PublicFunctions {

    public static String encryptAndDecrypt(String value){

        byte[] bt = value.getBytes();

        for(int i = 0;i < bt.length; i++){
            bt[i]=(byte)(bt[i]^(int)5);
        }

        String result = new String(bt,0,bt.length);
        return result;
    }



}
