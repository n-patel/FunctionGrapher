package me.npatelaz.functiongrapher.listener;

import me.npatelaz.functiongrapher.graph.Function;
import me.npatelaz.functiongrapher.graph.GraphPanel;

import javax.swing.JTextField;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listens to action commands fired by text fields from the function config panel and updates the graph panel accordingly.
 *
 * Nikhil Patel
 * File created on Apr 11, 2014
 */
public class FunctionConfigListener implements ActionListener
{
	/**
	 * Listens to action commands fired by text fields from the function config panel and updates the graph panel accordingly
	 * @param e     ActionEvent that was fired
	 */
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		JTextField textField = (JTextField)e.getSource();
		String fieldValue = textField.getText();

		// Set function expression to the value of the text field
		if (command.equals("FUNCTION"))
		{
			Function.setExpression(fieldValue);
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
