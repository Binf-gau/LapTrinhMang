package BAI1;

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
            String arr[] = received.split(" ");
            String send = convertNumber(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));

            // gửi dữ liệu về client
            dout.writeUTF(send);
            dout.flush();
        }
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
