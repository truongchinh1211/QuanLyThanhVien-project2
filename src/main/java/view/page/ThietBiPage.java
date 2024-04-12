/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.page;

import bus.ThietBiBUS;
import constants.ResponseStatus;
import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.ThietBi;
import utils.Response;
import view.component.TableActionCellEditor;
import view.component.TableActionCellRender;
import view.component.TableActionEvent;
import view.component.customDialog;

/**
 *
 * @author Son
 */
public class ThietBiPage extends javax.swing.JPanel {
    private final ThietBiBUS thietBiBUS;
    private TableActionEvent event;
    /**
     * Creates new form userPage
     */
    public ThietBiPage() {
        initComponents();
        thietBiBUS = new ThietBiBUS();
        setEvent();
        setTable();
        userForm = new customDialog(null);
        userForm.setDialogContent(detailPanel);
        renderThietBis();
    }
    public void setEvent(){
        event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int id =Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
                isUpdating=true;
                renderDetail(id);
            }
            @Override
            public void onDelete(int row) {
                int Ok = JOptionPane.showConfirmDialog(null, "Xác nhận xóa ?", TOOL_TIP_TEXT_KEY, JOptionPane.YES_NO_OPTION);
                if(Ok!=JOptionPane.YES_OPTION)
                    return;
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int id = Integer.parseInt(model.getValueAt(row, 0).toString());
                Response response = thietBiBUS.delete(id);
                if(response.getStatus() == ResponseStatus.FAILURE){
                    JOptionPane.showMessageDialog(null, response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                renderThietBis();

            }
        };
    }
    
