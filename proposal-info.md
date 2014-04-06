FunctionGrapher Proposal
=====================

FunctionGrapher will allow users to visualize functions and interact with them in various ways.  It will be a desktop Swing application with two panels, a graph panel and a configuration panel.  The graph panel will be the larger of the two panels and will contain the graph of the function as well as the x- and y-axes.  The config panel will contain text fields and buttons to edit the attributes of the graph (e.g. change the axes lengths and scales) and perform other tasks (e.g. pull information from WolframAlpha).  Users will also have the option of saving a function and its configuration to a file to be loaded again at a later point in time.

The program can be started by executing a JAR artifact, which will be built and uploaded to this repository when the project is completed.  Upon executing the JAR, a JFrame will appear with the graph and configuration panels.  Users can influence the graph panel by inputting values into text fields in the configuration panel.  Some text fields will only allow ints (e.g. axis scaling) while others will allow strings (e.g. function to graph).  Each field will be validated before being reflected on the graph to reduce the chance of users accidentally breaking the program.  When users want to quit the program, they can simply close the frame.

I'm excited to work with Java Swing and the WolframAlpha API, as I have little experience designing GUIs in Java and no experience with working with web APIs.  I will research the WolframAlpha Webservice API by using the [official documentation](http://products.wolframalpha.com/api/documentation.html).

There will be many challenges while designing this program:
- Working with Swing
	- Splitting the frame into two panels and managing the size of each when the window is resized
	- Using a layout manager to arrange the buttons and fields on the configuration panel
	- Working with listeners/events
- File I/O: Saving and loading configurations
- Utilizing the WolframAlpha API (a RESTful web API using HTTP GET requests) which returns XML
	- Parsing the XML to display the information in the application
