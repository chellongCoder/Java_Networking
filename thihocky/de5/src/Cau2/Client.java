package Cau2;

/**
 * @Project de5
 * @Author chellong on 3/31/19.
 **/
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Client implements IMess{
    public static final int PORT = 2345;
    /**
     * This class represents a socket for sending and receiving datagram packets.
     * hình dung đơn giản nó là thằng trung gian chuyển nhận các gói tin
     */
    private static DatagramSocket ds = null;
    /**
     *  Each message is routed from one machine to another based solely on information contained within that packet.
     * các gói tin gửi và nhận
     */
    private static DatagramPacket DpReceive = null;
    private static DatagramPacket DpSend = null;

    /**
     * menu hiển thị
     * @return choice
     */
    private static int menu () {
        System.out.println("=================");
        System.out.println("1. hien thi thong tin sach");
        System.out.println("2. cho muon sach");
        System.out.println("3. tra sach");
        System.out.println("=================");
        System.out.println("chon> ");
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    public static void main(String[] args) {
        int choice;
        Client client = new Client();

        try {
            /**
             * khởi tạo Sockey và adress
             */
            ds = new DatagramSocket();

            while (true) {
                /**
                 * guửi lựa chọn lên server
                 */
                choice = menu();
                byte buf[] = new byte[Short.MAX_VALUE];
                buf[0] = (byte)choice;
                client.send(buf, ds);
                switch (choice) {
                    case 1: xuLyHienThiSach(client); break;
                    case 2: xuLyMuonTraSach(client); break;
                    case 3: xuLyMuonTraSach(client);  break;
                    default: break;
                }
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * chuyển đổi mảng byte thành object
     * @param buf : các byte nhận được
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object convertByteToOb(byte[] buf) throws IOException, ClassNotFoundException {
        ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(buf));
        Object o = iStream.readObject();
        iStream.close();
        return o;
    }

    /**
     * xử lý hiẻn thị mượn trả sách tương tác với server
     * 1. nhận yêu cầu nhập tên sách từ server
     * 2. gửi tên sách lên
     * 3. nhận danh sách đã được chỉnh sửa
     * @param client
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void xuLyMuonTraSach(Client client) throws IOException, ClassNotFoundException {
        byte[] receive = client.receive(ds);
        String s = new String(receive);
        System.out.println(s.trim());
        String name = new Scanner(System.in).nextLine();
        client.send(name.getBytes(), ds);
        receive = client.receive(ds);
        ArrayList<Sach> mangsach = (ArrayList<Sach>)convertByteToOb(receive);
        mangsach.forEach(System.out::println);
    }

    /**
     * nhận danh sách sách
     * @param client
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void xuLyHienThiSach(Client client) throws IOException, ClassNotFoundException {
        byte[] receive = client.receive(ds);
        ArrayList<Sach> Sachs = (ArrayList<Sach>)convertByteToOb(receive);
        System.out.println("Client: " + Sachs);

    }

    /**
     * nhận về mảng byte từ server
     * @param ds socket
     * @return
     * @throws IOException
     */
    @Override
    public byte[] receive(DatagramSocket ds) throws IOException {
        byte[] buf = new byte[Short.MAX_VALUE];
        DpReceive = new DatagramPacket(buf, buf.length);
        ds.receive(DpReceive);
        return buf;
    }

    /**
     * gửi pakage lên server
     * @param buf
     * @param ds
     * @throws IOException
     */
    @Override
    public void send(byte[] buf, DatagramSocket ds) throws IOException {
        DpSend = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), PORT);
        ds.send(DpSend);
    }
}
