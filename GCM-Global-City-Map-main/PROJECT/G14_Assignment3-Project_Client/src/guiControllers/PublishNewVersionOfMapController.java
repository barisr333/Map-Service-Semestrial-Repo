package guiControllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;
import entities.Map;
import entities.PointOfInterest;
import entities.Purchase;
import entities.Tour;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systemFunctionality.ClientMemberController;
import systemFunctionality.ValidationTests;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.util.concurrent.TimeUnit;

// TODO: Auto-generated Javadoc
/**
 * The Class PublishNewVersionOfMapController.
 */
public class PublishNewVersionOfMapController {

	/**
	 * The Class lessapptl.
	 */
	public class lessapptl {

		/** The id. */
		private int id;
		
		/** The country name. */
		private String countryName;
		
		/** The city name. */
		private String cityName;
		
		/** The rate. */
		private double rate;
		
		/** The sub rate. */
		private double subRate;
		
		/** The description. */
		private String description;

		/**
		 * Instantiates a new lessapptl.
		 *
		 * @param id the id
		 * @param county the county
		 * @param city the city
		 * @param rate the rate
		 * @param subrate the subrate
		 * @param desc the desc
		 */
		public lessapptl(int id, String county, String city, double rate, double subrate, String desc) {
			super();
			this.id = id;
			this.countryName = county;
			this.cityName = city;
			this.rate = rate;
			this.subRate = subrate;
			this.description = desc;
		}

		/**
		 * Gets the id.
		 *
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * Sets the id.
		 *
		 * @param id the new id
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * Gets the country name.
		 *
		 * @return the country name
		 */
		public String getCountryName() {
			return countryName;
		}

		/**
		 * Sets the country name.
		 *
		 * @param countryName the new country name
		 */
		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}

		/**
		 * Gets the city name.
		 *
		 * @return the city name
		 */
		public String getCityName() {
			return cityName;
		}

		/**
		 * Sets the city name.
		 *
		 * @param cityName the new city name
		 */
		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		/**
		 * Gets the rate.
		 *
		 * @return the rate
		 */
		public double getRate() {
			return rate;
		}

		/**
		 * Sets the rate.
		 *
		 * @param rate the new rate
		 */
		public void setRate(double rate) {
			this.rate = rate;
		}

		/**
		 * Gets the sub rate.
		 *
		 * @return the sub rate
		 */
		public double getSubRate() {
			return subRate;
		}

		/**
		 * Sets the sub rate.
		 *
		 * @param subRate the new sub rate
		 */
		public void setSubRate(double subRate) {
			this.subRate = subRate;
		}

