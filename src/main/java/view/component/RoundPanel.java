package view.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class RoundPanel extends JPanel {
    public enum Round {
        ALL, TOP, BOTTOM, LEFT, RIGHT
    }

    public RoundPanel() {
        setOpaque(false);
    }
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public void setRound(Round round) {
        if(round!=null)
        this.round = round;
    }

    public Round getRound() {
        return round;
    }
    
    private Round round = Round.ALL;
    private int radius=20;
    @Override
    public void paint(Graphics grphcs) {
        
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        int width = getWidth();
        int height = getHeight();
         g2.fillRoundRect(0, 0, width, height, radius, radius);
         switch(round){
             case LEFT -> g2.fillRect(radius, 0, width-radius , height);
             case RIGHT -> g2.fillRect(0, 0, getWidth() - radius, getHeight());
             case TOP -> g2.fillRect(0, radius, getWidth(), getHeight() - radius);
             case BOTTOM -> g2.fillRect(0, 0, width, height - radius);
         }
        g2.dispose();
        super.paint(grphcs);
    }
}
