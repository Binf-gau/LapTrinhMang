/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai10;
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
            if(cmd.equalsIgnoreCase(Constant.ACL_PRIME_EQUAL_SUM)){
                int s = in.readInt();
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
                out.writeUTF(builder.toString());
                out.flush();
                
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
}
