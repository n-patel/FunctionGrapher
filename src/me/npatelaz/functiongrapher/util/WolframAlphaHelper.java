package me.npatelaz.functiongrapher.util;

import com.wolfram.alpha.*;
import me.npatelaz.functiongrapher.listener.TaskListener;

import java.util.*;

/**
 * Utility class to queryText Wolfram Alpha.
 *
 * Nikhil Patel
 * File created on Apr 21, 2014
 */
public class WolframAlphaHelper
{
	private WolframAlphaRunnable wolframAlphaRunnable = new WolframAlphaRunnable();


	/**
	 * Queries Wolfram Alpha
	 *
	 * @param queryText     text to queryText
	 */
	public void query(String queryText)
	{
		// Set the queryText text
		wolframAlphaRunnable.setQueryText(queryText);

		// Start the Wolfram Alpha thread
		Thread thread = new Thread(wolframAlphaRunnable);
		thread.start();
	}


	/**
	 * @return resultText       result of the queryText
	 */
	public String getResultText()
	{
		return wolframAlphaRunnable.getResultText();
	}


	/**
	 * Adds a listener to the runnable
	 * @param listener      listener to add
	 */
	public void addListenerToRunnable(TaskListener listener)
	{
		wolframAlphaRunnable.addListener(listener);
	}


	/**
	 * Removes a listener from the runnable
	 * @param listener      listener to remove
	 */
	public void removeListenerFromRunnable(TaskListener listener)
	{
		wolframAlphaRunnable.removeListener(listener);
	}



	/**
	 * Runnable class to queryText Wolfram Alpha
	 */
	private class WolframAlphaRunnable implements Runnable
	{
		private String queryText;
		private String resultText;

		/**
		 * Queries, then notifies all listeners of its completion
		 */
		@Override
		public void run()
		{
			// Set up WolframAlpha engine
			WAEngine engine = new WAEngine();
			engine.setAppID("KGQA7X-WR86X7AL2K");
			engine.addFormat("plaintext");

			// Set up WolframAlpha queryText
			WAQuery query = engine.createQuery();
			query.setInput(queryText);

			try
			{
				WAQueryResult queryResult = engine.performQuery(query);

				if (queryResult.isError())
				{
					resultText = "Query error: " + queryResult.getErrorMessage() + "(code " + queryResult.getErrorCode() + ").";
				}
				else if (!queryResult.isSuccess())
				{
					resultText = "No results available.";
				}
				else
				{
					resultText = "";
					for (WAPod pod : queryResult.getPods())
					{
						if (!pod.isError() && !pod.getTitle().contains("Plot"))
						{
							resultText += pod.getTitle() + "\n";
							resultText += "------------" + "\n";

							for (WASubpod subpod : pod.getSubpods())
							{
								for (Object element : subpod.getContents())
								{
									if (element instanceof WAPlainText)
									{
										resultText += ((WAPlainText)element).getText() + "\n";
									}
								}
							}
							resultText += "\n";
						}
					}
				}
			}
			catch (WAException e)
			{
				e.printStackTrace();
			}

			notifyListeners();
		}


		/**
		 * @param queryText     query text to set
		 */
		private void setQueryText(String queryText)
		{
			this.queryText = queryText;
		}


		/**
		 * @return resultText     query result text
		 */
		private String getResultText()
		{
			return resultText;
		}


		/*
		 * Thanks to http://www.algosome.com/articles/knowing-when-threads-stop.html for this idea.
		 * This code works to notify all listeners that the thread has been completed
		 */
		private final List<TaskListener> listeners = Collections.synchronizedList(new ArrayList<TaskListener>());


		/**
		 * Adds a listener
		 * @param listener      listener to add
		 */
		public void addListener(TaskListener listener)
		{
			listeners.add(listener);
		}


		/**
		 * Removes a listener
		 * @param listener      listener to remove
		 */
		public void removeListener(TaskListener listener)
		{
			listeners.remove(listener);
		}


		/**
		 * Notifies all listeners that the thread has finished
		 */
		public void notifyListeners()
		{
			synchronized (listeners)
			{
				for (TaskListener listener : listeners)
				{
					listener.threadComplete(this);
				}
			}
		}

	}

}