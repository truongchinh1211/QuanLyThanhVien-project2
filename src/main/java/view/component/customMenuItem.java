/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Son
 */
public class customMenuItem extends JMenuItem {
    public customMenuItem(String text,Icon icon){
        super(text);
        ImageIcon img = (ImageIcon) icon;
        ImageIcon imageIcon = new ImageIcon(img.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)); 
        super.setIcon(imageIcon);
        setLayout(new BorderLayout()); // Sử dụng BorderLayout

        // Điều chỉnh khoảng cách giữa hình ảnh và văn bản
        setIconTextGap(10); // Thay đổi khoảng cách tùy theo nhu cầu

        // Điều chỉnh giao diện cho JMenuItem
        setBorder(BorderFactory.createEmptyBorder(6, 5, 6, 5));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(Color.GRAY); // Màu chữ khi hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(Color.BLACK); // Màu chữ bình thường
            }
        });

    }
    
}

