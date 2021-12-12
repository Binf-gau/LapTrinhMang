package BAI7;

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

        // nhập data
        Scanner sc = new Scanner(System.in);
        int n;
        String send = "";

        System.out.print("Nhập số phần tử của mảng: ");
        n = sc.nextInt();

        sc.nextLine();
        System.out.print("Nhập các phần tử của mảng: \n");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            String so = sc.nextLine();
            send = send.concat(so + " ");
        }

        // giai đoạn trao đổi
        dout.writeUTF(send);
        dout.flush();

        // khai báo đối tượng nhận kết quả
        String received = din.readUTF();
        System.out.println("Các phần tử xuất hiện 1 lần: \n" + received);

    }
}
