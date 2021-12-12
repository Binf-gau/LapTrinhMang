package BAI9;

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
        String str;
        byte strByte[] = new byte[256];

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        str = sc.nextLine();

        // tạo datagrampacket gửi 
        InetAddress ipser = InetAddress.getByName("localhost");
        int port = 8888;
        strByte = str.getBytes();
        DatagramPacket doutson = new DatagramPacket(strByte, strByte.length, ipser, port);
        client.send(doutson);

        // tạo datagrampacket nhận
        byte kq[] = new byte[256];
        DatagramPacket nhan = new DatagramPacket(kq, kq.length);
        client.receive(nhan);
        // hiển thị dữ liệu lên màn hình
        String sl = new String(nhan.getData(), 0, nhan.getLength()).trim();
        System.out.println("\"" + str + "\"" + " có số lượng từ là: " + sl);

    }
}
