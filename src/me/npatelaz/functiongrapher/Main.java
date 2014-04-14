package me.npatelaz.functiongrapher;

import me.npatelaz.functiongrapher.config.ConfigPanel;
import me.npatelaz.functiongrapher.graph.GraphPanel;

import javax.swing.*;
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
	// Window dimension constants
	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH  = 850;
	public static final int CONFIG_WIDTH  = 250;
	public static final int CONFIG_PADDING = 20;


	public static void main(String[] args)
	{
		// Set the Metal (crossplatform) look & feel
		try
		{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e)
		{
			e.printStackTrace();
		}

		// Set up frame (main application window)
		JFrame frame = new JFrame();
		frame.setTitle("Function Grapher");
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Set up graph panel
		GraphPanel graphPanel = new GraphPanel();
		graphPanel.setPreferredSize(new Dimension(WINDOW_WIDTH - CONFIG_WIDTH, WINDOW_HEIGHT));
		frame.add(graphPanel, BorderLayout.CENTER);

		// Set up config panel
		ConfigPanel configPanel = new ConfigPanel();
		configPanel.setPreferredSize(new Dimension(CONFIG_WIDTH, WINDOW_HEIGHT));
		configPanel.initializePanel();
		frame.add(configPanel, BorderLayout.EAST);

		frame.pack();

	}
}
