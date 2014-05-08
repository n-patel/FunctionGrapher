package me.npatelaz.functiongrapher.listener;

import me.npatelaz.functiongrapher.util.FileIO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listens to action commands fired by buttons on the Save/Load panel and attempts to save/load accordingly.
 *
 * Nikhil Patel
 * File created on Apr 29, 2014
 */
public class SaveLoadConfigListener implements ActionListener
{
	/**
	 * Listens to action commands fired by buttons on the Save/Load panel and attempts to save/load accordingly
	 * @param e     ActionEvent that was fired
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		JComponent component = (JComponent)e.getSource();

		FileIO fileIO = new FileIO();
		JFileChooser fileChooser = new JFileChooser();

		switch(command)
		{
			case "SAVE":
			{
				fileChooser.setApproveButtonText("Save");

				// Show file chooser dialog
				int returnValue = fileChooser.showOpenDialog(component);
				if (returnValue == JFileChooser.APPROVE_OPTION)
				{
					// Save current properties
					fileIO.storeProperties(fileChooser.getSelectedFile());
					JOptionPane.showMessageDialog(component, "Configuration saved!");
				}
				break;
			}
			case "LOAD":
			{
				fileChooser.setApproveButtonText("Load");
				// Show file chooser dialog
				int returnValue = fileChooser.showOpenDialog(component);
				if (returnValue == JFileChooser.APPROVE_OPTION)
				{
					// Load properties from selected file
					fileIO.loadProperties(fileChooser.getSelectedFile());
					JOptionPane.showMessageDialog(component, "Configuration loaded!");
				}
				break;
			}
			case "RESET":
			{
				// Load the default properties
				fileIO.loadDefaultProperties();
				JOptionPane.showMessageDialog(component, "Default configuration loaded!");
				break;
			}
		}
	}
}
