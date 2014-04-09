package me.npatelaz.functiongrapher.util;

import javax.swing.JPanel;

/**
 * A set of utility methods to manage coordinate scaling (converting coordinates to pixels on a programmer-defined scale)
 * <p/>
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
     * Gets the XMIN value (lowest x-coordinate)
     * @return XMIN
     */
    public static int getXMIN()
    {
        return XMIN;
    }


    /**
     * Sets the XMIN value (lowest x-coordinate)
     * @param XMIN
     */
    public static void setXMIN(int XMIN)
    {
        GraphScalingHelper.XMIN = XMIN;
    }


    /**
     * Gets the XMAX value (highest x-coordinate)
     * @return XMAX
     */
    public static int getXMAX()
    {
        return XMAX;
    }


    /**
	 * Sets the XMAX value (highest x-coordinate)
	 * @param XMAX
	 */
	public static void setXMAX(int XMAX)
	{
		GraphScalingHelper.XMAX = XMAX;
	}


    /**
     * Gets the YMIN value (lowest y-coordinate)
     * @return YMIN
     */
    public static int getYMIN()
    {
        return YMIN;
    }


    /**
	 * Sets the YMIN value (lowest y-coordinate)
	 * @param YMIN
	 */
	public static void setYMIN(int YMIN)
	{
		GraphScalingHelper.YMIN = YMIN;
	}


    /**
     * Gets the YMAX value (highest y-coordinate)
     * @return YMAX
     */
    public static int getYMAX()
    {
        return YMAX;
    }


    /**
	 * Sets the YMAX value (highest y-coordinate)
	 * @param YMAX
	 */
	public static void setYMAX(int YMAX)
	{
		GraphScalingHelper.YMAX = YMAX;
	}

    
    public static int getXSCL()
    {
        return XSCL;
    }

    public static void setXSCL(int XSCL)
    {
        GraphScalingHelper.XSCL = XSCL;
    }

    public static int getYSCL()
    {
        return YSCL;
    }

    public static void setYSCL(int YSCL)
    {
        GraphScalingHelper.YSCL = YSCL;
    }
}
