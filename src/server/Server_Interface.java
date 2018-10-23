package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server_Interface extends Remote
{
    String name = "interface";
    String getName() throws RemoteException;
    void send(String string) throws  RemoteException;
    String getMessage()throws  RemoteException;

}
