/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Registry.IAccount;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chellong
 */
public class RMIServer {
    public static void main(String[] args) {
        try {
            IAccount account = new AccountServiceImpl();
            LocateRegistry.createRegistry(2345);
            
            //registry with rmi registry
            Naming.bind("rmi://192.168.137.62:2345/longnn", account);
            System.out.println(">>>>>INFO: RMI Server started!!!!!!!!");
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println(ex.getMessage());
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
