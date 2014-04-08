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
public class FunctionConfig extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		MigLayout migLayout = new MigLayout("wrap 2");
		setLayout(migLayout);

		add(new JLabel("Function"));
		add(new JTextField(8), "gapleft 16");
		add(new JLabel("Color"));
		add(new JTextField(8), "gapleft 16");
	}
}
