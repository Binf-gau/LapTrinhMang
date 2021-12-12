package BAI3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

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

        // phân tích số nguyên dương n
        List<Integer> listNumbers = phanTichSoNguyen(a);
        // kết quả
        String send = "";
        int size = listNumbers.size();
        for (int i = 0; i < size - 1; i++) {
            send = send.concat("" + listNumbers.get(i) + " x ");
        }
        send = send.concat("" + listNumbers.get(size - 1));

        // server gửi dữ liệu về cho phía client
        byte guiTong[] = new byte[256];
        guiTong = send.getBytes();
        DatagramPacket gui = new DatagramPacket(guiTong, guiTong.length, dinson.getAddress(), dinson.getPort());
        ds.send(gui);

    }

    public static List<Integer> phanTichSoNguyen(int n) {
        int i = 2;
        List<Integer> listNumbers = new ArrayList<Integer>();
        // phân tích
        while (n > 1) {
            if (n % i == 0) {
                n = n / i;
                listNumbers.add(i);
            } else {
                i++;
            }
        }
        // nếu listNumbers trống thì add n vào listNumbers
        if (listNumbers.isEmpty()) {
            listNumbers.add(n);
        }
        return listNumbers;
    }
}
