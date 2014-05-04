package com.bestsoft.checkers.view.server_connect.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class ServerConnectDialog extends JDialog {
    @Value("${serverConnectDialog.dialogName}")
    private String dialogName;

    @Value("${serverConnectDialog.addresText}")
    private String addressText;

    @Value("${serverConnectDialog.portLblText}")
    private String portText;

    @Value("${serverConnectDialog.buttonOkText}")
    private String buttonOkText;

    @Value("${serverConnectDialog.buttonCancelText}")
    private String buttonCancelText;

    private JTextField addressTF;

    private JTextField portTF;

    private JButton btnCancel;

    private JButton btnOk;

    public void init() {
        initializeDialog();
        initComponents();
    }

    private void initializeDialog() {
        setTitle(dialogName);
        setLayout(new GridLayout(3, 2, 10, 10));
    }

    private void initComponents() {

        JLabel addresLbl = new JLabel(addressText);
        addressTF = new JTextField();
        JLabel portLbl = new JLabel(portText);
        portTF = new JTextField();
        btnCancel = new JButton(buttonCancelText);
        btnOk = new JButton(buttonOkText);

        add(addresLbl);
        add(addressTF);
        add(portLbl);
        add(portTF);
        add(btnCancel);
        add(btnOk);
    }

    public JTextField getAddressTF() {
        return addressTF;
    }

    public JTextField getPortTF() {
        return portTF;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnOk() {
        return btnOk;
    }
}
