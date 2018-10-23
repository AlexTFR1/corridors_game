package client;

import server.Server_Interface;


import java.rmi.RemoteException;

public class Client
{
    String name;
    Server_Interface serv;

    public  Client(Server_Interface serv)
    {
        this.serv=serv;

        try
        {
            name=serv.getName();
            System.out.println(name);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void send(String string)
    {
        try {
            serv.send(string);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public String getMessage(){
        try {
            return serv.getMessage();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
