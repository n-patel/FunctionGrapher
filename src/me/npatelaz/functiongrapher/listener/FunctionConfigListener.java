package me.npatelaz.functiongrapher.listener;

import me.npatelaz.functiongrapher.graph.Function;
import me.npatelaz.functiongrapher.graph.GraphPanel;

import javax.swing.JTextField;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Description
 *
 * Nikhil Patel
 * File created on Apr 11, 2014
 */
public class FunctionConfigListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		JTextField textField = (JTextField)e.getSource();
		String fieldValue = textField.getText();

		if (command.equals("FUNCTION"))
		{
			Function.setExpression(fieldValue);
			System.out.println("Set expression to " + fieldValue);
		}

		// Update the graph panel (not my favorite way of doing this, but it will have to suffice)
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
