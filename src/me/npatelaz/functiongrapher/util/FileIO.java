package me.npatelaz.functiongrapher.util;

import me.npatelaz.functiongrapher.config.AxesConfig;
import me.npatelaz.functiongrapher.config.FunctionConfig;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

/**
 * Description
 *
 * Nikhil Patel
 * File created on Apr 24, 2014
 */
public class FileIO
{
	public void writeToFile(Object object, String filePath)
	{
		try
		{
			XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filePath)));
			xmlEncoder.writeObject(object);
			xmlEncoder.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public Object readFromFile(String filePath)
	{
		Object object = null;
		try
		{
			XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filePath)));
			object = xmlDecoder.readObject();
			xmlDecoder.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return object;
	}


	public void writeConfig(String fileName)
	{
		String function = FunctionConfig.getInstance().getFunction();
		String color    = String.valueOf(FunctionConfig.getInstance().getColor());
		String brush    = String.valueOf(FunctionConfig.getInstance().getBrushstroke());
		String xmin = AxesConfig.getInstance().getXminField();
		String xmax = AxesConfig.getInstance().getXmaxField();
		String xscl = AxesConfig.getInstance().getXsclField();
		String ymin = AxesConfig.getInstance().getYminField();
		String ymax = AxesConfig.getInstance().getYmaxField();
		String yscl = AxesConfig.getInstance().getYsclField();

		String[] values= {function, color, brush, xmin, xmax, xscl, ymin, ymax, yscl};

		try
		{
			FileWriter fileWriter = new FileWriter(new File(fileName));
			for (String s : values)
			{
				fileWriter.write(s + "\n");
			}
			fileWriter.flush();
			fileWriter.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
