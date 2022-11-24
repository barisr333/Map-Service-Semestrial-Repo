package guiControllers;

import java.io.IOException;
import java.util.ArrayList;

import entities.City;
import entities.Report;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systemFunctionality.ClientMemberController;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.control.RadioButton;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewReportController.
 */
public class ViewReportController {
	// -------------------------------------------------------------------------------------------//
	// GUI components
	// attribute------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/** The btn back. */
	@FXML
	private Button btnBack;

	/** The btn view catalg. */
	@FXML
	private Button btnView_Catalg;

	/** The btn edit prfile. */
	@FXML
	private Button btnEdit_Prfile;

	/** The City cbx. */
	@FXML
	private ComboBox<String> CityCbx;

	/** The date from txt. */
	@FXML
	private DatePicker dateFromTxt;

	/** The todate txt. */
	@FXML
	private DatePicker todateTxt;

	/** The Country cbx. */
	@FXML
	private ComboBox<String> CountryCbx;

	/** The Tab menu. */
	@FXML
	private HBox TabMenu;

	/** The anchor pane. */
	@FXML
	private AnchorPane anchorPane;

	/** The username. */
	@FXML
	private Label username;

	/** The Show report btn. */
	@FXML
	private Button ShowReportBtn;

	/** The image 1. */
	@FXML
	private ImageView image1;

	/** The image 2. */
	@FXML
	private ImageView image2;

    /** The All cities. */
    @FXML
    private RadioButton AllCities;

    /** The One city. */
    @FXML
    private RadioButton OneCity;

    /** The country label. */
    @FXML
    private Label countryLabel;

    /** The C ity label. */
    @FXML
    private Label CItyLabel;


/** The tablemapsinformation. */
//////////////=================================/////////////////////
	@FXML
	private TableView<Report> tablemapsinformation;

	/** The Numberofmaps col. */
	@FXML
	private TableColumn<Report, String> NumberofmapsCol;

	/** The Onetimepurchases col. */
	@FXML
	private TableColumn<Report, String> OnetimepurchasesCol;

	/** The Subscriptions col. */
	@FXML
	private TableColumn<Report, String> SubscriptionsCol;

	/** The Subscription renewals col. */
	@FXML
	private TableColumn<Report, String> SubscriptionRenewalsCol;

	/** The Views col. */
	@FXML
	private TableColumn<Report, String> ViewsCol;

	/** The Subscribeddownloads col. */
	@FXML
	private TableColumn<Report, String> SubscribeddownloadsCol;

	// -------------------------------------------------------------------------------------------//
	// Internal Class
	// attributes-----------------------------------------------------------------//
	/** The client member controller. */
	// -------------------------------------------------------------------------------------------//
	private ClientMemberController clientMemberController;
	
	/** The view report controller. */
	public static ViewReportController viewReportController;
	
	/** The country list. */
	ObservableList<String> countryList;
	
	/** The city list. */
	ObservableList<String> cityList;
	
	/** The info. */
	private String info[] = new String[3];
	
	/** The flag 13. */
	public static int flag13 = 0;
	
	/** The lock. */
	private Object lock = new Object();
	
