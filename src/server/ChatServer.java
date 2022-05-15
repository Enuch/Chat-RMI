package server;

import client.ChatClientIF;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatServer extends UnicastRemoteObject implements ChatServerIF {
    private  static final Long serialVersionID = 1L;
    private ArrayList<ChatClientIF> chatClients;

    protected ChatServer() throws RemoteException {
        chatClients = new ArrayList<ChatClientIF>();
    }

    @Override
    public synchronized void registerChatClient(ChatClientIF chatClient, String name) throws RemoteException {
        this.chatClients.add(chatClient);
        System.out.println(name + ": logou no server");
    }

    @Override
    public synchronized void broadcastMessage(String message) throws RemoteException {
        int i = 0;
        while (i < chatClients.size()) {
            chatClients.get(i++).retrieveMessage(message);
        }
    }
}
