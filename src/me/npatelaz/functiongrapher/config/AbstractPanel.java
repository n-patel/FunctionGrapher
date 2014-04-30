package me.npatelaz.functiongrapher.config;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.*;

/**
 * Abstract panel class for configuration panels
 *
 * Nikhil Patel
 * File created on Apr 29, 2014
 */
public abstract class AbstractPanel extends JPanel
{
	/**
	 * Initializes the panel
	 * @param panelName         name of the panel (used to create titled border)
	 * @param dimensions        dimensions of the panel
	 * @param layoutManager     layout manager to use
	 */
	public void initialize(String panelName, Dimension dimensions, LayoutManager layoutManager)
	{
		this.setBorder(BorderFactory.createTitledBorder(panelName));
		this.setPreferredSize(dimensions);
		this.setLayout(layoutManager);
		populate();
	}

	/**
	 * Populates the panel
	 */
	public abstract void populate();
}
