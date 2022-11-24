package guiControllers;

import java.io.IOException;
import java.util.ArrayList;

import entities.City;
import entities.Map;
import entities.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systemFunctionality.ClientMemberController;
import systemFunctionality.ValidationTests;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.scene.control.RadioButton;
import guiControllers.gcmMainController;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewCatalogController.
 */
public class ViewCatalogController {

	// -------------------------------------------------------------------------------------------//
	// GUI components
	// attribute------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/** The back btn. */
	@FXML
	private Button backBtn;

	/** The one time radio btn. */
	@FXML
	private RadioButton one_time_radio_btn;

	/** The Subscription radio btn. */
	@FXML
	private RadioButton Subscription_radio_btn;

	/** The username. */
	@FXML
	private Label username;

	/** The City cbx. */
	@FXML
	private ComboBox<String> CityCbx;

	/** The select country cbx. */
	@FXML
	private ComboBox<String> selectCountryCbx;

	/** The City cbx 1. */
	@FXML
	private ComboBox<String> CityCbx1;

	/** The select country cbx 1. */
	@FXML
	private ComboBox<String> selectCountryCbx1;

	/** The Name cbx. */
	@FXML
	private ComboBox<String> NameCbx;

	/** The keyword. */
	@FXML
	private Label keyword;

	/** The search txt. */
	@FXML
	private TextField search_txt;

	/** The search btn 1. */
	@FXML
	private Button searchBtn1;

	/** The anchor pane. */
	@FXML
	private AnchorPane anchorPane;

	/** The search btn 2. */
	@FXML
	private Button searchBtn2;

	/** The search btn 3. */
	@FXML
	private Button searchBtn3;

	/** The label information 11. */
	@FXML
	private Label label_information11;

	/** The Tab menu. */
	@FXML
	private HBox TabMenu;

	/** The Maps purchased. */
	@FXML
	private Label MapsPurchased;

	/** The catalog image. */
	@FXML
	private ImageView catalog_image;

	/** The btn edit prfile. */
	@FXML
	private Button btnEdit_Prfile;

	/** The btn publish new version. */
	@FXML
	private Button btn_Publish_New_Version;

	/** The btn edit map. */
	@FXML
	private Button btn_Edit_Map;

	/** The label information 1. */
	@FXML
	private Label label_information1;

	/** The information txt 1. */
	@FXML
	private TextField informationTxt1;

	/** The label information. */
	@FXML
	private Label label_information;

	/** The information txt. */
	@FXML
	private TextField informationTxt;

	/** The loadingimage. */
	@FXML
	private ImageView loadingimage;

	/** The catalog table. */
	//////// ========================================////////////////
	@FXML
	private TableView<Map> catalogTable;

	/** The desc col. */
	@FXML
	private TableColumn<Map, String> descCol;

	/** The rate col. */
	@FXML
	private TableColumn<Map, String> rateCol;

	/** The subrate col. */
	@FXML
	private TableColumn<Map, String> subrateCol;

	////// =========================================/////////////////////

	/** The catalog table by city. */
	@FXML
	private TableView<City> catalogTableByCity;

	/** The Numof mups col. */
	@FXML
	private TableColumn<City, String> NumofMupsCol;

	/** The Description col. */
	@FXML
	private TableColumn<City, String> DescriptionCol;

	/** The Num of poi col. */
	@FXML
	private TableColumn<City, String> NumOfPoiCol;

	/** The Num of tours col. */
	@FXML
	private TableColumn<City, String> NumOfToursCol;

	///// ================================/////

	/** The catalog purchased table. */
	@FXML
	private TableView<Map> catalog_purchased_Table;

	/** The desc col 1. */
	@FXML
	private TableColumn<Map, String> descCol1;

	/** The city name col. */
	@FXML
	private TableColumn<Map, String> cityNameCol;

	/** The num place col. */
	@FXML
	private TableColumn<Map, String> numPlaceCol;

	// -------------------------------------------------------------------------------------------//
	// Internal Class
	// attributes-----------------------------------------------------------------//
	/** The client member controller. */
	// -------------------------------------------------------------------------------------------//
	private ClientMemberController clientMemberController;
	
	/** The view catalog controller. */
	public static ViewCatalogController viewCatalogController;
	
	/** The country list. */
	ObservableList<String> countryList;
	
