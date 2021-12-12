package BAI6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;

public class TCPServer {

    public static final char CHAR_55 = 55;

    public static void main(String[] args) throws IOException {
        // khai báo socket server
        ServerSocket server = new ServerSocket(9999);
        System.out.println("Server đã chạy!!!");

        //tạo kết nối server
        Socket client = server.accept();

        /// khai báo các đối tượng input và output
        DataInputStream din = new DataInputStream(client.getInputStream());
        DataOutputStream dout = new DataOutputStream(client.getOutputStream());
        System.out.println("Server đã kết nối với client!!!");

        // khai báo đối tượng để nhận dữ liệu từ client 
        String received = din.readUTF();
        String arr[] = received.split(" ");

        String send = "";

        // tìm số lần xuất hiện của các phần tử
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            addElement(map, Integer.parseInt(arr[i]));
        }
        for (Integer key : map.keySet()) {
            if(map.get(key) == 1)
            send = send.concat(key + " xuất hiện " + map.get(key) + " lần.\n");
        }

        // gửi dữ liệu về client
        dout.writeUTF(send);
        dout.flush();

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
