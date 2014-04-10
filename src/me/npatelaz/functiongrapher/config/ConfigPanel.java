package me.npatelaz.functiongrapher.config;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * JPanel that contains the in-application configuration.
 *
 * Nikhil Patel
 * File created on Apr 07, 2014
 */
public class ConfigPanel extends JPanel
{
	/**
	 * Initializes the JPanel with the function and axes config panels
	 */
	public void initializePanel()
	{
		// Initialize and add the function configuration panel
		FunctionConfig functionConfig = new FunctionConfig();
		functionConfig.initializePanel();
		functionConfig.setBorder(BorderFactory.createTitledBorder("Function Configuration"));
		add(functionConfig);

		// Initialize and add the axes configuration panel
		AxesConfig axesConfig = new AxesConfig();
		axesConfig.initializePanel();
		axesConfig.setBorder(BorderFactory.createTitledBorder("Axes Configuration"));
		add(axesConfig);
	}
}
