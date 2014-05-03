package com.ninjaapps.checkers;

import com.ninjaapps.checkers.view.game.new_code.view.GameFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context_base.xml");

        GameFrame gameFrame = context.getBean("gameFrame", GameFrame.class);
        gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
    }
}
