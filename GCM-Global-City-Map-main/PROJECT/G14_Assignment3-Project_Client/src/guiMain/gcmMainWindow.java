package guiMain;

import java.io.IOException;
import java.net.ConnectException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import client.MainClient;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// TODO: Auto-generated Javadoc
/**
 *  gcmMainWindow - The class opened after the first loading page.
 *	The class also work with the server that include some connection 
 *	with SQL.
 */
public class gcmMainWindow extends Application {
	/**
	 * start(Stage primaryStage) - Shows the gcmFXML.fxml page.
	 * @param primaryStage - the scene that shown is gcmCSS.css
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/gcmFXML.fxml"));
			Scene scene = new Scene(root,850,650);
			scene.getStylesheets().add(getClass().getResource("/fxml/gcmCSS.css").toExternalForm());
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/fxml/icon.png")));
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("GCM System");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * createConnection - Function that get server ip from the input field from the user, 
	 * and connect to this server ip.
	 * Also, the method thats create a socket and connect to the server TCP.
	 *
	 * @param ip the ip
	 */
	public static void createConnection(String ip)
	{
		try { 
		int port= 5555;
			System.out.println("Connecting to (default): " + ip + ", port: " + port);
			MainClient.GetClient(ip, port);//192.168.14.194	
	}  catch (ConnectException e) {
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Conecttion error");
				alert.setHeaderText(null);
				alert.setContentText("Could not connect to server.");
				alert.showAndWait(); 	    }
			});
	} catch (NumberFormatException | IOException e) {
		e.printStackTrace();
		System.out.println("error1");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("error2");
	   }	
		
   }
	
	/** main(String[] args) - Main menu, .
	 * @param args - Main page, the main that runs when the jar opens.
	 */
	public static void main(String[] args) {

		launch(args);
	}
	
	/**
	 * Gets the my ip.
	 *
	 * @return the string
	 */
	@SuppressWarnings("unused")
	private static String GetMyIp() {
		try (final DatagramSocket socket = new DatagramSocket()) {
		    socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
		    return socket.getLocalAddress().getHostAddress();
		} catch (UnknownHostException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (SocketException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
		return null;
	    }
	
}
