package Cau1.Client;

/**
 * @Project de5
 * @Author chellong on 3/31/19.
 **/
import Cau1.Registry.IString;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        try {
            /**
             *  lấy IString đã được đănh ký từ server
             */
            IString iString = (IString) Naming.lookup("rmi://localhost:3000/longnn");
            System.out.println("Connected to Cau1.Server");
            if(iString!=null) {
                while (true) {
                    System.out.println("length= " + iString.getLengthString(new Scanner(System.in).nextLine()));
                }
            }
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
