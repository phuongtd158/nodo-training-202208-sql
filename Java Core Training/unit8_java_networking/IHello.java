package com.demo.unit8_java_networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHello extends Remote {
    String say(String name) throws RemoteException;
}
