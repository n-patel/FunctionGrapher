package me.npatelaz.functiongrapher.graph;

import expr.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Graphics2D;
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
	private JPanel p;
	private Expr expression;

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
		setExpression("x^3 + x - 4");
		double d = (getXMAX() - getXMIN()) / 1000.0;                // how much x increments each calculation
		for (double x = getXMIN(); x <= getXMAX(); x += d)
		{
			Point2D.Double point1 = new Point2D.Double(xPixel(x, p),
													   yPixel(getValue(x), p));
			Point2D.Double point2 = new Point2D.Double(xPixel(x+d, p),
													   yPixel(getValue(x+d), p));
			Line2D.Double segment = new Line2D.Double(point1, point2);
			g2.draw(segment);
		}

	}


	public void setExpression(String expression)
	{
		try
		{
			this.expression = Parser.parse(expression);
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
	private double getValue(double x)
	{
		Variable varX = Variable.make("x");
		varX.setValue(x);
		return expression.value();
	}
}
