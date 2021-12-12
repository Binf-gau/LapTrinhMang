/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai11;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author TIEN
 */
public class ServerTCP {
    private ServerSocket ss;  
    public final static int PORT = 8081;
    
    public ServerTCP(){
        try {
            ss = new ServerSocket(PORT);
            System.out.println("ServerTCP running in port " + PORT);
            while(true){
                Socket socket = ss.accept();
                MyThread thread = new MyThread(socket);
                thread.run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ServerTCP();
    }
}
