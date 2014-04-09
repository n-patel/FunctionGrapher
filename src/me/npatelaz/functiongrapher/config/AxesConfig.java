package me.npatelaz.functiongrapher.config;

import me.npatelaz.functiongrapher.listener.AxesConfigListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Description
 *
 * Nikhil Patel
 * File created on Apr 07, 2014
 */
public class AxesConfig extends JPanel
{
	public void initializePanel()
	{
		MigLayout migLayout = new MigLayout("wrap 2");
		setLayout(migLayout);

		JTextField xmin = new JTextField(7);
		JTextField xmax = new JTextField(7);
		JTextField xscl = new JTextField(7);
		JTextField ymin = new JTextField(7);
		JTextField ymax = new JTextField(7);
		JTextField yscl = new JTextField(7);

		AxesConfigListener axesConfigListener = new AxesConfigListener();
		xmin.addActionListener(axesConfigListener);
		xmax.addActionListener(axesConfigListener);
		xscl.addActionListener(axesConfigListener);
		ymin.addActionListener(axesConfigListener);
		ymax.addActionListener(axesConfigListener);
		yscl.addActionListener(axesConfigListener);

		xmin.setActionCommand("XMIN");
		xmax.setActionCommand("XMAX");
		xscl.setActionCommand("XSCL");
		ymin.setActionCommand("YMIN");
		ymax.setActionCommand("YMAX");
		yscl.setActionCommand("YSCL");

		add(new JLabel("XMIN"));
		add(xmin, "gapleft 50");
		add(new JLabel("XMAX"));
		add(xmax, "gapleft 50");
		add(new JLabel("XSCL"));
		add(xscl, "gapleft 50");
		add(new JLabel("YMIN"));
		add(ymin, "gapleft 50");
		add(new JLabel("YMAX"));
		add(ymax, "gapleft 50");
		add(new JLabel("YSCL"));
		add(yscl, "gapleft 50");
	}
}
