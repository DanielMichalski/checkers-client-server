package com.bestsoft.checkers.view.about.view;

import com.bestsoft.checkers.util.ApplicationUtil;
import com.bestsoft.checkers.util.Const;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * Author: Daniel
 */
@Component
public class AboutPanel extends JPanel {
    @Value("${aboutDialog.labelText}")
    private String labelText;

    @Value("${aboutDialog.buttonOkText}")
    private String buttonOkText;

    private JButton btnOk;

    public void init() {
        setupPanel();
        initializeComponents();
    }

    private void setupPanel() {
        ApplicationUtil.setSystemLookAndFeel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void initializeComponents() {
        JTextArea aboutTA = createAboutTextArea();
        add(aboutTA);

        btnOk = new JButton(buttonOkText);
        add(btnOk);
    }

    private JTextArea createAboutTextArea() {
        JTextArea aboutTA = new JTextArea(labelText);
        aboutTA.setLineWrap(true);
        aboutTA.setWrapStyleWord(true);
        aboutTA.setEditable(false);
        aboutTA.setFont(Const.Fonts.TEXT_AREA_FONT);
        return aboutTA;
    }

    public JButton getBtnOk() {
        return btnOk;
    }
}
