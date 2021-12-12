package BAI1;

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
        String n, b;
        byte son[] = new byte[256];
        byte sob[] = new byte[256];

        // nhập 2 số a, b
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số n: ");
        n = sc.nextLine();
        System.out.print("Nhập hệ cơ số base: ");
        b = sc.nextLine();

        // tạo datagrampacket gửi 
        InetAddress ipser = InetAddress.getByName("localhost");
        int port = 8888;
        son = n.getBytes();
        sob = b.getBytes();
        DatagramPacket doutson = new DatagramPacket(son, son.length, ipser, port);
        client.send(doutson);
        DatagramPacket doutsob = new DatagramPacket(sob, sob.length, ipser, port);
        client.send(doutsob);

        // tạo datagrampacket nhận
        byte convered[] = new byte[256];
        DatagramPacket nhan = new DatagramPacket(convered, convered.length);
        client.receive(nhan);
        // hiển thị dữ liệu lên màn hình
        String str = new String(nhan.getData(), 0, nhan.getLength()).trim();
        System.out.println("Số " + n + " chuyển sang cơ số " + b + " thành: " + str);

    }
}
