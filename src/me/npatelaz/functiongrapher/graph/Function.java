package me.npatelaz.functiongrapher.graph;

import expr.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import static me.npatelaz.functiongrapher.util.GraphScalingHelper.*;

/**
 * Draws a function.
 *
 * Nikhil Patel
 * File created on Apr 05, 2014
 */
public class Function
{
	private static Color color;
	private static Expr expression;
	private static float thickness;

	private JPanel p;


	/**
	 * Constructor to set the panel to draw on
	 * @param panel     JPanel to draw on
	 */
	public Function(JPanel panel)
	{
		this.p = panel;
	}


	/**
	 * Draws a function, evaluating y values for x values from the beginning to the end of the panel
	 * @param g2        Graphics2D instance for drawing
	 */
	public void draw(Graphics2D g2)
	{
		g2.setColor(color);
		g2.setStroke(new BasicStroke(thickness));
		double d = (getXMAX() - getXMIN()) / 1000.0;                // how much x increments each calculation
		for (double x = getXMIN(); x <= getXMAX(); x += d)
		{
			Point2D.Double point1 = new Point2D.Double(xPixel(x, p),
													   yPixel(getValue(x), p));
			Point2D.Double point2 = new Point2D.Double(xPixel(x+d, p),
													   yPixel(getValue(x+d), p));
			Line2D.Double segment = new Line2D.Double(point1, point2);

			// Skip drawing the segment if it extends both below and above the window (this is a discontinuity in almost all normal cases)
			if ((point1.getY() > yPixel(getYMIN(),p) && point2.getY() < yPixel(getYMAX(), p)) ||
			    (point2.getY() > yPixel(getYMIN(),p) && point1.getY() < yPixel(getYMAX(),p)))
			{
				continue;
			}

			g2.draw(segment);
		}
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(1.0F));
	}


	/**
	 * Sets the color of the function to be graphed
	 *
	 * NOTE: Can be accessed statically so that GraphPanel can repaint using the same instance
	 *
	 * @param color     color to graph the function in
	 */
	public static void setColor(Color color)
	{
		Function.color = color;
	}


	/**
	 * Sets the brushstroke of the function to be graphed
	 *
	 * NOTE: Can be accessed statically so that GraphPanel can repaint using the same instance
	 *
	 * @param thickness     thickness of brushstroke
	 */
	public static void setBrushstroke(float thickness)
	{
		Function.thickness = thickness;
	}
	/**
	 * Sets the expression to be graphed
	 *
	 * NOTE: Can be accessed statically so that GraphPanel can repaint using the same instance
	 *
	 * @param expression    expression to be graphed
	 */
	public static void setExpression(String expression)
	{
		try
		{
			Function.expression = Parser.parse(expression);
		}
		catch (SyntaxException e)
		{
			JOptionPane.showMessageDialog(null, "Invalid expression.");
			e.printStackTrace();
		}
	}


	/**
	 * Gets the y-value of a certain function for the given x-value
	 * @param x         x-value used to calculate y-value
	 * @return          y-value
	 */
	private static double getValue(double x)
	{
		if (expression == null)
		{
			// set expression to the default expression (for now)
			setExpression("x^2");
		}
		Variable varX = Variable.make("x");
		varX.setValue(x);
		return expression.value();
	}

}
