package me.npatelaz.functiongrapher.graph;

import javax.swing.*;
import java.awt.*;

/**
 * JPanel that contains the graph (function and axes).
 *
 * Nikhil Patel
 * File created on Apr 05, 2014
 */
public class GraphPanel extends JPanel
{
	private static GraphPanel instance;

	private GraphPanel() {}

	public static GraphPanel getInstance()
	{
		if (instance == null) {
			instance = new GraphPanel();
		}
		return instance;
	}


	/**
	 * Draws the function and the axes on the panel
	 * @param g     Graphics instance for drawing
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		// Draw the function
		Function function = new Function(this);
		function.draw(g2);

		// Draw the axes
		Axes axes = new Axes(this);
		axes.draw(g2);
	}


	/**
	 * Repaints the GraphPanel
	 * Not my favorite way of doing this, but it will have to suffice.
	 *
	 * @param component     a component within the window in order to get a reference point to obtain the GraphPanel instance
	 */
	public static void updatePanel(JComponent component)
	{
		if (component.getRootPane() != null)
		{
			for (Component c : component.getRootPane().getContentPane().getComponents())
			{
				if (c instanceof GraphPanel)
				{
					c.repaint();
					break;
				}
			}
		}
	}
}
