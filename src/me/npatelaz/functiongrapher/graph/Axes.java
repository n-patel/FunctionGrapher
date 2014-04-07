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

        // Draw ticks along the x-axis
        for (int x = getXMIN(); x <= getXMAX(); x++)
        {
            Point2D.Double tickBottom = new Point2D.Double(xPixel(x, p),
                                                           yPixel(0, p) + sHeight(.2, p));
            Point2D.Double tickTop    = new Point2D.Double(xPixel(x, p),
                                                           yPixel(0, p) - sHeight(.2, p));
            Line2D.Double tick = new Line2D.Double(tickBottom, tickTop);
            g2.draw(tick);
        }

        // Draw ticks along the y-axis
        for (int y = getYMIN(); y <= getYMAX(); y++)
        {
            Point2D.Double tickLeft  = new Point2D.Double(xPixel(0, p) + sWidth(.2, p),
                                                          yPixel(y, p));
            Point2D.Double tickRight = new Point2D.Double(xPixel(0, p) - sWidth(.2, p),
                                                          yPixel(y, p));
            Line2D.Double tick = new Line2D.Double(tickLeft, tickRight);
            g2.draw(tick);
        }

    }

}
