package com.ninjaapps.checkers.view.game.controller;

import com.ninjaapps.checkers.log.AutowiredLogger;
import com.ninjaapps.checkers.util.ApplicationUtil;
import com.ninjaapps.checkers.view.about.view.AboutDialog;
import com.ninjaapps.checkers.view.game.model.Bicia;
import com.ninjaapps.checkers.view.game.model.Board;
import com.ninjaapps.checkers.view.game.model.Moves;
import com.ninjaapps.checkers.view.game.view.BoardPanel;
import com.ninjaapps.checkers.view.game.view.ButtonsPanel;
import com.ninjaapps.checkers.view.game.view.GameFrame;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Author: Daniel
 */
@Controller
public class GameController {
    @AutowiredLogger
    private Logger logger;

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

    @Autowired
    private GameFrame gameFrame;

    public void init() {
        boardPanel.addMouseListener(
                new BoardMouseAdapter());

        buttonsPanel.getNewGameBtn()
                .addActionListener(new NewGameBtnListener());

        gameFrame.setJMenuBar(gegJMenuBar());
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

    class NewGameBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            startNewGane();
        }
    }

    private void startNewGane() {
        plansza.start();
        ruchy.clearFields();
        ruchy.set_gracz(1);
        bicia.clearFields();
        boardPanel.repaint();
    }

    private void updatePlayerLbl() {
        buttonsPanel.getPlayerLbl().setText("Gracz: " + ruchy.getPlayerNumber());
    }

    private JMenuBar gegJMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Plik");
        JMenuItem newGameItem = createJMenuItem("Nowa gra",
                new NewGameBtnListener());
        JMenuItem closeItem = createJMenuItem("Zamknij",
                new CloseBtnListener());
        fileMenu.add(newGameItem);
        fileMenu.add(closeItem);

        JMenu serverMenu = new JMenu("Serwer");
        JMenuItem createServer = createJMenuItem("Stwórz serwer",
                new CreateServerBtnListener());
        JMenuItem connectToServer = createJMenuItem("Podłącz do serwera",
                new ConnectToServerBtnListener());
        JMenuItem disconnectFromServer = createJMenuItem("Rozłącz",
                new DisconnectServerBtnListener());
        serverMenu.add(createServer);
        serverMenu.add(connectToServer);
        serverMenu.add(disconnectFromServer);

        JMenu aboutMenu = new JMenu("Pomoc");
        JMenuItem about = createJMenuItem("O programie",
                new AboutProgramBtnListener());
        aboutMenu.add(about);

        menuBar.add(fileMenu);
        menuBar.add(serverMenu);
        menuBar.add(aboutMenu);

        return menuBar;
    }

    private JMenuItem createJMenuItem(String label, ActionListener listener) {
        JMenuItem menuItem = new JMenuItem(label);
        menuItem.addActionListener(listener);
        return menuItem;
    }

    class CloseBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class CreateServerBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            logger.info("Create server");
        }
    }

    class ConnectToServerBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            logger.info("connect");
        }
    }

    class DisconnectServerBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            logger.info("disconnect");
        }
    }

    class AboutProgramBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            AboutDialog aboutDialog = ApplicationUtil.context
                    .getBean("aboutDialog", AboutDialog.class);

            aboutDialog.setVisible(true);
        }
    }

}
