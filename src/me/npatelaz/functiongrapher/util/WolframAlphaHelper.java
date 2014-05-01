package me.npatelaz.functiongrapher.util;

import com.wolfram.alpha.*;

/**
 * Description
 *
 * Nikhil Patel
 * File created on Apr 21, 2014
 */
public class WolframAlphaHelper
{
	/**
	 * Returns a string containing the query result for a given input
	 * @param queryText     text to query
	 * @return              query result from WolframAlpha
	 */
	public static String query(String queryText)
	{
		// Set up WolframAlpha engine
		WAEngine engine = new WAEngine();
		engine.setAppID("KGQA7X-WR86X7AL2K");
		engine.addFormat("plaintext");

		// Set up WolframAlpha query
		WAQuery query = engine.createQuery();
		query.setInput(queryText);

		WAQueryResult queryResult;
		String queryResultText = "";

		try
		{
			queryResult = engine.performQuery(query);

			if (queryResult.isError())
			{
				queryResultText = "Query error: " + queryResult.getErrorMessage() + "(code " + queryResult.getErrorCode() + ").";
			}
			else if (!queryResult.isSuccess())
			{
				queryResultText = "No results available.";
			}
			else
			{
				for (WAPod pod : queryResult.getPods())
				{
					if (!pod.isError() && !pod.getTitle().contains("Plot"))
					{
						queryResultText += pod.getTitle() + "\n";
						queryResultText += "------------" + "\n";

						for (WASubpod subpod : pod.getSubpods())
						{
							for (Object element : subpod.getContents())
							{
								if (element instanceof WAPlainText)
								{
									queryResultText += ((WAPlainText)element).getText() + "\n";
								}
							}
						}
						queryResultText += "\n";
					}
				}
			}
		}
		catch (WAException e)
		{
			e.printStackTrace();
		}

		return queryResultText;
	}

}

