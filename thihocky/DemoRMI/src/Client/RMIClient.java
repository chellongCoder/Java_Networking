/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Registry.IAccount;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chellong
 */
public class RMIClient {
    public static void main(String[] args) {
        try {
            IAccount account = (IAccount) Naming.lookup("rmi://192.168.137.62:2345/longnn");
            System.out.println("Connected to Server");
            if(account!=null) {
                try {
                    System.out.println("Name: " + account.getUser().getUsername());
                    while (true) {
                        account.sendMessage(new Scanner(System.in).nextLine());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (NotBoundException ex) {
            System.out.println(ex.getMessage());
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        } 
    }
}
