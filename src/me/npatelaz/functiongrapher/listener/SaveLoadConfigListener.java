package me.npatelaz.functiongrapher.listener;

import me.npatelaz.functiongrapher.util.FileIO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Description
 *
 * Nikhil Patel
 * File created on Apr 29, 2014
 */
public class SaveLoadConfigListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		JComponent component = (JComponent)e.getSource();

		FileIO fileIO = new FileIO();

		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(component);

		if (returnValue == JFileChooser.APPROVE_OPTION)
		{
			File file = fileChooser.getSelectedFile();
			if (command.equals("SAVE"))
			{
				fileIO.writeConfig(file);
				JOptionPane.showMessageDialog(component, "Configuration saved!");
			}
			else if (command.equals("LOAD"))
			{
				fileIO.readConfig(file);
				JOptionPane.showMessageDialog(component, "Configuration loaded!");
			}

		}
	}
}
