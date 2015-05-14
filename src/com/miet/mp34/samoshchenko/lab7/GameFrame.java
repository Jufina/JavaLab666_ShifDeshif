package com.miet.mp34.samoshchenko.lab7;

import javax.swing.*;


/**
 * Created by Julia on 11.05.2015.
 */
public class GameFrame extends JFrame {

    private static GamePanel gp;
    public GameFrame(){
        super("Теннис");
        setVisible(true);
        setSize(500,350);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createGUI();
    }


    public void createGUI() {
        gp=new GamePanel();
        add(gp);
        gp.repaint();
    }

    public static GamePanel getGp()
    {
        return gp;
    }
}
