import java.awt.*; 
import java.applet.*;

public class Graph extends Applet  
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font bigFont;
     Color redColor; 
     Color weirdColor; 
     Color bgColor;
     
     public void init()  
     { 
          bigFont = new Font("Arial",Font.BOLD,16);
          //redColor = Color.red;

         // weirdColor = new Color(60,60,122);

         // bgColor = Color.blue;

         //setBackground(bgColor);

     }

     public void stop() 
     { 
     }

     public void paint(Graphics g)  
     { 
    	// g.drawString("Shapes and Colors",80,20);
    	 g.drawOval(0,0,450,300);
    	 g.setFont(bigFont); 
         g.drawOval(170,30,40,40);
         g.drawString("DB",175,50);
         g.drawString("b",197,55);
         g.drawLine(80,125,50,180);
         g.drawOval(35,130,40,40);
         g.drawString("DB",40,150);
         g.drawString("a",63,153);
         g.drawLine(80,70,160,160);
         g.drawOval(315,200,40,40);
         g.drawString("DB",320,220);
         g.drawString("c",343,223);
         g.drawLine(80,70,160,160);
         g.drawOval(120,220,40,40);
         g.drawString("DB",125,240);
         g.drawString("d",148,243);
         
         //g1.setFont(bigFont); 
        //g1.drawString("Shapes and Colors",80,20);

    // g.setColor(redColor);

    //  g.drawRect(100,100,100,100);
     
   //   g.fillRect(110,110,80,80);
      
 
   //   g.setColor(weirdColor);

 
  //    g.fillArc(120,120,60,60,0,360);
     
  //    g.setColor(Color.yellow);

   //   g.drawLine(140,140,160,160);
      
  //    g.setColor(Color.black);

     }
    
}