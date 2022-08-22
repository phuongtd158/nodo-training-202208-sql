package com.demo.unit8_java_networking;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerExample {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
        Server object = new Server();
        Remote stub = UnicastRemoteObject.exportObject(object, 0);

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8000);
        registry.bind("Hello", stub);

        System.out.println("Server ready");
    }

    static class Server implements IHello {
        @Override
        public String say(String name) throws RemoteException {
            return "Hello" + name;
        }
    }
}
