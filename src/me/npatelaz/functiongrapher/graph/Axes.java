package me.npatelaz.functiongrapher.graph;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import static me.npatelaz.functiongrapher.util.GraphScalingHelper.*;

/**
 * Description
 * <p/>
 * Nikhil Patel
 * File created on Apr 06, 2014
 */
public class Axes
{
	private JPanel p;

	public Axes(JPanel panel)
	{
		this.p = panel;
	}

	public void draw(Graphics2D g2)
	{
		Line2D.Double xAxis = new Line2D.Double(xPixel(getXMIN(), p),
												yPixel(0, p),
												xPixel(getXMAX(), p),
												yPixel(0, p));
		Line2D.Double yAxis = new Line2D.Double(xPixel(0, p),
												yPixel(getYMIN(), p),
												xPixel(0, p),
												yPixel(getYMAX(), p));
		g2.draw(xAxis);
		g2.draw(yAxis);

		int x;
		int y;

		// Draw ticks along the positive part of the x-axis
		for (x = 0; x <= getXMAX(); x += getXSCL())
		{
			drawXTick(g2, x);
		}

		// Draw ticks along the negative part of the x-axis
		for (x = 0; x >= getXMIN(); x -= getXSCL())
		{
			drawXTick(g2, x);
		}

		// Draw ticks along the positive part of the y-axis
		for (y = 0; y <= getYMAX(); y += getYSCL())
		{
			drawYTick(g2, y);
		}

		// Draw ticks along the negative part of the y-axis
		for (y = 0; y >= getXMIN(); y -= getYSCL())
		{
			drawYTick(g2, y);
		}

	}

	public void drawXTick(Graphics2D g2, double x)
	{
		Point2D.Double tickBottom = new Point2D.Double(xPixel(x, p),
		                                               yPixel(0, p) + sHeight(.2, p));
		Point2D.Double tickTop    = new Point2D.Double(xPixel(x, p),
		                                               yPixel(0, p) - sHeight(.2, p));
		Line2D.Double tick = new Line2D.Double(tickBottom, tickTop);
		g2.draw(tick);
	}

	public void drawYTick(Graphics2D g2, double y)
	{
		Point2D.Double tickLeft  = new Point2D.Double(xPixel(0, p) + sWidth(.2, p),
		                                              yPixel(y, p));
		Point2D.Double tickRight = new Point2D.Double(xPixel(0, p) - sWidth(.2, p),
		                                              yPixel(y, p));
		Line2D.Double tick = new Line2D.Double(tickLeft, tickRight);
		g2.draw(tick);
	}

}
