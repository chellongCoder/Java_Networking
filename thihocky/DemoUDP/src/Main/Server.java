/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chellong
 */
public class Server {

    public static void main(String[] args) throws IOException {
        try {
            int port = 3000;
            // Step 1 : Create a socket to listen at port 3000 
            DatagramSocket ds = new DatagramSocket(port);
            System.out.println("server started... " + port) ;
            byte[] receive = new byte[65535];

            DatagramPacket DpReceive = null;
            
            while (true) {
                // Step 2 : create a DatgramPacket to receive the data. 
                DpReceive = new DatagramPacket(receive, receive.length);

                // Step 3 : recieve the data in byte buffer. 
                ds.receive(DpReceive);

                System.out.println("Client:-" + data(receive));
                ds.send(DpReceive);
                // Exit the server if the client sends "bye" 
                if (data(receive).toString().equals("bye")) {
                    System.out.println("Client sent bye.....EXITING");
                    break;
                }

                // Clear the buffer after every message. 
                receive = new byte[65535];

            }
        } catch (SocketException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // A utility method to convert the byte array 
    // data into a string representation. 
    public static StringBuilder data(byte[] a) {
        if (a == null) {
            return null;
        }
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0) {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}
