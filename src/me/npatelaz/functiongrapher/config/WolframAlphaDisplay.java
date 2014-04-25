package me.npatelaz.functiongrapher.config;

import me.npatelaz.functiongrapher.util.WolframAlphaHelper;

import javax.swing.*;

/**
 * Description
 *
 * Nikhil Patel
 * File created on Apr 17, 2014
 */
public class WolframAlphaDisplay extends JPanel
{
	private String input;

	public void initializePanel()
	{
		JTextArea textArea = new JTextArea(13, 18);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);

		add(scrollPane);

		String queryResultText = WolframAlphaHelper.query(input);
		textArea.setText(queryResultText);
	}

	public void setQuery(String query)
	{
		this.input = query;
	}

}

