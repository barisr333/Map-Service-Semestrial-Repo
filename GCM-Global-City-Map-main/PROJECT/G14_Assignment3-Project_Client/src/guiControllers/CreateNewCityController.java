package guiControllers;

import java.io.IOException;
import javafx.scene.layout.HBox;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//import serverFunctionality.ServerLogger;
import systemFunctionality.ClientMemberController;
import systemFunctionality.ValidationTests;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import entities.City;
import entities.Countries;
import entities.User;

// TODO: Auto-generated Javadoc
/**
 * CreateNewCityController - GUI controller for "CreateNewCity.fxml"
 */
public class CreateNewCityController {
	// -------------------------------------------------------------------------------------------//
	// GUI components
	// attribute------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/** The image content emp. */
	@FXML
	private ImageView image_content_emp;

	/** The gcm manager. */
	@FXML
	private ImageView gcm_manager;

	/** The image gcm content manger. */
	@FXML
	private ImageView image_gcm_content_manger;

	/** The back btn. */
	@FXML
	private Button backBtn;

	/** The btn view catalg. */
	@FXML
	private Button btnView_Catalg;

	/** The btn edit prfile. */
	@FXML
	private Button btnEdit_Prfile;

	/** The btn publish new version. */
	@FXML
	private Button btn_Publish_New_Version;

	/** The btn edit map. */
	@FXML
	private Button btn_Edit_Map;

	/** The Add city. */
	@FXML
	private Button Add_city;

	/** The cityname txt. */
	@FXML
	private TextField citynameTxt;

	/** The description txt. */
	@FXML
	private TextArea description_Txt;

	/** The Country cbx. */
	@FXML
	private ComboBox<String> CountryCbx;

	/** The Tab menu. */
	@FXML
	private HBox TabMenu;

	// -------------------------------------------------------------------------------------------//
	// Internal Class
	// attributes-----------------------------------------------------------------//
	/** The client member controller. */
	// -------------------------------------------------------------------------------------------//
	private ClientMemberController clientMemberController;
	
	/** The create new city controller. */
	public static CreateNewCityController createNewCityController;
	
	/** The country list. */
	ObservableList<String> countryList;
	
	/** The str. */
	private String str[] = new String[3];
	
	/** The city counter. */
	public int cityCounter = 0;
	
	/** The city. */
	public City city;
	// -------------------------------------------------------------------------------------------//
	// Getters and setters
	// methods---------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Instantiates a new creates the new city controller.
	 */
	public CreateNewCityController() {
		createNewCityController = this;
	}

	/**
	 * Sets the client member controller.
	 *
	 * @param clientMemberController the new client member controller
	 */
	public void setClientMemberController(ClientMemberController clientMemberController) {
		this.clientMemberController = clientMemberController;
	}

	/**
	 * Gets the create new city controller.
	 *
	 * @return the creates the new city controller
	 */
	public static CreateNewCityController GetCreateNewCityController() {
		if (createNewCityController == null)
			createNewCityController = new CreateNewCityController();
		return createNewCityController;
	}

