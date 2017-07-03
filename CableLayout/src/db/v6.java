package db;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
 
public class v6 extends Applet{
 
        public void paint(Graphics g)
        {
               
                setForeground(Color.red);
                g.drawOval(50,50,600,300);
                g.drawOval(140,90,70,70);
                g.drawOval(300,90,70,70);
                g.drawOval(440,90,70,70);
                g.drawOval(140,200,70,70);
                g.drawOval(300,200,70,70);
                g.drawOval(440,200,70,70);
        }
}