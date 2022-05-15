package server;

import client.ChatClientIF;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServerIF extends Remote {
    void registerChatClient(ChatClientIF chatClient, String name) throws RemoteException;
    void broadcastMessage(String message) throws RemoteException;
}
