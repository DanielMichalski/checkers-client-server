package com.bestsoft.checkers.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

/**
 * Author: Daniel
 */
public class ApplicationUtil {
    public static ApplicationContext context;
    
    static {
        context = new ClassPathXmlApplicationContext("context.xml");
    }
    
    public static void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, "Wystąpił błąd przy zmianie motywu na systemowy");
        }
    }
}