		/**
		 * Gets the description.
		 *
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * Sets the description.
		 *
		 * @param description the new description
		 */
		public void setDescription(String description) {
			this.description = description;
		}

	}

	/**
	 * The Class allapptl.
	 */
	public class allapptl {

		/** The id. */
		private int id;
		
		/** The country name. */
		private String countryName;
		
		/** The city name. */
		private String cityName;
		
		/** The oldrate. */
		private double oldrate;
		
		/** The newrate. */
		private double newrate;
		
		/** The oldsub rate. */
		private double oldsubRate;
		
		/** The newsub rate. */
		private double newsubRate;
		
		/** The description. */
		private String description;

		/**
		 * Instantiates a new allapptl.
		 *
		 * @param id the id
		 * @param county the county
		 * @param city the city
		 * @param oldrate the oldrate
		 * @param newrate the newrate
		 * @param oldsubRate the oldsub rate
		 * @param newsubRate the newsub rate
		 * @param desc the desc
		 */
		public allapptl(int id, String county, String city, double oldrate, double newrate, double oldsubRate,
				double newsubRate, String desc) {
			super();
			this.id = id;
			this.countryName = county;
			this.cityName = city;
			this.oldrate = oldrate;
			this.newrate = newrate;
			this.oldsubRate = oldsubRate;
			this.newsubRate = newsubRate;
			this.description = desc;
		}

		/**
		 * Gets the id.
		 *
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * Sets the id.
		 *
		 * @param id the new id
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * Gets the country name.
		 *
		 * @return the country name
		 */
		public String getCountryName() {
			return countryName;
		}

		/**
		 * Sets the country name.
		 *
		 * @param countryName the new country name
		 */
		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}

		/**
		 * Gets the city name.
		 *
		 * @return the city name
		 */
		public String getCityName() {
			return cityName;
		}

		/**
		 * Sets the city name.
		 *
		 * @param cityName the new city name
		 */
		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		/**
		 * Gets the oldrate.
		 *
		 * @return the oldrate
		 */
		public double getOldrate() {
			return oldrate;
		}

		/**
		 * Sets the oldrate.
		 *
		 * @param oldrate the new oldrate
		 */
		public void setOldrate(double oldrate) {
			this.oldrate = oldrate;
		}

		/**
		 * Gets the newrate.
		 *
		 * @return the newrate
		 */
		public double getNewrate() {
			return newrate;
		}

		/**
		 * Sets the newrate.
		 *
		 * @param newrate the new newrate
		 */
		public void setNewrate(double newrate) {
			this.newrate = newrate;
		}

		/**
		 * Gets the oldsub rate.
		 *
		 * @return the oldsub rate
		 */
		public double getOldsubRate() {
			return oldsubRate;
		}

		/**
		 * Sets the oldsub rate.
		 *
		 * @param oldsubRate the new oldsub rate
		 */
		public void setOldsubRate(double oldsubRate) {
			this.oldsubRate = oldsubRate;
		}

		/**
		 * Gets the newsub rate.
		 *
		 * @return the newsub rate
		 */
		public double getNewsubRate() {
			return newsubRate;
		}

		/**
		 * Sets the newsub rate.
		 *
		 * @param newsubRate the new newsub rate
		 */
		public void setNewsubRate(double newsubRate) {
			this.newsubRate = newsubRate;
		}

		/**
		 * Gets the description.
		 *
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * Sets the description.
		 *
		 * @param description the new description
		 */
		public void setDescription(String description) {
			this.description = description;
		}

	}

	/**
	 * The Class keeplacesformap.
	 */
	public static class keeplacesformap{


		/** The oldlistof poi. */
		public List<PointOfInterest> oldlistofPoi;
		
		/** The newlistof poi. */
		public List<PointOfInterest> newlistofPoi;

		/**
		 * Instantiates a new keeplacesformap.
		 *
		 * @param oldlistofPoi the oldlistof poi
		 * @param newlistofPoi the newlistof poi
		 */
		public keeplacesformap(List<PointOfInterest> oldlistofPoi, List<PointOfInterest> newlistofPoi) {
			super();
			this.oldlistofPoi = oldlistofPoi;
			this.newlistofPoi = newlistofPoi;
		}

		/**
		 * Gets the oldlistof poi.
		 *
		 * @return the oldlistof poi
		 */
		public List<PointOfInterest> getOldlistofPoi() {
			return oldlistofPoi;
		}

		/**
		 * Sets the oldlistof poi.
		 *
		 * @param oldlistofPoi the new oldlistof poi
		 */
		public void setOldlistofPoi(List<PointOfInterest> oldlistofPoi) {
			this.oldlistofPoi = oldlistofPoi;
		}

		/**
		 * Gets the newlistof poi.
		 *
		 * @return the newlistof poi
		 */
		public List<PointOfInterest> getNewlistofPoi() {
			return newlistofPoi;
		}

		/**
		 * Sets the newlistof poi.
		 *
		 * @param newlistofPoi the new newlistof poi
		 */
		public void setNewlistofPoi(List<PointOfInterest> newlistofPoi) {
			this.newlistofPoi = newlistofPoi;
		}


	}


	/** The back. */
	@FXML
	private Button back;

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

	/** The anchor pane. */
	@FXML
	private AnchorPane anchorPane;

	/** The lessapptl. */
	@FXML
	private TableView<lessapptl> lessapptl;

	/** The tlid. */
	@FXML
	private TableColumn<lessapptl, String> tlid;

	/** The tlcountry. */
	@FXML
	private TableColumn<lessapptl, String> tlcountry;

	/** The tlcity. */
	@FXML
	private TableColumn<lessapptl, String> tlcity;

	/** The tlrate. */
	@FXML
	private TableColumn<lessapptl, String> tlrate;

	/** The tlsubrate. */
	@FXML
	private TableColumn<lessapptl, String> tlsubrate;

	/** The tldescription. */
	@FXML
	private TableColumn<lessapptl, String> tldescription;

	/** The Approve. */
	@FXML
	private Button Approve;

    /** The gcm manager. */
    @FXML
    private ImageView gcm_manager;

    /** The image gcm content. */
    @FXML
    private ImageView image_gcm_content;

	/** The allapptl. */
	@FXML
	private TableView<allapptl> allapptl;

	/** The tlid 1. */
	@FXML
	private TableColumn<allapptl, String> tlid1;

	/** The tlcountry 1. */
	@FXML
	private TableColumn<allapptl, String> tlcountry1;

	/** The tlcity 1. */
	@FXML
	private TableColumn<allapptl, String> tlcity1;

	/** The tloldrate. */
	@FXML
	private TableColumn<allapptl, String> tloldrate;

	/** The tlnewrate. */
	@FXML
	private TableColumn<allapptl, String> tlnewrate;

	/** The tloldsubrate. */
	@FXML
	private TableColumn<allapptl, String> tloldsubrate;

	/** The tlnewsubrate. */
	@FXML
	private TableColumn<allapptl, String> tlnewsubrate;

	/** The tldescription 1. */
	@FXML
	private TableColumn<allapptl, String> tldescription1;

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

	/** The added table 1. */
	@FXML
	private TableView<PointOfInterest> addedTable1;

	/** The name col 1. */
	@FXML
	private TableColumn<PointOfInterest, String> nameCol1;

	/** The type col 1. */
	@FXML
	private TableColumn<PointOfInterest, String> typeCol1;

	/** The desc col 1. */
	@FXML
	private TableColumn<PointOfInterest, String> descCol1;

	/** The acc col 1. */
	@FXML
	private TableColumn<PointOfInterest, String> accCol1;

	/** The time col 1. */
	@FXML
	private TableColumn<PointOfInterest, String> timeCol1;

	/** The address col 1. */
	@FXML
	private TableColumn<PointOfInterest, String> addressCol1;

	/** The mapid. */
	int mapid;
	
	/** The oldlistof poi. */
	public List<PointOfInterest> oldlistofPoi;
	
	/** The newlistof poi. */
	public List<PointOfInterest> newlistofPoi;
	
	/** The templistextended. */
	public List<allapptl> templistextended;
	
	/** The templist. */
	public List<lessapptl> templist;
	
	/** The likethelist. */
	public HashMap <Integer,keeplacesformap> likethelist;
	
	/** The client member controller. */
	private ClientMemberController clientMemberController;
	
	/** The publish new version of map controller. */
	public static PublishNewVersionOfMapController publishNewVersionOfMapController;
	
	/** The default selection model. */
	TableViewSelectionModel<allapptl> defaultSelectionModel;
	
	/** The default selection model 1. */
	TableViewSelectionModel<lessapptl> defaultSelectionModel1;

	/** The Tab menu. */
	@FXML
	private HBox TabMenu;

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

	/**
	 * Back on click.
	 *
	 * @param event the event
	 */
	@FXML
	void BackOnClick(MouseEvent event) {

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
					Scene scene = new Scene(root, 875, 650);
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

	// -------------------------------------------------------------------------------------------//
	// Getters and setters
	// methods---------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//


	/**
	 * Instantiates a new publish new version of map controller.
	 */
	public PublishNewVersionOfMapController() {
		publishNewVersionOfMapController = this;
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
	 * Gets the publish new version of map controller.
	 *
	 * @return the publish new version of map controller
	 */
	public static PublishNewVersionOfMapController GetPublishNewVersionOfMapController() {
		if (publishNewVersionOfMapController == null)
			publishNewVersionOfMapController = new PublishNewVersionOfMapController();
		return publishNewVersionOfMapController;
	}

    //------------------------------------------------------------------------------------------------//

	/**
     * Approve on click.
     *
     * @param event the event
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @FXML
	void ApproveOnClick(MouseEvent event) throws IOException {
		if(allapptl.getSelectionModel().isEmpty())
		{
			 Platform.runLater(new Runnable() {
		 			@Override
		 			public void run() {
		 				ValidationTests.printInfoMsg("Approve State", "there are not selected map waiting for approvement have a good day.");
		 			}
		 		});
		}
		else
		{
		TablePosition pos = allapptl.getSelectionModel().getSelectedCells().get(0);
		int row = pos.getRow();
		allapptl selected = allapptl.getItems().get(row);
		String id = Integer.toString(selected.getId());

		if((selected.getOldrate()!=selected.getNewrate())||(selected.getOldsubRate()!=selected.getNewsubRate()))
		{

			clientMemberController.SendToserverapproverate(id);
		}
		else
		{

			clientMemberController.SendToserverapprovepoi(id);
		}
		}



	}

	/**
	 * Selectedrow.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void Selectedrow(MouseEvent event) throws IOException {


		addedTable.getItems().clear();
		addedTable1.getItems().clear();
		if(allapptl.getSelectionModel().isEmpty())
		{
			 Platform.runLater(new Runnable() {
		 			@Override
		 			public void run() {
		 				ValidationTests.printInfoMsg("List of maps state", "There are no maps to approve.");
		 			}
		 		});
		}
		else
		{
		TablePosition pos = allapptl.getSelectionModel().getSelectedCells().get(0);
		int row = pos.getRow();
 		allapptl selected = allapptl.getItems().get(row);
 		mapid=selected.getId();
		String id = Integer.toString(selected.getId());

		if(likethelist.containsKey(selected.getId())==true)
		{
			oldlistofPoi=likethelist.get(selected.getId()).getOldlistofPoi();
			newlistofPoi=likethelist.get(selected.getId()).getNewlistofPoi();

			for (int i = 0; i < oldlistofPoi.size(); i++) {
				addedTable.getItems().add(oldlistofPoi.get(i));
			}

			for (int i = 0; i < newlistofPoi.size(); i++) {
				addedTable1.getItems().add(newlistofPoi.get(i));
			}

		}
		else
		{

			clientMemberController.sendToServeridofmaptogetoldandnewpoi(id);

		}
		}

	}

	/**
	 * Selectedrow 1.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void Selectedrow1(MouseEvent event) throws IOException {


		addedTable.getItems().clear();
		addedTable1.getItems().clear();
		if(allapptl.getSelectionModel().isEmpty())
		{
			 Platform.runLater(new Runnable() {
		 			@Override
		 			public void run() {
		 				ValidationTests.printInfoMsg("List of maps state", "there are not maps left waiting for approvement have a good day.");
		 			}
		 		});
		}
		else
		{
		TablePosition pos = lessapptl.getSelectionModel().getSelectedCells().get(0);
		int row = pos.getRow();
		lessapptl selected = lessapptl.getItems().get(row);
		mapid=selected.getId();
		String id = Integer.toString(selected.getId());
		if(likethelist.containsKey(selected.getId()))
		{
			oldlistofPoi=likethelist.get(selected.getId()).getOldlistofPoi();
			newlistofPoi=likethelist.get(selected.getId()).getNewlistofPoi();

			for (int i = 0; i < oldlistofPoi.size(); i++) {
				addedTable.getItems().add(oldlistofPoi.get(i));
			}

			for (int i = 0; i < newlistofPoi.size(); i++) {
				addedTable1.getItems().add(newlistofPoi.get(i));
			}

		}

		else
		{
			clientMemberController.sendToServeridofmaptogetoldandnewpoi(id);

		}
		}


    }



	/**
	 * Initialize.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void initialize() throws IOException {

		likethelist=new HashMap <Integer,keeplacesformap>();

		if (gcmMainController.user.getPermission() == 1){
			TabMenu.setVisible(false);
			gcm_manager.setVisible(true);
		}

		else{
			TabMenu.setVisible(true);
			image_gcm_content.setVisible(true);
		}

		defaultSelectionModel = allapptl.getSelectionModel();
		defaultSelectionModel1 = lessapptl.getSelectionModel();

		clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setClientPublishNewVersionOfMapController(this);

		descCol.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("description"));
		nameCol.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("name"));
		typeCol.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("type"));
		addressCol.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("address"));
		accCol.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("accessible"));
		timeCol.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("time"));
		addedTable.setStyle("-fx-focus-color: transparent;");

		descCol1.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("description"));
		nameCol1.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("name"));
		typeCol1.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("type"));
		addressCol1.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("address"));
		accCol1.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("accessible"));
		timeCol1.setCellValueFactory(new PropertyValueFactory<PointOfInterest, String>("time"));
		addedTable1.setStyle("-fx-focus-color: transparent;");

		if (gcmMainController.user.getPermission() == 1) {
			lessapptl.setVisible(false);
			allapptl.setVisible(true);
			tlid1.setCellValueFactory(new PropertyValueFactory<allapptl, String>("id"));
			tlcountry1.setCellValueFactory(new PropertyValueFactory<allapptl, String>("countryName"));
			tlcity1.setCellValueFactory(new PropertyValueFactory<allapptl, String>("cityName"));
			tloldrate.setCellValueFactory(new PropertyValueFactory<allapptl, String>("oldrate"));
			tlnewrate.setCellValueFactory(new PropertyValueFactory<allapptl, String>("newrate"));
			tloldsubrate.setCellValueFactory(new PropertyValueFactory<allapptl, String>("oldsubRate"));
			tlnewsubrate.setCellValueFactory(new PropertyValueFactory<allapptl, String>("newsubRate"));
			tldescription1.setCellValueFactory(new PropertyValueFactory<allapptl, String>("description"));
			clientMemberController.sendToServerPublishnewversionalltb();



		  }

		else {
			lessapptl.setVisible(true);
			allapptl.setVisible(false);
			tlid.setCellValueFactory(new PropertyValueFactory<lessapptl, String>("id"));
			tlcountry.setCellValueFactory(new PropertyValueFactory<lessapptl, String>("countryName"));
			tlcity.setCellValueFactory(new PropertyValueFactory<lessapptl, String>("cityName"));
			tlrate.setCellValueFactory(new PropertyValueFactory<lessapptl, String>("rate"));
			tlsubrate.setCellValueFactory(new PropertyValueFactory<lessapptl, String>("subrate"));
			tldescription.setCellValueFactory(new PropertyValueFactory<lessapptl, String>("description"));
			clientMemberController.sendToServerPublishnewversiontb();

		}
	}

	/**
	 * Set old POI objects list.
	 *
	 * @param array the array
	 */
	public void filloldpoi(ArrayList<String> array) {
		oldlistofPoi = new ArrayList<PointOfInterest>();
		int size = array.size();
		for (int i = 0; i < size / 6; i++) {
			oldlistofPoi.add(new PointOfInterest(array.get(0), array.get(1), array.get(2), array.get(3), array.get(4),
					array.get(5)));
			for (int j = 0; j < 6; j++)
				array.remove(0);
		}

		for (int i = 0; i < oldlistofPoi.size(); i++) {
			addedTable.getItems().add(oldlistofPoi.get(i));
		}

		keeplacesformap keep=new keeplacesformap(oldlistofPoi,newlistofPoi);
		likethelist.put(mapid, keep);


	}

	/**
	 * Set POI objects list.
	 *
	 * @param array the array
	 */
	public void fillnewpoi(ArrayList<String> array) {
		newlistofPoi = new ArrayList<PointOfInterest>();
		int size = array.size();
		for (int i = 0; i < size / 6; i++) {
			newlistofPoi.add(new PointOfInterest(array.get(0), array.get(1), array.get(2), array.get(3), array.get(4),
					array.get(5)));
			for (int j = 0; j < 6; j++)
				array.remove(0);
		}

		for (int i = 0; i < newlistofPoi.size(); i++) {
			addedTable1.getItems().add(newlistofPoi.get(i));
		}

	}

	/**
	 * Set extended list of Map objects.
	 *
	 * @param arr the arr
	 */
	public void fillmaplistextended(ArrayList<String> arr) {

		ArrayList<allapptl> templistextended = new ArrayList<allapptl>();
		int size = arr.size();
		for (int i = 0; i < size / 8; i++) {
			templistextended.add(new allapptl(Integer.parseInt(arr.get(0)), arr.get(1), arr.get(2),
					Double.parseDouble(arr.get(3)), Double.parseDouble(arr.get(4)), Double.parseDouble(arr.get(5)),
					Double.parseDouble(arr.get(6)), arr.get(7)));
			for (int j = 0; j < 8; j++)
				arr.remove(0);
		}

		for (int i = 0; i < templistextended.size(); i++) {
			allapptl.getItems().add(templistextended.get(i));
		}



	}

	/**
	 * Set list of Map objects.
	 *
	 * @param arr the arr
	 */
	public void fillmaplist(ArrayList<String> arr) {

		ArrayList<lessapptl> templist = new ArrayList<lessapptl>();
		int size = arr.size();
		for (int i = 0; i < size / 6; i++) {
			templist.add(new lessapptl(Integer.parseInt(arr.get(0)), arr.get(1), arr.get(2),
					Double.parseDouble(arr.get(3)), Double.parseDouble(arr.get(4)), arr.get(5)));
			for (int j = 0; j < 6; j++)
				arr.remove(0);
		}

		for (int i = 0; i < templist.size(); i++) {
			lessapptl.getItems().add(templist.get(i));
		}

	}

	/**
	 * Clear UI and notify Manager of success after approving new map rates or new maps.
	 *
	 * @param arr the arr
	 */
	public void afterApprovedrate(String arr) {

		allapptl.getItems().clear();
		lessapptl.getItems().clear();
		addedTable.getItems().clear();
		addedTable1.getItems().clear();
		try {
			this.initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				ValidationTests.printInfoMsg("Approve State", "You have approved the map rates successfully");
			}
		});

	}

     /**
      * Clear UI and notify Manager of success after approving items.
      *
      * @param arr the arr
      */
     public void afterApprovedpoi(String arr) {

    	allapptl.getItems().clear();
    	lessapptl.getItems().clear();
    	addedTable.getItems().clear();
 		addedTable1.getItems().clear();
    	 try {
			this.initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 Platform.runLater(new Runnable() {
 			@Override
 			public void run() {
 				ValidationTests.printInfoMsg("Approve State", "You have approved the map poi successfully");
 			}
 		});


	}


}

