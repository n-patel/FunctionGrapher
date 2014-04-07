package me.npatelaz.functiongrapher.graph;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import static me.npatelaz.functiongrapher.util.GraphScalingHelper.*;

/**
 * Description
 * <p/>
 * Nikhil Patel
 * File created on Apr 05, 2014
 */
public class Function
{
    private JPanel p;

    public Function(JPanel panel)
    {
        this.p = panel;
    }

    public void draw(Graphics2D g2)
    {
        double d = .00001;
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

    public static double getValue(double x)
    {
        return .5 * x * x;       // temporary function until I make it configurable
    }
}
