package guiControllers;

import java.awt.Desktop;
import entities.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import systemFunctionality.ClientMemberController;
import systemFunctionality.QueryCreator;
import systemFunctionality.ValidationTests;
import javafx.scene.layout.HBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

// TODO: Auto-generated Javadoc
/**
 * The Class AddNewTourToCityControllers.
 */
public class AddNewTourToCityControllers {

	// -------------------------------------------------------------------------------------------//
	// GUI components
	// attribute------------------------------------------------------------------//
	/** The image content emp. */
	// -------------------------------------------------------------------------------------------//
	@FXML
	private ImageView image_content_emp;

	/** The gcm manager. */
	@FXML
	private ImageView gcm_manager;

	/** The image gcm content manger. */
	@FXML
	private ImageView image_gcm_content_manger;

	/** The add place btn. */
	@FXML
	private Button addPlaceBtn;

	/** The time area. */
	@FXML
	private TextArea timeArea;

	/** The desc area. */
	@FXML
	private TextArea descArea;

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

	/** The Tab menu. */
	@FXML
	private HBox TabMenu;

	/** The Country cbx. */
	@FXML
	private ComboBox<String> CountryCbx;

	/** The City cbx. */
	@FXML
	private ComboBox<String> CityCbx;

	/** The Name cbx. */
	@FXML
	private ComboBox<String> NameCbx;

	/** The name of tour txt. */
	@FXML
	private TextField name_of_tour_Txt;

	/** The add place btn. */
	@FXML
	private Button add_placeBtn;

	/** The add tour btn. */
	@FXML
	private Button add_tour_Btn;

	/** The order txt. */
	@FXML
	private TextField orderTxt;

	/** The added table. */
	@FXML
	private TableView<PointOfInterest> addedTable;

	/** The name col. */
	@FXML
	private TableColumn<PointOfInterest, String> nameCol;

	/** The type col. */
	@FXML
	private TableColumn<PointOfInterest, String> typeCol;

	/** The desc col. */
	@FXML
	private TableColumn<PointOfInterest, String> descCol;

	/** The acc col. */
	@FXML
	private TableColumn<PointOfInterest, String> accCol;

	/** The time col. */
	@FXML
	private TableColumn<PointOfInterest, String> timeCol;

	/** The address col. */
	@FXML
	private TableColumn<PointOfInterest, String> addressCol;

	/** The order col. */
	@FXML
	private TableColumn<PointOfInterest, String> orderCol;

	// -------------------------------------------------------------------------------------------//
	// Internal Class
	// attributes-----------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/** The client member controller. */
	private ClientMemberController clientMemberController;
	
	/** The add new tour to city controllers. */
	public static AddNewTourToCityControllers addNewTourToCityControllers;
	
	/** The country list. */
	ObservableList<String> countryList;
	
	/** The city list. */
	ObservableList<String> cityList;
	
	/** The Name palce list. */
	ObservableList<String> NamePalceList;
	
	/** The info. */
	private String[] info = new String[9];
	
	/** The cur tour. */
	public Tour curTour;
	
	/** The lock. */
	private Object lock = new Object();
	
	/** The lock 2. */
	private Object lock2 = new Object();
	
	/** The tour btn flag. */
	private boolean tourBtnFlag = false;
	
	/** The place btn flag. */
	private boolean placeBtnFlag = false;
	
	/** The index arr. */
	private ArrayList<Integer> indexArr;
	
	/** The on this page. */
	public boolean onThisPage = false;