	/** The all city. */
	public int one_city=0, all_city=0;
	// -------------------------------------------------------------------------------------------//
	// Getters and setters
	// methods---------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Instantiates a new view report controller.
	 */
	public ViewReportController() {
		viewReportController = this;
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
	 * Gets the view report controller.
	 *
	 * @return the view report controller
	 */
	public static ViewReportController GetViewReportController() {
		if (viewReportController == null)
			viewReportController = new ViewReportController();
		return viewReportController;
	}
//-------------------------------------------------------------------------------------------//
// Initialize method - Happens when the fxml file load---------------------------------------//
//-------------------------------------------------------------------------------------------//

	/**
 * Initialize.
 *
 * @throws IOException Signals that an I/O exception has occurred.
 */
@FXML
	void initialize() throws IOException {

		username.setText(
				"Welcome " + gcmMainController.user.getFirstName() + " " + gcmMainController.user.getLastName());

		if (gcmMainController.user.getPermission() == 1)
			TabMenu.setVisible(false);
		else
			TabMenu.setVisible(true);

		clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setClientViewReportController(this);
		clientMemberController.sendToServerCountry();

		CountryCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By clicking on a value within the
																			// combobox, the state will be drawn/
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

		NumberofmapsCol.setCellValueFactory(new PropertyValueFactory<Report, String>("NumberOfMaps"));
		OnetimepurchasesCol.setCellValueFactory(new PropertyValueFactory<Report, String>("Onetimepurchases"));
		SubscriptionsCol.setCellValueFactory(new PropertyValueFactory<Report, String>("Subscriptions"));
		SubscriptionRenewalsCol.setCellValueFactory(new PropertyValueFactory<Report, String>("SubscriptionRenewals"));
		ViewsCol.setCellValueFactory(new PropertyValueFactory<Report, String>("Views"));
		SubscribeddownloadsCol.setCellValueFactory(new PropertyValueFactory<Report, String>("SubscribedDownloads"));
		tablemapsinformation.setStyle("-fx-focus-color: transparent;");

	}
	// -------------------------------------------------------------------------------------------//
	// Cases of events from
	// GUI------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Back on click.
	 *
	 * @param event the event
	 */
	@FXML
	void BackOnClick(MouseEvent event) {
		flag13 = 0;
		switch (gcmMainController.user.getPermission()) {
		case 1:// Case of GCM Manager.
			openManagerPage(gcmMainController.user.getFirstName());
			break;

		case 3:// Case of Content Department Employee.
			openContDepManPage(gcmMainController.user.getFirstName());
			break;
		default:
			break;
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
	 * On click all cities.
	 *
	 * @param event the event
	 */
	@FXML
    void OnClickAllCities(MouseEvent event) {

		ShowReportBtn.setDisable(true);
		AllCities.setSelected(true);
		OneCity.setSelected(false);
		CountryCbx.setVisible(false);
		countryLabel.setVisible(false);
		CityCbx.setVisible(false);
		CItyLabel.setVisible(false);
		all_city=1;
		one_city=0;
    }


    /**
     * On klick paricular city.
     *
     * @param event the event
     */
    @FXML
    void OnKlickParicularCity(MouseEvent event) {

    	ShowReportBtn.setDisable(true);
    	AllCities.setSelected(false);
		OneCity.setSelected(true);
		CountryCbx.setVisible(true);
		countryLabel.setVisible(true);
		CityCbx.setVisible(true);
		CItyLabel.setVisible(true);
		all_city=0;
		one_city=1;

    }


	/**
	 * Click on show report.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void ClickOnShowReport(MouseEvent event) throws IOException {
		image1.setVisible(false);
		image2.setVisible(true);
		if(one_city==1) {
		    InfoToArray();
		    todateTxt.setValue(null);
		    dateFromTxt.setValue(null);
		    tablemapsinformation.getItems().clear();
		    clientMemberController.sendToServerDetailsOfTheReports(info);
		    ShowReportBtn.setDisable(true);
		}
		if(all_city==1) {
			 InfoToArray();
			 info[0]="allcity";
			 todateTxt.setValue(null);
			 dateFromTxt.setValue(null);
			 tablemapsinformation.getItems().clear();
			 clientMemberController.sendToServerDetailsOfTheReports(info);
			 ShowReportBtn.setDisable(true);
		}
	}


	/**
	 * Todateclick.
	 *
	 * @param event the event
	 */
	@FXML
	void Todateclick(MouseEvent event) {
		ShowReportBtn.setDisable(false);
	}



	/**
	 * Open manager page.
	 *
	 * @param userName the user name
	 */
	public void openManagerPage(String userName) {
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
	 * Open cont dep man page.
	 *
	 * @param userName the user name
	 */
	public void openContDepManPage(String userName) {
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
	 * Info to array.
	 */
	public void InfoToArray() {
		// arr[0]= allcity, arr[1]= from date, arr[2]= to date
		if(all_city==1)
		{
		   info[0] = "allcity";
		   info[1] = dateFromTxt.getValue().toString();
		   info[2] = todateTxt.getValue().toString();
		}
		// arr[0]= city name, arr[1]= from date, arr[2]= to date
		if(one_city==1)
		{
		   info[0] = CityCbx.getValue().toString();
		   info[1] = dateFromTxt.getValue().toString();
		   info[2] = todateTxt.getValue().toString();
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

	/**
	 * Load city combo box.
	 *
	 * @param arr the arr
	 */
	//////////////// Loading a city list into the combobox////////////////////////
	public void loadComboBox1(ArrayList<String> arr) {

		cityList = FXCollections.observableArrayList(arr);
		CityCbx.setItems(cityList);
	}

	/**
	 * Prints the city information by date.
	 *
	 * @param arr the arr
	 */
	public void PrintInformationByDate(ArrayList<String> arr) {
		ArrayList<Report> cityarr = new ArrayList<Report>();
		int size = arr.size();
		for (int i = 0; i < size / 6; i++) {
			cityarr.add(new Report());
			cityarr.get(i).setNumberOfMaps(arr.get(0));
			arr.remove(0);
			cityarr.get(i).setOnetimepurchases(arr.get(0));
			arr.remove(0);
			cityarr.get(i).setSubscriptions(arr.get(0));
			arr.remove(0);
			cityarr.get(i).setSubscriptionRenewals(arr.get(0));
			arr.remove(0);
			cityarr.get(i).setViews(arr.get(0));
			arr.remove(0);
			cityarr.get(i).setSubscribedDownloads(arr.get(0));
			arr.remove(0);

		}

		synchronized (lock) {

			try {
				lock.wait(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (cityarr != null) {
				for (int i = 0; i < cityarr.size(); i++) {

					tablemapsinformation.getItems().add(cityarr.get(i));
				}
				image1.setVisible(true);
				image2.setVisible(false);
			}
		}

	}

	// -------------------------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

}