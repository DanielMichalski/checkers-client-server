package com.ninjaapps.checkers.server;

import com.ninjaapps.checkers.log.AutowiredLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import com.ninjaapps.checkers.view.game.old.Pawns;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class TCPServer implements Runnable {
    @AutowiredLogger
    private Logger logger;

    @Value("${tcpServer.serverPort}")
    private int serverPort;

    @Value("${tcpServer.serverSocketTimeout}")
    private int serverSocketTimeout;

    private ServerSocket ss;

    private Socket socket;

    private ObjectOutputStream oos;

    private ObjectInputStream ois;

    public void createServer(int port) {
        try {
            ss = new ServerSocket(port);
            ss.setSoTimeout(serverSocketTimeout);
            socket = ss.accept();
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            logger.error("Error while creating com.ninjaapps.checkers.server.", e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Pawns listen() {
        boolean flag = true;
        Pawns p = null;
        while (flag) {
            try {
                p = (Pawns) ois.readObject();
                flag = false;
            } catch (IOException e) {
                flag = false;
                Rozlacz();
                logger.error("Error while listening clients. ", e);
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (ClassNotFoundException e) {
                logger.error("Error while listening clients. ", e);
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
        return p;
    }

    public void send(Pawns p) {
        try {
            oos.writeObject(p);
            oos.flush();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void run() {
        try {
            ss = new ServerSocket(serverPort);
            socket = ss.accept();
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());

        } catch (IOException ex) {
            logger.error("Error ");
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void Rozlacz() {
        try {
            oos.close();
            ois.close();
            socket.close();
            ss.close();
        } catch (IOException e) {
            logger.error("Błąd przy rozłączaniu servera.", e);
        }
    }
}
