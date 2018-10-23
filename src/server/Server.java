package server;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(final String[] args) throws IOException, AlreadyBoundException
    {
        Server_methods serv = new Server_methods();
        Registry localReg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        localReg.bind(Server_Interface.name, serv);
        System.out.println("it works");
    }
}
