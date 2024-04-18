/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.page;

import bus.ThongKeBUS;
import constants.ResponseStatus;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import utils.Response;
import view.component.ChartPie;
import view.component.ModelChartPie;

/**
 *
 * @author Son
 */
public class ThongKePage extends javax.swing.JPanel {
    private final ThongKeBUS thongKeBUS;
    /**
     * Creates new form userPage
     */
    public ThongKePage() {
        initComponents();
        thongKeBUS = new ThongKeBUS();
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.with(LocalTime.MAX);
        Date date = java.sql.Timestamp.valueOf(startTime);
        start.setDate(date);
        end.setDate(date);
        Response<List<Object[]>> response =  thongKeBUS.thongKeSoLuongTVTheoKhoa(startTime, endTime);
        if(response.getStatus()==ResponseStatus.FAILURE){
            return;
        }
        if(response.getData().isEmpty()){
            nullText1.setVisible(false);
        }
        else{
            List<ModelChartPie> list = createChartModel(response.getData());
            setModel(chartPie1,list);
        }
        response = thongKeBUS.thongKeSoLuongTVTheoNganh(startTime, endTime);
        if(response.getStatus()==ResponseStatus.FAILURE){
            return;
        }
        if(response.getData()==null){
            setNull(chartPie2);
        }
        else{
            List<ModelChartPie> list = createChartModel(response.getData());
            setModel(chartPie2, list);
        }
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detailPanel = new javax.swing.JPanel();
        renameTitle = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        confirmBtn = new view.component.Button();
        closeBtn = new view.component.Button();
        msTxt = new view.component.textField();
        nameTxt = new view.component.textField();
        khoaTxt = new view.component.textField();
        nganhTxt = new view.component.textField();
        sdtTxt = new view.component.textField();
        detailPanel1 = new javax.swing.JPanel();
        renameTitle1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        confirmBtn2 = new view.component.Button();
        closeBtn1 = new view.component.Button();
        msTxt1 = new view.component.textField();
        card1 = new view.component.Card();
        card2 = new view.component.Card();
        card5 = new view.component.Card();
        jPanel1 = new javax.swing.JPanel();
        start = new com.toedter.calendar.JDateChooser();
        end = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        confirmBtn1 = new view.component.Button();
        roundPanel1 = new view.component.RoundPanel();
        nullText2 = new javax.swing.JLabel();
        nullText1 = new javax.swing.JLabel();
        chartPie1 = new view.component.ChartPie();
        chartPie2 = new view.component.ChartPie();

        detailPanel.setBackground(new java.awt.Color(255, 255, 255));
        detailPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 216, 216)));

        renameTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        renameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        renameTitle.setText("Thông tin thành viên");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Mã TV:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Họ và tên:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Khoa:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Ngành:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("SDT:");

        confirmBtn.setBackground(new java.awt.Color(204, 204, 255));
        confirmBtn.setColor(new java.awt.Color(204, 204, 255));
        confirmBtn.setColorClick(new java.awt.Color(153, 153, 153));
        confirmBtn.setColorOver(new java.awt.Color(102, 102, 102));
        confirmBtn.setLabel("Xác nhận");
        confirmBtn.setRadius(5);
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        closeBtn.setBackground(new java.awt.Color(204, 204, 255));
        closeBtn.setText("Hủy");
        closeBtn.setColor(new java.awt.Color(204, 204, 255));
        closeBtn.setColorClick(new java.awt.Color(153, 153, 153));
        closeBtn.setColorOver(new java.awt.Color(102, 102, 102));
        closeBtn.setRadius(5);
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        msTxt.setLabelText("Nhập mã số");

        nameTxt.setLabelText("Nhập tên");

        khoaTxt.setLabelText("Nhập khoa");

        nganhTxt.setLabelText("Nhập ngành");

        sdtTxt.setLabelText("Nhập sdt");
        sdtTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdtTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout detailPanelLayout = new javax.swing.GroupLayout(detailPanel);
        detailPanel.setLayout(detailPanelLayout);
        detailPanelLayout.setHorizontalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(renameTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(detailPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(detailPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(detailPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(26, 26, 26)
                                .addComponent(msTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, detailPanelLayout.createSequentialGroup()
                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addGap(37, 37, 37)
                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(detailPanelLayout.createSequentialGroup()
                                        .addComponent(khoaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(nganhTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(sdtTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(84, 84, 84)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        detailPanelLayout.setVerticalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(renameTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(14, 14, 14)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(khoaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(nganhTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sdtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        detailPanel1.setBackground(new java.awt.Color(255, 255, 255));
        detailPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 216, 216)));

        renameTitle1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        renameTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        renameTitle1.setText("Xóa thành viên theo niên khóa");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Niên khóa:");

        confirmBtn2.setBackground(new java.awt.Color(204, 204, 255));
        confirmBtn2.setColor(new java.awt.Color(204, 204, 255));
        confirmBtn2.setColorClick(new java.awt.Color(153, 153, 153));
        confirmBtn2.setColorOver(new java.awt.Color(102, 102, 102));
        confirmBtn2.setLabel("Xác nhận");
        confirmBtn2.setRadius(5);
        confirmBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtn2ActionPerformed(evt);
            }
        });

        closeBtn1.setBackground(new java.awt.Color(204, 204, 255));
        closeBtn1.setText("Hủy");
        closeBtn1.setColor(new java.awt.Color(204, 204, 255));
        closeBtn1.setColorClick(new java.awt.Color(153, 153, 153));
        closeBtn1.setColorOver(new java.awt.Color(102, 102, 102));
        closeBtn1.setRadius(5);
        closeBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtn1ActionPerformed(evt);
            }
        });

        msTxt1.setLabelText("Nhập ms");
        msTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msTxt1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout detailPanel1Layout = new javax.swing.GroupLayout(detailPanel1);
        detailPanel1.setLayout(detailPanel1Layout);
        detailPanel1Layout.setHorizontalGroup(
            detailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanel1Layout.createSequentialGroup()
                .addGroup(detailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel13)
                        .addGap(40, 40, 40)
                        .addGroup(detailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(detailPanel1Layout.createSequentialGroup()
                                .addComponent(confirmBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(closeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(msTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 82, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(renameTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        detailPanel1Layout.setVerticalGroup(
            detailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(renameTitle1)
                .addGap(18, 18, 18)
                .addGroup(detailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(23, 23, 23)
                .addGroup(detailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(200, 227, 254));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        card1.setColor1(new java.awt.Color(0, 0, 255));
        card1.setColor2(new java.awt.Color(153, 153, 255));
        add(card1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 237, 342, -1));

        card2.setColor1(new java.awt.Color(0, 153, 0));
        card2.setColor2(new java.awt.Color(0, 255, 204));
        add(card2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 402, 342, -1));

        card5.setColor1(new java.awt.Color(255, 204, 204));
        card5.setColor2(new java.awt.Color(153, 0, 0));
        add(card5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 567, 342, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        start.setBackground(new java.awt.Color(255, 255, 255));

        end.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Bắt đầu:");

        jLabel2.setText("Kết thúc:");

        confirmBtn1.setBackground(new java.awt.Color(204, 204, 255));
        confirmBtn1.setColor(new java.awt.Color(204, 204, 255));
        confirmBtn1.setColorClick(new java.awt.Color(153, 153, 153));
        confirmBtn1.setColorOver(new java.awt.Color(102, 102, 102));
        confirmBtn1.setLabel("Xác nhận");
        confirmBtn1.setRadius(5);
        confirmBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(confirmBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 46, -1, 179));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        add(roundPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 237, 806, -1));

        nullText2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nullText2.setText("Chưa có dữ liệu thời gian này");
        add(nullText2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 130, -1, 20));

        nullText1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nullText1.setText("Chưa có dữ liệu thời gian này");
        add(nullText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, 20));
        add(chartPie1, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 46, 400, -1));
        add(chartPie2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 46, 400, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
       
    }//GEN-LAST:event_closeBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        

    }//GEN-LAST:event_confirmBtnActionPerformed

    private void confirmBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtn2ActionPerformed
        
    }//GEN-LAST:event_confirmBtn2ActionPerformed

    private void closeBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtn1ActionPerformed
       
    }//GEN-LAST:event_closeBtn1ActionPerformed

    private void confirmBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtn1ActionPerformed
        LocalDateTime startTime = start.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime endTime = end.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        endTime = endTime.with(LocalTime.MAX);
        Response<List<Object[]>> response =  thongKeBUS.thongKeSoLuongTVTheoKhoa(startTime, endTime);
        if(response.getStatus()==ResponseStatus.FAILURE){
            return;
        }
        List<ModelChartPie> list = createChartModel(response.getData());
        setModel(chartPie1,list);
        response = thongKeBUS.thongKeSoLuongTVTheoNganh(startTime, endTime);
        if(response.getStatus()==ResponseStatus.FAILURE){
            return;
        }
        list = createChartModel(response.getData());
        setModel(chartPie2, list);

        
    }//GEN-LAST:event_confirmBtn1ActionPerformed

    private void sdtTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdtTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdtTxtActionPerformed

    private void msTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msTxt1ActionPerformed
    public  List<ModelChartPie> createChartModel(List<Object[]> data){
        List<ModelChartPie> chartData = new ArrayList<>();
        Random random = new Random();
        for (Object[] row : data) {
            String title = (String) row[0];
            double value =  ((Long) row[1]).doubleValue();
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            System.out.println(value);
            chartData.add(new ModelChartPie(title, value, color));
        }
        return chartData;
    }
    public void setModel(ChartPie chartPie,List<ModelChartPie> list){
        chartPie.setModel(list);
        chartPie.revalidate();
        chartPie.repaint();
    }
    public void setNull(ChartPie chartPie){
        List<ModelChartPie> chartData = new ArrayList<>();
        chartData.add(new ModelChartPie("Trống", 0, new Color(153,0,0)));
        setModel(chartPie, chartData);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.component.Card card1;
    private view.component.Card card2;
    private view.component.Card card5;
    private view.component.ChartPie chartPie1;
    private view.component.ChartPie chartPie2;
    private view.component.Button closeBtn;
    private view.component.Button closeBtn1;
    private view.component.Button confirmBtn;
    private view.component.Button confirmBtn1;
    private view.component.Button confirmBtn2;
    private javax.swing.JPanel detailPanel;
    private javax.swing.JPanel detailPanel1;
    private com.toedter.calendar.JDateChooser end;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private view.component.textField khoaTxt;
    private view.component.textField msTxt;
    private view.component.textField msTxt1;
    private view.component.textField nameTxt;
    private view.component.textField nganhTxt;
    private javax.swing.JLabel nullText1;
    private javax.swing.JLabel nullText2;
    private javax.swing.JLabel renameTitle;
    private javax.swing.JLabel renameTitle1;
    private view.component.RoundPanel roundPanel1;
    private view.component.textField sdtTxt;
    private com.toedter.calendar.JDateChooser start;
    // End of variables declaration//GEN-END:variables
}
