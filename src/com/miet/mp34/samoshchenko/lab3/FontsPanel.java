package com.miet.mp34.samoshchenko.lab3;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Created by Julia on 11.03.2015.
 */
public class FontsPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D bounds = g2.getClipBounds();


        // Общий голубой прямоугольник
        double x0,y0,h0,w0;
        h0=Math.min(bounds.getWidth()/4, bounds.getHeight()/2);
        w0=h0*2;
        x0=bounds.getWidth()/2-w0/2;
        y0=bounds.getHeight()/2-h0/2;
        Rectangle2D baserect=new Rectangle2D.Double(x0,y0,w0,h0);
        //g2.draw(baserect);
        Color bl=new Color(0,200,255);
        g2.setColor(bl);
        g2.fill(baserect);


        //Жёлтая Полоса по центру
        double x1,y1,h1,w1;
        h1=h0/4;
        w1=w0;
        x1=x0;
        y1=y0+(h0*3)/8;
        Rectangle2D rect=new Rectangle2D.Double(x1,y1,w1,h1);
        //g2.draw(rect);
        Color ylw=new Color(230,225,10);
        g2.setColor(ylw);
        g2.fill(rect);

        // Черный треугольник
        double xc, yc;
        xc=bounds.getWidth()/2;
        yc=bounds.getHeight()/2;

        double xt,yt,ht,wt;
        //h1=Math.min(bounds.getWidth()/4, bounds.getHeight()/2);
        GeneralPath trangle = new GeneralPath();
        trangle.moveTo(x0, y0);
        trangle.lineTo(xc, yc);
        trangle.lineTo(x0, y0+h0);
        trangle.closePath();
        g2.setPaint(Color.BLACK);
        g2.fill(trangle);

        // ТЕКСТ
        float xtext, ytext;
        xtext=(float)x0;
        ytext=(float)y0-(float)h0/10;
        int sizetext=(int)w0/10;
        Font textBO = new Font("Arial", Font.BOLD|Font.ITALIC, sizetext);
        g2.setFont(textBO);
        String message = "Багамские острова";
        g2.drawString(message, xtext, ytext);
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Mrmrmr Flag");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FontsPanel panel = new FontsPanel();
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
