package guiMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchasemapWindow.
 */
public class PurchasemapWindow extends Application {

	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/Purchasemap.fxml"));
			//Scene scene = new Scene(root,800,451);
			Scene scene = new Scene(root,850,650);
			scene.getStylesheets().add(getClass().getResource("/fxml/Purchasemap.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Purchase map Window");
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
