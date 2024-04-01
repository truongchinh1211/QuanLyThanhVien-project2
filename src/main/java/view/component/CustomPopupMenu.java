/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPopupMenu;

public class CustomPopupMenu extends JPopupMenu {
    private Color backgroundColor;

    public CustomPopupMenu() {
        super();
        super.setOpaque(false);
        init();
    }
    private void init(){
        setBackground(Color.RED);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Vẽ màu nền cho JPopupMenu
        super.paintComponent(g);
        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    // Đặt màu nền cho JPopupMenu
    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        setBackground(backgroundColor);
    }
}
