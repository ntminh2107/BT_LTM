import model.Student;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host  = "10.23.95.238";
        int port = 11001;
        try{
            Socket s = new Socket(host,port);

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());


            Student student = new Student();
            student.setMaSV("B20DCCN024");
            student.setHovaten("nguyen tuan minh");
            student.setIP("10.23.98.82");
            student.setGroup(5);
            student.setRmiName("TuanMinh");
            student.setRmiPort(1099);
            dos.writeUTF(student.getMaSV());
            dos.writeUTF(student.getHovaten());
            dos.writeUTF(student.getIP());
            dos.writeInt(student.getGroup());
            dos.writeUTF(student.getRmiName());
            dos.writeInt(student.getRmiPort());


            System.out.println("success " + student.getHovaten());



        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
