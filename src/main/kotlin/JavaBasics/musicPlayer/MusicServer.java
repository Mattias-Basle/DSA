package JavaBasics.musicPlayer;

import JavaBasics.network.SimpleChatServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class MusicServer {
    ArrayList<ObjectOutputStream> clientOutputStreams;

    public class ClientHandler implements Runnable {
        ObjectInputStream in;
        Socket clientSocket;

        public static void main(String[] args) {
            new MusicServer().go();
        }

        public ClientHandler(Socket socket) {
            try {
                clientSocket = socket;
                in = new ObjectInputStream(clientSocket.getInputStream());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public void run() {
            Object o1;
            Object o2;
            try {
                while ((o1 = in.readObject()) != null) {
                    o2 = in.readObject();

                    System.out.println("read two objects");
                    tellEveryone(o1, o2);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void go() {
        clientOutputStreams = new ArrayList();
        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                clientOutputStreams.add(out);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("got a connection");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void tellEveryone(Object one, Object two) {
        Iterator iterator = clientOutputStreams.iterator();
        while (iterator.hasNext()) {
            try {
                ObjectOutputStream out = (ObjectOutputStream) iterator.next();
                out.writeObject(one);
                out.writeObject(two);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
