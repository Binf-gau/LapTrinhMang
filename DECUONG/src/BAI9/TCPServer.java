package BAI9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
            StringTokenizer strToken = new StringTokenizer(received.trim(), " ");

            // kết quả
            String send = "" + strToken.countTokens();

            // gửi dữ liệu về client
            dout.writeUTF(send);
            dout.flush();
        }
    }
}
