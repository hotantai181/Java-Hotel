/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks;

import DAO.DAO_Phong;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Administrator
 */
public class QLP extends javax.swing.JPanel {

    /**
     * Creates new form QLP
     */
    DAO_Phong dao;
    public QLP() {
        initComponents();
        dao = new DAO_Phong();
        loadPhong();
    }
    public void loadPhong()
    {   int a = 0; int b=0;
        Object[] phong = dao.LayDanhSachPhong().toArray();
        for(int i=0;i<phong.length;i++)
        {
            String text = phong[i].toString();
            JButton btn = new JButton(phong[i].toString());
            if(text.substring(5,14).compareTo("Còn phòng")==0)
                btn.setBackground(new Color(0, 255, 255));
            else
                 btn.setBackground(new Color(255, 0, 0));
            btn.setSize(150,100);// kich thuoc
            btn.setLocation(a,b);
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
		// Kiểm tra nếu sử dụng chuột fải thì hiển thị
		if (e.isPopupTrigger())
                {
                    if(text.substring(5,14).compareTo("Còn phòng")==0)
			hienThiMenu(e);
                    else 
                        hienThiMenuDP(e);
                }
                }
              });
            jPanel2.add(btn);
            
            if(a == 765)
            {
                b = b+ 105;
                a = 0;
            }
            else
                a=a+ 153;
        }
    }
    private void hienThiMenu(MouseEvent e) {
		// Khởi tạo ContextMenuStrip
		ContextMenuStripConPhong cmsMenu = new ContextMenuStripConPhong();
                cmsMenu.menu1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DP dp = new DP();
                        dp.setVisible(true);
                    }
                });
                cmsMenu.menu3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ThemPhong tp = new ThemPhong();
                        tp.setVisible(true);
                    }
                });
                
                
		// Hiển thị menu ngay chuột
		cmsMenu.show(e.getComponent(), e.getX(), e.getY());       
	}
     private void hienThiMenuDP(MouseEvent e) {
		// Khởi tạo ContextMenuStrip
		ContextMenuStripDangSD cmsMenu = new ContextMenuStripDangSD();
                cmsMenu.menu1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    }
                });
                
                cmsMenu.menu3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         ThemPhong tp = new ThemPhong();
                        tp.setVisible(true);
                    }
                });
                
		// Hiển thị menu ngay chuột
		cmsMenu.show(e.getComponent(), e.getX(), e.getY());
                
                
	}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(227, 239, 255));
        setPreferredSize(new java.awt.Dimension(915, 501));

        jPanel2.setLayout(null);

        jButton1.setText("Cập nhật");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tìm phòng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jPanel2.removeAll();
        
        jPanel2.repaint();
        loadPhong();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
