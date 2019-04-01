package Cau1.Server;

/**
 * @Project de5
 * @Author chellong on 3/31/19.
 **/
import Cau1.Registry.IString;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            IString iString = new StringImplement();
            int port = 3000;
            LocateRegistry.createRegistry(port);
            Naming.bind("rmi://localhost:"+port+"/longnn", iString);
            System.out.println(">>>>>INFO: RMI Cau1.Server started!!!!!!!!" + port);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
