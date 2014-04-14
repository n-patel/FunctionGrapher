package me.npatelaz.functiongrapher.config;

import me.npatelaz.functiongrapher.listener.FunctionConfigListener;
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

		JTextField function = new JTextField(10);
		function.setHorizontalAlignment(JTextField.CENTER);
		function.addActionListener(new FunctionConfigListener());
		function.setActionCommand("FUNCTION");

		add(new JLabel("Function"));
		add(function, "gapleft 30");
		add(new JLabel("Color"));
		add(new JTextField(10), "gapleft 30");
	}
}
