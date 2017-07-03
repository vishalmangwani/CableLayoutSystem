import java.awt.*;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;


public class A {

		public void drawMyEllipse(Graphics2D g) {
            

            

	         Ellipse2D myEllipse = new Ellipse2D.Double(10.0, 10.0, 200.0, 100.0);
	                  

	                   

	         g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                  

	             RenderingHints.VALUE_ANTIALIAS_ON);
	                  

	                   

	         g.setStroke(new BasicStroke(5));
	                  

	         g.setPaint(Color.black);
	                  

	         g.fill(myEllipse);
	                  

	         g.setPaint(Color.red);
	                  

	         g.draw(myEllipse);
	                  

	                   

	}
	                

	}


