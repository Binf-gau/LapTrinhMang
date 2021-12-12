/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zLittleMasterz
 */
public class TCPCLIENT extends javax.swing.JFrame {

    private Socket clSocket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int[][] matran;

    public TCPCLIENT() throws IOException {
        initComponents();
        clSocket = new Socket("localhost", 2212);
        dos = new DataOutputStream(clSocket.getOutputStream());
        dis = new DataInputStream(clSocket.getInputStream());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        bttTimMax = new javax.swing.JButton();
        bttTimSoNt = new javax.swing.JButton();
        bttSapXepTangDan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaServer = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaMatran = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bttTimMax.setText("Phần tử lớn nhất");
        bttTimMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttTimMaxActionPerformed(evt);
            }
        });

        bttTimSoNt.setText("Số nguyên tố");
        bttTimSoNt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttTimSoNtActionPerformed(evt);
            }
        });

        bttSapXepTangDan.setText("Sắp xếp tăng dân");
        bttSapXepTangDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSapXepTangDanActionPerformed(evt);
            }
        });

        txtaServer.setColumns(20);
        txtaServer.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtaServer.setRows(5);
        jScrollPane1.setViewportView(txtaServer);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Server");

        txtaMatran.setColumns(20);
        txtaMatran.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtaMatran.setRows(5);
        txtaMatran.setText("[0,0,0,0]\n[0,0,0,0]\n[0,0,0,0]");
        jScrollPane2.setViewportView(txtaMatran);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Ma trận:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("TCP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(bttTimMax)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bttTimSoNt)
                                .addGap(18, 18, 18)
                                .addComponent(bttSapXepTangDan))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttTimMax)
                    .addComponent(bttTimSoNt)
                    .addComponent(bttSapXepTangDan))
                .addGap(22, 22, 22)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttTimMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttTimMaxActionPerformed
        try {
            dos.writeUTF(txtaMatran.getText());
            dos.writeInt(1);
            txtaServer.append(dis.readUTF()+"\n");
        } catch (IOException ex) {
            Logger.getLogger(TCPCLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_bttTimMaxActionPerformed

    private void bttTimSoNtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttTimSoNtActionPerformed
        try {
            dos.writeUTF(txtaMatran.getText());
            dos.writeInt(2);
            txtaServer.append(dis.readUTF()+"\n");
        } catch (IOException ex) {
            Logger.getLogger(TCPCLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bttTimSoNtActionPerformed

    private void bttSapXepTangDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSapXepTangDanActionPerformed
         try {
            dos.writeUTF(txtaMatran.getText());
            dos.writeInt(3);
            txtaServer.append(dis.readUTF()+"\n");
        } catch (IOException ex) {
            Logger.getLogger(TCPCLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bttSapXepTangDanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TCPCLIENT().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(TCPCLIENT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttSapXepTangDan;
    private javax.swing.JButton bttTimMax;
    private javax.swing.JButton bttTimSoNt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea txtaMatran;
    private javax.swing.JTextArea txtaServer;
    // End of variables declaration//GEN-END:variables
}
