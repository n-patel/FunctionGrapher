package me.npatelaz.functiongrapher.util;

import me.npatelaz.functiongrapher.config.AxesConfig;
import me.npatelaz.functiongrapher.config.FunctionConfig;

import java.io.*;
import java.util.Properties;

/**
 * Handles reading and writing of the config to a properties file
 *
 * Nikhil Patel
 * File created on Apr 24, 2014
 */
public class FileIO
{
	/**
	 * Read from a config properties file and set fields in application
	 * @param file      file to read from
	 */
	public void readConfig(File file)
	{
		Properties properties = new Properties();
		InputStream inputStream;
		try
		{
			// Open stream to load file
			inputStream = new FileInputStream(file);

			// Load up the properties
			properties.load(inputStream);

			// Set fields to property values
			FunctionConfig.getInstance().setFunction(properties.getProperty("function"));
			FunctionConfig.getInstance().setColor(properties.getProperty("color"));
			FunctionConfig.getInstance().setBrushstroke(Float.parseFloat(properties.getProperty("brushstroke")));
			AxesConfig.getInstance().setXminField(properties.getProperty("xmin"));
			AxesConfig.getInstance().setXmaxField(properties.getProperty("xmax"));
			AxesConfig.getInstance().setXsclField(properties.getProperty("xscl"));
			AxesConfig.getInstance().setYminField(properties.getProperty("ymin"));
			AxesConfig.getInstance().setYmaxField(properties.getProperty("ymax"));
			AxesConfig.getInstance().setYsclField(properties.getProperty("yscl"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}


	/**
	 * Writes field values in application to a config properties file
	 * @param file      file to write to
	 */
	public void writeConfig(File file)
	{
		Properties properties = new Properties();
		OutputStream outputStream;
		try
		{
			outputStream = new FileOutputStream(file);

			// Set properties from the form fields
			properties.setProperty("function",      FunctionConfig.getInstance().getFunction());
			properties.setProperty("color",         FunctionConfig.getInstance().getColor());
			properties.setProperty("brushstroke",   String.valueOf(FunctionConfig.getInstance().getBrushstroke()));
			properties.setProperty("xmin",          AxesConfig.getInstance().getXminField());
			properties.setProperty("xmax",          AxesConfig.getInstance().getXmaxField());
			properties.setProperty("xscl",          AxesConfig.getInstance().getXsclField());
			properties.setProperty("ymin",          AxesConfig.getInstance().getYminField());
			properties.setProperty("ymax",          AxesConfig.getInstance().getYmaxField());
			properties.setProperty("yscl",          AxesConfig.getInstance().getYsclField());

			// Save file and close stream
			properties.store(outputStream, null);
			outputStream.flush();
			outputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
