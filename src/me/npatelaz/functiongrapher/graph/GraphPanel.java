package me.npatelaz.functiongrapher.graph;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * JPanel that contains the graph (function and axes).
 *
 * Nikhil Patel
 * File created on Apr 05, 2014
 */
public class GraphPanel extends JPanel
{
	/**
	 * Draws the function and the axes on the panel
	 * @param g     Graphics instance for drawing
	 */
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
}
