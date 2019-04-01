/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registry;

import BEAN.User;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author chellong
 */
public interface IAccount extends Remote {
    public User getUser() throws RemoteException;
    public void sendMessage(String text) throws RemoteException;
}
