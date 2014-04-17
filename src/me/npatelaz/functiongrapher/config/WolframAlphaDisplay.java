package me.npatelaz.functiongrapher.config;

import com.wolfram.alpha.*;

/**
 * Description
 *
 * Nikhil Patel
 * File created on Apr 17, 2014
 */
public class WolframAlphaDisplay
{
	private final String input;

	public WolframAlphaDisplay(String input)
	{
		this.input = input;
	}

	public void initializePanel()
	{
		WAEngine engine = new WAEngine();
		engine.setAppID("KGQA7X-WR86X7AL2K");
		engine.addFormat("plaintext");

		WAQuery query = engine.createQuery();

		query.setInput(input);

		try
		{
			System.out.println("Query URL:");
			System.out.println(engine.toURL(query));
			System.out.println("");

			WAQueryResult queryResult = engine.performQuery(query);

			if (queryResult.isError())
			{
				System.out.println("Query error");
				System.out.println("  error code: " + queryResult.getErrorCode());
				System.out.println("  error message: " + queryResult.getErrorMessage());
			}
			else if (!queryResult.isSuccess())
			{
				System.out.println("Query was not understood; no results available.");
			}
			else
			{
				// Got a result.
				System.out.println("Successful query. Pods follow:\n");
				for (WAPod pod : queryResult.getPods())
				{
					if (!pod.isError())
					{
						System.out.println(pod.getTitle());
						System.out.println("------------");
						for (WASubpod subpod : pod.getSubpods())
						{
							for (Object element : subpod.getContents())
							{
								if (element instanceof WAPlainText)
								{
									System.out.println(((WAPlainText) element).getText());
									System.out.println("");
								}
							}
						}
						System.out.println("");
					}
				}
			}
		}
		catch (WAException e)
		{
			e.printStackTrace();
		}
	}

}

