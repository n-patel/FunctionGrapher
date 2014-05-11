package me.npatelaz.functiongrapher.listener;

/**
 * An interface that can be used to notify listening objects that a task is complete.
 * Idea from http://www.algosome.com/articles/knowing-when-threads-stop.html.
 *
 * Nikhil Patel
 * File created on May 11, 2014
 */
public interface TaskListener
{
	/**
	 * Notifies this object that the Runnable object has finished
	 * @param runner        Runnable interface whose work has been completed
	 */
	public void threadComplete(Runnable runner);
}
