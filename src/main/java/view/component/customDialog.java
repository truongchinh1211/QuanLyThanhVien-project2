/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component;

import java.awt.Dialog;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Bum
 */
public class customDialog extends JDialog {
        public customDialog(Frame parentFrame) {
        super(parentFrame, "Undecorated Custom Dialog", Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
    }

    public void setDialogContent(JPanel contentPanel) {
        // Xóa nội dung hiện tại (nếu có)
        getContentPane().removeAll();

        // Đặt nội dung mới từ contentPanel
        getContentPane().add(contentPanel);

        pack();
        setLocationRelativeTo(getParent());
    }
}
