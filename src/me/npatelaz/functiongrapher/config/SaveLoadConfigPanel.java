package me.npatelaz.functiongrapher.config;

import me.npatelaz.functiongrapher.listener.SaveLoadConfigListener;

import javax.swing.JButton;

/**
 * Description
 *
 * Nikhil Patel
 * File created on Apr 29, 2014
 */
public class SaveLoadConfigPanel extends AbstractPanel
{
	private static SaveLoadConfigPanel instance;

	private SaveLoadConfigPanel() {}

	public static SaveLoadConfigPanel getInstance()
	{
		if (instance == null)
		{
			instance = new SaveLoadConfigPanel();
		}
		return instance;
	}

	JButton save;
	JButton load;

	@Override
	public void populate()
	{
		SaveLoadConfigListener saveLoadConfigListener = new SaveLoadConfigListener();

		save = new JButton("Save");
		save.addActionListener(saveLoadConfigListener);
		save.setActionCommand("SAVE");

		load = new JButton("Load");
		load.addActionListener(saveLoadConfigListener);
		load.setActionCommand("LOAD");

		add(save);
		add(load);
	}

}
