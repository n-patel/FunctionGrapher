package me.npatelaz.functiongrapher.util;

import java.beans.*;
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
			xmlEncoder.setExceptionListener(new ExceptionListener()
			{
				@Override
				public void exceptionThrown(Exception e)
				{
					e.printStackTrace(System.out);
				}
			});
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
			xmlDecoder.setExceptionListener(new ExceptionListener()
			{
				@Override
				public void exceptionThrown(Exception e)
				{
					e.printStackTrace(System.out);
				}
			});
			object = xmlDecoder.readObject();
			xmlDecoder.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return object;
	}
}
