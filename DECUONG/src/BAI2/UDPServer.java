package BAI2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    
    public static final char CHAR_55 = 55;

    public static void main(String[] args) throws SocketException, IOException {
        // tạo datagramsocket server 
        DatagramSocket ds = new DatagramSocket(8888);
        System.out.println("Server đang chạy!!!");

        //server nhận dữ liệu
        byte son[] = new byte[256];
        DatagramPacket dinson = new DatagramPacket(son, son.length);
        ds.receive(dinson);

        // server xử lý dữ liệu 
        int a;
        a = Integer.parseInt(new String(dinson.getData(), 0, dinson.getLength()).trim());
        String tong = tinhTong(a);
        

        // server gửi dữ liệu về cho phía client
        byte guiTong[] = new byte[256];
        guiTong = tong.getBytes();
        DatagramPacket gui = new DatagramPacket(guiTong, guiTong.length, dinson.getAddress(), dinson.getPort());
        ds.send(gui);

    }
    
     public static String tinhTong(int i) {
        int sum = 0;
        int n;
        while (i != 0) {
            n = i % 10;
            sum += n;
            i /= 10;
        }
        return "" + sum;
    }
}
