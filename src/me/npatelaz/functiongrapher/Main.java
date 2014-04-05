package me.npatelaz.functiongrapher;

import javax.swing.*;
import java.awt.*;

/**
 * Description
 * <p/>
 * Nikhil Patel
 * File created on Apr 05, 2014
 */
public class Main
{
    public static void main(String[] args)
    {
        // Set up frame (main application window)
        JFrame frame = new JFrame();
        frame.setTitle("Function Grapher");
        frame.setSize(850, 600);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Set up graph panel
        JPanel graphPanel = new JPanel();
        graphPanel.setPreferredSize(new Dimension(600, 600));
        frame.add(graphPanel, BorderLayout.WEST);

        // Set up right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(250, 600));
        frame.add(rightPanel, BorderLayout.EAST);

    }
}
