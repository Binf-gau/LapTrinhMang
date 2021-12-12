/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI22;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Binh
 */

public class SERVER {   
    private InetAddress clientIP;
    private int clientPort;

    public SERVER() {
    }
    
    public void execute() throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(2212);
        System.out.println("Server đang chạy!!!");

        while (true) {
            int bai = Integer.parseInt(receiveData(server));
            switch (bai) {
                case 1:
                    File source = new File(receiveData(server));
                    File dest = new File(receiveData(server));

                    FileInputStream reader = null;
                    FileOutputStream writer = null;

                    if (source.isFile()) {
                        reader = new FileInputStream(source);
                        writer = new FileOutputStream(dest + "\\" + source.getName());

                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = reader.read(buffer)) > 0) {
                            writer.write(buffer, 0, length);
                        };
                        reader.close();
                        writer.close();
                    }
                    sendData("Di chuyển file thành công", server);
                    break;
                case 2:
                    String hoten = receiveData(server);
                    String[] word = hoten.split("\\s");
                    String temp = "";
                    
                    for (int i = 0; i< word.length-1;i++) {
                        temp = temp.concat(word[i].substring(0,1).toLowerCase());
                    }
                    String email = word[word.length-1].toLowerCase();
                    email = email.concat(temp);
                    email = email.concat("@ptithcm.edu.vn");
                    sendData(email, server);
                    break;

            }
        }
    }

    private String receiveData(DatagramSocket server) throws IOException{
        byte[] data = new byte[1024];
        DatagramPacket dinData = new DatagramPacket(data, data.length);
        server.receive(dinData);
        clientIP = dinData.getAddress();
        clientPort = dinData.getPort();
        return new String(data, 0, data.length).trim();
    }
    
    private void sendData(String data,DatagramSocket server) throws IOException{
        byte dataSend[] = data.getBytes();
        DatagramPacket message = new DatagramPacket(dataSend, dataSend.length, clientIP, clientPort);
        server.send(message);
    }
    
    public static void main(String[] args) {
        SERVER server = new SERVER();
        try {
            server.execute();
        } catch (IOException ex) {
            System.out.println("Lỗi khởi động server");
        }
    }
}