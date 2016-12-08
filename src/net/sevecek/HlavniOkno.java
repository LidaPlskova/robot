package net.sevecek;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import net.sevecek.util.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labRobot;
    JLabel labZed1;
    JLabel labZed2;
    JLabel labZed3;
    JLabel labZed4;
    JKeyboard klavesnice;
    JLabel labZed5;
    JLabel labZed6;
    JLabel labZed7;
    JLabel labZed8;
    JLabel labZed9;
    JLabel labZed10;
    JLabel labZed11;
    JLabel labZed12;
    JLabel labZed13;
    JLabel labZed14;
    JLabel labZed15;
    JLabel labZed16;
    JLabel labZed17;
    JLabel labZed18;
    JTimer casovac;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    //JLabel labZed5;
    ArrayList<JLabel> seznamZdi;

    public HlavniOkno() {
        initComponents();
    }

    private void priOtevreniOkna(WindowEvent e) {
    //    labZed5 = new JLabel();
    //    labZed5.setLocation(10, 20);
    //    labZed5.setSize(100, 30);
    //    labZed5.setBackground(new Color(255, 0, 0));
    //    labZed5.setOpaque(true);
    //    contentPane.add(labZed5);
    //    contentPane.repaint();

        seznamZdi = new ArrayList<>();
        seznamZdi.add(labZed1);
        seznamZdi.add(labZed2);
        seznamZdi.add(labZed3);
        seznamZdi.add(labZed4);
        seznamZdi.add(labZed5);
        seznamZdi.add(labZed6);
        seznamZdi.add(labZed7);
        seznamZdi.add(labZed8);
        seznamZdi.add(labZed9);
        seznamZdi.add(labZed10);
        seznamZdi.add(labZed11);
        seznamZdi.add(labZed12);
        seznamZdi.add(labZed13);
        seznamZdi.add(labZed14);
        seznamZdi.add(labZed15);
        seznamZdi.add(labZed16);
        seznamZdi.add(labZed17);
        seznamZdi.add(labZed18);


        casovac.start();

    }

    private void priTiknutiCasovace(ActionEvent e) {
        Point puvodniPolohaRobota = labRobot.getLocation();
        pohybujRobotem();
        for (Integer cisloPrvku = 0; cisloPrvku < seznamZdi.size(); cisloPrvku = cisloPrvku + 1) {
            JLabel jednaZed = seznamZdi.get(cisloPrvku);
            if (detekujKolizi(labRobot, jednaZed)) {
                labRobot.setLocation(puvodniPolohaRobota);
            }
        }
    }

    private void priZavreniOkna(WindowEvent e) {
        casovac.stop();
    }

    private void pohybujRobotem() {
        Point poziceRobot;
        Integer robotSirka = labRobot.getWidth();

        Integer robotVyska = labRobot.getHeight();

        poziceRobot = labRobot.getLocation();

        Integer xRobot = poziceRobot.x;
        Integer yRobot = poziceRobot.y;
        if (klavesnice.isKeyDown(KeyEvent.VK_UP)) {
            if (yRobot > 0) {
                yRobot = yRobot - 10;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_DOWN)) {
            if (yRobot + robotVyska < contentPane.getHeight()) {
                yRobot = yRobot + 10;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_LEFT)) {
            if (xRobot > 0) {
                xRobot = xRobot - 10;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_RIGHT)) {
            if (xRobot + robotSirka < contentPane.getWidth()) {
                xRobot = xRobot + 10;
            }
        }
        poziceRobot.x = xRobot;
        poziceRobot.y = yRobot;
        labRobot.setLocation(poziceRobot);

    }

    private boolean detekujKolizi(JLabel label1, JLabel label2) {
        Integer ax = label1.getX();
        Integer ay = label1.getY();
        Integer bx = ax + label1.getWidth();
        Integer by = ay + label1.getHeight();

        Integer cx = label2.getX();
        Integer cy = label2.getY();
        Integer dx = cx + label2.getWidth();
        Integer dy = cy + label2.getHeight();

        if ((bx >= cx) && (ax <= dx) && (by >= cy) && (ay <= dy)) {
            return true;
        } else {
            return false;
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labRobot = new JLabel();
        labZed1 = new JLabel();
        labZed2 = new JLabel();
        labZed3 = new JLabel();
        labZed4 = new JLabel();
        klavesnice = new JKeyboard();
        labZed5 = new JLabel();
        labZed6 = new JLabel();
        labZed7 = new JLabel();
        labZed8 = new JLabel();
        labZed9 = new JLabel();
        labZed10 = new JLabel();
        labZed11 = new JLabel();
        labZed12 = new JLabel();
        labZed13 = new JLabel();
        labZed14 = new JLabel();
        labZed15 = new JLabel();
        labZed16 = new JLabel();
        labZed17 = new JLabel();
        labZed18 = new JLabel();
        casovac = new JTimer();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Robot");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                priZavreniOkna(e);
            }
            @Override
            public void windowOpened(WindowEvent e) {
                priOtevreniOkna(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());

        //---- labRobot ----
        labRobot.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/r2d2.png")));
        contentPane.add(labRobot);
        labRobot.setBounds(new Rectangle(new Point(20, 15), labRobot.getPreferredSize()));

        //---- labZed1 ----
        labZed1.setBackground(Color.red);
        labZed1.setOpaque(true);
        contentPane.add(labZed1);
        labZed1.setBounds(280, 25, 240, 70);

        //---- labZed2 ----
        labZed2.setBackground(Color.red);
        labZed2.setOpaque(true);
        contentPane.add(labZed2);
        labZed2.setBounds(520, 25, 80, 215);

        //---- labZed3 ----
        labZed3.setBackground(Color.red);
        labZed3.setOpaque(true);
        contentPane.add(labZed3);
        labZed3.setBounds(345, 260, 70, 70);

        //---- labZed4 ----
        labZed4.setBackground(Color.red);
        labZed4.setOpaque(true);
        contentPane.add(labZed4);
        labZed4.setBounds(0, 545, 170, 65);
        contentPane.add(klavesnice);
        klavesnice.setBounds(new Rectangle(new Point(5, 10), klavesnice.getPreferredSize()));

        //---- labZed5 ----
        labZed5.setBackground(Color.red);
        labZed5.setOpaque(true);
        contentPane.add(labZed5);
        labZed5.setBounds(680, 315, 135, 25);

        //---- labZed6 ----
        labZed6.setBackground(Color.red);
        labZed6.setOpaque(true);
        contentPane.add(labZed6);
        labZed6.setBounds(210, 25, 70, 70);

        //---- labZed7 ----
        labZed7.setBackground(Color.red);
        labZed7.setOpaque(true);
        contentPane.add(labZed7);
        labZed7.setBounds(415, 330, 70, 70);

        //---- labZed8 ----
        labZed8.setBackground(Color.red);
        labZed8.setOpaque(true);
        contentPane.add(labZed8);
        labZed8.setBounds(265, 415, 60, 70);

        //---- labZed9 ----
        labZed9.setBackground(Color.red);
        labZed9.setOpaque(true);
        contentPane.add(labZed9);
        labZed9.setBounds(910, 5, 100, 70);

        //---- labZed10 ----
        labZed10.setBackground(Color.red);
        labZed10.setOpaque(true);
        contentPane.add(labZed10);
        labZed10.setBounds(315, 485, 190, 50);

        //---- labZed11 ----
        labZed11.setBackground(Color.red);
        labZed11.setOpaque(true);
        contentPane.add(labZed11);
        labZed11.setBounds(600, 25, 190, 65);

        //---- labZed12 ----
        labZed12.setBackground(Color.red);
        labZed12.setOpaque(true);
        contentPane.add(labZed12);
        labZed12.setBounds(485, 425, 190, 65);

        //---- labZed13 ----
        labZed13.setBackground(Color.red);
        labZed13.setOpaque(true);
        contentPane.add(labZed13);
        labZed13.setBounds(225, 195, 190, 65);

        //---- labZed14 ----
        labZed14.setBackground(Color.red);
        labZed14.setOpaque(true);
        contentPane.add(labZed14);
        labZed14.setBounds(600, 175, 80, 165);

        //---- labZed15 ----
        labZed15.setBackground(Color.red);
        labZed15.setOpaque(true);
        contentPane.add(labZed15);
        labZed15.setBounds(815, 185, 80, 200);

        //---- labZed16 ----
        labZed16.setBackground(Color.red);
        labZed16.setOpaque(true);
        contentPane.add(labZed16);
        labZed16.setBounds(805, 475, 80, 145);

        //---- labZed17 ----
        labZed17.setBackground(Color.red);
        labZed17.setOpaque(true);
        contentPane.add(labZed17);
        labZed17.setBounds(95, 170, 30, 270);

        //---- labZed18 ----
        labZed18.setBackground(Color.red);
        labZed18.setOpaque(true);
        contentPane.add(labZed18);
        labZed18.setBounds(0, 100, 80, 70);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(1015, 635);
        setLocationRelativeTo(null);

        //---- casovac ----
        casovac.setDelay(50);
        casovac.setInitialDelay(50);
        casovac.addActionListener(e -> priTiknutiCasovace(e));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