    public void setTable(){
        table.removeEditor();
        table.setTableHeader(null);
        table.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));
        table.setDefaultRenderer(Object.class, (JTable t, Object value, boolean isSelected, boolean hasFocus, int row, int column) -> {
            Component component = new DefaultTableCellRenderer().getTableCellRendererComponent(t, value, isSelected, hasFocus, row, column);
            if (isSelected == false ) {
            component.setBackground(Color.WHITE);
            }
            return component;
        });
    }
    
    public void renderThietBis(){
        setTable();
        Response<List<ThietBi>> response = thietBiBUS.getAll();
        if(response.getStatus() == ResponseStatus.FAILURE){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for(ThietBi thietBi: response.getData()){
            Object[] row = new Object[]{thietBi.getMaTB(),thietBi.getTenTB(),thietBi.getMoTaTB()};
            model.addRow(row);
        }
        table.revalidate();
        table.repaint();
    }
    
    public void renderDetail(int id){
        Response<ThietBi> response = thietBiBUS.getOne("MaTB",id);
        if(response.getStatus() == ResponseStatus.FAILURE){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ThietBi thietBi = response.getData();
        msTxt.setText(thietBi.getMaTB()+"");
        nameTxt.setText(thietBi.getTenTB());
        khoaTxt.setText(thietBi.getMoTaTB());
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
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        msTxt = new view.custom.textField();
        nameTxt = new view.custom.textField();
        khoaTxt = new view.custom.textField();
        nganhTxt = new view.custom.textField();
        sdtTxt = new view.custom.textField();
        confirmBtn = new view.component.Button();
        closeBtn = new view.component.Button();
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        keyword = new javax.swing.JComboBox<>();
        searchTxt = new javax.swing.JTextField();
        confirmBtn1 = new view.component.Button();

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

        msTxt.setEnabled(false);
        msTxt.setLabelText("Nhập mã số");

        nameTxt.setLabelText("Nhập tên");

        khoaTxt.setLabelText("Nhập khoa");

        nganhTxt.setLabelText("Nhập ngành");

        sdtTxt.setLabelText("Nhập số điện thoại");

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
                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(detailPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sdtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(detailPanelLayout.createSequentialGroup()
                                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(26, 26, 26)
                                        .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(msTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(nameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(detailPanelLayout.createSequentialGroup()
                                                .addComponent(khoaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(nganhTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(detailPanelLayout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 70, Short.MAX_VALUE)))
                .addContainerGap())
        );
        detailPanelLayout.setVerticalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(renameTitle)
                .addGap(18, 18, 18)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(msTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(khoaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nganhTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(sdtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(200, 227, 254));

        roundPanel2.setBackground(new java.awt.Color(51, 122, 183));
        roundPanel2.setRadius(10);
        roundPanel2.setRound(view.component.RoundPanel.Round.TOP);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1081, Short.MAX_VALUE)
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 122, 183)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ THIẾT BỊ");

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
        button1.setText("Thêm thiết bị");
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã TB", "Tên", "Mô tả", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
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
            table.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Mã TB");

        jLabel4.setText("Tên thiết bị");

        jLabel5.setText("Mô tả");

        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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
                        .addGap(88, 88, 88)
                        .addComponent(jLabel3)
                        .addGap(192, 192, 192)
                        .addComponent(jLabel4)
                        .addGap(219, 219, 219)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE))
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

        keyword.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã TB", "tên TB", "Mô tả" }));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confirmBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(38, Short.MAX_VALUE))
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
//        int generatedId = thietBiBUS.generateMaTV();
//        msTxt.setText(generatedId+"");
//        System.out.println(generatedId);
        userForm.setVisible(true);
        
    }//GEN-LAST:event_button1ActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        closeDialog();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        int id = Integer.parseInt(msTxt.getText());
        String tenTb = nameTxt.getText();
        String moTa = khoaTxt.getText();
        if(tenTb.isBlank()&&moTa.isBlank()){
            JOptionPane.showMessageDialog(null, "không được để trống thông tin", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ThietBi thietBi = new ThietBi(id,tenTb,moTa);
        Response response;
        if(isUpdating){
        response = thietBiBUS.update(thietBi);
        if(response.getStatus() == ResponseStatus.FAILURE){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        }
        else {
        response = thietBiBUS.add(thietBi);
        if(response.getStatus() == ResponseStatus.FAILURE){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        }
        JOptionPane.showMessageDialog(null, response.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
        closeDialog();
        renderThietBis();

    }//GEN-LAST:event_confirmBtnActionPerformed

    private void confirmBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtn1ActionPerformed
        int index = keyword.getSelectedIndex();
        String fieldName = index==0?"MaTB":index==1?"TenTB":index==2?"MoTaTB":null;
        String keyValue = searchTxt.getText();
        if(keyValue.isBlank()){
            renderThietBis();
        }
        Response<List<ThietBi>> response = thietBiBUS.getByFilter(fieldName, keyValue);
        if(response.getStatus() == ResponseStatus.FAILURE){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for(ThietBi thietBi: response.getData()){
            Object[] row = new Object[]{thietBi.getMaTB(),thietBi.getTenTB(),thietBi.getMoTaTB()};
            model.addRow(row);
        }
        table.revalidate();
        table.repaint();
        
        
    }//GEN-LAST:event_confirmBtn1ActionPerformed
    public void closeDialog(){
        userForm.setVisible(false);
        msTxt.setText("");
        nameTxt.setText("");
        khoaTxt.setText("");
        nganhTxt.setText("");
        sdtTxt.setText("");
    }
    private boolean isUpdating;
    private customDialog userForm;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.component.Button button1;
    private view.component.Button closeBtn;
    private view.component.Button confirmBtn;
    private view.component.Button confirmBtn1;
    private javax.swing.JPanel detailPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> keyword;
    private view.custom.textField khoaTxt;
    private view.custom.textField msTxt;
    private view.custom.textField nameTxt;
    private view.custom.textField nganhTxt;
    private javax.swing.JLabel renameTitle;
    private view.component.RoundPanel roundPanel1;
    private view.component.RoundPanel roundPanel2;
    private view.custom.textField sdtTxt;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}