package guiMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// TODO: Auto-generated Javadoc
/** loadingMainWindow -The first class that load the main page of the system. 
 * @author Bar Israel.
 * @author Kfir Gaon.
 * @author Rafael Moshayof.
 * @author Shoval Yehuda.
 * @author Roman Ratchitski.
 * @version Client 1.1 Build June 24, 2019.
 * */
public class loadingMainWindow extends Application {

	/** start(Stage primaryStage) - start function that run the stage.
	 * @param primaryStage - the scene that shown is loadingMainWindow.css
	 */
	
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/loadingMainWindow.fxml"));
			Scene scene = new Scene(root,550,350);
			scene.getStylesheets().add(getClass().getResource("/fxml/loadingMainWindow.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setTitle("GCM System");
			primaryStage.initStyle(StageStyle.UNDECORATED);
	        primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** main(String[] args) - Main menu, .
	 * @param args - Main page, the main that runs when the jar opens.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
