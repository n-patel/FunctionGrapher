package me.npatelaz.functiongrapher.config;

import me.npatelaz.functiongrapher.listener.FunctionConfigListener;

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
		FunctionConfigListener functionConfigListener = new FunctionConfigListener();

		// Create the function text field
		JTextField function = new JTextField(10);
		function.setHorizontalAlignment(JTextField.CENTER);
		function.addActionListener(functionConfigListener);
		function.setActionCommand("FUNCTION");

		// Create the dropdown menu
		String[] colors = {"Black", "Blue", "Cyan", "Dark_Gray", "Gray", "Green", "Light_Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
		JComboBox<String> color = new JComboBox<>(colors);
		color.addActionListener(functionConfigListener);
		color.setActionCommand("COLOR");

		// Create the brushstroke text field
		JTextField brushstroke = new JTextField(10);
		brushstroke.setHorizontalAlignment(JTextField.CENTER);
		brushstroke.addActionListener(functionConfigListener);
		brushstroke.setActionCommand("BRUSHSTROKE");

		// Add the components
		add(new JLabel("Function"));
		add(function, "gapleft 15");
		add(new JLabel("Color"));
		add(color, "gapleft 15");
		add(new JLabel("Brushstroke"));
		add(brushstroke, "gapleft 15");
	}

}
