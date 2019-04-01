/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import static Main.Server.data;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chellong
 */
public class Client {

    public static void main(String[] args) throws IOException {
        try {
            Scanner sc = new Scanner(System.in);
            // Step 1:Create the socket object for
            // carrying the data.
            DatagramSocket ds = new DatagramSocket();

            InetAddress ip = InetAddress.getLocalHost();

            byte buf[] = null;
            byte[] receive = new byte[65535];
            DatagramPacket DpReceive = null;
            // loop while user not enters "bye" 
            while (true) {
                System.out.println("input: ");
                String inp = sc.nextLine();
                buf = inp.getBytes();

//                Sach s = new Sach();
//                // Serialize to a byte array
//                ByteArrayOutputStream bStream = new ByteArrayOutputStream();
//                ObjectOutput oo = new ObjectOutputStream(bStream);
//                oo.writeObject(s);
//                oo.close();
//                
//                buf = bStream.toByteArray();

                // Step 2 : Create the datagramPacket for sending 
                // the data. 
                DatagramPacket DpSend
                        = new DatagramPacket(buf, buf.length, ip, 3000);

                // Step 3 : invoke the send call to actually send 
                // the data. 
                ds.send(DpSend);
                DpReceive = new DatagramPacket(receive, receive.length);
                ds.receive(DpReceive);
                System.out.println("Client:-" + data(receive));
                // break the loop if user enters "bye" 
                if (inp.equals("bye")) {
                    break;
                }

            }
        } catch (SocketException ex) {
            System.out.println(ex.getMessage());
        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
