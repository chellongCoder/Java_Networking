import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @Project de4
 * @Author chellong on 4/2/19.
 **/
public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress id = InetAddress.getLocalHost();
//            byte[] buf = new byte
            String character = new Scanner(System.in).next();
            byte[] buf = character.getBytes();
            DatagramPacket dpSend = new DatagramPacket(buf, buf.length, id, 3002);
            socket.send(dpSend);
            socket.receive(dpSend);
            character = new String(buf);
            System.out.println(character);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
