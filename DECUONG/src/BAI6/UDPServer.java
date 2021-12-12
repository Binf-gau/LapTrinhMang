package BAI6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Map;
import java.util.TreeMap;

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
        String arr[] = new String(dinson.getData(), 0, dinson.getLength()).trim().split(" ");

        String send = "";

        // tìm số lần xuất hiện của các phần tử
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            addElement(map, Integer.parseInt(arr[i]));
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                send = send.concat(key + " xuất hiện " + map.get(key) + " lần.\n");
            }
        }

        // server gửi dữ liệu về cho phía client
        byte guiChuoi[] = new byte[256];
        guiChuoi = send.getBytes();
        DatagramPacket gui = new DatagramPacket(guiChuoi, guiChuoi.length, dinson.getAddress(), dinson.getPort());
        ds.send(gui);

    }

    public static void addElement(Map<Integer, Integer> map, int element) {
        if (map.containsKey(element)) {
            int count = map.get(element) + 1;
            map.put(element, count);
        } else {
            map.put(element, 1);
        }
    }
}
