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
	private JTextField function;
	private JComboBox<String> color;
	private JTextField brushstroke;

	/**
	 * Initializes the JPanel with the function configuration fields
	 */
	public void initializePanel()
	{
		FunctionConfigListener functionConfigListener = new FunctionConfigListener();

		// Create the function text field
		function = new JTextField(10);
		function.setHorizontalAlignment(JTextField.CENTER);
		function.addActionListener(functionConfigListener);
		function.setActionCommand("FUNCTION");

		// Create the dropdown menu
		String[] colors = {"Black", "Blue", "Cyan", "Dark_Gray", "Gray", "Green", "Light_Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
		color = new JComboBox<>(colors);
		color.addActionListener(functionConfigListener);
		color.setActionCommand("COLOR");

		// Create the brushstroke text field
		brushstroke = new JTextField(10);
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


	public String getColor()
	{
		return (String)color.getSelectedItem();
	}


	public void setColor(JComboBox<String> color)
	{
		// TODO
	}


	public String getFunction()
	{
		return (String)function.getText();
	}


	public void setFunction(String function)
	{
		this.function.setText(function);
	}


	public float getBrushstroke()
	{
		return Float.parseFloat(brushstroke.getText());
	}


	public void setBrushstroke(float brushstroke)
	{
		this.brushstroke.setText("" + brushstroke);
	}

}
