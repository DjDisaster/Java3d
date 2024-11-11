package me.djdisaster;

import me.djdisaster.matrix.CubeMatrix;
import me.djdisaster.matrix.HexPrismMatrix;
import me.djdisaster.matrix.Matrix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Main {

    public static JFrame frame;
    private static DrawPanel drawPanel;

    public static boolean showWireframe = true;
    public static boolean culling = true;

    private static ArrayList<Integer> values = new ArrayList<>();

    public static void main(String[] args) {

        frame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize);
        frame.setBackground(Color.BLACK);
        frame.setUndecorated(true);

        drawPanel = new DrawPanel(new Matrix[]{
                /*
                new CubeMatrix(-0.5,0.5,-0.5, 0.25),
                new CubeMatrix(0.5,0.5,0.5, 0.25),
                new CubeMatrix(-0.5,0.5,0.5, 0.25),
                new CubeMatrix(0.5,0.5,-0.5, 0.25),
                new CubeMatrix(-0.5,-0.5,-0.5, 0.25),
                new CubeMatrix(0.5,-0.5,0.5, 0.25),
                new CubeMatrix(-0.5,-0.5,0.5, 0.25),
                new CubeMatrix(0.5,-0.5,-0.5, 0.25),

                 */
                new HexPrismMatrix(-0.5,-0.5,-0.5, 0.75),

        });


        drawPanel.setBackground(Color.BLACK);

        frame.add(drawPanel);
        frame.setVisible(true);

        JLabel label = new JLabel();
        label.setForeground(Color.WHITE);
        label.setText("fps counter");

        drawPanel.add(label);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_F1 -> {
                        showWireframe = !showWireframe;
                    }
                    case KeyEvent.VK_F2 -> {
                        culling = !culling;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        label.setSize(1920,100);

        new Thread(() -> {
            int frames = 0;
            long lastFpsTime = System.currentTimeMillis();

            int n = 0;
            int n2 = 0;
            while (true) {
                frames++;

                if (System.currentTimeMillis() - lastFpsTime >= 1000) {
                    values.add(frames);
                    frames = 0;
                    lastFpsTime += 1000;
                }

                drawPanel.repaint();


                try {
                    Thread.sleep(1000 / 120);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                n2++;

                //label.setFont(new Font("", 0, 20 + (n2)));

                double sum = 0;
                for (double d : values) {
                    sum += d;
                }

                label.setText("Frames per Second (Average): " + (int)Math.floor(sum / values.size()) + " Checked over: " + values.size() + "s");

                if (n2 >= 50) {
                    n2 = 0;
                }





            }
        }).start();

    }




}