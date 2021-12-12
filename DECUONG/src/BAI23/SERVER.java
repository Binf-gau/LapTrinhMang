/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI23;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.file.Files;

/**
 *
 * @author zLittleMasterz
 */
public class SERVER {

    static ServerSocket svSocket;

    public static void main(String[] args) throws SocketException, IOException {
        svSocket = new ServerSocket(2212);
        Socket cl = svSocket.accept();

        DataInputStream dis = new DataInputStream(cl.getInputStream());
        DataOutputStream dos = new DataOutputStream(cl.getOutputStream());
        
        while (true) {
            String filePath = dis.readUTF();
            File file = new File(filePath);

            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);

            dos.write(data);
            fis.close();
        }
    }
}
