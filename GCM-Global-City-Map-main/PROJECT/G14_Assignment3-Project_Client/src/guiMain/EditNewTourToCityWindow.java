package guiMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


  // TODO: Auto-generated Javadoc
/**
   * The Class EditNewTourToCityWindow.
   */
  public class EditNewTourToCityWindow extends Application {

	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/EditNewTourToCity.fxml"));
			Scene scene = new Scene(root,850,650);
			scene.getStylesheets().add(getClass().getResource("/fxml/EditNewTourToCity.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Edit New Tour To City Window");
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
