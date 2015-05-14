package com.miet.mp34.samoshchenko.lab7;
import java.awt.event.KeyListener;

/**
 * Created by Julia on 11.05.2015.
 */
public class Main {
    private static GameFrame jt;
    private static Player1 pl1;
    private static Player2 pl2;
    private static BallHand ballhand;



    public static void main(String args[])
    {
        jt=new GameFrame();
        ballhand=new BallHand();

        startThreads();

    }
public static void startThreads()
{
    pl1=new Player1();
    pl2=new Player2();
    ballhand=new BallHand();
    pl1.start();
    pl2.start();
    ballhand.start();
}
    public static void joinThreads()
    {

        try {
            pl1.join();
            pl2.join();
            ballhand.join();

        }
        catch(InterruptedException e)
        {
            return;
        }
    }



    public static void setListenerPlayer1(KeyListener kl)
    {
        jt.addKeyListener(kl);
    }
    public static void removeListenerPlayer1(KeyListener kl)
    {
        jt.removeKeyListener(kl);
    }
    public static void removeListenerPlayer2(KeyListener kl)
    {
        jt.removeKeyListener(kl);
    }
    public static void setListenerPlayer2(KeyListener kl)
    {
        jt.addKeyListener(kl);
    }



}
