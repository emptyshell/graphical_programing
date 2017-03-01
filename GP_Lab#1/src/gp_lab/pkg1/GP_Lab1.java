/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gp_lab.pkg1;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author valentin
 */
class Fig1 extends Canvas {
    Dimension canvasSize = new Dimension(200,200);
    
    public void paint(Graphics g) {
        //delimitarea
        g.setColor(Color.green);
        g.drawLine(0, 200, 600, 200);
        g.drawLine(0, 400, 600, 400);
        g.drawLine(200, 0, 200, 600);
        g.drawLine(400, 0, 400, 600);
        //linie
        g.setColor(Color.blue);
        g.drawLine(175, 175, 25, 25);
        //triunghi
        g.setColor(Color.red);
        Polygon p = new Polygon();
        p.addPoint(225, 175);
        p.addPoint(375, 175);
        p.addPoint(300, 25);
        g.fillPolygon(p);
        //dreptunghi
        g.setColor(Color.GRAY);
        g.drawRect(450, 75, 100, 50);
        //poligon
        g.setColor(Color.MAGENTA);
        Polygon h = new Polygon();
        h.addPoint(20, 225);
        h.addPoint(40, 250);
        h.addPoint(60, 225);
        h.addPoint(80, 250);
        h.addPoint(100, 225);
        h.addPoint(120, 250);
        h.addPoint(140, 225);
        h.addPoint(160, 250);
        h.addPoint(180, 225);
        h.addPoint(180, 275);
        h.addPoint(140, 300);
        h.addPoint(60, 300);
        h.addPoint(20, 275);
        g.drawPolygon(h);
        //paralelipiped
        g.setColor(Color.ORANGE);
        g.fillRect(275, 250, 100, 50);
        g.fill3DRect(250, 275, 100, 50, true);
        Polygon romb = new Polygon();
        romb.addPoint(275, 250);
        romb.addPoint(375, 250);
        romb.addPoint(375, 300);
        romb.addPoint(350, 325);
        romb.addPoint(250, 275);
        g.fillPolygon(romb);
        g.setColor(Color.black);
        g.drawLine(275, 250, 250, 275);
        g.drawLine(375, 250, 350, 275);
        g.drawLine(375, 300, 350, 325);
        g.drawLine(275, 250, 375, 250);
        g.drawLine(375, 250, 375, 300);
        g.drawRect(250, 275, 100, 50);
        //cerc
        g.setColor(Color.PINK);
        g.drawOval(450, 250, 100, 100);
        //elipsa
        g.setColor(Color.RED);
        g.fillOval(50, 450, 100, 75);
        //segment de cerc
        g.setColor(Color.black);
        g.fillArc(250, 450, 100, 100 , 0, 90);
        //segment de elipsa
        g.setColor(Color.blue);
        g.fillArc(450, 450, 100, 50, 0, 90);
    }
    
    public void exportImage(String imageName) {
    BufferedImage image = new  BufferedImage(600, 600,BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = image.createGraphics();
        //delimitarea
        g.setColor(Color.green);
        g.drawLine(0, 200, 600, 200);
        g.drawLine(0, 400, 600, 400);
        g.drawLine(200, 0, 200, 600);
        g.drawLine(400, 0, 400, 600);
        //linie
        g.setColor(Color.blue);
        g.drawLine(175, 175, 25, 25);
        //triunghi
        g.setColor(Color.red);
        Polygon p = new Polygon();
        p.addPoint(225, 175);
        p.addPoint(375, 175);
        p.addPoint(300, 25);
        g.fillPolygon(p);
        //dreptunghi
        g.setColor(Color.GRAY);
        g.drawRect(450, 75, 100, 50);
        //poligon
        g.setColor(Color.MAGENTA);
        Polygon h = new Polygon();
        h.addPoint(20, 225);
        h.addPoint(40, 250);
        h.addPoint(60, 225);
        h.addPoint(80, 250);
        h.addPoint(100, 225);
        h.addPoint(120, 250);
        h.addPoint(140, 225);
        h.addPoint(160, 250);
        h.addPoint(180, 225);
        h.addPoint(180, 275);
        h.addPoint(140, 300);
        h.addPoint(60, 300);
        h.addPoint(20, 275);
        g.drawPolygon(h);
        //paralelipiped
        g.setColor(Color.ORANGE);
        g.fillRect(275, 250, 100, 50);
        g.fill3DRect(250, 275, 100, 50, true);
        Polygon romb = new Polygon();
        romb.addPoint(275, 250);
        romb.addPoint(375, 250);
        romb.addPoint(375, 300);
        romb.addPoint(350, 325);
        romb.addPoint(250, 275);
        g.fillPolygon(romb);
        g.setColor(Color.black);
        g.drawLine(275, 250, 250, 275);
        g.drawLine(375, 250, 350, 275);
        g.drawLine(375, 300, 350, 325);
        g.drawLine(275, 250, 375, 250);
        g.drawLine(375, 250, 375, 300);
        g.drawRect(250, 275, 100, 50);
        //cerc
        g.setColor(Color.PINK);
        g.drawOval(450, 250, 100, 100);
        //elipsa
        g.setColor(Color.RED);
        g.fillOval(50, 450, 100, 75);
        //segment de cerc
        g.setColor(Color.black);
        g.fillArc(250, 450, 100, 100 , 0, 90);
        //segment de elipsa
        g.setColor(Color.blue);
        g.fillArc(450, 450, 100, 50, 0, 90);
    paintAll(g);
    g.dispose();
    try {
        System.out.println("Exporting image: "+imageName);
        FileOutputStream out = new FileOutputStream(imageName);
        ImageIO.write(image, "png", out);
        out.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}

class Fereastra extends JFrame {
    public Fereastra(Fig1 f,String titlu) {
        super(titlu);
        setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(f,BorderLayout.CENTER);
    }
}

public class GP_Lab1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Fig1 t = new Fig1();
        Fereastra f = new Fereastra(t,"Lucrare de laborator 1");
        t.exportImage("test.png");
        f.show();
    }
    
}
