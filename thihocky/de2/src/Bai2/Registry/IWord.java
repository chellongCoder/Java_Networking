package Bai2.Registry;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Project de2
 * @Author chellong on 4/1/19.
 **/
public interface IWord extends Remote {
    public String shortToLong(String shortWord) throws RemoteException;
    public String longToShort(String longWord) throws RemoteException;
}
