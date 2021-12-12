package BAI3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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

        while (true) {
            // khai báo đối tượng để nhận dữ liệu từ client 
            String received = din.readUTF();

            // phân tích số nguyên dương n
            List<Integer> listNumbers = phanTichSoNguyen(Integer.parseInt(received));
            // kết quả
            String send = "";
            int size = listNumbers.size();
            for (int i = 0; i < size - 1; i++) {
                send = send.concat("" + listNumbers.get(i) + " x ");
            }
            send = send.concat("" + listNumbers.get(size - 1));

            // gửi dữ liệu về client
            dout.writeUTF(send);
            dout.flush();
        }
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
