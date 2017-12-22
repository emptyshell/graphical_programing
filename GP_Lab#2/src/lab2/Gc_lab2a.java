package lab2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Gc_lab2a {	
	public static void main(String[] args) throws IOException {
    	 
        JFrame f = new JFrame("Lab 2 GC");
        Graphics2D g;
        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
 
        // Create a graphics which can be used to draw into the buffered image

        	g = bufferedImage.createGraphics();
        	g.setColor(new Color(255,255,255));
            g.fillRect(0, 0, 800, 800);
            //DIsplay
            f.setSize(600,600);
            f.setBackground(new Color(0,0,100));
            f.getContentPane().add(new JLabel(new ImageIcon(bufferedImage)));
            f.pack();
            f.setVisible(true);
    		
    		//Triunghi
            g.setColor(new Color (255,0,0));
    		Polygon poly = new Polygon();
    		poly.addPoint(120, 330);
    		poly.addPoint(50, 470);
    		poly.addPoint(190, 470);
    		g.drawPolygon(poly);
    		//Draw String
    		g.setColor(new Color (0,0,0));
    		Font currentFont = g.getFont();
    		Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
    		g.setFont(newFont);
    		g.drawString("Studentul Suruceanu Valentin, gr.TI-154", 150, 150);
    		g.drawString("Triunghiul netransformat", 60, 300);
    		g.drawString("Patratul de culoare rosie, transformat", 280, 300);
    	    //Dreptunghi
    		int rectX=330, rectY=350;
    		int width=120, height=120;
    		int trans_rectX = rectX+200, trans_rectY = rectY+20;
    		int sc_width = (int)(width*1.3);
    		int sc_height = (int)(height*1.3);
    		g.setColor(new Color (0,0,255));
    	    g.drawRect(rectX, rectY, width,height);
    	    g.rotate(Math.toRadians(300),(trans_rectX+sc_width/2),(trans_rectY+sc_height/2));
    	    g.setColor(new Color (255,0,0));
    	    g.drawRect(trans_rectX, trans_rectY, sc_width,sc_height);
            // Disposes of this graphics context and releases any system resources that it is using.
            g.dispose();      
    }
}