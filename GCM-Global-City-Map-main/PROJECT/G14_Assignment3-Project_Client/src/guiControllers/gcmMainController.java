package guiControllers;

import javafx.collections.FXCollections;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.util.ArrayList;
import entities.City;
import entities.Countries;
import entities.Customer;
import entities.Payment;
import entities.User;
import entities.Employee;
import entities.Map;
import systemFunctionality.ClientMemberController;
import systemFunctionality.ValidationTests;
import guiMain.gcmMainWindow;
import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;

// TODO: Auto-generated Javadoc
/**
 * gcmMainController - GUI controller for "gcmFXML.fxml"
 */

public class gcmMainController {
	// -------------------------------------------------------------------------------------------//
	// GUI components
	// attribute------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/** The register btn. */
	@FXML
	private Button registerBtn;

	/** The login btn. */
	@FXML
	private Button loginBtn;

	/** The search btn. */
	@FXML
	private Button searchBtn;

	/** The forgor pass btn. */
	@FXML
	private Button forgorPassBtn;

	/** The Password txt. */
	@FXML
	private PasswordField PasswordTxt;

	/** The username txt. */
	@FXML
	private TextField usernameTxt;

	/** The server ip. */
	@FXML
	private TextField serverIp;

	/** The log in serverbtn. */
	@FXML
	private Button logInServerbtn;

	/** The anchor pane. */
	@FXML
	private AnchorPane anchorPane;

	/** The cityname btn. */
	@FXML
	private Button citynameBtn;

	/** The place name btn. */
	@FXML
	private Button place_nameBtn;

	/** The description btn. */
	@FXML
	private Button descriptionBtn;

	/** The information txt. */
	@FXML
	private TextField informationTxt;

	/** The label information. */
	@FXML
	private Label label_information;

	/** The select country cbx. */
	@FXML
	private ComboBox<String> selectCountryCbx;

	/** The City cbx. */
	@FXML
	private ComboBox<String> CityCbx;

	/** The Name cbx. */
	@FXML
	private ComboBox<String> NameCbx;

	/** The search txt. */
	@FXML
	private TextField search_txt;

	/** The keyword. */
	@FXML
	private Label keyword;

	/** The loading image. */
	@FXML
	private ImageView loadingImage;

	/** The catalog table. */
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

	////// =========================================///

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

	/** The flag 12. */
	public static int flag10 = 0, flag12 = 0;
	
	/** The Search free text. */
	public static int Search_By_city_name = 0, Search_By_place_name = 0, Search_Free_Text = 0;
	
	/** The size. */
	public int size = 0;

	// -------------------------------------------------------------------------------------------//
	// Internal Class
	// attributes-----------------------------------------------------------------//
	/** The client member controller. */
	// -------------------------------------------------------------------------------------------//
	private ClientMemberController clientMemberController;
	
	/** The Gcm main controller. */
	public static gcmMainController GcmMainController;
	
	/** The flag. */
	public static int flag = 0;
	
	/** The country list. */
	ObservableList<String> countryList;
	
	/** The city list. */
	ObservableList<String> cityList;
	
	/** The Name palce list. */
	ObservableList<String> NamePalceList;
	
	/** The flag 6. */
	public static int flag6 = 0;
	
	/** The lock. */
	private Object lock = new Object();
	
	/** The City list. */
	public static ArrayList<City> CityList = new ArrayList<City>();
	
	/** The Country list. */
	public static ArrayList<Countries> CountryList = new ArrayList<Countries>();
	
	/** The Map list. */
	public static ArrayList<Map> MapList = new ArrayList<Map>();
	
	/** The freetext. */
	public String freetext;
	
	/** The user. */
	public static User user;
	
	/** The connected. */
	public static boolean connected = false;
	
	/** The primary stage 1. */
	Stage primaryStage1;
	
	/** The req 3. */
	private int req3=0;
	
	/** The req 1. */
	private int req1=0;



	// -------------------------------------------------------------------------------------------//
	// Getters and setters
	// methods---------------------------------------------------------------//
	/**
	 * Instantiates a new gcm main controller.
	 */
	// -------------------------------------------------------------------------------------------//
	public gcmMainController() {
		GcmMainController = this;
	}