	/** The country list 1. */
	ObservableList<String> countryList1;
	
	/** The city list. */
	ObservableList<String> cityList;
	
	/** The city list 1. */
	ObservableList<String> cityList1;
	
	/** The Name palce list. */
	ObservableList<String> NamePalceList;
	
	/** The flag 11. */
	public static int flag11 = 0;
	
	/** The y. */
	int x = 0, y = 0;
	
	/** The lock. */
	private Object lock = new Object();
	
	/** The str arr. */
	private String[] strArr = new String[2];
	
	/** The mapsiz. */
	int mapsiz = 0;
	// -------------------------------------------------------------------------------------------//
	// Getters and setters
	// methods---------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Instantiates a new view catalog controller.
	 */
	public ViewCatalogController() {
		viewCatalogController = this;
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
	 * Gets the view catalog controller.
	 *
	 * @return the view catalog controller
	 */
	public static ViewCatalogController GetViewCatalogController() {
		if (viewCatalogController == null)
			viewCatalogController = new ViewCatalogController();
		return viewCatalogController;
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
		username.setText(
				"Welcome " + gcmMainController.user.getFirstName() + " " + gcmMainController.user.getLastName());

		if (gcmMainController.user.getPermission() == 1)
			TabMenu.setVisible(false);
		else
			TabMenu.setVisible(true);

		if ((gcmMainController.user.getPermission() == 1) || (gcmMainController.user.getPermission() == 2)
				|| (gcmMainController.user.getPermission() == 3)) {
			catalog_image.setVisible(true);
			MapsPurchased.setVisible(false);
			one_time_radio_btn.setVisible(false);
			Subscription_radio_btn.setVisible(false);
			label_information11.setVisible(false);

		} else {
			catalog_image.setVisible(false);
			MapsPurchased.setVisible(true);
			one_time_radio_btn.setVisible(true);
			Subscription_radio_btn.setVisible(true);
			label_information11.setVisible(true);
		}

		clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setClientViewCatalogController(this);
		clientMemberController.sendToServerCountry();

		selectCountryCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By
																					// clicking
																					// on
																					// a
																					// value
																					// inside
																					// the
																					// combobox,
																					// we
																					// will
																					// print
																					// to
																					// ////

			if (newItem != null) {
				try {
					clientMemberController.sendToServerState(selectCountryCbx.getValue().toString());
					searchBtn2.setDisable(true);
					searchBtn3.setDisable(true);
					CityCbx1.getItems().clear();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

			}
		});

		selectCountryCbx1.valueProperty().addListener((obs, oldItem, newItem) -> { // By
																					// clicking
																					// on
																					// a
																					// value
																					// inside
																					// the
																					// combobox,
																					// we
																					// will
																					// print
																					// to
																					// ////

			if (newItem != null) {
				try {
					clientMemberController.sendToServerState(selectCountryCbx1.getValue().toString());
					searchBtn1.setDisable(true);
					searchBtn3.setDisable(true);
					CityCbx.getItems().clear();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

			}
		});

		CityCbx1.valueProperty().addListener((obs, oldItem, newItem) -> { // By
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
					clientMemberController.sendToServer_get_poi_by_city(CityCbx1.getValue().toString());
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
			// the state will be drawn//

			if (newItem != null) {
				searchBtn1.setDisable(false);
			} else {

			}
		});

		NameCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By
			// clicking
			// on
			// a
			// value
			// within
			// the
			// combobox,
			// the state will be drawn//

			if (newItem != null) {
				searchBtn2.setDisable(false);
			} else {

			}
		});

		descCol.setCellValueFactory(new PropertyValueFactory<Map, String>("Description"));
		rateCol.setCellValueFactory(new PropertyValueFactory<Map, String>("Rate"));
		subrateCol.setCellValueFactory(new PropertyValueFactory<Map, String>("subRate"));
		catalogTable.setStyle("-fx-focus-color: transparent;");

		NumofMupsCol.setCellValueFactory(new PropertyValueFactory<City, String>("NumOfMaps"));
		DescriptionCol.setCellValueFactory(new PropertyValueFactory<City, String>("description"));
		NumOfPoiCol.setCellValueFactory(new PropertyValueFactory<City, String>("NumOfPOI"));
		NumOfToursCol.setCellValueFactory(new PropertyValueFactory<City, String>("NumOfTours"));
		catalogTableByCity.setStyle("-fx-focus-color: transparent;");

