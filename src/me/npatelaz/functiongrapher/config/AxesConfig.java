package me.npatelaz.functiongrapher.config;

import me.npatelaz.functiongrapher.listener.AxesConfigListener;

import javax.swing.*;

/**
 * JPanel that contains the axes portion of the in-application configuration.
 *
 * Nikhil Patel
 * File created on Apr 07, 2014
 */
public class AxesConfig extends JPanel
{
	private JTextField xmin;
	private JTextField xmax;
	private JTextField xscl;
	private JTextField ymin;
	private JTextField ymax;
	private JTextField yscl;

	/**
	 * Initializes the JPanel with the axes configuration text fields
	 */
	public void initializePanel()
	{
		AxesConfigListener axesConfigListener = new AxesConfigListener();

		xmin = new JTextField(10);
		xmax = new JTextField(10);
		xscl = new JTextField(10);
		ymin = new JTextField(10);
		ymax = new JTextField(10);
		yscl = new JTextField(10);

		JTextField[] textFields =   { xmin,   xmax,   xscl,   ymin,   ymax,   yscl };
		String[] labels =           {"XMIN", "XMAX", "XSCL", "YMIN", "YMAX", "YSCL"};

        for (int i = 0; i < textFields.length; i++)
        {
	        textFields[i].setHorizontalAlignment(JTextField.CENTER);
	        textFields[i].addActionListener(axesConfigListener);
	        textFields[i].setActionCommand(labels[i]);

            add(new JLabel(labels[i]));
            add(textFields[i], "gapleft 55");
        }

	}

	/**
	 * @return xmin     xmin field text
	 */
	public String getXminField()
	{
		return xmin.getText();
	}

	/**
	 * @param xmin      xmin field text to set
	 */
	public void setXminField(String xmin)
	{
		this.xmin.setText(xmin);
	}

	/**
	 * @return xmax     xmax field text
	 */
	public String getXmaxField()
	{
		return xmax.getText();
	}

	/**
	 * @param xmax      xmax field text to set
	 */
	public void setXmaxField(String xmax)
	{
		System.out.println(this.xmax);
		this.xmax.setText(xmax);
	}

	/**
	 * @return xscl     xscl field text
	 */
	public String getXsclField()
	{
		return xscl.getText();
	}

	/**
	 * @param xscl      xscl field text to set
	 */
	public void setXsclField(String xscl)
	{
		this.xscl.setText(xscl);
	}

	/**
	 * @return ymin     ymin field text
	 */
	public String getYminField() {
		return ymin.getText();
	}

	/**
	 * @param ymin      ymin field text to set
	 */
	public void setYminField(String ymin)
	{
		this.ymin.setText(ymin);
	}

	/**
	 * @return ymax     ymax field text
	 */
	public String getYmaxField() {
		return ymax.getText();
	}

	/**
	 * @param ymax      ymax field text to set
	 */
	public void setYmaxField(String ymax)
	{
		this.ymax.setText(ymax);
	}

	/**
	 * @return yscl     yscl field text
	 */
	public String getYsclField()
	{
		return yscl.getText();
	}

	/**
	 * @param yscl      yscl field text to set
	 */
	public void setYsclField(String yscl)
	{
		this.yscl.setText(yscl);
	}

}