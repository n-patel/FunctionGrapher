package me.npatelaz.functiongrapher;

import me.npatelaz.functiongrapher.config.ConfigPanel;
import me.npatelaz.functiongrapher.graph.GraphPanel;
import me.npatelaz.functiongrapher.util.FileIO;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

import static me.npatelaz.functiongrapher.util.WindowDimensionConstants.*;

/**
 * Main controlled class for an application which graphs function.
 *
 * Nikhil Patel
 * File created on Apr 05, 2014
 */
public class Main
{
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
		JFrame frame = new JFrame("Function Grapher");
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Set up graph panel
		GraphPanel graphPanel = GraphPanel.getInstance();
		graphPanel.setPreferredSize(new Dimension(WINDOW_WIDTH - CONFIG_WIDTH, WINDOW_HEIGHT));
		frame.add(graphPanel, BorderLayout.CENTER);

		// Set up config panel
		ConfigPanel configPanel = ConfigPanel.getInstance();
		configPanel.initializePanel();
		configPanel.setPreferredSize(new Dimension(CONFIG_WIDTH, WINDOW_HEIGHT));
		frame.add(configPanel, BorderLayout.EAST);

		// Fill config panel with default values
		FileIO fileIO = new FileIO();
		fileIO.loadDefaultProperties();

		frame.pack();
	}

}