	// -------------------------------------------------------------------------------------------//
	// Initialize method - Happens when the fxml file
	// load---------------------------------------//
	/**
	 * Initialize.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// -------------------------------------------------------------------------------------------//
	@FXML
	void initialize() throws IOException {
		if (gcmMainController.user.getPermission() == 1)
			TabMenu.setVisible(false);
		else
			TabMenu.setVisible(true);

		if ((gcmMainController.user.getPermission() == 2) || (gcmMainController.user.getPermission() == 3)) {
			btn_Edit_Map.setVisible(false);
			btn_Publish_New_Version.setVisible(false);
		}
// Check which user is logged in
		if (gcmMainController.user.getPermission() == 1)
			gcm_manager.setVisible(true);
		if (gcmMainController.user.getPermission() == 2)
			image_content_emp.setVisible(true);
		if (gcmMainController.user.getPermission() == 3)
			image_gcm_content_manger.setVisible(true);

		clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setClientCreateNewCityController(this);
		clientMemberController.sendToServerCountry(); // Load country combo box
	}

	// -------------------------------------------------------------------------------------------//
	// Cases of events from
	// GUI------------------------------------------------------------------//
	/**
	 * Back on click.
	 *
	 * @param event the event
	 */
	// -------------------------------------------------------------------------------------------//
	@FXML
	void backOnClick(MouseEvent event) {
		EditMapContent.flag1 = 0;
		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("/fxml/EditMapContent.fxml"));
			Scene scene = new Scene(root, 850, 650);
			scene.getStylesheets().add(getClass().getResource("/fxml/EditMapContent.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Edit Map Content");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * On click edit prfile.
	 *
	 * @param event the event
	 */
	@FXML
	void OnClick_Edit_Prfile(MouseEvent event) {
		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("/fxml/EditProfile.fxml"));
			Scene scene = new Scene(root, 850, 650);
			scene.getStylesheets().add(getClass().getResource("/fxml/EditProfile.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Edit Profile Window");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * On click view catalg.
	 *
	 * @param event the event
	 */
	@FXML
	void OnClick_View_Catalg(MouseEvent event) {
		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("/fxml/ViewCatalog.fxml"));
			Scene scene = new Scene(root, 850, 695);
			scene.getStylesheets().add(getClass().getResource("/fxml/ViewCatalog.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("View Catalog Window");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * On click publish new version.
	 *
	 * @param event the event
	 */
	@FXML
	void On_Click_Publish_New_Version(MouseEvent event) {

		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("/fxml/PublishNewVersionOfMap.fxml"));
			Scene scene = new Scene(root, 850, 650);
			scene.getStylesheets().add(getClass().getResource("/fxml/PublishNewVersionOfMap.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Publish New Version Of Map Window");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * On click edit map.
	 *
	 * @param event the event
	 */
	@FXML
	void On_Click_Edit_Map(MouseEvent event) {

		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("/fxml/EditMapContent.fxml"));
			Scene scene = new Scene(root, 850, 650);
			scene.getStylesheets().add(getClass().getResource("/fxml/EditMapContent.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Edit Map Content Window");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Click add city.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void Click_Add_City(MouseEvent event) throws IOException {

		if (checkFields()) {

			city = new City();
			city.setCountry(CountryCbx.getValue());
			city.setName(citynameTxt.getText());
			city.setDescription(description_Txt.getText());
			gcmMainController.CityList.add(city);

			str[0] = citynameTxt.getText();
			str[1] = CountryCbx.getValue();
			str[2] = description_Txt.getText();
			clientMemberController.sendToServerCity(str);
			ValidationTests.printInfoMsg("City created", "City successfully created!");
			clear_value();
		}
		CountryCbx.setValue(null);
	}

	/**
	 * Clear value.
	 */
	public void clear_value() {
		citynameTxt.setText("");
		CountryCbx.setValue("");
		description_Txt.setText("");

	}


	/**
	 * Mouse exit.
	 *
	 * @param event the event
	 */
	@FXML
	void mouse_exit(MouseEvent event) {

		Button n;
		n = (Button) event.getSource();
		n.setStyle("-fx-background-color : #f0f0f0;-fx-border-color :  #f0f0f0");
	}

	/**
	 * Mouse hover.
	 *
	 * @param event the event
	 */
	@FXML
	void mouse_hover(MouseEvent event) {
		Button n;
		n = (Button) event.getSource();
		n.setStyle("-fx-background-color : #BDBBC3");
	}
	// -------------------------------------------------------------------------------------------//
	// Internal
	// functions------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	//////////////// Loading a country list into the
	/**
	 * Load country combo box.
	 *
	 * @param arr the arr
	 */
	//////////////// combobox////////////////////////
	public void loadComboBox(ArrayList<String> arr) {

		countryList = FXCollections.observableArrayList(arr);
		CountryCbx.setItems(countryList);
	}

	// -------------------------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Check fields.
	 *
	 * @return true, if successful
	 */
	public boolean checkFields() {
		if(CountryCbx.getValue()==null)
		{
			ValidationTests.printErrorMsg("Error", "You must select a country!");
			return false;
		}
		if (ValidationTests.isFieldEmpty(citynameTxt.getText()))
			return false;
		if (!ValidationTests.isCityNameValid(citynameTxt.getText()))
			return false;
		if (ValidationTests.isFieldEmpty(description_Txt.getText()))
			return false;
		return true;

	}

}
