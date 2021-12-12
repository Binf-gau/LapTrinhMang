/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author zLittleMasterz
 */
public class UDPSERVER {

    public static DatagramSocket svSocket;
    public static DatagramPacket packet;
    
    public static void main(String[] args) throws IOException {
        svSocket = new DatagramSocket(2212);

        while (true) {
            DatagramPacket maTranPacket = udpReceive();
            DatagramPacket cnPacket = udpReceive();
            
            String mtString = new String(maTranPacket.getData(), 0, maTranPacket.getLength());
            ArrayList<int[]> maTran = layMaTran(mtString);
            int chucNang = Integer.parseInt(new String(cnPacket.getData(), 0, cnPacket.getLength()));
            switch (chucNang) {
                case 1: {
                    byte[] kq = timMax(maTran).getBytes();
                    udpSend(kq,cnPacket.getAddress(),cnPacket.getPort());
                    break;
                }
                case 2: { 
                    byte[] kq = soNguyenTo(maTran).getBytes();
                    udpSend(kq,cnPacket.getAddress(),cnPacket.getPort());
                    break;
                }
                case 3: {
                    byte[] kq = sapXepCotTang(maTran).getBytes();
                    udpSend(kq,cnPacket.getAddress(),cnPacket.getPort());
                    break;
                }
            }
        }

    }

    public static String timMax(ArrayList<int[]> maTran){
        int max = 0;
        String chiSo="A[0,0]";
        for (int i = 0; i < maTran.size(); i++) {
            int[] dong = maTran.get(i);
            for (int j = 0; j < dong.length; j++) {
                if (dong[j]>max) {
                    max = dong[j];
                    chiSo = "A["+(i+1)+", "+(j+1)+"]";
                }
            }
        }
        return "Max là "+chiSo+"= "+max;
    }
    
    public static String soNguyenTo(ArrayList<int[]> maTran){

        String mtString = "";
        for (int i = 0; i < maTran.size(); i++) {
            int[] dong = maTran.get(i);
            mtString = mtString + "[";
            for (int j = 0; j < dong.length; j++) {
                int val = dong[j];
                if(val == 1) maTran.get(i)[j] = 0;
                for (int k = 2; k <= val/2; k++) {
                    if (val%k ==0) {
                        maTran.get(i)[j] = 0;
                        break;
                    }
                }
                mtString = mtString + dong[j] + ",";
            }
            mtString = mtString + "] \n";
        }

        return "Ma trận tìm số nguyên tố: \n" + mtString;
    }

    public static String sapXepCotTang(ArrayList<int[]> maTran) {
        int min = 100;
        String mtString = "";
        for (int j = 0; j < maTran.get(0).length; j++) {
            for (int i = 0; i < maTran.size(); i++) {
                
                for (int lap = i; lap < maTran.size(); lap++) {
                    if (maTran.get(lap)[j]<min) {
                        min = maTran.get(lap)[j];
                        maTran.get(lap)[j] = maTran.get(i)[j];
                        maTran.get(i)[j] = min;
                    }
                }
                min = 100;
            }
        }
        
        for (int i = 0; i < maTran.size(); i++) {
            mtString = mtString+"[";
            for (int j = 0; j < maTran.get(i).length; j++) {
                mtString = mtString + maTran.get(i)[j]+",";
            }
            mtString = mtString+"] \n";
        }
        return "Sắp xếp ma trận tăng dần theo từng cột: \n"+mtString;
    }
    
    public static ArrayList<int[]> layMaTran(String mtString) {
        ArrayList<int[]> matran = new ArrayList<>();
        String[] dsDong = mtString.split("\n");
        for (int i = 0; i < dsDong.length; i++) {
            dsDong[i] = dsDong[i].replace("[", "");
            dsDong[i] = dsDong[i].replace("]", "");
            String[] dsCot = dsDong[i].split(",");
            int[] valDong = new int[dsCot.length];
            for (int j = 0; j < dsCot.length; j++) {
                int ij = Integer.valueOf(dsCot[j].trim());
                System.out.println("A["+i+","+j+"] = "+ij);
                valDong[j] = ij;
            }
            matran.add(valDong);
        }
        return matran;
    }
    
    public static void udpSend(byte[] message,InetAddress address,int port) throws IOException{
        DatagramPacket packetSend = new DatagramPacket(message, message.length,address,port);
        svSocket.send(packetSend);
    }
    
    public static DatagramPacket udpReceive() throws IOException{
        DatagramPacket packetReceive = new DatagramPacket(new byte[1024], 1024);
        svSocket.receive(packetReceive);

        return packetReceive;
    }
}
