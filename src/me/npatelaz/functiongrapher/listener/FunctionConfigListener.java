package me.npatelaz.functiongrapher.listener;

import me.npatelaz.functiongrapher.graph.Function;
import me.npatelaz.functiongrapher.graph.GraphPanel;

import javax.swing.*;
import java.awt.Color;
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
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		JComponent component = (JComponent)e.getSource();

		switch (command)
		{
			case "FUNCTION":
			{
				JTextField textField = (JTextField)component;
				String fieldValue = textField.getText();

				// Set function expression to the value of the text field
				Function.setExpression(fieldValue);
				break;
			}
			case "COLOR":
			{
				JComboBox<Color> jComboBox = (JComboBox<Color>)component;
				Color jComboBoxSelectedItem = (Color)jComboBox.getSelectedItem();

				// Set function color to value of dropdown menu
				Function.setColor(jComboBoxSelectedItem);
				break;
			}
			case "BRUSHSTROKE":
			{
				JTextField textField = (JTextField)component;
				float fieldValue = Float.parseFloat(textField.getText());

				// Set brushstroke thickness to the value of the text field
				Function.setBrushstroke(fieldValue);
				break;
			}
		}

		// Update the graph panel
		GraphPanel.updatePanel(component);
	}

}
