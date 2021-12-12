/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai16;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author TIEN
 */
public class ClientUDP1 {

    private static DatagramSocket socket;
    private final static byte[] BUFF = new byte[4 * 1024];
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try {
            socket = new DatagramSocket();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Nhập mảng");
        System.out.print("Nhập số lượng phần tử: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + " ");
            arr[i] = sc.nextByte();
        }

        DatagramPacket packet = new DatagramPacket(Constant.ACL_INIT.getBytes(), Constant.ACL_INIT.getBytes().length, Inet4Address.getLocalHost(), ServerUDP.PORT);
        socket.send(packet);

        DatagramPacket packet1 = new DatagramPacket(String.valueOf(n).getBytes(), String.valueOf(n).getBytes().length, Inet4Address.getLocalHost(), ServerUDP.PORT);
        socket.send(packet1);

        for (int i = 0; i < n; i++) {
            DatagramPacket packet2 = new DatagramPacket(String.valueOf(arr[i]).getBytes(), String.valueOf(arr[i]).getBytes().length, Inet4Address.getLocalHost(), ServerUDP.PORT);
            socket.send(packet2);
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
                    DatagramPacket packet2 = new DatagramPacket(Constant.ACL_MAX.getBytes(), Constant.ACL_MAX.getBytes().length, Inet4Address.getLocalHost(), ServerUDP.PORT);
                    socket.send(packet2);
                        
                    Arrays.fill(BUFF, (byte) 0);
                    DatagramPacket recived = new DatagramPacket(BUFF, BUFF.length);
                    socket.receive(recived);

                    String result = new String(recived.getData());
                    System.out.println(result);
                    break;
                }
                case 2: {
                    DatagramPacket packet2 = new DatagramPacket(Constant.ACL_SORT.getBytes(), Constant.ACL_SORT.getBytes().length, Inet4Address.getLocalHost(), ServerUDP.PORT);
                    socket.send(packet2);

                    Arrays.fill(BUFF, (byte) 0);
                    DatagramPacket recived = new DatagramPacket(BUFF, BUFF.length);
                    socket.receive(recived);

                    String result = new String(recived.getData());
                    System.out.println(result);
                    break;

                }
                case 3: {
                    System.out.print("Nhập giá trị cần chèn: ");
                    int so = sc.nextByte();
                    DatagramPacket packet2 = new DatagramPacket(Constant.ACL_INSERT.getBytes(), Constant.ACL_INSERT.getBytes().length, Inet4Address.getLocalHost(), ServerUDP.PORT);
                    socket.send(packet2);
                    
                    DatagramPacket packet3 = new DatagramPacket(String.valueOf(so).getBytes(), String.valueOf(so).getBytes().length, Inet4Address.getLocalHost(), ServerUDP.PORT);
                    socket.send(packet3);
                    

                    Arrays.fill(BUFF, (byte) 0);
                    DatagramPacket recived = new DatagramPacket(BUFF, BUFF.length);
                    socket.receive(recived);

                    String result = new String(recived.getData());
                    System.out.println(result);
                    break;

                }
            }
        }

    }
}
