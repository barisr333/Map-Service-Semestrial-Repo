package guiMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class registerWindow.
 */
public class registerWindow extends Application {

	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/registerFXML.fxml"));
			//Scene scene = new Scene(root,800,451);
			Scene scene = new Scene(root,850,650);
			scene.getStylesheets().add(getClass().getResource("/fxml/registerCSS.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Register");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
