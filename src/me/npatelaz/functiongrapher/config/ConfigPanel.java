package me.npatelaz.functiongrapher.config;

import net.miginfocom.swing.MigLayout;

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
	private static ConfigPanel instance;

	private ConfigPanel() {}

	public static ConfigPanel getInstance()
	{
		if (instance == null) {
			instance = new ConfigPanel();
		}
		return instance;
	}


	// Panel height constants
	// Note: These numbers were chosen based on how large the panels actually where. Because they will always be the same width,
	//       they can have a constant height without the need to worry about resizing/scaling.
	private static int FUNCTION_PANEL_HEIGHT = 115;
	private static int AXES_PANEL_HEIGHT     = 185;
	private static int SAVELOAD_PANEL_HEIGHT = 65;
	private static int WOLFRAM_PANEL_HEIGHT  = 255;


	/**
	 * Initializes the JPanel with the function and axes config panels
	 */
	public void initializePanel()
	{
		// Initialize and add the function configuration panel
		FunctionConfig functionConfig = FunctionConfig.getInstance();
		functionConfig.setLayout(new MigLayout("wrap 2"));
		functionConfig.initializePanel();
		functionConfig.setPreferredSize(new Dimension(CONFIG_WIDTH - CONFIG_PADDING, FUNCTION_PANEL_HEIGHT));
		functionConfig.setBorder(BorderFactory.createTitledBorder("Function Configuration"));
		functionConfig.setFunction("x^2");
		functionConfig.setBrushstroke(1.0F);
		add(functionConfig);

		// Initialize and add the axes configuration panel
		AxesConfig axesConfig = AxesConfig.getInstance();
		axesConfig.setLayout(new MigLayout("wrap 2"));
		axesConfig.initializePanel();
		axesConfig.setPreferredSize(new Dimension(CONFIG_WIDTH - CONFIG_PADDING, AXES_PANEL_HEIGHT));
		axesConfig.setBorder(BorderFactory.createTitledBorder("Axes Configuration"));
		add(axesConfig);

		// Initialize and add the save/load configuration panel
		SaveLoadConfigPanel saveLoadConfigPanel = SaveLoadConfigPanel.getInstance();
		saveLoadConfigPanel.initializePanel();
		saveLoadConfigPanel.setPreferredSize(new Dimension(CONFIG_WIDTH - CONFIG_PADDING, SAVELOAD_PANEL_HEIGHT));
		saveLoadConfigPanel.setBorder(BorderFactory.createTitledBorder("Save/Load Settings"));
		add(saveLoadConfigPanel);

		// Initialize and add the Wolfram Alpha query panel
		WolframAlphaDisplay wolframAlphaDisplay = new WolframAlphaDisplay();
		wolframAlphaDisplay.setQuery("y=" + functionConfig.getFunction());
		wolframAlphaDisplay.initializePanel();
		wolframAlphaDisplay.setPreferredSize(new Dimension(CONFIG_WIDTH - CONFIG_PADDING, WOLFRAM_PANEL_HEIGHT));
		wolframAlphaDisplay.setBorder(BorderFactory.createTitledBorder("Wolfram Alpha"));
		add(wolframAlphaDisplay);
	}
}
