/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai11;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author TIEN
 */
public class MyThread implements Runnable{
    
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;

    public MyThread(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
    }

    
    @Override
    public void run() {
        try {
            while(true){
            String cmd = in.readUTF();
            if(cmd.equalsIgnoreCase(Constant.ACL_FIBO)){
                int n = in.readInt();
                StringBuilder builder = new StringBuilder();
                
                for (int i = 1; i < n; i++) {
                    int fi = Func.fibonacci(i);
                    if(Func.isPrime(fi)) builder.append(fi).append(' ');
                }
                out.writeUTF(builder.toString());
                out.flush();
                
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
}
