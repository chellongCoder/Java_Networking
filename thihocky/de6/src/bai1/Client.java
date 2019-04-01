package bai1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @Project de6
 * @Author chellong on 3/31/19.
 **/
public class Client {

    public static void main(String[] args) {
        try {
            int port = 3333;
            DatagramSocket socket = new DatagramSocket();
            InetAddress id = InetAddress.getLocalHost();
            int number = new Scanner(System.in).nextInt();
            byte[] bytes = Util.intToByteArray(number);
            DatagramPacket dpSend = new DatagramPacket(bytes, bytes.length, id, port);
            socket.send(dpSend);
            socket.receive(dpSend);
            System.out.println(Util.byteArrayToInt(bytes));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
