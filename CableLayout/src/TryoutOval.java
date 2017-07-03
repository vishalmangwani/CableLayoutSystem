import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class TryoutOval 
{
	public static void main(String[] args) 
	{
        new TryoutOval();
    }
    public TryoutOval() 
    {
        EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                try 
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } 
                catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
                {
                	ex.printStackTrace();
                }
                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TryoutPanel(Color.RED));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    public class TryoutPanel extends JPanel 
    {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Color myColor;
        public TryoutPanel(Color c) 
        {
            myColor = c;
        }
        @Override
        public Dimension getPreferredSize() 
        {
            return new Dimension(400, 400);
        }
        @Override
        protected void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            int centerX = 280;
            int centerY = 300;
            int radius = 50;
            int diameter = radius * 2;
            int x = centerX - radius;
            int y = centerY - radius;
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x + radius, y + radius);
            g.drawLine(x + radius, y, x, y + radius);
            g.setColor(myColor);
            g.drawOval(x, y, diameter, diameter);
            g.fillOval(centerX - 5, centerY - 5, 10, 10);
        }
    }
}