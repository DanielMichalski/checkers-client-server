package com.ninjaapps.checkers.view.game.view;

import com.ninjaapps.checkers.util.ApplicationUtil;
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
    private JButton newGameBtn;

    private JLabel playerLbl;

    public void init() {
        initializeComponents();
    }

    private void initializeComponents() {
        ApplicationUtil.setSystemLookAndFeel();
        newGameBtn = new JButton(newGameBtnText);
        add(newGameBtn);

        playerLbl = new JLabel();
        add(playerLbl);
    }

    public JButton getNewGameBtn() {
        return newGameBtn;
    }

    public JLabel getPlayerLbl() {
        return playerLbl;
    }
}
