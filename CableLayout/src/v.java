import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
 
public class v extends Applet{
 
        public void paint(Graphics g)
        {
               
                setForeground(Color.red);
                g.drawOval(50,50,600,300);
                g.drawOval(70,140,100,100);
                g.drawOval(530,140,100,100);
        }
}