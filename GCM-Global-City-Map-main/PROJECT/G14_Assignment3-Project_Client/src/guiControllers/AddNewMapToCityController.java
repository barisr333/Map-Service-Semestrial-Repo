package guiControllers;

import systemFunctionality.ClientMemberController;
import systemFunctionality.ValidationTests;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.application.Platform;
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
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import systemFunctionality.ClientMemberController;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.File;
import java.awt.Desktop;
import javax.imageio.ImageIO;

import entities.City;
import entities.Map;
import entities.PointOfInterest;
import javafx.embed.swing.SwingFXUtils;
import java.awt.image.BufferedImage;
import javafx.scene.layout.Pane;
import javafx.scene.control.ScrollPane;
import javafx.scene.Group;
import guiControllers.gcmMainController;

// TODO: Auto-generated Javadoc
/**
 * The Class AddNewMapToCityController.
 */
public class AddNewMapToCityController {
//-------------------------------------------------------------------------------------------//
// GUI components attribute------------------------------------------------------------------//
/** The image content emp. */
//-------------------------------------------------------------------------------------------//
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

	/** The rate txt. */
	@FXML
	private TextField rate_Txt;

	/** The Country cbx. */
	@FXML
	private ComboBox<String> CountryCbx;

	/** The description txt. */
	@FXML
	private TextArea description_Txt;

	/** The City cbx. */
	@FXML
	private ComboBox<String> CityCbx;

	/** The Subrate txt. */
	@FXML
	private TextField Subrate_Txt;

	/** The add btn. */
	@FXML
	private Button addBtn;

	/** The Tab menu. */
	@FXML
	private HBox TabMenu;

	/** The add mapbtn. */
	@FXML
	private Button addMapbtn;

	/** The map image. */
	@FXML
	private ImageView mapImage;

	/** The anchor pane scroll. */
	@FXML
	private AnchorPane anchorPaneScroll;

	/** The zoom slider. */
	@FXML
	private Slider zoom_slider;

	/** The map scrollpane. */
	@FXML
	private ScrollPane map_scrollpane;

	/** The zoom outbtn. */
	@FXML
	private Button zoomOutbtn;

	/** The zoom inbtn. */
	@FXML
	private Button zoomInbtn;

	// -------------------------------------------------------------------------------------------//
	// Internal Class
	// attributes-----------------------------------------------------------------//
	/** The client member controller. */
	// -------------------------------------------------------------------------------------------//
	private ClientMemberController clientMemberController;
	
	/** The add new map to city controller. */
	public static AddNewMapToCityController addNewMapToCityController;
	
	/** The country list. */
	ObservableList<String> countryList;
	
	/** The city list. */
	ObservableList<String> cityList;
	
	/** The Registration info. */
	private String[] RegistrationInfo = new String[9];
	
	/** The desktop. */
	private Desktop desktop = Desktop.getDesktop();
	
	/** The file. */
	public File file;
	
	/** The file chooser. */
	final FileChooser fileChooser = new FileChooser();
	
	/** The Image. */
	String Image = new String();
	
	/** The zoom group. */
	Group zoomGroup;
	
	/** The file content. */
	byte[] fileContent;
	
	/** The lock. */
	private Object lock = new Object();
	
	/** The map. */
	Map map;

