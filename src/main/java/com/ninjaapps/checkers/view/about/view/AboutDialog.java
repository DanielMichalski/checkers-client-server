package com.ninjaapps.checkers.view.about.view;

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

    @Autowired
    private AboutPanel aboutPanel;

    public void init() {
        initializeDialog();
        initComponents();
    }

    private void initializeDialog() {
        setTitle(dialogName);
        setSize(200, 200);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
       add(aboutPanel);
    }
}
