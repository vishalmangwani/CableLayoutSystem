package db;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
 
public class v2 extends Applet{
 
        public void paint(Graphics g)
        {
               
                setForeground(Color.red);
                g.drawOval(50,50,400,200);
                g.drawOval(70,120,50,50);
                g.drawOval(350,120,50,50);
        }
}