/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.page;

import bus.ThanhVienBUS;
import bus.ThietBiBUS;
import bus.ThongTinSDBUS;
import bus.XuLyBUS;
import com.toedter.calendar.JCalendar;
import constants.ResponseStatus;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.ThanhVien;
import model.ThietBi;
import model.ThongTinSD;
import model.XuLy;
import utils.DateTimeUtils;
import utils.ExcelUtil;
import utils.Response;
import view.component.TableActionCellEditor;
import view.component.TableActionCellRender;
import view.component.TableActionEvent;
import view.component.customDialog;


/**
 *
 * @author Son
 */
public class ThongTinSDPage extends javax.swing.JPanel {
    private final ThongTinSDBUS thongTinSDBUS;
    private TableActionEvent event;
    /**
     * Creates new form userPage
     */
    public ThongTinSDPage() {
        initComponents();
        thongTinSDBUS = new ThongTinSDBUS();
        setEvent();
        setTable();
        checkinForm = new customDialog(null);
        checkinForm.setDialogContent(checkinPanel);
        issueForm = new customDialog(null);
        issueForm.setDialogContent(detailPanel);
        renderUsers();
    }
    public void setEvent(){
        event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int id =Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
                isUpdating=true;
                oldId = id;
                renderDetail(id);
            }
            @Override
            public void onDelete(int row) {
                int Ok = JOptionPane.showConfirmDialog(null, "Xác nhận xóa ?", TOOL_TIP_TEXT_KEY, JOptionPane.YES_NO_OPTION);
                if(Ok!=JOptionPane.YES_OPTION)
                    return;
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int id = Integer.parseInt(model.getValueAt(row, 0).toString());
                Response response = thongTinSDBUS.delete(id);
                if(response.getStatus() == ResponseStatus.FAILURE){
                    JOptionPane.showMessageDialog(null, response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                renderUsers();

            }
        };
    }
    
    public void setTable(){
        table.removeEditor();
        table.setTableHeader(null);
        table.setDefaultRenderer(Object.class, (JTable t, Object value, boolean isSelected, boolean hasFocus, int row, int column) -> {
            Component component = new DefaultTableCellRenderer().getTableCellRendererComponent(t, value, isSelected, hasFocus, row, column);
            if (isSelected == false ) {
            component.setBackground(Color.WHITE);
            }
            return component;
        });
    }
    
