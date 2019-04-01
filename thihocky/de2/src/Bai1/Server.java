package Bai1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Project de2
 * @Author chellong on 4/1/19.
 **/
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3000, 100);
            Socket socket = serverSocket.accept();
            System.out.println("da ket noi");
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                int number = input.readInt();
                System.out.println(number);
                output.writeUTF(number % 2 == 0 ? "ok" : "not ok");
                output.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
