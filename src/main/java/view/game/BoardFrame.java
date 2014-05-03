package view.game;


import log.AutowiredLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.TCPClient;
import server.TCPServer;

import javax.swing.*;
import java.awt.*;

@Component
public class BoardFrame extends JFrame {

    @AutowiredLogger
    private Logger logger;

    @Autowired
    private Board plansza;

    @Autowired
    private Pawns pionki;

    @Autowired
    private TCPServer tcpServer;

    @Autowired
    private TCPClient tcpClient;

    private boolean flaga = false;

    private boolean kolejka = true; //true - jasne, false - ciemne

    private boolean bicie = false;

    private Graphics g;

    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;

    public void init() {
        initComponents();
        plansza.printFields();
        setResizable(false);
        setSize(480, 480);
        g = jPanel1.getGraphics();
    }

    @Override
    public void paint(Graphics gp) {
        super.paint(gp);
        //Graphics g = jPanel1.getGraphics();
        NarysujPlansze(g);
        NarysujPionki(g);
    }

    public void NarysujPlansze(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(30, 70, 322, 322);
        g.setColor(Color.WHITE);
        for (int i = 0; i < plansza.getFields().length; i++) {
            for (int j = 0; j < plansza.getFields().length; j++) {
                if (plansza.getFields()[i][j] == 0) {
                    g.fillRect(31 + 40 * i, 71 + 40 * j, 40, 40);

                }

            }

        }
    }

    public void NarysujPionki(Graphics g) {
        for (int i = 0; i < pionki.rozstawienie.length; i++) {
            for (int j = 0; j < pionki.rozstawienie.length; j++) {
                if (pionki.rozstawienie[i][j] == 1) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(33 + 40 * i, 73 + 40 * j, 35, 35);

                } else if (pionki.rozstawienie[i][j] == 2) {
                    g.setColor(Color.RED);
                    g.fillOval(33 + 40 * i, 73 + 40 * j, 35, 35);
                } else if (pionki.rozstawienie[i][j] == 3) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(33 + 40 * i, 73 + 40 * j, 35, 35);
                    g.setColor(Color.BLACK);
                    g.drawLine(40 + 40 * i, 80 + 40 * j, 60 + 40 * i, 100 + 40 * j);
                    g.drawLine(60 + 40 * i, 80 + 40 * j, 40 + 40 * i, 100 + 40 * j);
                } else if (pionki.rozstawienie[i][j] == 4) {
                    g.setColor(Color.RED);
                    g.fillOval(33 + 40 * i, 73 + 40 * j, 35, 35);
                    g.setColor(Color.BLACK);
                    g.drawLine(40 + 40 * i, 80 + 40 * j, 60 + 40 * i, 100 + 40 * j);
                    g.drawLine(60 + 40 * i, 80 + 40 * j, 40 + 40 * i, 100 + 40 * j);
                }
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu jMenu1 = new JMenu();
        JMenuItem nowaGra = new JMenuItem();
        JMenu menu = new JMenu();
        JMenuItem stworzSerwer = new JMenuItem();
        JMenuItem podlaczDoSerwera = new JMenuItem();
        JMenuItem rozlacz = new JMenuItem();
        JMenu jMenu2 = new JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Warcaby - Trzaskowski - Gontarczyk");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(617, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(473, Short.MAX_VALUE))
        );

        jMenu1.setText("Gra");

