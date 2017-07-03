package db;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
 
public class v5 extends Applet{
 
        public void paint(Graphics g)
        {
               
                setForeground(Color.red);
                g.drawOval(50,50,500,250);
                g.drawOval(140,90,70,70);
                g.drawOval(370,90,70,70);
                g.drawOval(140,200,70,70);
                g.drawOval(370,200,70,70);
                g.drawOval(250,150,70,70);
        }
}