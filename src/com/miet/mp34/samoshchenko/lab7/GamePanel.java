package com.miet.mp34.samoshchenko.lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;



/**
 * Created by Julia on 11.05.2015.
 */
public class GamePanel extends JPanel {
    private int xn,yn, xn2, yn2;
    private int xe,ye;
    private static Vector vect;
    private boolean firsttime=false;
    private static JLabel score1;
    private static JLabel score2;
    private static JButton resetButton;
    private static boolean isReseting;
    public GamePanel ()
    {
        vect=new Vector(1,3);
        score1=new JLabel("0");
        score2=new JLabel("0");
        resetButton=new JButton("RESET");
        resetButton.setFocusable(false);
        isReseting=false;
        ActionListener acl=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isReseting=true;
                firsttime=false;
                score1.setText(0+"");
                score2.setText(0+"");
                Main.joinThreads();
                isReseting=false;
                Main.startThreads();
            }
        };
        resetButton.addActionListener(acl);
        add(score1);
        add(resetButton);
        add(score2);
    }

    public void firstTime(double width, double height) {
        yn=0;
        yn2=0;
        xe=(int)width/2;
        ye=(int)height/2;
        firsttime=true;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        double frW,frH;
        frW = getWidth();
        frH= getHeight();
        xn=0;
        xn2=(int)frW - 30;
        if(!firsttime) {
            firstTime(frW, frH);
        }

        g2.setColor(Color.GREEN);
        Rectangle field=new Rectangle(0,0,(int)frW,(int)frH);
        g2.draw(field);
        g2.fill(field);


        g2.setColor(Color.BLUE);
        Rectangle pl1=new Rectangle(xn,yn,30,70);
        g2.draw(pl1);
        g2.fill(pl1);

        g2.setColor(Color.RED);
        Rectangle pl2=new Rectangle(xn2,yn2,30,70);
        g2.draw(pl2);
        g2.fill(pl2);

        g2.setColor(Color.BLACK);

        Ellipse2D ball=new Ellipse2D.Double(xe,ye,20,20);
        g2.draw(ball);
        g2.fill(ball);


    }
public static Vector getVect()
{
    return vect;
}
    public int getXn() {
        return xn;
    }

    public int getYn() {
        return yn;
    }

    public int getXn2() {
        return xn2;
    }

    public int getYn2() {
        return yn2;
    }

    public void setXn(int xn) {
        this.xn = xn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }

    public void setXn2(int xn2) {
        this.xn2 = xn2;
    }

    public void setYn2(int yn2) {
        this.yn2 = yn2;
    }

    public int getXe() {
        return xe;
    }

    public void setXe(int xe) {
        this.xe = xe;
    }

    public int getYe() {
        return ye;
    }

    public void setYe(int ye) {
        this.ye = ye;
    }
    public static void setScore(int scorepl1, int scorepl2)
    {
        score1.setText(scorepl1+"");
        score2.setText(scorepl2+"");
    }

    public static boolean isIsReseting() {
        return isReseting;
    }


}