        nowaGra.setText("Nowa gra");
        nowaGra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NowaGraActionPerformed(evt);
            }
        });
        jMenu1.add(nowaGra);

        jMenuBar1.add(jMenu1);

        menu.setText("Serwer");

        stworzSerwer.setText("Stwórz serwer");
        stworzSerwer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stworzSerwerActionPerformed(evt);
            }
        });
        menu.add(stworzSerwer);

        podlaczDoSerwera.setText("Podłącz do serwera");
        podlaczDoSerwera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                podlaczDoSerweraActionPerformed(evt);
            }
        });
        menu.add(podlaczDoSerwera);

        rozlacz.setText("Rozłącz");
        rozlacz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RozlaczActionPerformed(evt);
            }
        });
        menu.add(rozlacz);

        jMenuBar1.add(menu);

        jMenu2.setText("Ustawienia");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Warcaby - Trzaskowski - Gontarczyk");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked


    }//GEN-LAST:event_formMouseClicked

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        System.out.println(evt.getX() + " " + evt.getY());
        //Graphics g = this.getGraphics();
        //Graphics g = jPanel1.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        int x = (evt.getX() - 31) / 40;
        int y = (evt.getY() - 121) / 40;
        System.out.println("x=" + x + " y=" + y);
        //gracz jasny
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            System.out.print("Flaga: " + flaga + " Kolejka: " + pionki.kolejka + " rozstawienie: " + pionki.rozstawienie[x][y] + " SprawdzBicia " + pionki.SprawdzBicia(pionki.kolejka) + " MozliweBicia ");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(pionki.mozliweBicia[j][i]);

                }
                System.out.print("\n");

            }
            if (pionki.kolejka == true) {
                //wybór pionka do ruchu
                if (pionki.SprawdzBicia(pionki.kolejka) && flaga == false) {
                    if (pionki.Bicie(x, y, pionki.kolejka)) {
                        flaga = true;
                        g.fillRect(31 + 40 * (x), 71 + 40 * y, 40, 40);
                        NarysujPionki(g);
                        pionki.poprzedniKolor = pionki.rozstawienie[x][y];
                        pionki.poprzedniX = x;
                        pionki.poprzedniY = y;
                        bicie = true;
                    }

                } else if ((pionki.rozstawienie[x][y] == 1 || pionki.rozstawienie[x][y] == 3) && flaga == false) {
                    flaga = true;
                    g.fillRect(31 + 40 * (x), 71 + 40 * y, 40, 40);
                    NarysujPionki(g);
                    pionki.poprzedniKolor = pionki.rozstawienie[x][y];
                    pionki.poprzedniX = x;
                    pionki.poprzedniY = y;
                }
                //ruch wybranego pionka
                else if (flaga == true) {
                    if (bicie) {
                        if (pionki.mozliweBicia[x][y] == 1) {
                            pionki.Zbij(x, y, pionki.kolejka);
                            NarysujPlansze(g);
                            NarysujPionki(g);
                            bicie = false;
                            flaga = false;
                            if (pionki.SprawdzBicia(pionki.kolejka) && pionki.Bicie(x, y, pionki.kolejka)) {

                                bicie = false;
                                flaga = false;

                            } else {
                                pionki.kolejka = !pionki.kolejka;
                                bicie = false;
                                flaga = false;
                                if (tcpServer != null) {
                                    tcpServer.send(pionki);
                                    jLabel1.setText("Oczekiwanie na ruch przeciwnika!");
                                    SwingUtilities.invokeLater(
                                            new Runnable() {
                                                public void run() {
                                                    NarysujPlansze(g);
                                                    NarysujPionki(g);
                                                    pionki = tcpServer.listen();
                                                    jLabel1.setText("Twój ruch!");
                                                    NarysujPlansze(g);
                                                    NarysujPionki(g);
                                                }
                                            }
                                    );

                                } else if (tcpClient != null) {
                                    tcpClient.send(pionki);
                                    jLabel1.setText("Oczekiwanie na ruch przeciwnika!");
                                    SwingUtilities.invokeLater(
                                            new Runnable() {
                                                public void run() {
                                                    pionki = tcpClient.listen();
                                                    jLabel1.setText("Twój ruch!");
                                                    NarysujPlansze(g);
                                                    NarysujPionki(g);
                                                }
                                            }
                                    );

                                }
                            }

                        }
                    } else if (pionki.SprawdzRuch(x, y, pionki.kolejka)) {
                        pionki.Ruch(x, y, pionki.kolejka);
                        NarysujPlansze(g);
                        NarysujPionki(g);
                        flaga = false;
                        pionki.kolejka = !pionki.kolejka;
                        if (tcpServer != null) {
                            tcpServer.send(pionki);
                            jLabel1.setText("Oczekiwanie na ruch przeciwnika!");
                            SwingUtilities.invokeLater(
                                    new Runnable() {
                                        public void run() {
                                            pionki = tcpServer.listen();
                                            jLabel1.setText("Twój ruch!");
                                            NarysujPlansze(g);
                                            NarysujPionki(g);
                                        }
                                    }
                            );
                        } else if (tcpClient != null) {
                            tcpClient.send(pionki);
                            jLabel1.setText("Oczekiwanie na ruch przeciwnika!");
                            SwingUtilities.invokeLater(
                                    new Runnable() {
                                        public void run() {
                                            pionki = tcpClient.listen();
                                            jLabel1.setText("Twój ruch!");
                                            NarysujPlansze(g);
                                            NarysujPionki(g);
                                        }
                                    }
                            );
                        }

                    } else if (pionki.rozstawienie[x][y] == 1 || pionki.rozstawienie[x][y] == 3) {
                        NarysujPlansze(g);
                        g.setColor(Color.LIGHT_GRAY);
                        g.fillRect(31 + 40 * (x), 71 + 40 * y, 40, 40);
                        NarysujPionki(g);
                        pionki.poprzedniKolor = pionki.rozstawienie[x][y];
                        pionki.poprzedniX = x;
                        pionki.poprzedniY = y;

                    }
                }
            }
            //gracz ciemny
            if (pionki.kolejka == false) {
                //wybór pionka do ruchu
                if (pionki.SprawdzBicia(pionki.kolejka) && flaga == false) {
                    if (pionki.Bicie(x, y, pionki.kolejka)) {

                        flaga = true;
                        g.fillRect(31 + 40 * (x), 71 + 40 * y, 40, 40);
                        NarysujPionki(g);
                        pionki.poprzedniKolor = pionki.rozstawienie[x][y];
                        pionki.poprzedniX = x;
                        pionki.poprzedniY = y;
                        bicie = true;
                    }
                } else if ((pionki.rozstawienie[x][y] == 2 || pionki.rozstawienie[x][y] == 4) && flaga == false) {
                    flaga = true;
                    g.fillRect(31 + 40 * (x), 71 + 40 * y, 40, 40);
                    NarysujPionki(g);
                    pionki.poprzedniKolor = pionki.rozstawienie[x][y];
                    pionki.poprzedniX = x;
                    pionki.poprzedniY = y;
                }
                //ruch pionka
                else if (flaga == true) {
                    if (bicie) {
                        System.out.print("\nciemny  moz " + pionki.mozliweBicia[x][y]);
                        //System.out.print("bij!");
                        if (pionki.mozliweBicia[x][y] == 2) {
                            pionki.Zbij(x, y, pionki.kolejka);
                            NarysujPlansze(g);
                            NarysujPionki(g);
                            if (pionki.SprawdzBicia(pionki.kolejka) && pionki.Bicie(x, y, pionki.kolejka)) {

                                bicie = false;
                                flaga = false;

                            } else {
                                pionki.kolejka = !pionki.kolejka;
                                bicie = false;
                                flaga = false;
                                if (tcpServer != null) {
                                    tcpServer.send(pionki);
                                    jLabel1.setText("Oczekiwanie na ruch przeciwnika!");
                                    SwingUtilities.invokeLater(
                                            new Runnable() {
                                                public void run() {
                                                    pionki = tcpServer.listen();
                                                    jLabel1.setText("Twój ruch!");
                                                    NarysujPlansze(g);
                                                    NarysujPionki(g);
                                                }
                                            }
                                    );
                                } else if (tcpClient != null) {
                                    tcpClient.send(pionki);
                                    jLabel1.setText("Oczekiwanie na ruch przeciwnika!");
                                    SwingUtilities.invokeLater(
                                            new Runnable() {
                                                public void run() {
                                                    pionki = tcpClient.listen();
                                                    jLabel1.setText("Twój ruch!");
                                                    NarysujPlansze(g);
                                                    NarysujPionki(g);
                                                }
                                            }
                                    );
                                }
                            }

                        }
                    } else if (pionki.SprawdzRuch(x, y, pionki.kolejka)) {
                        pionki.Ruch(x, y, pionki.kolejka);
                        NarysujPlansze(g);
                        NarysujPionki(g);
                        flaga = false;
                        pionki.kolejka = !pionki.kolejka;
                        if (tcpServer != null) {
                            tcpServer.send(pionki);
                            jLabel1.setText("Oczekiwanie na ruch przeciwnika!");
                            //NarysujPlansze(g);
                            //NarysujPionki(g);
                            SwingUtilities.invokeLater(
                                    new Runnable() {
                                        public void run() {
                                            pionki = tcpServer.listen();
                                            jLabel1.setText("Twój ruch!");
                                            NarysujPlansze(g);
                                            NarysujPionki(g);
                                        }
                                    }
                            );
                        } else if (tcpClient != null) {
                            tcpClient.send(pionki);
                            jLabel1.setText("Oczekiwanie na ruch przeciwnika!");
                            SwingUtilities.invokeLater(
                                    new Runnable() {
                                        public void run() {
                                            pionki = tcpClient.listen();
                                            jLabel1.setText("Twój ruch!");
                                            NarysujPlansze(g);
                                            NarysujPionki(g);
                                        }
                                    }
                            );
                        }
                    } else if (pionki.rozstawienie[x][y] == 2 || pionki.rozstawienie[x][y] == 4) {
                        NarysujPlansze(g);
                        g.setColor(Color.LIGHT_GRAY);
                        g.fillRect(31 + 40 * (x), 71 + 40 * y, 40, 40);
                        NarysujPionki(g);
                        pionki.poprzedniKolor = pionki.rozstawienie[x][y];
                        pionki.poprzedniX = x;
                        pionki.poprzedniY = y;

                    }
                }
            }
        }

    }//GEN-LAST:event_formMouseReleased

    private void stworzSerwerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stworzSerwerActionPerformed
        //NowaGra();
        jLabel1.setText("Oczekiwanie na gracza...");
        //JOptionPane.showMessageDialog(null, "hahah");

        //Thread t = new Thread(new OczekiwanieDialog());
        //t.start();
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        tcpServer.createServer(2000);
                        jLabel1.setText("Twój ruch!");

                    }
                }
        );
    }//GEN-LAST:event_stworzSerwerActionPerformed

    private void podlaczDoSerweraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_podlaczDoSerweraActionPerformed

//        ServerConnectDialog dialog = new ServerConnectDialog(this, true);
//        dialog.setVisible(true);
//        if(dialog.isCzyPodano())
//        {
//            tcpClient = new TCPClient(dialog.getAdres(), dialog.getPort());
//            jLabel1.setText("Oczekiwanie na ruch przeciwnika!");
//            SwingUtilities.invokeLater(
//                new Runnable() {
//                public void run() {
//                    pionki = tcpClient.listen();
//                    jLabel1.setText("Twój ruch!");
//                    NarysujPlansze(g);
//                    NarysujPionki(g);
//                }
//                }
//                );
//        }

    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void RozlaczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RozlaczActionPerformed
        if (tcpServer != null) {
            tcpServer.Rozlacz();
            tcpServer = null;
        } else if (tcpClient != null) {
        }
    }//GEN-LAST:event_RozlaczActionPerformed

    private void NowaGra() {
        pionki.UstawPionki();
        kolejka = true;
        NarysujPlansze(g);
        NarysujPionki(g);
    }

    private void NowaGraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NowaGraActionPerformed
        NowaGra();
    }
}
