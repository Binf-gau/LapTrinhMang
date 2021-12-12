package BAI2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
            String send = tinhTong(Integer.parseInt(received));

            // gửi dữ liệu về client
            dout.writeUTF(send);
            dout.flush();
        }
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
