package Cau2;

/**
 * @Project de5
 * @Author chellong on 3/31/19.
 **/
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * trừu tượng 2 phương thức gửi và nhận của server và client
 */
public interface IMess {
    public byte[] receive (DatagramSocket ds) throws IOException;
    public void send (byte[] buf, DatagramSocket ds) throws IOException;
}
