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
			drawTick(g2, x, 0);
		}

		// Draw ticks along the negative part of the x-axis
		for (x = 0; x >= getXMIN(); x -= getXSCL())
		{
			drawTick(g2, x, 0);
		}

		// Draw ticks along the positive part of the y-axis
		for (y = 0; y <= getYMAX(); y += getYSCL())
		{
			drawTick(g2, 0, y);
		}

		// Draw ticks along the negative part of the y-axis
		for (y = 0; y >= getYMIN(); y -= getYSCL())
		{
			drawTick(g2, 0, y);
		}

	}

	public void drawTick(Graphics2D g2, double x, double y)
	{
		if (x == 0 && y == 0) return;           // no tickmark at the origin

		// v and h are used to decide whether to draw vertical or horizontal ticks
		double v = (x==0)? 1 : 0;
		double h = (y==0)? 1 : 0;

		Point2D.Double tickStart = new Point2D.Double(xPixel(x, p) + v * sWidth(.2, p),
		                                              yPixel(y, p) + h * sHeight(.2, p));
		Point2D.Double tickEnd   = new Point2D.Double(xPixel(x, p) - v * sWidth(.2, p),
		                                              yPixel(y, p) - h * sHeight(.2, p));
		Line2D.Double tick = new Line2D.Double(tickStart, tickEnd);
		g2.draw(tick);
	}

}
