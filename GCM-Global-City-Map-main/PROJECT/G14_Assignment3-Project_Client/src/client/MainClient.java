// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com

package client;

import ocsf.client.*;
import java.io.*;
import client.MainClient;
import systemFunctionality.ClientMemberController;
import systemFunctionality.ClassQueryIdentification;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class MainClient extends AbstractClient
{
  //Instance variables **********************************************
	private static MainClient client = null;
	private ClientMemberController clientMemberController;
	private ClassQueryIdentification classQueryIdentification;
  /**
   * The interface type variable.  It allows the implementation of
   * the display method in the client.
   */


  //Constructors ****************************************************

  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */

  public MainClient(String host, int port) throws IOException {
	  super(host, port); //Call the superclass constructor
    openConnection();
    if (isConnected() == false) {
		throw new IOException("Could not connect to server.");
	}
    System.out.println("Connected");
    clientMemberController = null;
    classQueryIdentification = null;
  }


  //Instance methods ************************************************

  	public ClassQueryIdentification getClassQueryIdentification() {
		return classQueryIdentification;
	}


	public void SetClassQueryIdentification(ClassQueryIdentification classQueryIdentification) {
		this.classQueryIdentification = classQueryIdentification;
	}


  	public void SetClientMemberController(ClientMemberController clientMemberController) {
		this.clientMemberController = clientMemberController;
	}



	public ClientMemberController getClientMemberController() {
		return clientMemberController;
	}


	public static MainClient GetClient() {
		if (client != null) {
			return client;
		}
		return null;
	}

	public static MainClient GetClient(String host, int port) throws Exception {
		if (client == null) {
			client = new MainClient(host, port);
		}
		return client;
	}

	  //Instance methods ************************************************
  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  public void handleMessageFromServer(Object msg)
  {
	  classQueryIdentification.ChooseQuery(msg);
  }

  /**
   * This method handles all data coming from the UI
   *
   * @param message The message from the UI.
   */
  public void handleMessageFromClientUI(String message)
  {
    try
    {
    	sendToServer(message);
    }
    catch(IOException e)
    {
      //clientUI.display
       // ("Could not send message to server.  Terminating client.");
      quit();
    }
  }

  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }

  public void logout()
  {
	  this.handleMessageFromClientUI("Logout, ");
  }
}
//End of ChatClient class
