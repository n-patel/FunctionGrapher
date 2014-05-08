package me.npatelaz.functiongrapher.config;

import me.npatelaz.functiongrapher.listener.SaveLoadConfigListener;

import javax.swing.JButton;

/**
 * JPanel that contains the save/load configuration controls.
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


	/**
	 * Populates the JPanel with the saving/loading buttons
	 */
	@Override
	public void populate()
	{
		SaveLoadConfigListener saveLoadConfigListener = new SaveLoadConfigListener();

		JButton save = new JButton("Save");
		save.addActionListener(saveLoadConfigListener);
		save.setActionCommand("SAVE");

		JButton load = new JButton("Load");
		load.addActionListener(saveLoadConfigListener);
		load.setActionCommand("LOAD");

		JButton loadDefaults = new JButton("Reset");
		loadDefaults.addActionListener(saveLoadConfigListener);
		loadDefaults.setActionCommand("RESET");

		add(save);
		add(load);
		add(loadDefaults);
	}

}