	/**
	 * Gets the gcm main controller.
	 *
	 * @return the gcm main controller
	 */
	public static gcmMainController getGcmMainController() {
		if (GcmMainController == null)
			GcmMainController = new gcmMainController();
		return GcmMainController;
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
		if (connected == true) { // When page is reinitialized when coming back to it, it needs to know there is still connection to Server.
			clientMemberController = ClientMemberController.GetClientMemberController();
			clientMemberController.setClientWindowController(this);
		}


		descCol.setCellValueFactory(new PropertyValueFactory<Map, String>("Description"));
		rateCol.setCellValueFactory(new PropertyValueFactory<Map, String>("Rate"));
		subrateCol.setCellValueFactory(new PropertyValueFactory<Map, String>("subRate"));
		catalogTable.setStyle("-fx-focus-color: transparent;");

		NumofMupsCol.setCellValueFactory(new PropertyValueFactory<City, String>("NumOfMaps"));
		DescriptionCol.setCellValueFactory(new PropertyValueFactory<City, String>("description"));
		NumOfPoiCol.setCellValueFactory(new PropertyValueFactory<City, String>("NumOfPOI"));
		NumOfToursCol.setCellValueFactory(new PropertyValueFactory<City, String>("NumOfTours"));
		catalogTableByCity.setStyle("-fx-focus-color: transparent;");



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
				if (Search_By_place_name != 1)
					searchBtn.setDisable(false);
				try {
					clientMemberController.sendToServer_get_poi_by_city(CityCbx.getValue().toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			// the
			// state
			// will
			// be
			// drawn//

			if (newItem != null) {
				searchBtn.setDisable(false);
			} else {

			}
		});





	}



	// -------------------------------------------------------------------------------------------//
	// Cases of events from
	// GUI------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//
	/**
	 * logInServerOnClick(MouseEvent event) - By click on login to server button
	 * this function will check if the ip is correct and connect the user of the
	 * system to the sever.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void logInServerOnClick(MouseEvent event) throws IOException {
		flag6 = 1;
		flag12 = 0;
		gcmMainWindow.createConnection(serverIp.getText());
		clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setClientWindowController(this);
		clientMemberController.sentToServerLoadCityInfo("Select All"); // load
																		// all
																		// city
																		// info
																		// to
																		// city
																		// entety
		clientMemberController.sendToServerCountry();
		clientMemberController.sendToServerGetMapImage();
		clientMemberController.sendToServerGetRequests(1); // Check for pending requests for managers
		clientMemberController.sendToServerGetRequests(3);
		ValidationTests.printInfoMsg("Connected", "Connection to server successful!");
		connected = true;


	}

	/**
	 * logInOnAction(ActionEvent event) - By click on the login button this
	 * function will check if the user exist in the DB and if the info that the
	 * user gave to the system correct and after that will login to the system.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void logInOnAction(ActionEvent event) throws IOException {

		if (!ValidationTests.isFieldEmpty(usernameTxt.getText()) && !ValidationTests.isFieldEmpty(PasswordTxt.getText())
				&& checkConnection()) {
			flag = 0; // This flag reset himself every click on the login button
						// to be responsible
						// for showing if there is no such user in the DB.
			flag6 = 0;
			clientMemberController = ClientMemberController.GetClientMemberController();
			clientMemberController.setClientWindowController(this);
			clientMemberController.logInValidation(usernameTxt.getText(), PasswordTxt.getText()); // Check login details.
	}
	}

	/**
	 * On click cityname btn.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void OnClick_citynameBtn(MouseEvent event) throws IOException {
		if (checkConnection()) { // If connection is valid, run search by city and change GUI accordingly.
			CityCbx.getItems().clear();
			searchBtn.setDisable(true);
			flag12 = 1;
			catalogTableByCity.setVisible(true);
			catalogTable.setVisible(false);
			Search_By_place_name = 0;
			keyword.setVisible(false);
			search_txt.setVisible(false);
			NameCbx.setVisible(false);
			selectCountryCbx.setVisible(true);
			CityCbx.setVisible(true);
			clientMemberController.sendToServerCountry();
			Search_By_city_name = 1;
			Search_Free_Text = 0;
			CityCbx.setValue(null);
			CityCbx.getItems().clear();
			selectCountryCbx.setValue(null);
		}
	}

	/**
	 * On click place name btn.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void OnClick_place_nameBtn(MouseEvent event) throws IOException {
		if (checkConnection()) { // If connection is valid, run search by place and change GUI accordingly.
			searchBtn.setDisable(true);
			flag12 = 1;
			flag10 = 1;
			NameCbx.getItems().clear();
			CityCbx.getItems().clear();
			CityCbx.setValue(null);
			NameCbx.setValue(null);
			selectCountryCbx.setValue(null);
			catalogTable.getItems().clear();
			catalogTableByCity.getItems().clear();
			catalogTableByCity.setVisible(false);
			catalogTable.setVisible(true);
			clientMemberController.sendToServerCountry();
			Search_By_city_name = 0;
			Search_By_place_name = 1;
			Search_Free_Text = 0;
			informationTxt.setVisible(false);
			label_information.setVisible(false);
			keyword.setVisible(false);
			search_txt.setVisible(false);
			selectCountryCbx.setVisible(true);
			CityCbx.setVisible(true);
			NameCbx.setVisible(true);
		}
	}

	/**
	 * On click description btn.
	 *
	 * @param event the event
	 */
	@FXML
	void On_Click_descriptionBtn(MouseEvent event) {

		flag12 = 1;
		search_txt.setText("");
		searchBtn.setDisable(false);
		selectCountryCbx.setVisible(false);
		catalogTable.getItems().clear();
		catalogTableByCity.getItems().clear();
		catalogTableByCity.setVisible(false);
		catalogTable.setVisible(true);
		CityCbx.setVisible(false);
		NameCbx.setVisible(false);
		search_txt.setVisible(true);
		informationTxt.setVisible(false);
		label_information.setVisible(false);
		keyword.setVisible(true);
		Search_By_city_name = 0;
		Search_By_place_name = 0;
		Search_Free_Text = 1;
	}

