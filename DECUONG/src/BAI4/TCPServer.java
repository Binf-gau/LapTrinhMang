package BAI4;

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

            String send = "";
            int n = Integer.parseInt(received);
            if (n >= 2) {
                send = send.concat("2");
            }
            for (int i = 3; i < n; i += 2) {
                if (isPrimeNumber(i)) {
                    send = send.concat(" " + i);
                }
            }

            // gửi dữ liệu về client
            dout.writeUTF(send);
            dout.flush();
        }
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
