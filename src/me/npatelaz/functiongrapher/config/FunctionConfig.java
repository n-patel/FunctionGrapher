package me.npatelaz.functiongrapher.config;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * JPanel that contains the function drawing portion of the in-application configuration.
 *
 * Nikhil Patel
 * File created on Apr 07, 2014
 */
public class FunctionConfig extends JPanel
{
	/**
	 * Initializes the JPanel with the function configuration fields
	 */
	public void initializePanel()
	{
		MigLayout migLayout = new MigLayout("wrap 2");
		setLayout(migLayout);

		add(new JLabel("Function"));
		add(new JTextField(8), "gapleft 16");
		add(new JLabel("Color"));
		add(new JTextField(8), "gapleft 16");
	}
}
