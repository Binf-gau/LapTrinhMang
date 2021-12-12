package BAI4;

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
        int n;
        n = Integer.parseInt(new String(dinson.getData(), 0, dinson.getLength()).trim());

        String send = "";
        if (n >= 2) {
            send = send.concat("2");
        }
        for (int i = 3; i < n; i += 2) {
            if (isPrimeNumber(i)) {
                send = send.concat(" " + i);
            }
        }

        // server gửi dữ liệu về cho phía client
        byte guiTong[] = new byte[256];
        guiTong = send.getBytes();
        DatagramPacket gui = new DatagramPacket(guiTong, guiTong.length, dinson.getAddress(), dinson.getPort());
        ds.send(gui);

    }

    public static boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
