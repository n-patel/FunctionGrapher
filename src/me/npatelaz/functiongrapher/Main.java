package me.npatelaz.functiongrapher;

import me.npatelaz.functiongrapher.config.ConfigPanel;
import me.npatelaz.functiongrapher.graph.GraphPanel;
import me.npatelaz.functiongrapher.util.FileIO;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * An application which graphs function. TODO: insert continued description here
 *
 * Nikhil Patel
 * File created on Apr 05, 2014
 */
public class Main
{
	// Window dimension constants
	public static final int WINDOW_HEIGHT = 700;
	public static final int WINDOW_WIDTH  = 950;
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
		URL url = ClassLoader.class.getResource("/resources/default.properties");
		try
		{
			fileIO.readConfig(new File(url.toURI()));
		}
		catch (URISyntaxException e)
		{
			e.printStackTrace();
		}

		frame.pack();

	}
}
