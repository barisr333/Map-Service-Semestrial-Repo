package guiControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class HelpPopupController.
 */
public class HelpPopupController {

    /** The closebtn. */
    @FXML
    private Button closebtn;

    /**
     * Close on clike.
     *
     * @param event the event
     */
    @FXML
    void closeOnClike(ActionEvent event) {
    	Stage stage = (Stage) closebtn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }


}
