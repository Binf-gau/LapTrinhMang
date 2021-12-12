/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TIEN
 */
public class MyThread implements Runnable{
    
    private final static List<Integer> list = new ArrayList<>();
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
            if(cmd.equalsIgnoreCase(Constant.ACL_INIT)){
                list.clear();
                int n = in.readInt();
                for (int i = 0; i < n; i++) {
                    int so = in.readInt();
                    list.add(so);
                }
                Func.init(list);
            }else if(cmd.equalsIgnoreCase(Constant.ACL_MAX)){
                String res = Func.maxAndIndex();
                out.writeUTF(res);
                out.flush();
            }else if(cmd.equalsIgnoreCase(Constant.ACL_SORT)){
                String res = Func.sortDec();
                out.writeUTF(res);
                out.flush();
            }else if(cmd.equalsIgnoreCase(Constant.ACL_INSERT)){
                int c = in.readInt();
                String res = Func.insert(c);
                out.writeUTF(res);
                out.flush();
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
}
