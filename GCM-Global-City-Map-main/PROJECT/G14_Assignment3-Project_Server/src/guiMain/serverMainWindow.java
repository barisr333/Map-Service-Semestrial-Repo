package guiMain;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
//import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import server.EchoServer;
import guiControllers.ServerMainController;

// TODO: Auto-generated Javadoc
/**
 * The Class serverMainWindow.
 */
public class serverMainWindow extends Application {
	
	/** The main stage. */
	//The Object of the gui controller and serverlistener//
	private static Stage mainStage;
	
	/** The server controller. */
	private static ServerMainController serverController;
	/**
	   * The default port to listen on.
	   */
	final public static int DEFAULT_PORT = 5555;
	  
	/** The openserver. */
	public static EchoServer openserver;
	
	
	/**
	 * Gets the server controller.
	 *
	 * @return the server controller
	 */
	public static ServerMainController getServerController() {
		return serverController;
	}

	/**
	 * Sets the server controller.
	 *
	 * @param serverController the new server controller
	 */
	public static void setServerController(ServerMainController serverController) {
		serverMainWindow.serverController = serverController;
	}

	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//the method that starts the gui windows//
	@Override
	public void start(Stage primaryStage) throws IOException{
		try {
			/*BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("ServerWindow.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
			mainStage = primaryStage;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ServerWindow.fxml"));
			StackPane pane = (StackPane)loader.load();
			Scene scene = new Scene(pane);
			serverController = (ServerMainController)loader.getController();
			// setting the stage
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/fxml/ServerIcon.png")));
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.setTitle("GCM Server");
			primaryStage.show();
		} 
		catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	/**
	 * Gets the main stage.
	 *
	 * @return the main stage
	 */
	//get returns the call object//
	public static Stage getMainStage() {
		return mainStage;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	//the main that runs when the jar opens//
	public static void main(String[] args) {
		launch(args);
	}

}
