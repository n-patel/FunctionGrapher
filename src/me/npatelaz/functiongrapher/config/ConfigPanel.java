package me.npatelaz.functiongrapher.config;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Dimension;

import static me.npatelaz.functiongrapher.Main.CONFIG_PADDING;
import static me.npatelaz.functiongrapher.Main.CONFIG_WIDTH;

/**
 * JPanel that contains the in-application configuration.
 *
 * Nikhil Patel
 * File created on Apr 07, 2014
 */
public class ConfigPanel extends JPanel
{
	// Panel height constants
	// Note: These numbers were chosen based on how large the panels actually where. Because they will always be the same width,
	//       they can have a constant height without the need to worry about resizing/scaling.
	private int FUNCTION_PANEL_HEIGHT = 115;
	private int AXES_PANEL_HEIGHT     = 185;


	/**
	 * Initializes the JPanel with the function and axes config panels
	 */
	public void initializePanel()
	{
		// Initialize and add the function configuration panel
		FunctionConfig functionConfig = new FunctionConfig();
		functionConfig.initializePanel();
		functionConfig.setPreferredSize(new Dimension(CONFIG_WIDTH - CONFIG_PADDING, FUNCTION_PANEL_HEIGHT));
		functionConfig.setBorder(BorderFactory.createTitledBorder("Function Configuration"));
		add(functionConfig);

		// Initialize and add the axes configuration panel
		AxesConfig axesConfig = new AxesConfig();
		axesConfig.initializePanel();
		axesConfig.setPreferredSize(new Dimension(CONFIG_WIDTH - CONFIG_PADDING, AXES_PANEL_HEIGHT));
		axesConfig.setBorder(BorderFactory.createTitledBorder("Axes Configuration"));
		add(axesConfig);
	}
}
