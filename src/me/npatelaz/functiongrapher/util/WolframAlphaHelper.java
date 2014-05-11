package me.npatelaz.functiongrapher.util;

import com.wolfram.alpha.*;
import me.npatelaz.functiongrapher.listener.TaskListener;

import java.util.*;

/**
 * Utility class to query Wolfram Alpha.
 *
 * Nikhil Patel
 * File created on Apr 21, 2014
 */
public class WolframAlphaHelper
{
	private String queryText;
	private String resultText;

	/**
	 * Queries Wolfram Alpha
	 *
	 * @param queryText     text to query
	 */
	public void query(String queryText, TaskListener listener)
	{
		// Sets the query text
		this.queryText = queryText;

		// Sets up and starts Wolfram Alpha runnable
		WolframAlphaRunnable wolframAlphaRunnable = new WolframAlphaRunnable();
		wolframAlphaRunnable.addListener(listener);
		Thread thread = new Thread(wolframAlphaRunnable);
		thread.start();
	}


	/**
	 * Runnable class to query Wolfram Alpha
	 */
	private class WolframAlphaRunnable implements Runnable
	{
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

			// Set up WolframAlpha query
			WAQuery query = engine.createQuery();
			query.setInput(queryText);

			WAQueryResult queryResult;

			try
			{
				queryResult = engine.performQuery(query);

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
			//WolframAlphaDisplay.getInstance().setQueryResult(resultText);
		}

		private final List<TaskListener> listeners = Collections.synchronizedList(new ArrayList<TaskListener>());

		public void addListener(TaskListener listener)
		{
			listeners.add(listener);
		}

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

	public String getResultText()
	{
		return this.resultText;
	}
}