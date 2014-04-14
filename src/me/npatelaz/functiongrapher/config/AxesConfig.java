package me.npatelaz.functiongrapher.config;

import me.npatelaz.functiongrapher.listener.AxesConfigListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * JPanel that contains the axes portion of the in-application configuration.
 *
 * Nikhil Patel
 * File created on Apr 07, 2014
 */
public class AxesConfig extends JPanel
{
	/**
	 * Initializes the JPanel with the axes configuration text fields
	 */
	public void initializePanel()
	{
		MigLayout migLayout = new MigLayout("wrap 2");
		setLayout(migLayout);

		AxesConfigListener axesConfigListener = new AxesConfigListener();

		String[] labels = {"XMIN", "XMAX", "XSCL", "YMIN", "YMAX", "YSCL"};

        for (String label : labels) {
            JTextField tf = new JTextField(10);
            tf.addActionListener(axesConfigListener);
            tf.setActionCommand(label);

            add(new JLabel(label));
            add(tf, "gapleft 50");
        }

	}

}