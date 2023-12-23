package control;

import model.Student;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteClient extends Remote {
    Student getStudent() throws RemoteException;
    int getMax(int a, int b) throws RemoteException;
    int getUSCLN(int a, int b) throws RemoteException;
    int getBSCNN(int a, int b) throws RemoteException;
    String getReverse(String str) throws RemoteException;
    String getNormalization(String str) throws RemoteException;

}
