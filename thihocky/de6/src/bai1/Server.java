package bai1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Project de6
 * @Author chellong on 3/31/19.
 **/
public class Server {
    static int giaiThua(int n) {
        if(n==0) return 1;
        return n*giaiThua(n-1);
    }
    public static void main(String[] args) throws IOException {
        int port = 3333;
        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("server is running... " + port);
        byte[] buf = new byte[Short.MAX_VALUE];
        DatagramPacket dpReceive = new DatagramPacket(buf, buf.length);
        socket.receive(dpReceive);
        int result = Util.byteArrayToInt(buf);
        System.out.println(result);
        buf = Util.intToByteArray(giaiThua(result));
        dpReceive = new DatagramPacket(buf, buf.length, dpReceive.getAddress(), dpReceive.getPort());
        socket.send(dpReceive);
    }
}
