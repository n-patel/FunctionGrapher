package me.npatelaz.functiongrapher.config;

import net.miginfocom.swing.MigLayout;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;

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
	private static int WOLFRAM_PANEL_HEIGHT  = 295;


	/**
	 * Initializes the JPanel with the function and axes config panels
	 */
	public void initializePanel()
	{
		// Initialize and add the function configuration panel
		FunctionConfig functionConfig = FunctionConfig.getInstance();
		functionConfig.initialize("Function Configuration", new Dimension(CONFIG_WIDTH - CONFIG_PADDING, FUNCTION_PANEL_HEIGHT), new MigLayout("wrap 2"));
		functionConfig.setFunction("x^2");
		add(functionConfig);

		// Initialize and add the axes configuration panel
		AxesConfig axesConfig = AxesConfig.getInstance();
		axesConfig.initialize("Axes Configuration", new Dimension(CONFIG_WIDTH - CONFIG_PADDING, AXES_PANEL_HEIGHT), new MigLayout("wrap 2"));
		add(axesConfig);

		// Initialize and add the save/load configuration panel
		SaveLoadConfigPanel saveLoadConfigPanel = SaveLoadConfigPanel.getInstance();
		saveLoadConfigPanel.initialize("Save/Load Configuration", new Dimension(CONFIG_WIDTH - CONFIG_PADDING, SAVELOAD_PANEL_HEIGHT), new FlowLayout());
		add(saveLoadConfigPanel);

		// Initialize and add the Wolfram Alpha query panel
		WolframAlphaDisplay wolframAlphaDisplay = new WolframAlphaDisplay();
		wolframAlphaDisplay.setQuery("y=" + functionConfig.getFunction());
		wolframAlphaDisplay.initialize("Wolfram Alpha", new Dimension(CONFIG_WIDTH - CONFIG_PADDING, WOLFRAM_PANEL_HEIGHT), new FlowLayout());
		add(wolframAlphaDisplay);
	}
}
