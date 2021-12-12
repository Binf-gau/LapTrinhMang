package BAI5;

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

        int n, count = 0;
        String send = "";
        for (n = 100000; n <= 999999; n++) {
            if (testSoThuanNghich(n)) {
                send = send.concat(n + "\n");
                count++;
            }
        }
         send = send.concat("Co " + count + " so thuan nghich co 6 chu so");

    

        // gửi dữ liệu về client
        dout.writeUTF(send);
        dout.flush();

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
