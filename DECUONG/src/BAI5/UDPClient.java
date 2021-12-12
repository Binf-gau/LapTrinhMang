package BAI5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        // tạo datagramsocket client.
        DatagramSocket client = new DatagramSocket();
        
         // tạo datagrampacket gửi 
        InetAddress ipser = InetAddress.getByName("localhost");
        int port = 8888;
        
        String n = "a";
        byte son[] = new byte[256];
        son = n.getBytes();
        DatagramPacket doutson = new DatagramPacket(son, son.length, ipser, port);
        client.send(doutson);

        // tạo datagrampacket nhận
        byte sothuanngich[] = new byte[9000];
        DatagramPacket nhan = new DatagramPacket(sothuanngich, sothuanngich.length);
        client.receive(nhan);
        // hiển thị dữ liệu lên màn hình
        String str = new String(nhan.getData(), 0, nhan.getLength()).trim();
        System.out.println("Tất cả các số thuận nghịch độc có sáu chữ số là: \n" + str);

    }
}