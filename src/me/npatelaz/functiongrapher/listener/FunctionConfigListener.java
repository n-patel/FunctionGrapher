package me.npatelaz.functiongrapher.listener;

import me.npatelaz.functiongrapher.graph.Function;

import javax.swing.JTextField;
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

		Function function;

		switch(command)
		{
			case "FUNCTION":    function = new Function(); function.setExpression(fieldValue);
		}
	}
}
