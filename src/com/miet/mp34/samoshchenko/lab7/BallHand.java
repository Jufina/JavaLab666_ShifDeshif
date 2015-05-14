package com.miet.mp34.samoshchenko.lab7;

/**
 * Created by Julia on 11.05.2015.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallHand extends Thread implements ActionListener {
    private static int heightPlayer =70;
    private static int widthPlayer =30;
    private static int botY=300, topY=0;
    private static int radius=10;
    private static int score1=0,score2=0;
    public void run()
    {
        BallHand bh=new BallHand();
        Timer timer = new Timer(10,bh);
        timer.start();
        while(!GameFrame.getGp().isIsReseting())
        {
            System.out.print("");
        }
        timer.stop();
        score1=0;
        score2=0;
    }


    public void actionPerformed(ActionEvent e) {
        int xball, yball;
        int vectx, vecty;
        int xn2,yn2,xn1,yn1;



        xn2= GameFrame.getGp().getXn2();
        xn1= GameFrame.getGp().getXn();
        yn2= GameFrame.getGp().getYn2();
        yn1= GameFrame.getGp().getYn();
        vecty= GameFrame.getGp().getVect().getY();
        vectx= GameFrame.getGp().getVect().getX();
        xball= GameFrame.getGp().getXe();
        yball= GameFrame.getGp().getYe();


        GameFrame.getGp().setXe(xball+vectx);
        GameFrame.getGp().setYe(yball+vecty);


        if((yball < topY) && (vecty < 0))
        {

            GameFrame.getGp().getVect().setY(-1 * vecty);

        }
        if((yball > botY) && (vecty > 0))
        {

            GameFrame.getGp().getVect().setY(-1 * vecty);
        }

        if (((xball+radius*2 >= xn2) && (xball+radius*2 < xn2+radius)) && ((yball+radius >= yn2) && (yball+radius <= yn2+ heightPlayer)) && (vectx>0))
        {
            GameFrame.getGp().getVect().setX(-1 * vectx);
        }

        if ((xball <= xn1+widthPlayer)&& (xball >= xn1+radius) && ((yball+radius >= yn1) && (yball+radius <= yn1+ heightPlayer)) && (vectx<0))
        {
            GameFrame.getGp().getVect().setX(-1 * vectx);
        }

        if(xball+radius*2 < 0)
        {
            score2++;
            GameFrame.getGp().setXe(GameFrame.getGp().getWidth() / 2) ;
            GameFrame.getGp().setYe(GameFrame.getGp().getHeight() / 2) ;
            GameFrame.getGp().setScore(score1,score2);
        }

        if(xball > GameFrame.getGp().getWidth())
        {
            score1++;
            GameFrame.getGp().setXe(GameFrame.getGp().getWidth() / 2) ;
            GameFrame.getGp().setYe(GameFrame.getGp().getHeight() / 2) ;
            GameFrame.getGp().setScore(score1, score2);

        }



        GameFrame.getGp().repaint();

    }
}
