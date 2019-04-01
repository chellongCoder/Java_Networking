package Bai1;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Project de2
 * @Author chellong on 4/1/19.
 **/
public class Client {
    public static void main(String[] args) {
        Socket socket;
        ObjectOutputStream output;
        ObjectInputStream input;
        try {
            socket = new Socket("localhost", 3000);
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            while (true) {
                output.writeInt(new Scanner(System.in).nextInt());
                output.flush();
                String str = input.readUTF();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
