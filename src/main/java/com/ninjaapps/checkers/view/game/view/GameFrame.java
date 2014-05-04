package com.ninjaapps.checkers.view.game.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Daniel
 */
@Component
public class GameFrame extends JFrame
{
    @Value("${game.frame.frameTitle}")
    private String frameTitle;

    @Value("${game.frame.frameWidth}")
    private int frameWidth;

    @Value("${game.frame.frameHeight}")
    private int frameHeight;

    @Autowired
    private BoardPanel boardPanel;

    @Autowired
    private ButtonsPanel buttonsPanel;

    public void init() {
        setUpFrame();
        initializeComponents();
    }

    private void setUpFrame() {
        setTitle(frameTitle);
        setSize(frameWidth,frameHeight);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initializeComponents() {
        add(boardPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
