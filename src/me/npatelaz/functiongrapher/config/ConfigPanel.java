package me.npatelaz.functiongrapher.config;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * Description
 *
 * Nikhil Patel
 * File created on Apr 07, 2014
 */
public class ConfigPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		FunctionConfig functionConfig = new FunctionConfig();
		functionConfig.setBorder(BorderFactory.createTitledBorder("Function Configuration"));
		add(functionConfig);

		AxesConfig axesConfig = new AxesConfig();
		axesConfig.setBorder(BorderFactory.createTitledBorder("Axes Configuration"));
		add(axesConfig);
	}
}
