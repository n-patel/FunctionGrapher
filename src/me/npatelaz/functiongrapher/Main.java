package me.npatelaz.functiongrapher;

import me.npatelaz.functiongrapher.config.ConfigPanel;
import me.npatelaz.functiongrapher.graph.GraphPanel;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * An application which graphs function. TODO: insert continued description here
 *
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
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Set up graph panel
		GraphPanel graphPanel = new GraphPanel();
		graphPanel.setPreferredSize(new Dimension(600, 600));
		frame.add(graphPanel, BorderLayout.CENTER);

		// Set up config panel
		ConfigPanel configPanel = new ConfigPanel();
		configPanel.setPreferredSize(new Dimension(250, 600));
		configPanel.initializePanel();
		frame.add(configPanel, BorderLayout.EAST);

		frame.pack();

	}
}
