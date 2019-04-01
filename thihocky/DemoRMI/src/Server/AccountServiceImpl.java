/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BEAN.User;
import Registry.IAccount;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author chellong
 */
public class AccountServiceImpl extends UnicastRemoteObject implements IAccount{
    public static final long serialVersionUID = 1L;

    public AccountServiceImpl() throws RemoteException {
    }
    
    @Override
    public User getUser() throws RemoteException {
        User u = new User();
        u.setId(20);
        u.setUsername("chellong7798");
        u.setPassword("1234");
        return u;
    }

    @Override
    public void sendMessage(String s) throws RemoteException {
        System.out.println(s);
    }    
}
