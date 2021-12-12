package BAI9;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
        String str = new String(dinson.getData(), 0, dinson.getLength()).trim();

        StringTokenizer strToken = new StringTokenizer(str.trim(), " ");
        
        String send = "" + strToken.countTokens();

        // server gửi dữ liệu về cho phía client
        byte guikq[] = new byte[256];
        guikq = send.getBytes();
        DatagramPacket gui = new DatagramPacket(guikq, guikq.length, dinson.getAddress(), dinson.getPort());
        ds.send(gui);

    }


}
