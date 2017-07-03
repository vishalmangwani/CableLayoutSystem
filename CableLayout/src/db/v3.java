package db;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
 
public class v3 extends Applet{
 
        public void paint(Graphics g)
        {
               
                setForeground(Color.red);
                g.drawOval(50,50,400,250);
                g.drawOval(110,100,70,70);
                g.drawOval(330,100,70,70);
                g.drawOval(220,190,70,70);
         }
}