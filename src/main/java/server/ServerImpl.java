package server;

import control.IRemoteClient;
import model.Student;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl  extends UnicastRemoteObject implements IRemoteClient {

    protected ServerImpl() throws RemoteException {
    }

    @Override
    public Student getStudent() throws RemoteException {
        String maSV = "B20DCNN024";
        String hovaten = "Nguyen Tuan Minh";
        String IP = "10.23.98.82";
        int group = 5;
        String rmiName = "TuanMinh";
        int rmiPort = 1099;
        Student student = new Student(maSV,hovaten,IP,group,rmiName,rmiPort);
        return student;
    }

    @Override
    public int getMax(int a, int b) throws RemoteException {
        return Math.max(a,b);
    }

    @Override
    public int getUSCLN(int a, int b) throws RemoteException {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    @Override
    public int getBSCNN(int a, int b) throws RemoteException {
        return (a * b) / getUSCLN(a, b);
    }

    @Override
    public String getReverse(String str) throws RemoteException {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    @Override
    public String getNormalization(String str) throws RemoteException {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] words = str.split(" ");
        StringBuilder normalizedString = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                word = word.toLowerCase();
                char firstChar = Character.toUpperCase(word.charAt(0));
                word = firstChar + word.substring(1);
                normalizedString.append(word).append(" ");
            }
        }
        if (normalizedString.length() > 0) {
            normalizedString.setLength(normalizedString.length() - 1);
        }

        return normalizedString.toString();
    }
}
