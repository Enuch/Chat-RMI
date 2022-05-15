package client;

import server.ChatServerIF;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ChatClientDriverB {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String chatServerURL = "rmi://localhost:1099/chat";
        ChatServerIF chatServer = (ChatServerIF) Naming.lookup(chatServerURL);

        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Digite seu nome: ");
        name = scanner.nextLine();

        new Thread(new ChatClient(name, chatServer)).start();
    }
}
