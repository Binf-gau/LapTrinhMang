package BAI1;

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
        byte sob[] = new byte[256];
        DatagramPacket dinson = new DatagramPacket(son, son.length);
        DatagramPacket dinsob = new DatagramPacket(sob, sob.length);
        ds.receive(dinson);
        ds.receive(dinsob);

        // server xử lý dữ liệu 
        int a, b;
        a = Integer.parseInt(new String(dinson.getData(), 0, dinson.getLength()).trim());
        b = Integer.parseInt(new String(dinsob.getData(), 0, dinsob.getLength()).trim());
        String convered = convertNumber(a,b);
        

        // server gửi dữ liệu về cho phía client
        byte guiConvered[] = new byte[256];
        guiConvered = convered.getBytes();
        DatagramPacket gui = new DatagramPacket(guiConvered, guiConvered.length, dinson.getAddress(), dinson.getPort());
        ds.send(gui);

    }
    
    public static String convertNumber(int n, int b) {
        if (n < 0 || b <= 1 || b > 24) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int m;
        int remainder = n;

        while (remainder > 0) {
            if (b > 10) {
                m = remainder % b;
                if (m >= 10) {
                    sb.append((char) (CHAR_55 + m));
                } else {
                    sb.append(m);
                }
            } else {
                sb.append(remainder % b);
            }
            remainder = remainder / b;
        }
        return sb.reverse().toString();
    }
}