	// -------------------------------------------------------------------------------------------//
	// Getters and setters
	// methods---------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Instantiates a new adds the new tour to city controllers.
	 */
	public AddNewTourToCityControllers() {
		addNewTourToCityControllers = this;
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
	 * Gets the add new tour to city controllers.
	 *
	 * @return the adds the new tour to city controllers
	 */
	public static AddNewTourToCityControllers GetAddNewTourToCityControllers() {
		if (addNewTourToCityControllers == null)
			addNewTourToCityControllers = new AddNewTourToCityControllers();
		return addNewTourToCityControllers;
	}
	// -------------------------------------------------------------------------------------------//
	// Initialize method - Happens when the fxml file
	// load---------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Initialize.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() throws IOException {
		synchronized (lock2) {
			if (gcmMainController.user.getPermission() == 1)
				TabMenu.setVisible(false);
			else
				TabMenu.setVisible(true);

			if ((gcmMainController.user.getPermission() == 2) || (gcmMainController.user.getPermission() == 3)) {
				btn_Edit_Map.setVisible(false);
				btn_Publish_New_Version.setVisible(false);
			}

			if (gcmMainController.user.getPermission() == 1)
				gcm_manager.setVisible(true);
			if (gcmMainController.user.getPermission() == 2)
				image_content_emp.setVisible(true);
			if (gcmMainController.user.getPermission() == 3)
				image_gcm_content_manger.setVisible(true);

			onThisPage = true;
			indexArr = new ArrayList<Integer>();
			descCol.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("description"));
			nameCol.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("name"));
			typeCol.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("type"));
			addressCol.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("address"));
			accCol.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("accessible"));
			timeCol.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("time"));
			orderCol.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("tourIndex"));
			addedTable.setStyle("-fx-focus-color: transparent;");

			clientMemberController = ClientMemberController.GetClientMemberController();
			clientMemberController.setClientAddNewTourToCityControllers(this);
			clientMemberController.sendToServerCountry();

			CountryCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By
																				// clicking
																				// on
																				// a
																				// value
																				// within
																				// the
																				// combobox,
																				// the
																				// state
																				// will
																				// be
																				// drawn//

				if (newItem != null) {
					try {
						clientMemberController.sendToServerState(CountryCbx.getValue().toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {

				}

			});

			CityCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By
																				// clicking
																				// on
																				// a
																				// value
																				// within
																				// the
																				// combobox,
																				// the
																				// state
																				// will
																				// be
																				// drawn//

				if (newItem != null) {
					try {
						clientMemberController.sendToServer_get_poi_by_city(CityCbx.getValue().toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {

				}
			});
		}

	}

	// -------------------------------------------------------------------------------------------//
	// Cases of events from
	// GUI------------------------------------------------------------------//
	/**
	 * Click on add place.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// -------------------------------------------------------------------------------------------//
	@FXML
	void ClickOnAddPlace(MouseEvent event) throws IOException {
		if (!tourBtnFlag)
			ValidationTests.printErrorMsg("Failure", "You must first create a tour!");

		else {
			if (checkPlace(orderTxt.getText())) { // Checking if order exists in tour
				String[] strArr = new String[5];
				strArr[0] = NameCbx.getValue().toString();
				strArr[1] = curTour.getCityname();
				strArr[2] = Integer.toString(curTour.getID());
				strArr[3] = Integer.toString(Integer.parseInt(orderTxt.getText()));
				indexArr.add(Integer.parseInt(orderTxt.getText()));
				clientMemberController.sendToServerGetPoiID(strArr); // Get POI's in tour
				curTour.incNum();
				synchronized (lock) {
					try {
						lock.wait(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					strArr[4] = Integer.toString(curTour.getPOIList().get(curTour.getPOIList().size() - 1).getId());
					clientMemberController.sendToServerAddPOIToTour(strArr);
					NameCbx.getItems().remove(strArr[0]);
				}
			}
		}
	}

	/**
	 * Back on click.
	 *
	 * @param event the event
	 */
	@FXML
	void backOnClick(MouseEvent event) {
		EditMapContent.flag9 = 0;
		try {
			onThisPage = false;
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
	 * Click on add tour.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void Click_on_add_tour(MouseEvent event) throws IOException {
		if (checkFields()) {
			push_info_text();
			curTour = new Tour(name_of_tour_Txt.getText(), descArea.getText(), timeArea.getText(),
					CityCbx.getValue().toString());
			clientMemberController.sendToServerTourInfo(info); // Insert tour
																// query
																// execution
			clientMemberController.sendToServerGetTourID(curTour.getName()); // Retrieve
																				// unique
																				// id
																				// of
																				// added
																				// tour
			tourBtnFlag = true;
			ValidationTests.printInfoMsg("Success", "Tour successfully created!");
			add_tour_Btn.setDisable(true);
		}
	}

	/**
	 * Push info text.
	 */
	public void push_info_text() {
		info[0] = CountryCbx.getValue().toString();
		info[1] = CityCbx.getValue().toString();
		info[2] = name_of_tour_Txt.getText();
		info[3] = timeArea.getText();
		info[4] = descArea.getText();
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

	//////////////// Loading a city list into the
	/**
	 * Load city combo box.
	 *
	 * @param arr the arr
	 */
	//////////////// combobox////////////////////////
	public void loadComboBox1(ArrayList<String> arr) {

		cityList = FXCollections.observableArrayList(arr);
		CityCbx.setItems(cityList);
	}

	//////////////// Loading a name place list into the
	/**
	 * Load combo box name place.
	 *
	 * @param arr the arr
	 */
	//////////////// combobox////////////////////////
	public void loadComboBoxNamePlace(ArrayList<String> arr) {

		NamePalceList = FXCollections.observableArrayList(arr);
		NameCbx.setItems(NamePalceList);
	}

	/**
	 * Sets the tour ID.
	 *
	 * @param arr the new tour ID
	 */
	//////////////// Retreive tour ID////////////////////////
	public void setTourID(ArrayList<String> arr) {
		curTour.setID(Integer.parseInt(arr.get(0)));
	}

	/**
	 * Sets the new POI.
	 *
	 * @param arr the new new POI
	 */
	public void setNewPOI(ArrayList<String> arr) {
		// [0]=poiID, [1]=name, [2]=type, [3]=desc, [4]=accessible, [5]=time,
		// [6]=address
		curTour.getPOIList().add(new PointOfInterest(Integer.parseInt(arr.get(0)), arr.get(1), arr.get(2), arr.get(3),
				arr.get(4), arr.get(5), arr.get(6), Integer.parseInt(orderTxt.getText())));
	}

	/**
	 * Prints the POI to table.
	 */
	//////////////// Print POI object info to table////////////////////////
	public void printPOIToTable() {
		addedTable.getItems().add(curTour.getPOIList().get(curTour.getPOIList().size() - 1));
	}

	//////////////// Method to check fields////////////////////////

	/**
	 * Check fields.
	 *
	 * @return true, if successful
	 */
	public boolean checkFields() {
		if (name_of_tour_Txt.getText().isEmpty() || timeArea.getText().isEmpty() || descArea.getText().isEmpty()) {
			ValidationTests.printErrorMsg("Empty fields", "Please fill all fields!");
			return false;
		}
		try {
			if (CountryCbx.getValue().toString().isEmpty() || CityCbx.getValue().toString().isEmpty()) {
				ValidationTests.printErrorMsg("Empty fields", "Please select a country and city!");
				return false;
			}
		} catch (NullPointerException e) { // Handle combo-box exceptions 
			ValidationTests.printErrorMsg("Empty fields", "Please select a country and city!");
			return false;
		}
		return true;
	}

	/**
	 * Check if place index exists in tour and whether it is a valid number.
	 *
	 * @param index the index
	 * @return true, if successful
	 */
	public boolean checkPlace(String index) {
		if (ValidationTests.isFieldEmpty(index))
			return false;
		if (!QueryCreator.isNumeric(index)) {
			ValidationTests.printErrorMsg("Error", "Order of place in the tour must be an integer!");
			return false;
		}
		if (indexArr.contains(Integer.parseInt(index))) {
			ValidationTests.printErrorMsg("Error", "Order of place in the tour already exists!");
			return false;
		}
		return true;
	}
}
