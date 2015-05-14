package com.miet.mp34.samoshchenko.lab7;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Julia on 13.05.2015.
 */
public class Player1 extends Thread {
    private static int velocityPlayer = 50;
    private static int botY = 250, topY = 0;
    public KeyListener klplayer1;

    public void run() {
        try {

            klplayer1 = new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    String keyText = (e.getKeyText(e.getKeyCode()));

                    GamePanel gp = GameFrame.getGp();
                    if (keyText.equals("S")) {
                        gp.setYn(gp.getYn() + velocityPlayer);
                        if (gp.getYn() > botY) {
                            gp.setYn(botY);
                        }
                        gp.repaint();
                    }
                    if (keyText.equals("W")) {
                        gp.setYn(gp.getYn() - velocityPlayer);
                        if (gp.getYn() < topY) {
                            gp.setYn(topY);
                        }
                        gp.repaint();

                    }
                }


                @Override
                public void keyReleased(KeyEvent e) {
                }

            };
            Main.setListenerPlayer1(klplayer1);
            while(!GameFrame.getGp().isIsReseting())
            {
                System.out.print("");
            }

            Main.removeListenerPlayer1(klplayer1);

        } catch (Exception e) {
            return;
        }

    }
}
