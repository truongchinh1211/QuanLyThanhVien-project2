/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class imageIcon extends JLabel{
    private Icon originalIcon;
    private int _width=20,_height=20;
 @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        _width = width;
        _height = height;
        setIcon(originalIcon);
    }
    @Override
    public void setPreferredSize(Dimension preferredSize) {
        super.setPreferredSize(preferredSize);
        _width = preferredSize.width;
        _height= preferredSize.height;
        setIcon(originalIcon);
    }
@Override
public void setIcon(Icon icon){
    if(icon!=null){
    originalIcon = icon;
    ImageIcon img = (ImageIcon) originalIcon;
    ImageIcon imageIcon = new ImageIcon(img.getImage().getScaledInstance(_width, _height, Image.SCALE_DEFAULT));
    super.setIcon(imageIcon);
    }
}


}