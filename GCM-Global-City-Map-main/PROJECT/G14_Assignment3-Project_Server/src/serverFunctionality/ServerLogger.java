
package serverFunctionality;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import guiControllers.ServerMainController;

// TODO: Auto-generated Javadoc
/**
 * The Class ServerLogger.
 * This class is responsible for printing any string we want onto the Server Logger, seen in the Server UI. The logger is used to track actions on the server,
 * requests from the client, etc, and is useful for debugging and finding problems.
 */
public class ServerLogger {

	/** The server main controller. */
	public static ServerMainController serverMainController;

	/**
	 * The Enum Destination.
	 */
	public enum Destination {
		
		/** The ui. */
		UI, 
 /** The Console. */
 Console, 
 /** The File. */
 File, 
 /** The All. */
 All;
	}

	/**
	 * Sets the server window controller.
	 *
	 * @param controller the new server window controller
	 */
	//the method that set the object//
	public static void setServerWindowController(ServerMainController controller) {
		serverMainController = controller;
	}
   
	/**
	 * Write new line.
	 *
	 * @param msg the msg
	 */
	//the methods that write into the server gui//
	public static void writeNewLine(String msg) {
		writeNewLine(msg, Destination.UI);
	}

	/**
	 * Write new line.
	 *
	 * @param msg the msg
	 * @param whereToWrite the where to write
	 */
	public static void writeNewLine(String msg, Destination whereToWrite) {
		String timeStamp = new SimpleDateFormat("[HH:mm:ss]  ").format(Calendar.getInstance().getTime());

		if (whereToWrite.equals(Destination.UI)) {
			serverMainController.AddMsgToLog(timeStamp + msg + "\n");
		} 
		else {

		}
	}
}
