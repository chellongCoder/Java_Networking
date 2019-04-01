package Bai2.Client;

import Bai2.Registry.IWord;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * @Project de2
 * @Author chellong on 4/1/19.
 **/
public class ClientRMI {
    private static int menu() {
        System.out.println("===================");
        System.out.println("1. short to long");
        System.out.println("2. long to short");
        System.out.println("===================");
        System.out.println("chon> ");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        return choice;
    }
    public static void main(String[] args) {
        try {
            IWord iWord = (IWord) Naming.lookup("rmi://localhost:"+3001+"/iword");
            if(iWord!=null) {
                System.out.println("connected to server");

                String mess;
                while (true) {
                    int choice = menu();
                    switch (choice) {
                        case 1: {
                            System.out.println("nhap tu viet tat");
                            mess = new Scanner(System.in).nextLine();
                            String longWord = iWord.shortToLong(mess);
                            System.out.println("tu day du " + longWord);
                        }
                        break;
                        case 2: {
                            System.out.println("nhap tu viet day du");
                            mess = new Scanner(System.in).nextLine();
                            String shortWord = iWord.longToShort(mess);
                            System.out.println("tu viet tat " + shortWord);
                        }
                        break;
                        default:
                            System.out.println("nhap lai lua chon");
                            break;
                    }
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
