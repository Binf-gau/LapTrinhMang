package BAI4;

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

        // trên client tạo dữ liệu gửi đi
        String n;
        byte son[] = new byte[256];

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số n: ");
        n = sc.nextLine();

        // tạo datagrampacket gửi 
        InetAddress ipser = InetAddress.getByName("localhost");
        int port = 8888;
        son = n.getBytes();
        DatagramPacket doutson = new DatagramPacket(son, son.length, ipser, port);
        client.send(doutson);

        // tạo datagrampacket nhận
        byte sont[] = new byte[256];
        DatagramPacket nhan = new DatagramPacket(sont, sont.length);
        client.receive(nhan);
        // hiển thị dữ liệu lên màn hình
        String str = new String(nhan.getData(), 0, nhan.getLength()).trim();
        System.out.println("Các số nguyên tố nhỏ hơn " + n + " là: " + str);

    }
}
