package com.bestsoft.checkers.view.about.view;

import com.bestsoft.checkers.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * Author: Daniel
 */
@Component
public class AboutDialog extends JDialog {
    @Value("${aboutDialog.dialogName}")
    private String dialogName;

    @Value("${about.frame.frameWidth}")
    private int frameWidth;

    @Value("${about.frame.frameHeight}")
    private int frameHeight;

    @Autowired
    private AboutPanel aboutPanel;

    public void init() {
        initializeDialog();
        initComponents();
    }

    private void initializeDialog() {
        ApplicationUtil.setSystemLookAndFeel();
        setTitle(dialogName);
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
       add(aboutPanel);
    }
}
