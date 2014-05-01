package me.npatelaz.functiongrapher.listener;

import me.npatelaz.functiongrapher.config.FunctionConfig;
import me.npatelaz.functiongrapher.config.WolframAlphaDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listens to action commands fired by text fields from the WolframAlpha panel and updates the query result text accordingly.
 *
 * Nikhil Patel
 * File created on May 01, 2014
 */
public class WolframAlphaListener implements ActionListener
{
	/**
	 * Listens to action commands fired by text fields from the WolframAlpha panel and updates the query result text accordingly
	 * @param e     ActionEvent that was fired
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();

		switch (command)
		{
			case "UPDATE":
			{
				// Get the function field's text
				String function = FunctionConfig.getInstance().getFunction();

				// Update the result text area
				WolframAlphaDisplay.getInstance().setQuery(function);
				WolframAlphaDisplay.getInstance().updateResultText();

				break;
			}
		}

	}

}

