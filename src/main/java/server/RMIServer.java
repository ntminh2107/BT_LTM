package server;

import control.IRemoteClient;
import model.Student;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        String IP = "10.23.98.82";
        int RMI_PORT = 1099;
        String RMI_NAME = "TuanMinh";
        try
        {
            LocateRegistry.createRegistry(RMI_PORT);
            IRemoteClient iRemoteClient = new ServerImpl();
            Naming.bind("rmi://" + IP + ":"+ RMI_PORT +"/" + RMI_NAME, iRemoteClient);
            System.out.println("Server dang hoat dong");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
