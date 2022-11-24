package server;
// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import java.net.BindException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ocsf.server.*;
import serverFunctionality.mysqlConnection;
import guiControllers.ServerMainController;
import serverFunctionality.ServerLogger;
import serverFunctionality.ServerQueryIdentification;


/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
	//public mysqlConnection mySql = new mysqlConnection(); // sql connection class.
	private ServerQueryIdentification serverQueryIdentification; // The query identification class.
	static private ServerMainController serverMainController = null;// Server window controller with the components function.
	
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  

  public EchoServer(int port) 
  {
    super(port);
    serverQueryIdentification = new ServerQueryIdentification();
  }

  
  //Instance methods ************************************************
  
  public static ServerMainController getServerMainController() {
	return serverMainController;
}


public static void setServerMainController(ServerMainController serverMainController) {
	EchoServer.serverMainController = serverMainController;
}


/**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient (Object msg, ConnectionToClient client)
  {	
	   ServerLogger.writeNewLine("Message received from client: " + msg + " from " + client);
			try {
				client.sendToClient(serverQueryIdentification.ChooseQuery(msg,client));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
  }


  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
	
	//serverController.ServerStarted("Server listening for connections on port " + getPort() + ".");
	ServerLogger.writeNewLine("Server listening for connections on port " + getPort());
    
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
	
	/*	try {
			(SQLConnection.GetConnection()).CloseConnection();
		} catch (SQLException ex) {
				ServerLogger.writeNewLine("SQLException: " + ex.getMessage());
				ServerLogger.writeNewLine("SQLState: " + ex.getSQLState());
				ServerLogger.writeNewLine("VendorError: " + ex.getErrorCode());
			}
			*/
	   
  }
  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  public  void main(String[] args) 
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }
	
    
    try 
    {
      this.listen(); //Start listening for connections
    } catch (BindException bex) {
		ServerLogger.writeNewLine("Port already in use, choose another.");
	
	} catch (Exception ex) {
		ex.printStackTrace();
		ServerLogger.writeNewLine("ERROR - Could not listen for clients!");
	}
   }   
 
  //Class methods *************************************************** listen to a connection
    @Override
  	protected synchronized void clientConnected(ConnectionToClient client) {
  		super.clientConnected(client);
  		ServerLogger.serverMainController.clientConnected("Client connected: " + client.toString());
  	}

  //Class methods *************************************************** listen to a disconnection
  	@Override
  	protected synchronized void clientDisconnected(ConnectionToClient client) {
  		super.clientDisconnected(client);
  		ServerLogger.serverMainController.clientDisconnected("Client disconnected: " + client.toString());
  	}
     
  	
    //Class methods *************************************************** listen to exceptions
    
    @Override
  	protected synchronized void clientException(ConnectionToClient client, Throwable exception) {
  		super.clientException(client, exception);
  		ServerLogger.serverMainController.clientDisconnected("Client disconnected: " + client.toString());
  	}




	
}   	
   
 
	  
	  
	
