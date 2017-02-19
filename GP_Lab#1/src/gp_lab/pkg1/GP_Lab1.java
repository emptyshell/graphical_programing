/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gp_lab.pkg1;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author valentin
 */
class fig1 extends Canvas {
    Dimension canvasSize = new Dimension(200,200);
    
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.drawRect(0, 0, 200, 200);
        g.setColor(Color.blue);
        g.drawOval(50, 50, 100, 100);
        g.setColor(Color.red);
         g.setColor(Color.green);
        g.drawRect(200,0,200,200);
        Polygon p = new Polygon();
        p.addPoint(210, 150);
        p.addPoint(310, 150);
        p.addPoint(260, 100);
        g.drawPolygon(p);
    }
    
    public Dimension getMinimumSize() {
        return canvasSize;
    }
    public Dimension getPreferredSize() {
        return canvasSize;
    }
}

class fig2 extends Canvas {
    Dimension canvasSize = new Dimension(200,200);
    
    public void paint (Graphics g) {
        
        
    }
}

class Fereastra extends JFrame {
    public Fereastra(String titlu) {
        super(titlu);
        setSize(601,601);
        add(new fig1(),BorderLayout.CENTER);
    }
}

public class GP_Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fereastra f = new Fereastra("fig 1");
        f.show();
    }
    
}
