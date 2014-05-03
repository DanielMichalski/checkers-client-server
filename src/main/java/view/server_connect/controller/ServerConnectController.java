package view.server_connect.controller;

import log.AutowiredLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import view.server_connect.view.ServerConnectDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: Daniel
 */
@Component
public class ServerConnectController {

    @AutowiredLogger
    private Logger logger;

    @Autowired
    private ServerConnectDialog dialog;

    public void init() {
        dialog.getBtnOk().addActionListener(new ButtonOkActionListener());
        dialog.getBtnCancel().addActionListener(new ButtonCancelActionListener());
    }

    private class ButtonOkActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isFormFilled()) {
                try {
                    String address = dialog.getAddressTF().getText();
                    int port = Integer.parseInt(dialog.getPortTF().getText());
                    logger.debug(address + " " + port);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Podano złe wartości. Adres musi być adresem IPv4," +
                            " natomiast port liczbą całkowitą");
                }
            }
        }
    }

    private class ButtonCancelActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dialog.setVisible(false);
        }
    }

    private boolean isFormFilled() {
        return !dialog.getAddressTF().getText().isEmpty() &&
                !dialog.getPortTF().getText().isEmpty();
    }

}
