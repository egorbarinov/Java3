package Lesson_3.hw.chat;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class SimpleClient {
    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 8189)) {
            System.out.println("Socket connected");
            DataInputStream in = new DataInputStream(s.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

            while (true) {
            SerializeDemoApp.Cat cat = new SerializeDemoApp.Cat("Barsik");
            out.writeObject(cat);
            String b = in.readUTF();
            out.writeUTF("echo: " + b);
            System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
