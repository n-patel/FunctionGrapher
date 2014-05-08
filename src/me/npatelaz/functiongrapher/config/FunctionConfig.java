package me.npatelaz.functiongrapher.config;

import me.npatelaz.functiongrapher.listener.FunctionConfigListener;

import javax.swing.*;

/**
 * JPanel that contains the function drawing portion of the in-application configuration.
 *
 * Nikhil Patel
 * File created on Apr 07, 2014
 */
public class FunctionConfig extends AbstractPanel
{
	private static FunctionConfig instance;

	private FunctionConfig() {}

	public static FunctionConfig getInstance()
	{
		if (instance == null)
		{
			instance = new FunctionConfig();
		}
		return instance;
	}

	private JTextField function;
	private JComboBox<String> color;
	private JTextField brushstroke;

	/**
	 * Populates the JPanel with the function configuration fields
	 */
	@Override
	public void populate()
	{
		FunctionConfigListener functionConfigListener = new FunctionConfigListener();

		// Create the function text field
		function = new JTextField(10);
		function.setHorizontalAlignment(JTextField.CENTER);
		function.addActionListener(functionConfigListener);
		function.setActionCommand("FUNCTION");

		// Create the dropdown menu
		//List<Color> colors = Arrays.asList(Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW);
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


	/**
	 * @return color text field
	 */
	public String getColor()
	{
		return String.valueOf(color.getSelectedItem());
	}


	/**
	 * @param color     color text field to set
	 */
	public void setColor(String color)
	{
		this.color.setSelectedItem(color);
	}


	/**
	 * @return function text field
	 */
	public String getFunction()
	{
		return function.getText();
	}


	/**
	 * @param function      function text field to set
	 */
	public void setFunction(String function)
	{
		this.function.setText(function);
		this.function.postActionEvent();
	}


	/**
	 * @return brushstroke text field
	 */
	public float getBrushstroke()
	{
		return Float.parseFloat(brushstroke.getText());
	}


	/**
	 * @param brushstroke       brushstroke text field to set
	 */
	public void setBrushstroke(float brushstroke)
	{
		this.brushstroke.setText("" + brushstroke);
		this.brushstroke.postActionEvent();
	}

}
