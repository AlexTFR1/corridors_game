package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server_methods extends UnicastRemoteObject implements Server_Interface
{
    String firstPlayer, secondPlayer;
    String tmp;
    protected Server_methods() throws RemoteException {
    }

    public String getName() throws RemoteException {
        if (firstPlayer == null) {
            firstPlayer = "first";
            return firstPlayer;
        }
        secondPlayer = "second";
        return secondPlayer;
    }
    public void send(String string) throws RemoteException {
        tmp=string;
        System.out.println(tmp);
    }

    @Override
    public String getMessage() throws RemoteException {
        if(tmp!=null)
            return tmp;
        return null;
    }
}
