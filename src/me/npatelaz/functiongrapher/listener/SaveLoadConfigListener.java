package me.npatelaz.functiongrapher.listener;

import me.npatelaz.functiongrapher.util.FileIO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		switch(command)
		{
			case "SAVE":
			{
				fileChooser.setApproveButtonText("Save");
				int returnValue = fileChooser.showOpenDialog(component);
				if (returnValue == JFileChooser.APPROVE_OPTION)
				{
					fileIO.storeProperties(fileChooser.getSelectedFile());
					JOptionPane.showMessageDialog(component, "Configuration saved!");
				}
				break;
			}
			case "LOAD":
			{
				fileChooser.setApproveButtonText("Load");
				int returnValue = fileChooser.showOpenDialog(component);
				if (returnValue == JFileChooser.APPROVE_OPTION)
				{
					fileIO.loadProperties(fileChooser.getSelectedFile());
					JOptionPane.showMessageDialog(component, "Configuration loaded!");
				}
				break;
			}
			case "RESET":
			{
				fileIO.loadDefaultProperties();
				JOptionPane.showMessageDialog(component, "Default configuration loaded!");
				break;
			}
		}
	}
}
