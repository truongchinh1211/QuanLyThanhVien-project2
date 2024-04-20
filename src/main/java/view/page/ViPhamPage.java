/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.page;

import bus.ThanhVienBUS;
import bus.XuLyBUS;
import com.toedter.calendar.JCalendar;
import constants.ResponseStatus;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class ViPhamPage extends javax.swing.JPanel {
    private final XuLyBUS XuLyBUS;
    private final ThanhVienBUS thanhVienBUS;
    private TableActionEvent event;
    /**
     * Creates new form userPage
     */
    public ViPhamPage() {
        initComponents();
        XuLyBUS = new XuLyBUS();
        thanhVienBUS = new ThanhVienBUS();
        setEvent();
        setTable();
        userForm = new customDialog(null);
        userForm.setDialogContent(detailPanel);
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
                Response response = XuLyBUS.delete(id);
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
        table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
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
        Response<List<XuLy>> response = XuLyBUS.getAll();
        if(response.getStatus() == ResponseStatus.FAILURE){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for(XuLy xuLy: response.getData()){
            Object[] row = new Object[]{xuLy.getMaXL(),xuLy.getThanhVien().getHoTen(),xuLy.getHinhThucXL(),xuLy.getSoTien()
            ,DateTimeUtils.format(xuLy.getNgayXL()),xuLy.getTrangThaiXuLi()==1?"Đã xử lý":"Chưa xử lý"};
            model.addRow(row);
        }
        table.revalidate();
        table.repaint();
    }
    
    public void renderDetail(int id){
        Response<XuLy> response = XuLyBUS.getOne("MaXL",id);
        if(response.getStatus() == ResponseStatus.FAILURE){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        XuLy xuLy = response.getData();
        msTxt.setText(xuLy.getThanhVien().getMaTV()+"");
        hinhThucCb.setSelectedItem(xuLy.getHinhThucXL());
        if(hinhThucCb.getSelectedIndex()==3 || hinhThucCb.getSelectedIndex()==4)
            moneyTxt.setEnabled(true);
        moneyTxt.setText(xuLy.getSoTien()+"");
        hour.setText(xuLy.getNgayXL().getHour()+"");
        minute.setText(xuLy.getNgayXL().getMinute()+"");
        date.setDate(Date.from(xuLy.getNgayXL().atZone(ZoneId.systemDefault()).toInstant()));
        status.setSelected((xuLy.getTrangThaiXuLi()==1));
        userForm.setVisible(true);
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
        confirmBtn = new view.component.Button();
        closeBtn = new view.component.Button();
        hinhThucCb = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        status = new javax.swing.JCheckBox();
        msTxt = new view.component.textField();
        moneyTxt = new view.component.textField();
        hour = new view.component.textField();
        jLabel11 = new javax.swing.JLabel();
        minute = new view.component.textField();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        detailPanel.setBackground(new java.awt.Color(255, 255, 255));
        detailPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 216, 216)));

        renameTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        renameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        renameTitle.setText("Thông tin thành viên");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Mã TV:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Hình thức:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Số tiền:");

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

        hinhThucCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khóa thẻ 1 tháng", "Khóa thẻ 2 tháng", "Khóa thẻ vĩnh viễn", "Bồi thường", "Khóa thẻ 1 tháng và bồi thường" }));
        hinhThucCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hinhThucCbActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Ngày XL:");

        jLabel10.setText(":");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Trạng thái XL:");

        status.setText("Đã xử lý");

        msTxt.setLabelText("Nhập mã số");

        moneyTxt.setEnabled(false);
        moneyTxt.setLabelText("Nhập số tiền");

        hour.setLabelText("hh");

        jLabel11.setText(":");

        minute.setLabelText("mm");

        javax.swing.GroupLayout detailPanelLayout = new javax.swing.GroupLayout(detailPanel);
        detailPanel.setLayout(detailPanelLayout);
        detailPanelLayout.setHorizontalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(renameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, detailPanelLayout.createSequentialGroup()
                            .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(detailPanelLayout.createSequentialGroup()
                                    .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel15))
                                    .addGap(28, 28, 28)
                                    .addComponent(moneyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(detailPanelLayout.createSequentialGroup()
                                    .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                            .addGap(83, 83, 83)
                                            .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(3, 3, 3)
                                            .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                            .addGap(59, 59, 59)
                                            .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(detailPanelLayout.createSequentialGroup()
                                            .addGap(20, 20, 20)
                                            .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, detailPanelLayout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addGap(18, 18, 18)
                            .addComponent(status))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, detailPanelLayout.createSequentialGroup()
                            .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7))
                            .addGap(26, 26, 26)
                            .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(msTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hinhThucCb, 0, 301, Short.MAX_VALUE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        detailPanelLayout.setVerticalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(renameTitle)
                .addGap(9, 9, 9)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(hinhThucCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(moneyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel15))
                    .addGroup(detailPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(status))
                .addGap(22, 22, 22)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
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
        jLabel2.setText("QUẢN LÝ VI PHẠM");

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
        button1.setText("Thêm");
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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã XL", "Họ tên", "Hình thức XL", "Số tiền", "Ngày XL", "Trạng thái", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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
            table.getColumnModel().getColumn(1).setPreferredWidth(50);
            table.getColumnModel().getColumn(2).setPreferredWidth(50);
            table.getColumnModel().getColumn(3).setPreferredWidth(30);
            table.getColumnModel().getColumn(4).setPreferredWidth(50);
            table.getColumnModel().getColumn(5).setPreferredWidth(20);
            table.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Mã XL");

        jLabel4.setText("Họ Tên");

        jLabel5.setText("Hình thức XL");

        jLabel6.setText("Số tiền");

        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel13.setText("Ngày XL");

        jLabel14.setText("Trạng thái");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel4)
                        .addGap(101, 101, 101)
                        .addComponent(jLabel5)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel6)
                        .addGap(93, 93, 93)
                        .addComponent(jLabel13)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel14)
                        .addGap(0, 229, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        isUpdating=false;
        userForm.setVisible(true);
        
    }//GEN-LAST:event_button1ActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        closeDialog();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        try{
        int id = Integer.parseInt(msTxt.getText());
        Response<ThanhVien> memberRes = thanhVienBUS.getOne("MaTV",id);
        if(memberRes.getStatus()==ResponseStatus.FAILURE){
            JOptionPane.showMessageDialog(null, memberRes.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String hinhThucXL = hinhThucCb.getSelectedItem().toString();
        LocalDateTime dateTime = createLocalDateTime(date.getJCalendar(), hour, minute);
        if(dateTime==null){
            JOptionPane.showMessageDialog(null, "vui lòng nhập chính xác ngày tháng năm", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int trangThai = status.isSelected()?1:0;
        XuLy xuLy = new XuLy();
        xuLy.setThanhVien(memberRes.getData());
        xuLy.setHinhThucXL(hinhThucXL);
        if(hinhThucCb.getSelectedIndex()==3||hinhThucCb.getSelectedIndex()==4){
            xuLy.setSoTien(Integer.valueOf(moneyTxt.getText()));
        }
        
        xuLy.setNgayXL(dateTime);
        xuLy.setTrangThaiXuLi(trangThai);
        Response response;
        if(!isUpdating)
        response = XuLyBUS.add(xuLy);
        else {
            xuLy.setMaXL(oldId);
            response = XuLyBUS.update(xuLy);
        }
        if(response.getStatus()==ResponseStatus.FAILURE){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, response.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
        closeDialog();
        renderUsers();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Nhập tiền cho chính xác", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_confirmBtnActionPerformed

    private void hinhThucCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hinhThucCbActionPerformed
        if(hinhThucCb.getSelectedIndex()==3||hinhThucCb.getSelectedIndex()==4)
            moneyTxt.setEnabled(true);
        else
            moneyTxt.setEnabled(false);
    }//GEN-LAST:event_hinhThucCbActionPerformed
    public void closeDialog(){
        userForm.setVisible(false);
        msTxt.setText("");
        hinhThucCb.setSelectedIndex(0);
        moneyTxt.setEnabled(false);
        moneyTxt.setText("");
        hour.setText("");
        minute.setText("");
        status.setSelected(false);
        date.setCalendar(Calendar.getInstance());
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
    private customDialog userForm;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.component.Button button1;
    private view.component.Button closeBtn;
    private view.component.Button confirmBtn;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JPanel detailPanel;
    private javax.swing.JComboBox<String> hinhThucCb;
    private view.component.textField hour;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private view.component.textField minute;
    private view.component.textField moneyTxt;
    private view.component.textField msTxt;
    private javax.swing.JLabel renameTitle;
    private view.component.RoundPanel roundPanel1;
    private view.component.RoundPanel roundPanel2;
    private javax.swing.JCheckBox status;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
