package serverPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static  void main(String[] args) throws IOException {
                ServerSocket serverSocket = new ServerSocket(1234);
                System.out.println("Je suis un serveur en attente de la connexion d'un client");
                Socket socket = serverSocket.accept();
                System.out.println("Un client est connecte");
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                int x;
                x = in.readInt();
                int resultat = x * 5;
                out.writeInt(resultat);
                out.flush();
                System.out.println("Resultat : " + x + " * 5 = " + resultat);
                in.close();
                out.close();
                socket.close();
                serverSocket.close();
                System.out.println("Connexion terminee");
    }
}