    public void renderUsers(){
        setTable();
        Response<List<ThongTinSD>> response = thongTinSDBUS.getAllCheckin();
        if(response.getStatus() == ResponseStatus.FAILURE){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for(ThongTinSD thongTinSD: response.getData()){
            Object[] row = new Object[]{thongTinSD.getMaTT(),thongTinSD.getThanhVien().getHoTen(),DateTimeUtils.format(thongTinSD.getTGVao())};
            model.addRow(row);
        }
        table.revalidate();
        table.repaint();
    }
    public void renderBorrows(){
        Response<List<ThongTinSD>> response = thongTinSDBUS.getAllBorrow();
        DefaultTableModel model = (DefaultTableModel)borrowTable.getModel();
        model.setRowCount(0);
        for(ThongTinSD thongTinSD : response.getData()){
            Object[] row = new Object[]{thongTinSD.getMaTT(),thongTinSD.getThietBi().getMoTaTB(),thongTinSD.getThanhVien().getHoTen(),DateTimeUtils.format(thongTinSD.getTGMuon()),DateTimeUtils.format(thongTinSD.getTGTra())};
            model.addRow(row);
        }
    }
    public void renderDetail(int id){
//        Response<ThongTin> response = thongTinSDBUS.getOne("MaTV",id);
//        if(response.getStatus() == ResponseStatus.FAILURE){
//            JOptionPane.showMessageDialog(null, response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        msTxt.setEnabled(false);
//        ThanhVien thanhVien = response.getData();
//        msTxt.setText(thanhVien.getMaTV()+"");
//        nameTxt.setText(thanhVien.getHoTen());
//        checkinForm.setVisible(true);
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
        jLabel11 = new javax.swing.JLabel();
        msTxt = new view.custom.textField();
        maTBTxt = new view.custom.textField();
        confirmBtn = new view.component.Button();
        closeBtn = new view.component.Button();
        issueHour = new view.custom.textField();
        jLabel10 = new javax.swing.JLabel();
        issueMinute = new view.custom.textField();
        issueDate = new com.toedter.calendar.JDateChooser();
        returnHour = new view.custom.textField();
        jLabel13 = new javax.swing.JLabel();
        returnMinute = new view.custom.textField();
        returnDate = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        borrowTable = new javax.swing.JTable();
        confirmBtn3 = new view.component.Button();
        checkinPanel = new javax.swing.JPanel();
        confirmBtn2 = new view.component.Button();
        closeBtn1 = new view.component.Button();
        msTxt1 = new view.custom.textField();
        roundPanel2 = new view.component.RoundPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        button1 = new view.component.Button();
        roundPanel1 = new view.component.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        sortOp = new javax.swing.JComboBox<>();
        confirmBtn1 = new view.component.Button();
        button4 = new view.component.Button();
        calendar = new com.toedter.calendar.JDateChooser();

        detailPanel.setBackground(new java.awt.Color(255, 255, 255));
        detailPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        renameTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        renameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        renameTitle.setText("Thông tin sử dụng thiết bị");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Mã TV:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Mã TB:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Thời gian mượn:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Thời gian trả:");

        msTxt.setLabelText("Nhập mã thành viên");

        maTBTxt.setLabelText("Nhập mã thiết bị");

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

        issueHour.setLabelText("hh");

        jLabel10.setText(":");

        issueMinute.setLabelText("mm");

        returnHour.setLabelText("hh");

        jLabel13.setText(":");

        returnMinute.setLabelText("mm");

        borrowTable.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        borrowTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên thiết bị", "Tên TV", "TG mượn", "TG trả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new java.awt.Color(56, 138, 112)); // Đặt màu nền của tiêu đề
        borrowTable.setSelectionBackground(new java.awt.Color(255, 153, 51));
        borrowTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(borrowTable);
        if (borrowTable.getColumnModel().getColumnCount() > 0) {
            borrowTable.getColumnModel().getColumn(0).setResizable(false);
            borrowTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            borrowTable.getColumnModel().getColumn(1).setResizable(false);
            borrowTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            borrowTable.getColumnModel().getColumn(2).setResizable(false);
            borrowTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            borrowTable.getColumnModel().getColumn(3).setResizable(false);
            borrowTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            borrowTable.getColumnModel().getColumn(4).setResizable(false);
            borrowTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jScrollPane3.setViewportView(jScrollPane2);

        confirmBtn3.setText("Xóa");
        confirmBtn3.setColor(new java.awt.Color(255, 102, 102));
        confirmBtn3.setColorClick(new java.awt.Color(153, 153, 153));
        confirmBtn3.setColorOver(new java.awt.Color(102, 102, 102));
        confirmBtn3.setRadius(5);
        confirmBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout detailPanelLayout = new javax.swing.GroupLayout(detailPanel);
        detailPanel.setLayout(detailPanelLayout);
        detailPanelLayout.setHorizontalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(renameTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailPanelLayout.createSequentialGroup()
                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(detailPanelLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(detailPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addGap(26, 26, 26)
                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(detailPanelLayout.createSequentialGroup()
                                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(detailPanelLayout.createSequentialGroup()
                                                .addComponent(returnHour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(returnMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(detailPanelLayout.createSequentialGroup()
                                                .addComponent(issueHour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(issueMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(returnDate, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                            .addComponent(issueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(msTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                        .addComponent(maTBTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(32, 32, 32)))
                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        detailPanelLayout.setVerticalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(renameTitle)
                .addGap(38, 38, 38)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailPanelLayout.createSequentialGroup()
                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(msTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(maTBTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(detailPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(issueHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                    .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(issueMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))))
                            .addGroup(detailPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(issueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(detailPanelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel11))
                            .addGroup(detailPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(returnHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(returnMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13))))
                            .addGroup(detailPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        checkinPanel.setBackground(new java.awt.Color(255, 255, 255));
        checkinPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        msTxt1.setLabelText("Nhập mã thành viên");

        javax.swing.GroupLayout checkinPanelLayout = new javax.swing.GroupLayout(checkinPanel);
        checkinPanel.setLayout(checkinPanelLayout);
        checkinPanelLayout.setHorizontalGroup(
            checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkinPanelLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(checkinPanelLayout.createSequentialGroup()
                        .addComponent(confirmBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(msTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );
        checkinPanelLayout.setVerticalGroup(
            checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkinPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(msTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(200, 227, 254));

        roundPanel2.setBackground(new java.awt.Color(51, 122, 183));
        roundPanel2.setRadius(10);
        roundPanel2.setRound(view.component.RoundPanel.Round.TOP);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 122, 183)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ THÀNH VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 122, 183)));

        button1.setBackground(new java.awt.Color(68, 157, 68));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Check in");
        button1.setColor(new java.awt.Color(68, 157, 68));
        button1.setColorClick(new java.awt.Color(102, 153, 255));
        button1.setColorOver(new java.awt.Color(68, 181, 57));
        button1.setRadius(5);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        roundPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane1.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Họ tên", "Thời gian vào"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFocusable(false);
        table.setGridColor(new java.awt.Color(216, 216, 216));
        table.setRowHeight(50);
        table.setSelectionBackground(new java.awt.Color(56, 138, 112));
        table.setShowHorizontalLines(true);
        table.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(10);
            table.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("STT");

        jLabel4.setText("Họ Tên");

        jLabel6.setText("Thời gian vào");

        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel3)
                .addGap(249, 249, 249)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(254, 254, 254))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel12.setText("Điều kiện lọc:");

        sortOp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm dần", "Tăng dần" }));

        confirmBtn1.setBackground(new java.awt.Color(204, 204, 255));
        confirmBtn1.setText("Tìm kiếm");
        confirmBtn1.setColor(new java.awt.Color(204, 204, 255));
        confirmBtn1.setColorClick(new java.awt.Color(153, 153, 153));
        confirmBtn1.setColorOver(new java.awt.Color(102, 102, 102));
        confirmBtn1.setRadius(5);
        confirmBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtn1ActionPerformed(evt);
            }
        });

        button4.setForeground(new java.awt.Color(255, 255, 255));
        button4.setText("Mượn thiết bị");
        button4.setColor(new java.awt.Color(153, 153, 0));
        button4.setColorClick(new java.awt.Color(255, 153, 0));
        button4.setColorOver(new java.awt.Color(255, 102, 51));
        button4.setRadius(5);
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sortOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(confirmBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(sortOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(calendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        isUpdating=false;
        checkinForm.setVisible(true);
        
    }//GEN-LAST:event_button1ActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        closeIssueForm();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        try{
            LocalDateTime issueDateTime = createLocalDateTime(returnDate.getJCalendar(), issueHour,issueMinute);
            LocalDateTime returnDateTime = createLocalDateTime(returnDate.getJCalendar(), returnHour, returnMinute);
            System.out.println(issueDateTime);
            System.out.println(returnDateTime);
            if(issueDateTime==null|| returnDateTime==null){
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng thông tin", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            int maTV = Integer.parseInt(msTxt.getText().trim());
            int maTB = Integer.parseInt(maTBTxt.getText().trim());
            ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
            ThietBiBUS thietBiBUS = new ThietBiBUS();
            Response<ThanhVien> thanhVienRes = thanhVienBUS.getOne("MaTV", maTV);
            Response<ThietBi> thietBiRes = thietBiBUS.getOne("MaTB", maTB);
            if(thanhVienRes.getStatus()==ResponseStatus.FAILURE||thietBiRes.getStatus()==ResponseStatus.FAILURE){
                JOptionPane.showMessageDialog(null,"Không tìm thấy thông tin của mã TV hoặc Mã TB", "Warning", JOptionPane.WARNING_MESSAGE);
                return;         
            }
            ThanhVien thanhVien = thanhVienRes.getData();
            ThietBi thietBi = thietBiRes.getData();
            ThongTinSD thongTinSD = new ThongTinSD();
            thongTinSD.setThanhVien(thanhVien);
            thongTinSD.setThietBi(thietBi);
            thongTinSD.setTGMuon(issueDateTime);
            thongTinSD.setTGTra(returnDateTime);
            Response response = thongTinSDBUS.borrowDevice(thongTinSD);
            if(response.getStatus()==ResponseStatus.FAILURE){
                JOptionPane.showMessageDialog(null,response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                return; 
            }
            JOptionPane.showMessageDialog(null,response.getMessage(), "Information", JOptionPane.INFORMATION_MESSAGE);
            renderBorrows();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void confirmBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtn1ActionPerformed
        List<ThongTinSD> thongTinSDs;
        String sortKey = sortOp.getSelectedIndex()==0?"desc":"asc";
        if(calendar.getCalendar()==null){
            thongTinSDs = thongTinSDBUS.getCheckInByFilter(sortKey).getData();
        }
        else{
            LocalDate selectedDate = calendar.getDate().toInstant().atZone(calendar.getCalendar().getTimeZone().toZoneId()).toLocalDate();
            LocalDateTime startDateTime = LocalDateTime.of(selectedDate, LocalTime.MIN);
            LocalDateTime endDateTime = LocalDateTime.of(selectedDate,  LocalTime.MAX);
            thongTinSDs = thongTinSDBUS.getCheckInByTimeRange(startDateTime, endDateTime, sortKey).getData();
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for(ThongTinSD thongTinSD: thongTinSDs){ 
            Object[] row = new Object[]{thongTinSD.getMaTT(),thongTinSD.getThanhVien().getHoTen(),DateTimeUtils.format(thongTinSD.getTGVao())};
            model.addRow(row);
        }
        
        
    }//GEN-LAST:event_confirmBtn1ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        renderBorrows();
        issueForm.setVisible(true);
        
    }//GEN-LAST:event_button4ActionPerformed

    private void confirmBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtn2ActionPerformed
        String id = msTxt1.getText();
        if(id.isBlank()){
            JOptionPane.showMessageDialog(null, "không được để trống thông tin", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        id = id.trim();
        ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
        Response<ThanhVien> response = thanhVienBUS.getOne("maTV", id);
        if(response.getStatus()== ResponseStatus.FAILURE){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ThongTinSD thongTinSD = new ThongTinSD();
        thongTinSD.setThanhVien(response.getData());
        thongTinSD.setTGVao(LocalDateTime.now());
        Response newResponse = thongTinSDBUS.add(thongTinSD);
        if(newResponse.getStatus()==ResponseStatus.FAILURE){
            JOptionPane.showMessageDialog(null, newResponse.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        XuLyBUS xuLyBUS = new XuLyBUS();
        Response<XuLy> newRes = xuLyBUS.getLatestRecordByMaTV(Integer.parseInt(id));
        if(newRes.getStatus()==ResponseStatus.SUCCESS){
                    JOptionPane.showMessageDialog(null, "Thành viên này đang bị cảnh cáo vi phạm", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, newResponse.getMessage(), "Information", JOptionPane.INFORMATION_MESSAGE);
        renderUsers();
        checkinForm.setVisible(false);
    }//GEN-LAST:event_confirmBtn2ActionPerformed

    private void closeBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtn1ActionPerformed
        closeCheckinForm();
    }//GEN-LAST:event_closeBtn1ActionPerformed

    private void confirmBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtn3ActionPerformed
        int id = (int) borrowTable.getModel().getValueAt(borrowTable.getSelectedRow(), 0);
        Response response = thongTinSDBUS.delete(id);
        if(response.getStatus()==ResponseStatus.FAILURE){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, response.getMessage(), "Information", JOptionPane.INFORMATION_MESSAGE);
        renderBorrows();
    }//GEN-LAST:event_confirmBtn3ActionPerformed
    public void closeCheckinForm(){
        checkinForm.setVisible(false);
        msTxt1.setText("");
    }
    public void closeIssueForm(){
        issueForm.setVisible(false);
        msTxt.setText("");
        maTBTxt.setText("");
        issueHour.setText("");
        issueMinute.setText("");
        issueDate.setCalendar(Calendar.getInstance());
        returnHour.setText("");
        returnMinute.setText("");
        returnDate.setCalendar(Calendar.getInstance());
    }
    public LocalDateTime createLocalDateTime(JCalendar calendar, JTextField hourField, JTextField minuteField) {
        try{
            int year = calendar.getCalendar().get(Calendar.YEAR);
            int month = calendar.getCalendar().get(Calendar.MONTH) + 1; // Tháng trong Java bắt đầu từ 0
            int dayOfMonth = calendar.getCalendar().get(Calendar.DAY_OF_MONTH);
            String hourText = hourField.getText();
            String minuteText = minuteField.getText();
            if (hourText.isEmpty() || minuteText.isEmpty()) {
                return null;
            }
            int hour = Integer.parseInt(hourText);
            int minute = Integer.parseInt(minuteText);

            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                return null;
            }
        LocalDateTime dateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        return dateTime;
        }catch(NumberFormatException e){
            return null;
        }
    }
    private int oldId;
    private boolean isUpdating;
    private customDialog checkinForm;
    private customDialog issueForm;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable borrowTable;
    private view.component.Button button1;
    private view.component.Button button4;
    private com.toedter.calendar.JDateChooser calendar;
    private javax.swing.JPanel checkinPanel;
    private view.component.Button closeBtn;
    private view.component.Button closeBtn1;
    private view.component.Button confirmBtn;
    private view.component.Button confirmBtn1;
    private view.component.Button confirmBtn2;
    private view.component.Button confirmBtn3;
    private javax.swing.JPanel detailPanel;
    private com.toedter.calendar.JDateChooser issueDate;
    private view.custom.textField issueHour;
    private view.custom.textField issueMinute;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private view.custom.textField maTBTxt;
    private view.custom.textField msTxt;
    private view.custom.textField msTxt1;
    private javax.swing.JLabel renameTitle;
    private com.toedter.calendar.JDateChooser returnDate;
    private view.custom.textField returnHour;
    private view.custom.textField returnMinute;
    private view.component.RoundPanel roundPanel1;
    private view.component.RoundPanel roundPanel2;
    private javax.swing.JComboBox<String> sortOp;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
