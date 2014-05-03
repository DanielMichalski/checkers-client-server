package com.ninjaapps.checkers.view.game.new_code.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * Author: Daniel
 */
@Component
public class ButtonsPanel extends JPanel {
    @Value("${game.buttonPanel.newGameBtnText}")
    private String newGameBtnText;

    @Value("${game.buttonPanel.playerLblText}")
    private String playerLblText;

    private JButton newGameBtn;

    private JLabel playerLbl;

    public void init() {
        initializeComponents();
    }

    private void initializeComponents() {
        newGameBtn = new JButton(newGameBtnText);
        add(newGameBtn);

        playerLbl = new JLabel(playerLblText);
        add(playerLbl);
    }

    public JButton getNewGameBtn() {
        return newGameBtn;
    }

    public JLabel getPlayerLbl() {
        return playerLbl;
    }
}
