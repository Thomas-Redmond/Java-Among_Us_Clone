package network;

public class Global {

    static Server server = null;
    static Client client = null;

    public static Server getServer() {
        return server;
    }

    public static void setServer(Server server) {
        Global.server = server;
    }

    public static Client getClient() {
        return client;
    }

    public static void setClient(Client client) {
        Global.client = client;
    }


}
