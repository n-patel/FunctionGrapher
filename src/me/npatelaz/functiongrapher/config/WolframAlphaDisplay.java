
package me.npatelaz.functiongrapher.config;

import me.npatelaz.functiongrapher.listener.WolframAlphaListener;
import me.npatelaz.functiongrapher.util.WolframAlphaHelper;

import javax.swing.*;

/**
 * JPanel that contains the Wolfram Alpha query controls.
 *
 * Nikhil Patel
 * File created on Apr 17, 2014
 */
public class WolframAlphaDisplay extends AbstractPanel
{
	private static WolframAlphaDisplay instance;

	private WolframAlphaDisplay() {}

	public static WolframAlphaDisplay getInstance()
	{
		if (instance == null) {
			instance = new WolframAlphaDisplay();
		}
		return instance;
	}


	private String query;

	private JTextArea textArea;
	private JButton update;

	/**
	 * Populates the JPanel with the text area and update button
	 */
	@Override
	public void populate()
	{
		textArea = new JTextArea(14, 18);
		textArea.setEditable(false);

		update = new JButton("Update");
		update.setActionCommand("UPDATE");
		update.addActionListener(new WolframAlphaListener());

		add(new JScrollPane(textArea));
		add(update);

		query();
	}


	/**
	 * Sets the text to query Wolfram Alpha with
	 * @param query     text to query
	 */
	public void setQuery(String query)
	{
		this.query = query;
	}


	/**
	 * Simulates a press of the update button
	 */
	public void clickUpdateButton()
	{
		if (update != null)
		{
			update.doClick();
		}
	}


	/**
	 * Updates the result text area
	 */
	public void query()
	{
		textArea.setText("Querying...");
		new WolframAlphaHelper().query(query);
	}

	/**
	 * Sets the query result text area
	 * @param result        text to set
	 */
	public void setQueryResult(String result)
	{
		textArea.setText(result);
	}

}