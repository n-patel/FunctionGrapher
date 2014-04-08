package me.npatelaz.functiongrapher.config;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Description
 *
 * Nikhil Patel
 * File created on Apr 07, 2014
 */
public class ConfigPanel extends JPanel
{
	public void initializePanel()
	{
		FunctionConfig functionConfig = new FunctionConfig();
		functionConfig.initializePanel();
		functionConfig.setBorder(BorderFactory.createTitledBorder("Function Configuration"));
		add(functionConfig);

		AxesConfig axesConfig = new AxesConfig();
		axesConfig.initializePanel();
		axesConfig.setBorder(BorderFactory.createTitledBorder("Axes Configuration"));
		add(axesConfig);
	}
}
