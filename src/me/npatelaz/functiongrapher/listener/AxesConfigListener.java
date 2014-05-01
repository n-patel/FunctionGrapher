package me.npatelaz.functiongrapher.listener;

import me.npatelaz.functiongrapher.graph.GraphPanel;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static me.npatelaz.functiongrapher.util.GraphScalingHelper.*;

/**
 * Listens to action commands fired by text fields from the axes config panel and updates the graph panel accordingly.
 *
 * Nikhil Patel
 * File created on Apr 09, 2014
 */
public class AxesConfigListener implements ActionListener
{
	/**
	 * Listens to action commands fired by text fields from the axes config panel and updates the graph panel accordingly
	 * @param e     ActionEvent that was fired
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		JTextField textField = (JTextField)e.getSource();
		int fieldValue = Integer.parseInt(textField.getText());

		// Set scaling variables according to what is in the text field
		switch (command)
		{
			case "XMIN": setXMIN(fieldValue);    break;
			case "XMAX": setXMAX(fieldValue);    break;
			case "XSCL": setXSCL(fieldValue);    break;
			case "YMIN": setYMIN(fieldValue);    break;
			case "YMAX": setYMAX(fieldValue);    break;
			case "YSCL": setYSCL(fieldValue);    break;
		}

		// Update the graph panel
		GraphPanel.getInstance().repaint();

	}

}
