
package clientPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
            System.out.println("Je suis un client pas encore connecte...");
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Je suis un client connecte");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            int x;
            System.out.print("Saisir un entier : ");
            x = scanner.nextInt();
            out.writeInt(x);
            out.flush();
            int resultat = in.readInt();
            System.out.println("Resultat = " + resultat);
            in.close();
            out.close();
            socket.close();
            System.out.println("Client deconnecte");
    }
}

