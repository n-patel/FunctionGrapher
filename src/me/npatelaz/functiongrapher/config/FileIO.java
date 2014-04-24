package me.npatelaz.functiongrapher.config;

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
	public void writeToFile(Serializable object, String filePath)
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
}
