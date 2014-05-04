package com.ninjaapps.checkers.view.game.view;

import com.ninjaapps.checkers.util.Const;
import com.ninjaapps.checkers.view.game.model.Bicia;
import com.ninjaapps.checkers.view.game.model.Board;
import com.ninjaapps.checkers.view.game.model.Moves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Author: Daniel
 */
@Component
public class BoardPanel extends JPanel {
    @Autowired
    private Board plansza;

    @Autowired
    private Moves ruchy;

    @Autowired
    private Bicia bicia;

    @PostConstruct
    public void initia() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBoard(g);
    }

    private void drawBoard(Graphics g) {
        Image img = createImage(getSize().width,
                getSize().height);

        Graphics2D g2 = (Graphics2D) img.getGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.black);
        g2.fillRect(18, 38, 322, 322);

        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                drawBoard(g2, j, i);
                drawPawns(g2, j, i);
                drawMoves(g2, j, i);
            }
        }
        drawPlayerRectangle(g2);
        g.drawImage(img, 0, 0, this);
    }

    private void drawPlayerRectangle(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.fillRect(58, 378, 42, 42);

        g2.setColor(Const.Colors.BOARD_DARK);
        g2.fillRect(60, 380, 38, 38);

        if (ruchy.getPlayerNumber() != 0) {
            g2.setColor(Color.black);
            g2.fillOval(61, 381, 36, 36);

            if (ruchy.getPlayerNumber() == 1) {
                g2.setColor(Const.Colors.WHITE_PAWN);
            } else {
                g2.setColor(Const.Colors.BLACK_PAWN);
            }
            g2.fillOval(63, 383, 32, 32);
        }
    }

    private void drawMoves(Graphics2D g2, int j, int i) {
        if (bicia.fields[i][j] != 0) {
            g2.setColor(new Color(215, 95, 95));
            g2.drawRect(20 + 40 * i, 40 + 40 * j, 37, 37);
        }

        if (ruchy.fields[i][j] == 1) {
            g2.setColor(new Color(50, 100, 250));
            g2.drawRect(20 + 40 * i, 40 + 40 * j, 37, 37);
        }

        if (ruchy.fields[i][j] == 2 || ruchy.fields[i][j] == 3) {
            g2.setColor(new Color(150, 150, 150));
            g2.fillRect(20 + 40 * i, 40 + 40 * j, 38, 38);
        }
    }

    private void drawPawns(Graphics2D g2, int j, int i) {
        if (plansza.fields[i][j] > 1) {
            g2.setColor(Color.black);
            g2.fillOval(21 + 40 * i, 41 + 40 * j, 36, 36);

            if (plansza.fields[i][j] == 2 || plansza.fields[i][j] == 4)
                g2.setColor(Const.Colors.WHITE_PAWN);
            if (plansza.fields[i][j] == 3 || plansza.fields[i][j] == 5)
                g2.setColor(Const.Colors.BLACK_PAWN);

            g2.fillOval(23 + 40 * i, 43 + 40 * j, 32, 32);

            if (plansza.fields[i][j] == 4 || plansza.fields[i][j] == 5) {
                g2.setColor(Color.black);
                g2.fillOval(26 + 40 * i, 46 + 40 * j, 26, 26);
            }

        }
    }

    private void drawBoard(Graphics2D g2, int j, int i) {
        if (plansza.fields[i][j] == 0)
            g2.setColor(Const.Colors.BOARD_LIGHT);
        else
            g2.setColor(Const.Colors.BOARD_DARK);

        g2.fillRect(20 + 40 * i, 40 + 40 * j, 38, 38);
    }
}
