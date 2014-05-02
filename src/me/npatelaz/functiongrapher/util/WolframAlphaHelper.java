package me.npatelaz.functiongrapher.util;

import com.wolfram.alpha.*;
import me.npatelaz.functiongrapher.config.WolframAlphaDisplay;

/**
 * Description
 *
 * Nikhil Patel
 * File created on Apr 21, 2014
 */
public class WolframAlphaHelper
{
	/**
	 * Queries Wolfram Alpha
	 *
	 * @param queryText     text to query
	 */
	public void query(String queryText)
	{
		WolframAlphaRunnable wolframAlphaRunnable = new WolframAlphaRunnable(queryText);
		Thread thread = new Thread(wolframAlphaRunnable);
		thread.start();
	}


	/**
	 * Runnable class to query Wolfram Alpha
	 */
	private class WolframAlphaRunnable implements Runnable
	{
		private String queryText;
		private String resultText;

		/**
		 * Constructor to set query text
		 * @param queryText     text to query
		 */
		public WolframAlphaRunnable(String queryText)
		{
			this.queryText = queryText;
		}

		/**
		 * Queries, then directly sets the Wolfram Alpha text field.
		 * Although this is a terrible way to do it (high coupling, no separation of MVC, etc) I'm not sure how else to get this to work.
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
			resultText = "";

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
			WolframAlphaDisplay.getInstance().setQueryResult(resultText);

		}
	}
}