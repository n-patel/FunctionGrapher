package me.npatelaz.functiongrapher.config;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.Graphics;

/**
 * Description
 *
 * Nikhil Patel
 * File created on Apr 07, 2014
 */
public class AxesConfig extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		MigLayout migLayout = new MigLayout("wrap 2");
		setLayout(migLayout);

		add(new JLabel("XMIN"));
		add(new JTextField(7), "gapleft 50");
		add(new JLabel("XMAX"));
		add(new JTextField(7), "gapleft 50");
		add(new JLabel("XSCL"));
		add(new JTextField(7), "gapleft 50");
		add(new JLabel("YMIN"));
		add(new JTextField(7), "gapleft 50");
		add(new JLabel("YMAX"));
		add(new JTextField(7), "gapleft 50");
		add(new JLabel("YSCL"));
		add(new JTextField(7), "gapleft 50");
	}
}
