package BAI5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

    public static void main(String[] args) throws IOException {
        // tạo socket client
        Socket client = new Socket("localhost", 9999);

        // khai các đối tương input và out 
        DataInputStream din = new DataInputStream(client.getInputStream());
        DataOutputStream dout = new DataOutputStream(client.getOutputStream());

        // khai báo đối tượng nhận kết quả
        String received = din.readUTF();
        System.out.println("Tất cả các số thuận nghịch độc có sáu chữ số là: \n" + received);

    }
}
