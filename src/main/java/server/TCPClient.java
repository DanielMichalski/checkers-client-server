package server;

import org.slf4j.Logger;
import view.game.Pawns;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient {
    private Logger logger;

    private Socket gniazdo;

    private ObjectInputStream ois;

    private ObjectOutputStream oos;

    public void connect(String address, int port) {
        try {
            gniazdo = new Socket(address, port);
            ois = new ObjectInputStream(gniazdo.getInputStream());
            oos = new ObjectOutputStream(gniazdo.getOutputStream());
        } catch (IOException e) {
            logger.error("Error while connecting to server", e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Pawns listen() {
        Pawns p = null;
        boolean flaga = true;
        while (flaga) {
            try {
                p = (Pawns) ois.readObject();
                flaga = false;
            } catch (IOException e) {
                flaga = false;
                disconnect();
                logger.error("Error while listening server", e);
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (ClassNotFoundException e) {
                logger.error("Error while listening server", e);
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
            logger.error("Error while sending information to server", ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void disconnect() {
        try {
            ois.close();
            oos.close();
            gniazdo.close();
        } catch (IOException e) {
            logger.error("Error while disconecting client", e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
