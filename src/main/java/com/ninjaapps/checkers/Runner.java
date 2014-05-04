package com.ninjaapps.checkers;

import com.ninjaapps.checkers.util.ApplicationUtil;
import com.ninjaapps.checkers.view.game.view.GameFrame;
import org.springframework.context.ApplicationContext;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Runner {
    public static void main(String[] args) {
        ApplicationUtil.setSystemLookAndFeel();

        ApplicationContext context = ApplicationUtil.context;

        GameFrame gameFrame = context.getBean("gameFrame", GameFrame.class);
        gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
    }
}
