package Cau1.Server;

/**
 * @Project de5
 * @Author chellong on 3/31/19.
 **/
import Cau1.Registry.IString;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * extend từ UnicastRemoteObject để chỉ ra đối tượng này có thể đăng ký với Server Registry và binding
 */
public class StringImplement extends UnicastRemoteObject implements IString {

    protected StringImplement() throws RemoteException {

    }

    @Override
    public String getString() throws RemoteException {
        return null;
    }

    @Override
    public int getLengthString(String str) throws RemoteException {
        return str.length();
    }
}
