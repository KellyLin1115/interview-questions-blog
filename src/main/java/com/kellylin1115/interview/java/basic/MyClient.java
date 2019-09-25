package com.kellylin1115.interview.java.basic;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 6666);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF("First message!");
        dos.flush();
        dos.close();
    }
}
