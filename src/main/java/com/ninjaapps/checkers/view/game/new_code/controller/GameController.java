package com.ninjaapps.checkers.view.game.new_code.controller;

import com.ninjaapps.checkers.view.game.new_code.model.Bicia;
import com.ninjaapps.checkers.view.game.new_code.model.Board;
import com.ninjaapps.checkers.view.game.new_code.model.Moves;
import com.ninjaapps.checkers.view.game.new_code.view.BoardPanel;
import com.ninjaapps.checkers.view.game.new_code.view.ButtonsPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Author: Daniel
 */
@Controller
public class GameController {
    @Autowired
    private Board plansza;

    @Autowired
    private Moves ruchy;

    @Autowired
    private Bicia bicia;

    @Autowired
    private BoardPanel boardPanel;

    @Autowired
    private ButtonsPanel buttonsPanel;

    public void init() {
        boardPanel.addMouseListener(
                new BoardMouseAdapter());

        buttonsPanel.getNewGameBtn()
                .addActionListener(new ButtonNewGameListener());
    }

    class BoardMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            if (x >= 20 && x < 340 && y >= 40 && y < 360
                    && (x + 22) % 40 != 0 && (x + 21) % 40 != 0
                    && (y + 2) % 40 != 0 && (y + 1) % 40 != 0) {
                int _x, _y;
                _x = (x - 20) / 40;
                _y = (y - 40) / 40;
                System.out.println(_x + " " + _y);
                bicia.sprawdz_bicia(ruchy.getPlayerNumber(), plansza);
                ruchy.klikniecie(_x, _y, plansza, bicia);
                boardPanel.repaint();
                updatePlayerLbl();
            }
        }
    }

    class ButtonNewGameListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            plansza.start();
            ruchy.clearFields();
            ruchy.set_gracz(1);
            bicia.clearFields();
            boardPanel.repaint();
        }
    }

    private void updatePlayerLbl() {
        buttonsPanel.getPlayerLbl().setText("Gracz: " + ruchy.getPlayerNumber());
    }
}
