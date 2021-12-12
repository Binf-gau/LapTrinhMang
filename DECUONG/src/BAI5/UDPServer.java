package BAI5;

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

        int n, count = 0;
        String send = "";
        for (n = 100000; n <= 999999; n++) {
            if (testSoThuanNghich(n)) {
                send = send.concat(n + "\n");
                count++;
            }
        }
         send = send.concat("Co " + count + " so thuan nghich co 6 chu so");

        // server gửi dữ liệu về cho phía client
        byte guiTong[] = new byte[9000];
        guiTong = send.getBytes();
        DatagramPacket gui = new DatagramPacket(guiTong, guiTong.length, dinson.getAddress(), dinson.getPort());
        ds.send(gui);

    }

    public static boolean testSoThuanNghich(int n) {
        StringBuilder xau = new StringBuilder();
        String str = "" + n;
        xau.append(str);
        String check = "" + xau.reverse();
        if (str.equals(check)) {
            return true;
        } else {
            return false;
        }
    }
}