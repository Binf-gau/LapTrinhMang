/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDateTime;

/**
 *
 * @author vohoa
 */
public class Server {

    public static void dangNhap(DataInputStream din, DataOutputStream dout) {
        try {
            String username = din.readUTF();
            String password = din.readUTF();

            System.out.println(username);
            System.out.println(password);
            DBAccess acc = new DBAccess();
            ResultSet rs = acc.Query("select * from Account where username = '" + username + "' and password = '" + password + "'");
            if (rs.next()) {
                dout.writeInt(1);
                System.out.println("im here 1");
            } else {
                System.out.println("im here 0");
                dout.writeInt(0);
            }
        } catch (Exception ex) {
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("server đã chạy!");

        while (true) {
            Socket client = server.accept();

            DataInputStream din = new DataInputStream(client.getInputStream());
            DataOutputStream dout = new DataOutputStream(client.getOutputStream());

            int type = din.readInt();

            switch (type) {
                case 1:
                    dangNhap(din, dout);
                    break;
            }

            client.close();
        }
    }
}
