/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai10;

import static bai10.Func.isPrime;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Arrays;

/**
 *
 * @author TIEN
 */
public class ServerUDP {

    private DatagramSocket socket;
    private final static byte[] BUFFER = new byte[4 * 1024]; // bộ nhớ đệm đọc gói tin từ client
    public final static int PORT = 8080;

    public ServerUDP() {
        try {
            socket = new DatagramSocket(PORT);
            System.out.println("ServerUDP running in port " + PORT);
            while (true) {
                Arrays.fill(BUFFER, (byte) 0); // default empty 
                DatagramPacket incomming = new DatagramPacket(BUFFER, BUFFER.length);
                socket.receive(incomming);
                SocketAddress address = incomming.getSocketAddress();
                String cmd = new String(incomming.getData()).trim();
                if (cmd.equalsIgnoreCase(Constant.ACL_PRIME_EQUAL_SUM)) {
                    String strN = recivedDataFromClient();
                    int s = Integer.parseInt(strN);
                    StringBuilder builder = new StringBuilder();
                    // số nguyên tố có 5 chữ số và tổng bẳng s
                    for (int i = 10000; i < 100000; i++) {
                       if (Func.isPrime(i)) {
                            int temp = i;
                            int sum = 0;
                            while (temp > 0) {
                                int du = temp % 10;
                                sum += du;
                                temp /= 10;
                            }
                            if (sum == s) {
                                builder.append(i).append(' ');
                            }
                        }
                    }
                    sendDataToClient(builder.toString().getBytes(), address);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String recivedDataFromClient() {
        try {
            Arrays.fill(BUFFER, (byte) 0); // default empty 
            DatagramPacket incomming = new DatagramPacket(BUFFER, BUFFER.length);
            // đợi gói tin từ client
            socket.receive(incomming);
            return new String(incomming.getData()).trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void sendDataToClient(byte[] data, SocketAddress address) {
        try {
            DatagramPacket packet = new DatagramPacket(data, data.length, address);
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerUDP();
    }
}
