package guiMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


  // TODO: Auto-generated Javadoc
/**
   * The Class GcmManagerWindow.
   */
  public class GcmManagerWindow extends Application {

	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/GcmManager.fxml"));
			Scene scene = new Scene(root,797,611);
			scene.getStylesheets().add(getClass().getResource("/fxml/GcmManager.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Gcm Manager Window");
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