	/**
	 * Search on click.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void searchOnClick(MouseEvent event) throws IOException {
		// A different case for each type of search by the user
		if (Search_By_city_name == 1) {
			label_information.setVisible(false);
			informationTxt.setVisible(false);
			catalogTableByCity.getItems().clear();
			catalogTable.getItems().clear();
			loadingImage.setVisible(true);
			catalogTableByCity.setVisible(true);
			catalogTable.setVisible(false);
			clientMemberController.sendToServerCityNameByViewCatalog(CityCbx.getValue().toString());
			CityCbx.setValue(null);
			selectCountryCbx.setValue(null);
			CityCbx.getItems().clear();
			NameCbx.getItems().clear();
			searchBtn.setDisable(true);

		}
		if (Search_By_place_name == 1) {
			label_information.setVisible(false);
			informationTxt.setVisible(false);
			catalogTableByCity.getItems().clear();
			catalogTable.getItems().clear();
			loadingImage.setVisible(true);
			catalogTableByCity.setVisible(false);
			catalogTable.setVisible(true);
			clientMemberController.sendToServerplaceName(NameCbx.getValue().toString());
			CityCbx.getItems().clear();
			NameCbx.getItems().clear();

		}
		if (Search_Free_Text == 1) {
			if (!ValidationTests.isFieldEmpty(search_txt.getText())) {
				label_information.setVisible(false);
				informationTxt.setVisible(false);
				catalogTableByCity.getItems().clear();
				catalogTable.getItems().clear();
				loadingImage.setVisible(true);
				catalogTableByCity.setVisible(false);
				catalogTable.setVisible(true);
				clientMemberController.sendToServerFreeText(search_txt.getText());
				CityCbx.getItems().clear();
				NameCbx.getItems().clear();
			}
		}
	}

	/**
	 * Register on click.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void registerOnClick(MouseEvent event) throws IOException {
		if (checkConnection()) {
			try {
				VBox root = (VBox) FXMLLoader.load(getClass().getResource("/fxml/registerFXML.fxml"));
				Scene scene = new Scene(root, 850, 650);
				scene.getStylesheets().add(getClass().getResource("/fxml/registerCSS.css").toExternalForm());
				Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				primaryStage.setScene(scene);
				primaryStage.setTitle("Register");
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// -------------------------------------------------------------------------------------------//
	// Internal
	// functions------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//
	/**
	 * loginIdentification (String[] msg) - Method that called from
	 * ClientMemberController.class This method identify which scene to open
	 * according to the user that logged in.
	 *
	 * @param msg
	 *            - String array that contains the user name, password and the
	 *            permission.
	 */
	public void loginIdentification(ArrayList<String> msg) { // if msg.length is
																// not grater
																// then 1 thats
		if (msg.size()==1 && msg.contains("1062"))
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					try {
						ValidationTests.printErrorMsg("Error", "User is already logged in!");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

		// means there
		// are no such
		// user because
		// the query did
		// not find the
		// user.
		else {
			if (msg.size() > 1) {
				/**
				 * msg[0] - User Name. msg[1] - First name. msg[2] - Last name.
				 * msg[3] - Password. msg[4] - Email. msg[5] - Address. msg[6] -
				 * Permission. msg[7] - cardid. msg[8] - cardcompanyname. msg[9]
				 * - cardvaliddate. msg[10] - cardcvv. msg[11] - phoneNumber. OR
				 * - only one value - error 1062 from SQLServer if user is
				 * already logged in.
				 */
				this.setUserDetails(msg);
				switch (msg.get(6)) {
				case "0":// Case of GCM customer.
					openCustomerPage(msg.get(1));
					break;
				case "1":// Case of GCM Manager.
					openManagerPage(msg.get(1));
					break;
				case "2":// Case of Content Department Employee.
					openContDepEmpPage(msg.get(1));
					break;
				case "3":// Case of Content Department Manager.
					openContDepMngPage(msg.get(1));
					break;
				default:
					break;
				}
			} else {
				// This flag will give the option to open error message if the
				// *2*
				// query and their fields (Customers and employees) will be
				// empty.
				flag++;
				if (flag == 2)
					misMatchMsg();
			}
		}
	}

	// -------------------------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//
	/**
	 * openManagerPage(String userName) - Method that called from
	 * loginIdentification. This method open GCM Manager scene.
	 *
	 * @param userName
	 *            - Name of the person who logged in.
	 */
	public void openManagerPage(String userName) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("GCM Manager");
					alert.setHeaderText("Welcome " + userName + " to global city map system");
					alert.showAndWait();

					if(req1>0)
						ValidationTests.printInfoMsg("Notice", "You have pending version update requests!");

					FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GcmManager.fxml"));
					Parent root = (Parent) loader.load();
					Stage primaryStage = (Stage) anchorPane.getScene().getWindow();
					primaryStage.setScene(new Scene(root));
					primaryStage.setOnCloseRequest(e-> // This is a unique handler for the user closing the program from the X button, needed to log him out of server.
					{
						try {
							if(!ValidationTests.printConfirmMsg("Logging out", "Are you sure you want to log out and exit?"))
								e.consume();
							else
							{
								clientMemberController.sendToServerLogOut();
								Platform.exit(); //exit program
								System.exit(0);;
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 });
					primaryStage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// -------------------------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//
	/**
	 * openCustomerPage (String userName) - Method that called from
	 * loginIdentification. This method open GCM member main scene.
	 *
	 * @param userName
	 *            - Name of the person who logged in.
	 */
	public void openCustomerPage(String userName) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("GCM member main scene");
					alert.setHeaderText("Welcome " + userName + " to global city map system");

					alert.showAndWait();

					FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MemberMain.fxml"));
					Parent root = (Parent) loader.load();

					MemberMainController mb = loader.getController();
					Stage primaryStage = (Stage) anchorPane.getScene().getWindow();
					primaryStage.setScene(new Scene(root));
					primaryStage.setOnCloseRequest(e->
					{
						try {
							if(!ValidationTests.printConfirmMsg("Logging out", "Are you sure you want to log out and exit?"))
								e.consume();
							else
							{
								clientMemberController.sendToServerLogOut();
								Platform.exit(); //exit program
								System.exit(0);;
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 });
					primaryStage.show();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// -------------------------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//
	/**
	 * openContDepEmpPage (String userName) - Method that called from
	 * loginIdentification. This method open Content Department Employee scene.
	 *
	 * @param userName
	 *            - Name of the person who logged in.
	 */
	public void openContDepEmpPage(String userName) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Content Department Employee");
					alert.setHeaderText("Welcome " + userName + " to global city map system");
					alert.showAndWait();

					VBox root = (VBox) FXMLLoader.load(getClass().getResource("/fxml/ContentDepartmentEmployee.fxml"));
					Scene scene = new Scene(root, 850, 650);
					scene.getStylesheets()
							.add(getClass().getResource("/fxml/ContentDepartmentEmployee.css").toExternalForm());
					Stage primaryStage = (Stage) anchorPane.getScene().getWindow();
					primaryStage.setScene(scene);
					primaryStage.setTitle("Content Department Employee");
					primaryStage.setOnCloseRequest(e->
					{
						try {
							if(!ValidationTests.printConfirmMsg("Logging out", "Are you sure you want to log out and exit?"))
								e.consume();
							else
							{
								clientMemberController.sendToServerLogOut();
								Platform.exit(); //exit program
								System.exit(0);;
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 });
					primaryStage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Open cont dep mng page.
	 *
	 * @param userName the user name
	 */
	public void openContDepMngPage(String userName) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Content Department Manager");
					alert.setHeaderText("Welcome " + userName + " to global city map system");
					alert.showAndWait();
					synchronized(lock){
					try{
						lock.wait(500);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}

					if(req3>0)
						ValidationTests.printInfoMsg("Notice", "You have pending version update requests!");
					}
					VBox root = (VBox) FXMLLoader.load(getClass().getResource("/fxml/ContentDepartmentManger.fxml"));
					Scene scene = new Scene(root, 1123, 648);
					// scene.getStylesheets().add(getClass().getResource("/fxml/ContentDepartmentManger.css").toExternalForm());
					Stage primaryStage = (Stage) anchorPane.getScene().getWindow();
					primaryStage.setScene(scene);
					primaryStage.setTitle("Content Department Manager");
					primaryStage.setOnCloseRequest(e->
					{
						try {
							if(!ValidationTests.printConfirmMsg("Logging out", "Are you sure you want to log out and exit?"))
								e.consume();
							else
							{
								clientMemberController.sendToServerLogOut();
								Platform.exit(); //exit program
								System.exit(0);;
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 });
					primaryStage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// -------------------------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Mis match msg - when the user detaild don't exist in DB login is impossible.
	 */
	public void misMatchMsg() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Login error");
				alert.setHeaderText("Invalid username or password");
				alert.showAndWait();
			}
		});
	}

	// -------------------------------------------------------------------------------------------//
	/**
	 * Sets the user details.
	 * Set necessary information in static user object used to hold current User's information.
	 *
	 * @param userInfo the new user details
	 */
	// -------------------------------------------------------------------------------------------//
	public void setUserDetails(ArrayList<String> userInfo) {
		/**
		 * Insertion of all the information about the user. msg[0] - User Name.
		 * msg[1] - First name. msg[2] - Last name. msg[3] - Password. msg[4] -
		 * Email. msg[5] - Address. msg[6] - Permission. msg[7] - cardid. msg[8]
		 * - cardcompanyname. msg[9] - cardvaliddate. msg[10] - cardcvv. msg[11]
		 * - Phone number.
		 */
		if (userInfo.get(6).equals("0")) { // Due to different info, a check is ran on who the user is.
			user = new Customer();
			Payment payment = new Payment(userInfo.get(8), userInfo.get(9), userInfo.get(10),
					Integer.parseInt(userInfo.get(11)), userInfo.get(0));
			user.setPaymentDetails(payment);
			user.setUserName(userInfo.get(0));
			user.setFirstName(userInfo.get(1));
			user.setLastName(userInfo.get(2));
			user.setPassword(userInfo.get(3));
			user.setEmail(userInfo.get(4));
			user.setAddress(userInfo.get(5));
			user.setPermission(Integer.parseInt(userInfo.get(6)));
			user.setPhoneNumber(userInfo.get(7));

		}

		if (userInfo.get(6).equals("1") || userInfo.get(6).equals("2") || userInfo.get(6).equals("3")) {
			user = new Employee();
			Employee em = new Employee();
			Payment payment = new Payment(userInfo.get(9), userInfo.get(10), userInfo.get(11),
					Integer.parseInt(userInfo.get(12)), userInfo.get(0));
			user.setPaymentDetails(payment);
			user.setUserName(userInfo.get(0));
			user.setFirstName(userInfo.get(1));
			user.setLastName(userInfo.get(2));
			user.setPassword(userInfo.get(3));
			user.setEmail(userInfo.get(4));
			user.setAddress(userInfo.get(5));
			user.setPermission(Integer.parseInt(userInfo.get(6)));
			user.setPhoneNumber(userInfo.get(7));
			((Employee) user).setEmployeeID(userInfo.get(8));
			// ((Employee)user).getEmployeeID()
		}
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



	//////////////// Loading a country list into the
	//////////////// combobox/////////////////////////////////////////////////////////////////////
	/**
	 * Load country combo box.
	 *
	 * @param arr the arr
	 */
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void loadComboBox(ArrayList<String> arr) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				////// Add all Countries to Country object//////////////////////
				for (int i = 0; i < arr.size(); i++) {
					CountryList.add(new Countries());
					CountryList.get(i).setCountryname(arr.get(i).toString());
				}

				countryList = FXCollections.observableArrayList(arr);
				selectCountryCbx.setItems(countryList);
			}
		});
	}

	//////////////// Loading a city list into the
	//////////////// combobox//////////////////////////////////////////////////////////////////////////
	/**
	 * Load city combo box.
	 *
	 * @param arr the arr
	 */
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void loadComboBox1(ArrayList<String> arr) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				cityList = FXCollections.observableArrayList(arr);
				CityCbx.setItems(cityList);
			}
		});
	}

	//////////////// Loading a name place list into the
	//////////////// combobox////////////////////////////////////////////////////////////////////
	/**
	 * Load combo box name place.
	 *
	 * @param arr the arr
	 */
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void loadComboBoxNamePlace(ArrayList<String> arr) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				NamePalceList = FXCollections.observableArrayList(arr);
				NameCbx.setItems(NamePalceList);
			}
		});
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Prints the to search results table.
	 *
	 * @param arr the arr
	 */
	/* Print to catalog table */
	public void printToTable(ArrayList<String> arr) {
		ArrayList<Map> mapArr = new ArrayList<Map>();
		size = arr.size();
		for (int i = 0; i < size / 3; i++) { // By always removing the first element and already knowing the order of elements we can do this
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
				lock.wait(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (mapArr != null) {
				informationTxt.setVisible(true);
				label_information.setVisible(true);
				loadingImage.setVisible(false);
				informationTxt.setText(Integer.toString(size / 3));
				for (int i = 0; i < mapArr.size(); i++) {
					catalogTable.getItems().add(mapArr.get(i));
				}

			}
		}
	}


	/**
	 * Prints the to search results table.
	 *
	 * @param arr the arr
	 */
	// SELECT NumOfMaps, NumOfPOI, NumOfTours, description/////////////////
	public void printToTable1(ArrayList<String> arr) {
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
				lock.wait(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (cityarr != null) {

				loadingImage.setVisible(false);
				for (int i = 0; i < cityarr.size(); i++) {

					catalogTableByCity.getItems().add(cityarr.get(i));
				}
			}
		}
	}

	// -------------------------------------------------------------------------------------------//
	/**
	 * Sets the city entities.
	 *
	 * @param city the new city ent
	 */
	// -------------------------------------------------------------------------------------------//
	public void setCityEnt(ArrayList<String> city) {
		System.out.println("setCityEnt");
		int size = city.size();

		for (int i = 0; i < size / 7; i++) {
			CityList.add(new City());

			CityList.get(i).setName(city.get(0));
			city.remove(0);
			CityList.get(i).setNumOfMaps(Integer.parseInt(city.get(0)));
			city.remove(0);
			CityList.get(i).setNumOfPOI(Integer.parseInt(city.get(0)));
			city.remove(0);
			CityList.get(i).setNumOfTours(Integer.parseInt(city.get(0)));
			city.remove(0);
			CityList.get(i).setVersionNUmber(city.get(0));
			city.remove(0);
			CityList.get(i).setCountry(city.get(0));
			city.remove(0);
			CityList.get(i).setDescription(city.get(0));
			city.remove(0);
		}
	}

	// -------------------------------------------------------------------------------------------//
	/**
	 * Sets the map entities.
	 *
	 * @param array the new map ent
	 */
	// -------------------------------------------------------------------------------------------//
	public void setMapEnt(ArrayList<Object> array) {
		int i = 0;
		for (int j = 0; j < array.size(); j += 8) {
			MapList.add(new Map());
			MapList.get(i).setId((Integer) array.get(j));
			MapList.get(i).setRate((Double) array.get(j + 1));
			MapList.get(i).setSubRate((Double) array.get(j + 2));
			MapList.get(i).setStatus((String) array.get(j + 3));
			MapList.get(i).setCityName((String) array.get(j + 4));
			MapList.get(i).setDescription((String) array.get(j + 5));
			MapList.get(i).setNumPOI((Integer) array.get(j + 6));
			MapList.get(i).setImageFile((byte[]) array.get(j + 7));
			i++;
		}
	}

	/**
	 * Check connection. This is used to ensure client is connected to server before selecting options that require connection.
	 *
	 * @return true, if successful
	 */
	public boolean checkConnection() {
		if (connected)
			return true;
		ValidationTests.printErrorMsg("No connection", "You must first connect to the server!");
		return false;
	}

	/**
	 * Sets the existing version requests, if they exist, to the two Manager types so we can notify them when they log in to the system.
	 *
	 * @param res the new req
	 */
	public void setReq(String res) // Set the variables for manager update requests.
	{
		String[] arr=new String[2];
		arr=res.split("#"); //[0]=actual result, [1]=permission
		if(arr[1].equals("1"))
			req1=Integer.parseInt(arr[0]);
		else
			req3=Integer.parseInt(arr[0]);
	}
}
