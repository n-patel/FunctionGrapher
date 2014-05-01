package me.npatelaz.functiongrapher.config;

import me.npatelaz.functiongrapher.listener.WolframAlphaListener;
import me.npatelaz.functiongrapher.util.WolframAlphaHelper;

import javax.swing.*;

/**
 * Description
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


	JTextArea textArea;
	JButton update;
	private String query;

	@Override
	public void populate()
	{
		textArea = new JTextArea(13, 18);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);

		update = new JButton("Update");
		update.setActionCommand("UPDATE");
		update.addActionListener(new WolframAlphaListener());

		add(scrollPane);
		add(update);

		String queryResultText = WolframAlphaHelper.query(query);
		textArea.setText(queryResultText);
	}

	public void setQuery(String query)
	{
		this.query = query;
	}

	public void setResultText(String result)
	{
		this.textArea.setText(result);
	}

	public void update()
	{
		if (update != null) {
			update.doClick();
		}
	}

}

