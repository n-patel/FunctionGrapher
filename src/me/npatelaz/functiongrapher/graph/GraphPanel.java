package me.npatelaz.functiongrapher.graph;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Description
 * <p/>
 * Nikhil Patel
 * File created on Apr 05, 2014
 */
public class GraphPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		Function function = new Function(this);
		function.draw(g2);

		Axes axes = new Axes(this);
		axes.draw(g2);
	}
}
