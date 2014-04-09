package me.npatelaz.functiongrapher.listener;

import me.npatelaz.functiongrapher.graph.GraphPanel;

import javax.swing.JTextField;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static me.npatelaz.functiongrapher.util.GraphScalingHelper.*;

/**
 * Description
 *
 * Nikhil Patel
 * File created on Apr 09, 2014
 */
public class AxesConfigListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		JTextField textField = (JTextField)e.getSource();
		int fieldValue = Integer.parseInt(textField.getText());

		switch (command)
		{
			case "XMIN": setXMIN(fieldValue);    break;
			case "XMAX": setXMAX(fieldValue);    break;
			case "XSCL": setXSCL(fieldValue);    break;
			case "YMIN": setYMIN(fieldValue);    break;
			case "YMAX": setYMAX(fieldValue);    break;
			case "YSCL": setYSCL(fieldValue);    break;
		}

		// Not my favorite way of updating the graphpanel but it will have to suffice
		for (Component c : textField.getRootPane().getContentPane().getComponents())
		{
			if (c instanceof GraphPanel)
			{
				c.repaint();
				break;
			}
		}

	}

}
