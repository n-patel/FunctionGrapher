package me.npatelaz.functiongrapher.listener;

import me.npatelaz.functiongrapher.graph.Function;
import me.npatelaz.functiongrapher.graph.GraphPanel;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

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
		JComponent component = (JComponent)e.getSource();
		if (command.equals("FUNCTION"))
		{
			JTextField textField = (JTextField)component;
			String fieldValue = textField.getText();

			// Set function expression to the value of the text field
			Function.setExpression(fieldValue);
		}
		else if (command.equals("COLOR"))
		{
			JComboBox<String> jComboBox = (JComboBox<String>)component;
			String fieldValue = (String)jComboBox.getSelectedItem();

			// Convert fieldValue to Color
			Color color = Color.BLACK;
			try
			{
				Field field = Class.forName("java.awt.Color").getField(fieldValue);
				color = (Color)field.get(null);
			}
			catch (Exception exception)
			{
				exception.printStackTrace();
			}

			// Set function color to value of dropdown menu
			Function.setColor(color);
		}

		// Update the graph panel
		GraphPanel.updatePanel(component);
	}
}
