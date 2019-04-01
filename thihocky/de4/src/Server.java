import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Project de4
 * @Author chellong on 4/2/19.
 **/
public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(3002);
            System.out.println("server is running...");
            byte[] buf = new byte[Short.MAX_VALUE];
            DatagramPacket dpReceive = new DatagramPacket(buf, buf.length);
            socket.receive(dpReceive);
            String character = new String(buf);
            buf = character.trim().toUpperCase().getBytes();
            dpReceive = new DatagramPacket(buf, buf.length, dpReceive.getAddress(), dpReceive.getPort());
            socket.send(dpReceive);
            System.out.println();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
