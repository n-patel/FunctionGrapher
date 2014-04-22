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

	public String getXmin()
	{
		return xmin.getText();
	}

	public void setXmin(String xmin)
	{
		System.out.println(this.xmin);
		this.xmin.setText(xmin);
	}

	public String getXmax()
	{
		return xmax.getText();
	}

	public void setXmax(String xmax)
	{
		System.out.println(this.xmax);
		this.xmax.setText(xmax);
	}

	public String getXscl()
	{
		return xscl.getText();
	}

	public void setXscl(String xscl)
	{
		this.xscl.setText(xscl);
	}

	public String getYmin() {
		return ymin.getText();
	}

	public void setYmin(String ymin)
	{
		this.ymin.setText(ymin);
	}

	public String getYmax() {
		return ymax.getText();
	}

	public void setYmax(String ymax)
	{
		this.ymax.setText(ymax);
	}

	public String getYscl()
	{
		return yscl.getText();
	}

	public void setYscl(String yscl)
	{
		this.yscl.setText(yscl);
	}

}