		descCol1.setCellValueFactory(new PropertyValueFactory<Map, String>("description"));
		cityNameCol.setCellValueFactory(new PropertyValueFactory<Map, String>("cityName"));
		numPlaceCol.setCellValueFactory(new PropertyValueFactory<Map, String>("numPOI"));
		catalog_purchased_Table.setStyle("-fx-focus-color: transparent;");

	}

	// -------------------------------------------------------------------------------------------//
	// Cases of events from
	// GUI------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

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
	 * On click publish new version.
	 *
	 * @param event the event
	 */
	@FXML
	void On_Click_Publish_New_Version(MouseEvent event) {

		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("/fxml/PublishNewVersionOfMap.fxml"));
			Scene scene = new Scene(root, 1225, 670);
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
	 * Click on subscription.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void Click_on_Subscription(MouseEvent event) throws IOException { // Subscriptions handler

		one_time_radio_btn.setSelected(false);
		Subscription_radio_btn.setSelected(true);
		loadingimage.setVisible(true);
		catalogTable.getItems().clear();
		catalogTableByCity.getItems().clear();
		catalog_purchased_Table.getItems().clear();
		catalogTable.setVisible(false);
		catalogTableByCity.setVisible(false);
		catalog_purchased_Table.setVisible(false);
		strArr[0] = gcmMainController.user.getUserName();
		strArr[1] = "Subscription";
		clientMemberController.sendToServerTypePurchas(strArr);

	}

	/**
	 * Click on one time.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void Click_on_one_time(MouseEvent event) throws IOException { // One time handler

		one_time_radio_btn.setSelected(true);
		Subscription_radio_btn.setSelected(false);
		loadingimage.setVisible(true);
		catalogTable.getItems().clear();
		catalogTableByCity.getItems().clear();
		catalog_purchased_Table.getItems().clear();
		catalogTable.setVisible(false);
		catalogTableByCity.setVisible(false);
		catalog_purchased_Table.setVisible(false);
		strArr[0] = gcmMainController.user.getUserName();
		strArr[1] = "One time purchase";
		clientMemberController.sendToServerTypePurchas(strArr);

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

	// -------------------------------------------------------------------------------------------//Internal
	// functions------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	//////////////// Loading a country list into the
	/**
	 * Load combo box.
	 *
	 * @param arr the arr
	 */
	//////////////// combobox////////////////////////
	public void loadComboBox(ArrayList<String> arr) {

		countryList = FXCollections.observableArrayList(arr);
		selectCountryCbx.setItems(countryList);
		countryList1 = FXCollections.observableArrayList(arr);
		selectCountryCbx1.setItems(countryList);
	}

	//////////////// Loading a city list into the
	/**
	 * Load combo box 1.
	 *
	 * @param arr the arr
	 */
	//////////////// combobox////////////////////////
	public void loadComboBox1(ArrayList<String> arr) {
		if (selectCountryCbx.getValue() != null) {
			cityList = FXCollections.observableArrayList(arr);
			CityCbx.setItems(cityList);
		}
		if (selectCountryCbx1.getValue() != null) {
			cityList1 = FXCollections.observableArrayList(arr);
			CityCbx1.setItems(cityList1);
		}
	}

	//////////////// Loading a name place list into the
	/**
	 * Load combo box name place.
	 *
	 * @param arr the arr
	 */
	//////////////// combobox////////////////////////////////////////////////////////////////////
	public void loadComboBoxNamePlace(ArrayList<String> arr) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				NamePalceList = FXCollections.observableArrayList(arr);
				NameCbx.setItems(NamePalceList);
			}
		});

	}

	// -------------------------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Back on click.
	 *
	 * @param event the event
	 */
	@FXML
	void backOnClick(MouseEvent event) {
		switch (gcmMainController.user.getPermission()) {
		case 0:// Case of Client member.
			openclientPage(gcmMainController.user.getFirstName());
			break;
		case 1:// Case of GCM Manager.
			openManagerPage(gcmMainController.user.getFirstName());
			break;
		case 2:// Case of Content Department Employee.
			openContDepEmpPage(gcmMainController.user.getFirstName());
			break;
		case 3:// Case of Content Department Manager.
			openContDepManPage(gcmMainController.user.getFirstName());
			break;
		default:
			break;
		}
	}

	/**
	 * Open manager page.
	 *
	 * @param userName the user name
	 */
	public void openManagerPage(String userName) {
		flag11 = 0;
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GcmManager.fxml"));
					Parent root = (Parent) loader.load();
					Stage primaryStage = (Stage) anchorPane.getScene().getWindow();
					primaryStage.setScene(new Scene(root));
					primaryStage.show();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Open cont dep emp page.
	 *
	 * @param userName the user name
	 */
	public void openContDepEmpPage(String userName) {
		flag11 = 0;
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					VBox root = (VBox) FXMLLoader.load(getClass().getResource("/fxml/ContentDepartmentEmployee.fxml"));
					Scene scene = new Scene(root, 850, 650);
					scene.getStylesheets()
							.add(getClass().getResource("/fxml/ContentDepartmentEmployee.css").toExternalForm());
					Stage primaryStage = (Stage) anchorPane.getScene().getWindow();
					primaryStage.setScene(scene);
					primaryStage.setTitle("Content Department Employee");
					primaryStage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Open cont dep man page.
	 *
	 * @param userName the user name
	 */
	public void openContDepManPage(String userName) {
		flag11 = 0;
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					VBox root = (VBox) FXMLLoader.load(getClass().getResource("/fxml/ContentDepartmentManger.fxml"));
					Scene scene = new Scene(root, 1123, 648);
					// scene.getStylesheets().add(getClass().getResource("/fxml/ContentDepartmentManger.css").toExternalForm());
					Stage primaryStage = (Stage) anchorPane.getScene().getWindow();
					primaryStage.setScene(scene);
					primaryStage.setTitle("Content Department Manger");
					primaryStage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Openclient page.
	 *
	 * @param userName the user name
	 */
	public void openclientPage(String userName) {
		flag11 = 0;
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MemberMain.fxml"));
					Parent root = (Parent) loader.load();
					Stage primaryStage = (Stage) anchorPane.getScene().getWindow();
					primaryStage.setScene(new Scene(root));
					primaryStage.show();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Search on click place name.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void searchOnClick_place_name(MouseEvent event) throws IOException {
		y = 1;
		x = 0;

		catalogTable.getItems().clear();
		catalogTableByCity.getItems().clear();
		loadingimage.setVisible(true);
		catalogTable.setVisible(false);
		catalogTableByCity.setVisible(false);
		catalog_purchased_Table.setVisible(false);
		clientMemberController.sendToServerplaceName(NameCbx.getValue().toString());
		if(gcmMainController.user.getPermission()==0)
			clientMemberController.sendToServerAddView(gcmMainController.user.getUserName(), CityCbx1.getValue());
		informationTxt.setVisible(true);
		label_information.setVisible(true);
		informationTxt1.setVisible(false);
		label_information1.setVisible(false);
		informationTxt.setText("");
		NameCbx.setValue(null);
		selectCountryCbx.setValue(null);
		CityCbx.setValue(null);

	}

	/**
	 * Search on click city name.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void searchOnClick_city_name(MouseEvent event) throws IOException {

		catalogTable.getItems().clear();
		catalogTableByCity.getItems().clear();
		loadingimage.setVisible(true);
		catalogTable.setVisible(false);
		catalog_purchased_Table.setVisible(false);
		catalogTableByCity.setVisible(false);
		clientMemberController.sendToServerCityNameByViewCatalog(CityCbx.getValue().toString());
		if(gcmMainController.user.getPermission()==0)
			clientMemberController.sendToServerAddView(gcmMainController.user.getUserName(), CityCbx.getValue());
		informationTxt.setVisible(false);
		label_information.setVisible(false);
		informationTxt1.setVisible(false);
		label_information1.setVisible(false);
		NameCbx.setValue(null);
		CityCbx.setValue(null);
		selectCountryCbx1.setValue(null);
		CityCbx1.setValue(null);

	}

	/**
	 * Search on click free text.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void searchOnClick_free_text(MouseEvent event) throws IOException {

		if (!ValidationTests.isFieldEmpty(search_txt.getText())) {
			x = 1;
			y = 0;
			catalogTable.getItems().clear();
			catalogTableByCity.getItems().clear();
			loadingimage.setVisible(true);
			NameCbx.setValue(null);
			selectCountryCbx1.setValue(null);
			CityCbx1.setValue(null);
			selectCountryCbx.setValue(null);
			CityCbx.setValue(null);
			catalogTable.setVisible(false);
			catalogTableByCity.setVisible(false);
			clientMemberController.sendToServerFreeText(search_txt.getText());
			informationTxt.setVisible(false);
			label_information.setVisible(false);
			informationTxt1.setVisible(true);
			label_information1.setVisible(true);
			search_txt.setText("");
		}
	}

	/**
	 * Clkic key.
	 *
	 * @param event the event
	 */
	@FXML
	void ClkicKey(MouseEvent event) {

		searchBtn1.setDisable(true);
		searchBtn2.setDisable(true);
		searchBtn3.setDisable(false);

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Prints to the map search table.
	 *
	 * @param arr the arr
	 */
	/* Print to catalog table */
	public void printToTable(ArrayList<String> arr) {
		ArrayList<Map> mapArr = new ArrayList<Map>();
		int size = arr.size();
		mapsiz = size / 3;
		for (int i = 0; i < size / 3; i++) {
			mapArr.add(new Map());
			mapArr.get(i).setDescription(arr.get(0));
			arr.remove(0);
			mapArr.get(i).setRate(Double.parseDouble(arr.get(0)));
			arr.remove(0);
			mapArr.get(i).setSubRate(Double.parseDouble(arr.get(0)));
			arr.remove(0);
		}

		synchronized (lock) {

			try {
				lock.wait(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (mapArr != null) {
				loadingimage.setVisible(false);
				catalogTable.setVisible(true);
				if (x == 1)
					informationTxt1.setText(Integer.toString(mapsiz));
				if (y == 1)
					informationTxt.setText(Integer.toString(mapsiz));

				for (int i = 0; i < mapArr.size(); i++) {

					catalogTable.getItems().add(mapArr.get(i));
				}

			}
		}

	}

	/**
	 * Prints the required city information to the table following search by city.
	 *
	 * @param arr the arr
	 */
	// SELECT NumOfMaps, NumOfPOI, NumOfTours, description/////////////////
	public void printToTable1(ArrayList<String> arr) {
		for (String elem : arr)
			System.out.println(elem);
		ArrayList<City> cityarr = new ArrayList<City>();
		int size = arr.size();
		for (int i = 0; i < size / 4; i++) {
			cityarr.add(new City());
			cityarr.get(i).setNumOfMaps(Integer.parseInt(arr.get(0)));
			arr.remove(0);
			cityarr.get(i).setNumOfPOI(Integer.parseInt(arr.get(0)));
			arr.remove(0);
			cityarr.get(i).setNumOfTours(Integer.parseInt(arr.get(0)));
			arr.remove(0);
			cityarr.get(i).setDescription(arr.get(0));
			arr.remove(0);

		}

		synchronized (lock) {

			try {
				lock.wait(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (cityarr != null) {
				loadingimage.setVisible(false);
				catalogTableByCity.setVisible(true);
				for (int i = 0; i < cityarr.size(); i++) {

					catalogTableByCity.getItems().add(cityarr.get(i));
				}
			}
		}

	}

	/**
	 * Print maps purchased by the current user to the appropriate table in search type in Catalog.
	 *
	 * @param arr the arr
	 */
	// SELECT description ,type,NumOfPOI/////////////////
	public void printToTableByPurchase(ArrayList<String> arr) {
		for (String elem : arr)
			System.out.println(elem);
		ArrayList<Map> mapArr = new ArrayList<Map>();
		int size = arr.size();
		for (int i = 0; i < size / 3; i++) {
			mapArr.add(new Map());
			mapArr.get(i).setDescription(arr.get(0));
			arr.remove(0);
			mapArr.get(i).setCityName(arr.get(0));
			arr.remove(0);
			mapArr.get(i).setNumPOI(Integer.parseInt(arr.get(0)));
			arr.remove(0);
		}

		synchronized (lock) {

			try {
				lock.wait(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (mapArr != null) {
				loadingimage.setVisible(false);
				catalog_purchased_Table.setVisible(true);

				for (int i = 0; i < mapArr.size(); i++) {

					catalog_purchased_Table.getItems().add(mapArr.get(i));
				}

			}
		}

	}

}