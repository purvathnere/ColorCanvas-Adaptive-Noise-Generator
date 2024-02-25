
package com.myproject.noiseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class NoiseProject extends JFrame {

    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    public NoiseProject() {
        setTitle("Noise Project");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to display noise
        JPanel noisePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawNoise(g);
            }
        };

        add(noisePanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void drawNoise(Graphics g) {
        BufferedImage noiseImage = generateRandomNoise();
        g.drawImage(noiseImage, 0, 0, this);
    }

    private BufferedImage generateRandomNoise() {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                int rgb = generateRandomColor();
                image.setRGB(x, y, rgb);
            }
        }
        return image;
    }

    private int generateRandomColor() {
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        return new Color(red, green, blue).getRGB();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NoiseProject());
    }
}