	// -------------------------------------------------------------------------------------------//
	// Getters and setters
	// methods---------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Instantiates a new adds the new map to city controller.
	 */
	public AddNewMapToCityController() {
		addNewMapToCityController = this;
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
	 * Gets the add new map to city controller.
	 *
	 * @return the adds the new map to city controller
	 */
	public static AddNewMapToCityController GetAddNewMapToCityController() {
		if (addNewMapToCityController == null)
			addNewMapToCityController = new AddNewMapToCityController();
		return addNewMapToCityController;
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
	@FXML
	void initialize() throws IOException {

		Group contentGroup = new Group();
		zoomGroup = new Group();
		contentGroup.getChildren().add(zoomGroup);
		zoomGroup.getChildren().add(map_scrollpane.getContent());
		map_scrollpane.setContent(contentGroup);

		map_scrollpane.setVisible(false);
		zoom_slider.setVisible(false);
		zoomInbtn.setVisible(false);
		zoomOutbtn.setVisible(false);

		zoom_slider.setMin(1.0);
		zoom_slider.setMax(3.5);
		zoom_slider.setValue(1.0);
		zoom_slider.valueProperty().addListener((o, oldVal, newVal) -> zoom((Double) newVal));

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

		clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setClientAddNewMapToCityController(this);
		clientMemberController.sendToServerCountry();

		CountryCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By clicking on a value inside the
																			// combobox, we will print to ////

			if (newItem != null) {
				try {
					clientMemberController.sendToServerState(CountryCbx.getValue().toString());
					synchronized (lock) {

						try {
							lock.wait(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

			}
		});

	}

	// -------------------------------------------------------------------------------------------//
	// Cases of events from
	// GUI------------------------------------------------------------------//
	/**
	 * Zoom in.
	 *
	 * @param event the event
	 */
	// -------------------------------------------------------------------------------------------//
	@FXML
	void zoomIn(ActionEvent event) {
		double sliderVal = zoom_slider.getValue();
		zoom_slider.setValue(sliderVal += 0.1);
		System.out.println(zoom_slider.getValue());
	}

	/**
	 * Zoom out.
	 *
	 * @param event the event
	 */
	@FXML
	void zoomOut(ActionEvent event) {
		double sliderVal = zoom_slider.getValue();
		zoom_slider.setValue(sliderVal + -0.1);
		System.out.println(zoom_slider.getValue());
	}

	/**
	 * Adds the map on click.
	 *
	 * @param event the event
	 */
	@FXML
	void addMapOnClick(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		configuringFileChooser(fileChooser);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {

					file = fileChooser.showOpenDialog(primaryStage);
					BufferedImage bufferedImage = ImageIO.read(file);
					Image image = SwingFXUtils.toFXImage(bufferedImage, null);
					Image = file.getAbsolutePath();
					////////////////////////////////////////////////////////
					fileContent = Files.readAllBytes(file.toPath());
					//////////////////////////////////////////////////////////
					mapImage.setImage(image);

					if (file != null) {
					}

					zoom_slider.setVisible(true);
					zoomInbtn.setVisible(true);
					zoomOutbtn.setVisible(true);
					map_scrollpane.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Click on add.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void Click_on_add(MouseEvent event) throws IOException {
		if (checkFields()) {
			InsertDetailsInfoToArray();
			clientMemberController.sendToServerInsertMap(RegistrationInfo);
			clear_value_from_text();

		}
	}

	/**
	 * Back on click.
	 *
	 * @param event the event
	 */
	@FXML
	void backOnClick(MouseEvent event) {
		EditMapContent.flag2 = 0;
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
	/**
	 * Zoom settings.
	 *
	 * @param scaleValue the scale value
	 */
	// -------------------------------------------------------------------------------------------//
	private void zoom(double scaleValue) {
		double scrollH = map_scrollpane.getHvalue();
		double scrollV = map_scrollpane.getVvalue();
		zoomGroup.setScaleX(scaleValue);
		zoomGroup.setScaleY(scaleValue);
		map_scrollpane.setHvalue(scrollH);
		map_scrollpane.setVvalue(scrollV);
	}

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
////////////////Loading a city list into the combobox////////////////////////
	public void loadComboBox1(ArrayList<String> arr) {

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				cityList = FXCollections.observableArrayList(arr);
				CityCbx.setItems(cityList);
			}
		});

	}

	/**
	 * Check fields.
	 *
	 * @return true, if successful
	 */
	public boolean checkFields() {
		if (ValidationTests.isFieldEmpty(rate_Txt.getText()) || ValidationTests.isFieldEmpty(Subrate_Txt.getText())
				|| ValidationTests.isFieldEmpty(description_Txt.getText()))
			return false;
		if (!ValidationTests.isRateDouble(rate_Txt.getText()) || !ValidationTests.isRateDouble(Subrate_Txt.getText()))
			return false;
		if (CityCbx.getValue() == null) {
			ValidationTests.printErrorMsg("Error", "You must select a city!");
			return false;
		}
		return true;

	}

	/**
	 * Open file.
	 *
	 * @param file the file
	 */
	private void openFile(File file) {
		try {
			this.desktop.open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configuring file chooser.
	 *
	 * @param fileChooser the file chooser
	 */
	private void configuringFileChooser(FileChooser fileChooser) {
		// Set title for FileChooser
		fileChooser.setTitle("Select Pictures");

		// Set Initial Directory
		// fileChooser.setInitialDirectory(new
		// File("D:/Programs/eclipse-jee-photon-R-win32-x86_64-with
		// plugins/eclipse-jee-photon-R-win32-x86_64/workspace/G14_Assignment3-Project_Client/sourceFolder/All
		// pictures"));

		// Add Extension Filters
		fileChooser.getExtensionFilters().addAll(//
				new FileChooser.ExtensionFilter("PNG", "*.png"));
	}

	/**
	 * Insert details info to array to send to server.
	 * Inserting data to array to send to server
	 */
	public void InsertDetailsInfoToArray() {
		RegistrationInfo[0] = CountryCbx.getValue().toString();
		RegistrationInfo[1] = CityCbx.getValue().toString();
		RegistrationInfo[3] = rate_Txt.getText();
		RegistrationInfo[4] = Subrate_Txt.getText();
		RegistrationInfo[6] = description_Txt.getText();
	}

	/**
	 * Clear value from text on page.
	 * To be called whenever fields need to be cleared in GUI
	 */
	public void clear_value_from_text() {
		CountryCbx.setValue("");
		CityCbx.setValue("");
		rate_Txt.setText("");
		Subrate_Txt.setText("");
		description_Txt.setText("");
		mapImage.imageProperty().set(null);
		zoom_slider.setVisible(false);
		zoomInbtn.setVisible(false);
		zoomOutbtn.setVisible(false);
		map_scrollpane.setVisible(false);
	}

	/**
	 * Notify user map has been added successfully.
	 */
	public void aftermapadded() {

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				ValidationTests.printInfoMsg("Add State",
						"You have added the map successfully now is waiting for approvement");
			}
		});

	}

	// -------------------------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

}
