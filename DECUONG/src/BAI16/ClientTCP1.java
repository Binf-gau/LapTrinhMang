/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author TIEN
 */
public class ClientTCP1 {

    private static Socket socket;
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        socket = new Socket("localhost", ServerTCP.PORT);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        System.out.println("Nhập mảng");
        System.out.print("Nhập số lượng phần tử: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + " ");
            arr[i] = sc.nextByte();
        }

        out.writeUTF(Constant.ACL_INIT);
        out.flush();

        out.writeInt(n);
        out.flush();

        for (int i = 0; i < n; i++) {
            out.writeInt(arr[i]);
            out.flush();
        }

        while (true) {
            System.out.println("chọn chức năng");
            System.out.println("1: giá trị lớn nhất và thứ 2");
            System.out.println("2: Sắp xếp giảm giần");
            System.out.println("3: chèn");
            System.out.print("Lựa chọn của bạn: ");
            int choose = sc.nextByte();
            switch (choose) {
                case 1: {
                    out.writeUTF(Constant.ACL_MAX);
                    out.flush();

                    String result = in.readUTF();
                    System.out.println(result);
                    break;
                }
                case 2: {
                    out.writeUTF(Constant.ACL_SORT);
                    out.flush();

                    String result = in.readUTF();
                    System.out.println(result);
                    break;

                }
                case 3: {
                    System.out.print("Nhập giá trị cần chèn: ");
                    int so = sc.nextByte();

                    out.writeUTF(Constant.ACL_INSERT);
                    out.flush();

                    out.writeInt(so);
                    out.flush();

                    String result = in.readUTF();
                    System.out.println(result);
                    break;

                }
            }
        }

    }
}
