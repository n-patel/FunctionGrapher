package me.npatelaz.functiongrapher.util;

import javax.swing.JPanel;

/**
 * A set of utility methods to manage coordinate scaling (converting coordinates to pixels on a programmer-defined scale).
 *
 * Nikhil Patel
 * File created a long time ago (imported into project: Apr 05, 2014)
 */
public class GraphScalingHelper
{

	// Not final because they're subject to change based on settings in the config panel.
	// However, they act as constants and are therefore named as such.
	private static int XMIN = -10;
	private static int XMAX = 10;
    private static int XSCL = 1;
	private static int YMIN = -10;
	private static int YMAX = 10;
    private static int YSCL = 1;

	/**
	 * Scales the x-pixel
	 * @param xuser		the desired x-coordinate
	 * @param panel		instance of JPanel, used for getting width
	 * @return 			new x coordinate
	 */
	public static int xPixel(double xuser, JPanel panel)
	{
		return (int)((xuser - getXMIN()) * (panel.getWidth() - 1) / (getXMAX() - getXMIN()));
	}


	/**
	 * Scales the y-pixel
	 * @param yuser		the desired y-coordinate
	 * @param panel		instance of JPanel, used for getting height
	 * @return 			new y coordinate
	 */
	public static int yPixel(double yuser, JPanel panel)
	{
		return (int)((yuser - getYMAX()) * (panel.getHeight() - 1) / (getYMIN() - getYMAX()));
	}


	/**
	 * Scales the height
	 * @param yuser		the desired height
	 * @param panel		instance of JPanel, used for getting height
	 * @return 			new height
	 */
	public static int sHeight(double yuser, JPanel panel)
	{
		return (int)(yuser * (panel.getHeight() - 1) / (getYMAX() - getYMIN()));
	}


	/**
	 * Scales the width
	 * @param xuser		the desired width
	 * @param panel		instance of JPanel, used for getting width
	 * @return 			new width
	 */
	public static int sWidth(double xuser, JPanel panel)
	{
		return (int)(xuser * (panel.getWidth() - 1) / (getXMAX() - getXMIN()));
	}


    /**
     * @return XMIN     XMIN value (lowest x-coordinate)
     */
    public static int getXMIN()
    {
        return XMIN;
    }


    /**
     * @param XMIN      XMIN value (lowest x-coordinate) to set
     */
    public static void setXMIN(int XMIN)
    {
        GraphScalingHelper.XMIN = XMIN;
    }


    /**
     * @return XMAX     XMAX value (highest x-coordinate)
     */
    public static int getXMAX()
    {
        return XMAX;
    }


    /**
	 * Sets the XMAX value (highest x-coordinate) to set
	 * @param XMAX
	 */
	public static void setXMAX(int XMAX)
	{
		GraphScalingHelper.XMAX = XMAX;
	}


    /**
     * @return YMIN     YMIN value (lowest y-coordinate)
     */
    public static int getYMIN()
    {
        return YMIN;
    }


    /**
	 * @param YMIN      YMIN value (lowest y-coordinate) to set
	 */
	public static void setYMIN(int YMIN)
	{
		GraphScalingHelper.YMIN = YMIN;
	}


    /**
     * @return YMAX     YMAX value (highest y-coordinate)
     */
    public static int getYMAX()
    {
        return YMAX;
    }


    /**
	 * @param YMAX      YMAX value (highest y-coordinate) to set
	 */
	public static void setYMAX(int YMAX)
	{
		GraphScalingHelper.YMAX = YMAX;
	}


	/**
	 * @return XSCL     XSCL value (x-axis scaling)
	 */
    public static int getXSCL()
    {
        return XSCL;
    }


	/**
	 * @param XSCL      XSCL value (x-axis scaling) to set
	 */
    public static void setXSCL(int XSCL)
    {
        GraphScalingHelper.XSCL = XSCL;
    }


	/**
	 * @return YSCL     YSCL value (y-axis scaling)
	 */
    public static int getYSCL()
    {
        return YSCL;
    }


	/**
	 * @param YSCL      YSCL value (y-axis scaling) to set
	 */
    public static void setYSCL(int YSCL)
    {
        GraphScalingHelper.YSCL = YSCL;
    }
}
