package Cau2;

/**
 * @Project de5
 * @Author chellong on 3/31/19.
 **/
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Server implements IMess{
    /**
     * mảng sách lưu trữ
     */
    public static List<Sach> mangSach;
    /**
     * socket
     */
    private static DatagramSocket ds;
    /**
     * pakage gửi và nhận
     */
    private static DatagramPacket DpSend = null;
    private static DatagramPacket DpReceive = null;

    /**
     * init
     */
    private static void init() {
        mangSach = new ArrayList<>();
        mangSach.add(new Sach(1, "sach1", "nxb1", 10, 1));
        mangSach.add(new Sach(2, "sach2", "nxb2", 10, 2));
        mangSach.add(new Sach(3, "sach3", "nxb3", 10, 3));
    }

    /**
     * chuyển object thanhf mảng byte
     * @param o
     * @return
     * @throws IOException
     */
    public static byte[] convertObToByte(Object o) throws IOException {
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        ObjectOutput oo = new ObjectOutputStream(bStream);
        oo.writeObject(o);
        byte[] buf = bStream.toByteArray();
        oo.close();
        return buf;
    }

    /**
     * gửi pakage về client
     * @param server
     * @throws IOException
     */
    private static void xuLyHienThiSach(Server server) throws IOException {
            byte[] buf = convertObToByte(mangSach);
            server.send(buf, ds);
    }
    public static void main(String[] args) {
        init();
        int port = 2345;
        try {
            ds = new DatagramSocket(port);
            Server server = new Server();
            System.out.println("server started... " + port) ;
            while (true) {
                switch (server.receive(ds)[0]) {
                    case 1 :
                        xuLyHienThiSach(server); break;
                    case 2:
                        xuLyMuonSach(server); break;
                    case 3:
                        xuLyTraSach(server);  break;
                        default:break;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * so sách tên nếu trùng thì giảm mượn sách đi 1
     * gửi lại danh sách sách về client
     * @param server
     * @throws IOException
     */
    private static void xuLyTraSach(Server server)  throws IOException {
        byte[] q = "nhap ten sach can tra".getBytes();
        server.send(q, ds);
        String name = new String(server.receive(ds)).trim();
        for (Sach sach :
                mangSach) {
            if(sach.getTenSach().equals(name)) {
                sach.setSoLuongMuon(sach.getSoLuongMuon()-1); break;
            }
        }
        byte[] buf = convertObToByte(mangSach);
        server.send(buf, ds);
    }

    /**
     * so sách tên nếu trùng thì tăng lên mượn sách lên 1
     * gửi lại dânh sách sach về client
     * @param server
     * @throws IOException
     */
    private static void xuLyMuonSach(Server server) throws IOException {
        byte[] q = "nhap ten sach can muon".getBytes();
        server.send(q, ds);
        String name = new String(server.receive(ds)).trim();
        for (Sach sach :
                mangSach) {
            if(sach.getTenSach().equals(name)) {
                sach.setSoLuongMuon(sach.getSoLuongMuon()+1); break;
            }
        }
        byte[] buf = convertObToByte(mangSach);
        server.send(buf, ds);
    }

    @Override
    public byte[] receive(DatagramSocket ds) throws IOException {
        byte[] receive = new byte[Short.MAX_VALUE];
        DpReceive = new DatagramPacket(receive, receive.length);
        ds.receive(DpReceive);
        return receive;
    }

    /**
     * phải dùng DpReceive.getAddress để lấy ip và port của client
     * @param buf
     * @param ds
     * @throws IOException
     */
    @Override
    public void send(byte[] buf, DatagramSocket ds) throws IOException {
        DpSend = new DatagramPacket(buf, buf.length, DpReceive.getAddress(), DpReceive.getPort());
        ds.send(DpSend);
    }
}
