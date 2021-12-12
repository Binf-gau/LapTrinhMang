package BAI8;

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
        byte mang[] = new byte[256];
        
        Scanner sc = new Scanner(System.in);
        int n;
        String send = "";

        System.out.print("Nhập số phần tử của mảng: ");
        n = sc.nextInt();

        sc.nextLine();
        System.out.print("Nhập các phần tử của mảng: \n");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            String so = sc.nextLine();
            send = send.concat(so + " ");
        }

        // tạo datagrampacket gửi 
        InetAddress ipser = InetAddress.getByName("localhost");
        int port = 8888;
        mang = send.getBytes();
        DatagramPacket doutson = new DatagramPacket(mang, mang.length, ipser, port);
        client.send(doutson);

        // tạo datagrampacket nhận
        byte sont[] = new byte[256];
        DatagramPacket nhan = new DatagramPacket(sont, sont.length);
        client.receive(nhan);
        // hiển thị dữ liệu lên màn hình
        String str = new String(nhan.getData(), 0, nhan.getLength()).trim();
        System.out.println("Các phần tử xuất hiện 1 lần: \n" + str);

    }
}
