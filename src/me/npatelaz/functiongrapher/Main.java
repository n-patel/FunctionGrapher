package me.npatelaz.functiongrapher;

import me.npatelaz.functiongrapher.config.ConfigPanel;
import me.npatelaz.functiongrapher.graph.GraphPanel;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

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
		GraphPanel graphPanel = new GraphPanel();
		graphPanel.setPreferredSize(new Dimension(600, 600));
		frame.add(graphPanel, BorderLayout.WEST);

		// Set up right panel
		ConfigPanel configPanel = new ConfigPanel();
		configPanel.setPreferredSize(new Dimension(250, 600));
		configPanel.initializePanel();
		frame.add(configPanel, BorderLayout.EAST);

	}
}
