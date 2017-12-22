package lab3;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class main {
	
	public static double k=1;
   
    public static void draw(BufferedImage bufferedImage, JFrame f){
    	Graphics2D g;

        // Create a graphics which can be used to draw into the buffered image
        	g = bufferedImage.createGraphics();
        	g.setColor(new Color(231,231,231));
            g.fillRect(0, 0, 700, 700);
            g.setColor(new Color (0,0,0));
            //Lines
            
            g.drawLine(320,10,320,470);
    		g.drawLine(3,240,639,240);
    		g.translate(320, 0);
    		g.drawString("Lucrare de laborator Nr. 3", 105, 100);
    		g.drawString("DESENAREA GRAFICELOR UNOR FUNCTII", 55, 125);
    		g.drawString("Efectuat de: Suruceanu Valentin", 65, 155);
    		g.translate(-320, 0);
    		drawGraf(g,f,-2,2,-12,12,10,320,10,240,-3,3,0.005,1);
    		g.translate(0, 230);
    		g.setColor(new Color(231,231,231));
            g.fillRect(4, 12, 314, 220);
            g.setColor(new Color (0,0,0));
    		drawGraf(g,f,-6.28,6.28,-6,6,10,320,10,240,-5,5,0.001,2);
    		g.translate(320, 0);
    		g.setColor(new Color(231,231,231));
            g.fillRect(4, 12, 314, 220);
            g.setColor(new Color (0,0,0));
    		drawGraf(g,f,-6,6,-5,5,10,320,10,240,-6,6,0.01,3);
    		g.translate(-320, -230);
            g.drawRect(3, 10, 637, 460);
            g.translate(320, 0);
    		g.translate(-320, 0);

            // Disposes of this graphics context and releases any system resources that it is using.
            g.dispose();     	
    }
    
    public static void drawGraf(Graphics2D g,JFrame f, double xfmin, double xfmax, double yfmin, double yfmax, int xpmin, int xpmax,int ypmin,int ypmax, double a,double b,double pas,int n){
    	double Sx = 0,Sy = 0,tx = 0,ty=0,xf=0,yf=0,func = 0;
        int xp,yp;

    // calculam parametrii Sx, Sy , tx , ty
        if(n!=0){
        Sx=(xpmax-xpmin)/(xfmax-xfmin);
        Sy=(ypmax-ypmin)/(yfmax-yfmin);
        if(Sx<Sy)
            Sy=Sx;
        else
        Sx=Sy;
        tx=xpmin-Sx*xfmin+(xpmax-xpmin-Sx*(xfmax-xfmin))/2;
        ty=ypmin-Sy*yfmin+(ypmax-ypmin-Sy*(yfmax-yfmin))/2;
    }
    	switch(n){
    	case 1:{
    		g.drawString("y=ln(k*x)", 30, 200);
    		g.drawString("y", 175, 20);
    		g.drawString("0", 155, 138);
    		g.drawString("x", 295, 125);
    		g.drawLine(160, 15, 165, 10);
    		g.drawLine(165, 10, 170, 15);
    		g.drawLine(305, 120, 310, 125);
    		g.drawLine(310, 125, 305, 130);
    		break;
    	}
    	case 2:{
    		g.drawString("y=cos(k*x)", 20, 200);
    		g.drawString("y", 175, 20);
    		g.drawString("0", 155, 135);
    		g.drawString("x", 295, 137);
    		g.drawLine(160, 15, 165, 10);
    		g.drawLine(165, 10, 170, 15);
    		g.drawLine(305, 120, 310, 125);
    		g.drawLine(310, 125, 305, 130);
    		break;
    	}
    	case 3:{
    		g.drawString("y=tan(k*x)", 30, 200);
    		g.drawString("y", 175, 20);
    		g.drawString("0", 155, 135);
    		g.drawString("x", 285, 135);
    		g.drawLine(160, 15, 165, 10);
    		g.drawLine(165, 10, 170, 15);
    		g.drawLine(305, 120, 310, 125);
    		g.drawLine(310, 125, 305, 130);
    		break;
    	}
    	}
    	
    	xf=a;
        switch(n){
            case 1:{
                func=Math.log(k*xf);
                break;}
            case 2:{
                func=Math.cos(k*xf);
                break;}
            case 3:{
                func=Math.tan(k*xf);
                break;}
        	}
        
        xp=(int) (xf*Sx+tx);
        yp=(int) (ypmin+ypmax-(func*Sy+ty));
        
        xf+=pas;
        g.setColor(new Color(0,255,165));
        while(xf<b){
            xp=(int) (xf*Sx+tx);

            switch(n){
            case 1:{
                //func=2*xf*xf*xf-8*xf-5;
                func=Math.log(k*xf);
                break;}
            case 2:{
                //func=Math.tan(k*xf);
                func=Math.cos(k*xf);
                break;}
            case 3:{
                //func=3*Math.sin(k*xf);
                func=Math.tan(k*xf);
                break;}
      }
            yp=(int) (ypmin+ypmax-(func*Sy+ty));
            
            if (yp>12 && yp<240)
            g.drawRect(xp,yp,1,1);
            xf+=pas;
      }
        g.setColor(new Color(0,0,0));
        g.drawLine(xpmin+(xpmax-xpmin)/2,ypmin,xpmin+(xpmax-xpmin)/2,ypmax-8);
        g.drawLine(xpmin,ypmin+(ypmax-ypmin)/2,xpmax-12,ypmin+(ypmax-ypmin)/2);
        f.repaint();
    }

	public static void main(String[] args) throws IOException {
    	 
        JFrame f = new JFrame("Lab 3");
        BufferedImage bufferedImage = new BufferedImage(650, 480, BufferedImage.TYPE_INT_RGB);
            //DIsplay
            f.setSize(600,600);
            f.setBackground(new Color(0,0,100));
            f.getContentPane().add(new JLabel(new ImageIcon(bufferedImage)));
            f.pack();
            f.setVisible(true);
           
            //------
            draw(bufferedImage,f);
              
    }
}