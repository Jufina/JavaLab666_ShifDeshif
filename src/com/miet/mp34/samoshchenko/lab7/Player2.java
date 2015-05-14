package com.miet.mp34.samoshchenko.lab7;

/**
 * Created by Julia on 13.05.2015.
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created by Julia on 13.05.2015.
 */
public class Player2 extends Thread {
    private static int velocityPlayer = 50;
    private static int botY = 250, topY = 0;
    public KeyListener klplayer2;

    public void run() {
        try {

            klplayer2 = new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    String keyText = (e.getKeyText(e.getKeyCode()));
                    //System.out.println(keyText);
                    GamePanel gp = GameFrame.getGp();
                    if (keyText.equals("Down")) {
                        gp.setYn2(gp.getYn2() + velocityPlayer);
                        if(gp.getYn2() > botY) {
                            gp.setYn2(botY);
                        }
                        gp.repaint();
                    }
                    if (keyText.equals("Up")) {
                        gp.setYn2(gp.getYn2() - velocityPlayer);
                        if(gp.getYn2() < topY) {
                            gp.setYn2(topY);
                        }
                        gp.repaint();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }

            };
            Main.setListenerPlayer2(klplayer2);
            while(!GameFrame.getGp().isIsReseting())
            {
                System.out.print("");
            }

            Main.removeListenerPlayer2(klplayer2);

        } catch (Exception e) {
            return;
        }

    }
}

