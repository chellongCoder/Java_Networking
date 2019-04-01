package Cau1.Registry;

/**
 * @Project de5
 * @Author chellong on 3/31/19.
 **/
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * interface dành cho server và client sử dụng chung
 * extend từ Remote để cả 2 đều kết nối được
 */
public interface IString extends Remote {
    public String getString () throws RemoteException;
    public int getLengthString (String str) throws RemoteException;
}
