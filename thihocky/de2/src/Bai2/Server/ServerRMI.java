package Bai2.Server;

import Bai2.Registry.IWord;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @Project de2
 * @Author chellong on 4/1/19.
 **/
public class ServerRMI {
    public static void main(String[] args) {
        try {
            IWord iWord = new IWordImplement();
            LocateRegistry.createRegistry(3001);

            Naming.bind("rmi://localhost:"+3001+"/iword", iWord);
            System.out.println(">>>>>INFO: RMI Server started!!!!!!!!");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
