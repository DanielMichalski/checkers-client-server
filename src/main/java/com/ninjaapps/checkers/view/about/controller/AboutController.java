package com.ninjaapps.checkers.view.about.controller;

import com.ninjaapps.checkers.view.about.view.AboutDialog;
import com.ninjaapps.checkers.view.about.view.AboutPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: Daniel
 */
@Controller
public class AboutController {
    @Autowired
    private AboutPanel aboutPanel;

    @Autowired
    private AboutDialog aboutDialog;

    public void init() {
        aboutPanel.getBtnOk()
                .addActionListener(new ButtonOkListener());
    }

    class ButtonOkListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            aboutDialog.dispose();
        }
    }
}
