package guiControllers;

import systemFunctionality.ClientMemberController;
import systemFunctionality.ValidationTests;
import java.awt.image.BufferedImage;
import javafx.scene.control.RadioButton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;

import entities.Map;
import entities.PointOfInterest;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systemFunctionality.ClientMemberController;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


// TODO: Auto-generated Javadoc
/**
 * The Class AddInterestedPlaceController.
 * 
 */
public class AddInterestedPlaceController {
	// -------------------------------------------------------------------------------------------//
	// GUI components
	// attribute------------------------------------------------------------------//
	/** The image content emp. */
	// -------------------------------------------------------------------------------------------//
	@FXML
	private ImageView image_content_emp;

	/** The msg btn. */
	@FXML
    private ImageView msgBtn;

	/** The gcm manager. */
	@FXML
	private ImageView gcm_manager;

	/** The image gcm content manger. */
	@FXML
	private ImageView image_gcm_content_manger;

	/** The back btn. */
	@FXML
	private Button backBtn;

	/** The Ok btn. */
	@FXML
	private Button OkBtn;

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

	/** The name place. */
	@FXML
	private TextField name_place;

	/** The address txt. */
	@FXML
	private TextField addressTxt;

	/** The type cbx. */
	@FXML
	private ComboBox<String> typeCbx;

	/** The Country cbx. */
	@FXML
	private ComboBox<String> CountryCbx;

	/** The City cbx. */
	@FXML
	private ComboBox<String> CityCbx;

	/** The Map cbx. */
	@FXML
	private ComboBox<String> MapCbx;

	/** The POI cbx. */
	@FXML
	private ComboBox<String> POICbx;

	/** The time txt. */
	@FXML
	private TextField timeTxt;

	/** The description txt. */
	@FXML
	private TextArea description_Txt;

	/** The Tab menu. */
	@FXML
	private HBox TabMenu;

	/** The image pane. */
	@FXML
	private Pane imagePane;

	/** The map image. */
	@FXML
	private ImageView mapImage;

	/** The pane 2. */
	@FXML
	private Pane pane2;
	
	/** The image pan 2. */
	@FXML
	private Pane imagePan2;

	/** The anchor pane. */
	@FXML
	private AnchorPane anchorPane;

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

	/** The anchor pane scroll. */
	@FXML
	private AnchorPane anchorPaneScroll;

	/** The yes radbtn. */
	@FXML
	private RadioButton yesRadbtn;

	/** The no radbtn. */
	@FXML
	private RadioButton noRadbtn;

	/** The anchor pane loc img. */
	@FXML
	private AnchorPane anchorPaneLocImg; // pane for the exist poi and add to
											// map.

	/** The Image loc img. */
											@FXML
	private ImageView ImageLocImg;

	/** The create new box. */
	@FXML
	private CheckBox createNewBox;

	/** The ast 1. */
	@FXML
    private ImageView ast1;

    /** The ast 2. */
    @FXML
    private ImageView ast2;

    /** The ast 3. */
    @FXML
    private ImageView ast3;

    /** The ast 4. */
    @FXML
    private ImageView ast4;

    /** The ast 5. */
    @FXML
    private ImageView ast5;

	// -------------------------------------------------------------------------------------------//
	// Internal Class
	// attributes-----------------------------------------------------------------//
	/** The client member controller. */
	// -------------------------------------------------------------------------------------------//
	private ClientMemberController clientMemberController;
	
	/** The add interested place controller. */
	public static AddInterestedPlaceController addInterestedPlaceController;
	
	/** The type list. */
	ObservableList<String> typeList;
	
	/** The country list. */
	ObservableList<String> countryList;
	
	/** The city list. */
	ObservableList<String> cityList;
	
	/** The map list. */
	ObservableList<String> mapList;
	
	/** The POI list. */
	ObservableList<String> POIList;
	
	/** The Registration info. */
	private String[] RegistrationInfo = new String[10];
	/**
	 * RegistrationInfo[0]=addressTxt.getText();
	 * RegistrationInfo[1]=name_place.getText();
	 * RegistrationInfo[2]=typeCbx.getValue().toString();
	 * RegistrationInfo[3]=timeTxt.getText();
	 * RegistrationInfo[4]=description_Txt.getText(); RegistrationInfo[5]=
	 * Double.toString(imgX); RegistrationInfo[6]= Double.toString(imgY);
	 * RegistrationInfo[7]= mapId; RegistrationInfo[8]= "No accessibility." ;
	 * RegistrationInfo[9]= "city name;
	 */
	public File file;
	
	/** The Image. */
	String Image = new String();
	
	/** The a. */
	// Image image;
	ImageView a = new ImageView();
	
	/** The image. */
	Image image = new Image(getClass().getResourceAsStream("qw.png"));
	
	/** The zoom group. */
	Group zoomGroup;
	
	/** The img X. */
	static double imgX;
	
	/** The img Y. */
	static double imgY;
	
	/** The lock. */
	private Object lock = new Object();
	
	/** The lock 2. */
	private Object lock2 = new Object();
	
	/** The PO iarr. */
	public ArrayList<PointOfInterest> POIarr = new ArrayList<PointOfInterest>();
	
	/** The PO iinfo. */
	ArrayList<String> POIinfo = new ArrayList<String>();
	
	/** The cur map. */
	Map curMap;
	
	/** The on this page. */
	public static boolean onThisPage;

	// -------------------------------------------------------------------------------------------//
	// Getters and setters
	// methods---------------------------------------------------------------//
	/**
	 * Instantiates a new adds the interested place controller.
	 */
	// -------------------------------------------------------------------------------------------//
	public AddInterestedPlaceController() {
		addInterestedPlaceController = this;
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
	 * Gets the add interested place controller.
	 *
	 * @return the adds the interested place controller
	 */
	public static AddInterestedPlaceController GetAddInterestedPlaceController() {
		if (addInterestedPlaceController == null)
			addInterestedPlaceController = new AddInterestedPlaceController();
		return addInterestedPlaceController;
	}

	// -------------------------------------------------------------------------------------------//
	// Initialize method - Happens when the fxml file
	// load---------------------------------------//
	/**
	 * Initialize.
	 * When initializing this page we initialize the zoom objects and check the permission of the user logged in.
	 * Also initial loading of combo boxes and listeners for them.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// -------------------------------------------------------------------------------------------//
	@FXML
	void initialize() throws IOException {
		onThisPage = true;
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

		typeList = FXCollections.observableArrayList("HistorcalSite", "Museum", "Hotel", "Resturaunt", "Park",
				"PublicPlace", "Store", "MovieTheater", "Other");
		typeCbx.setItems(typeList);
		clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setAddInterestedPlaceController(this);
		clientMemberController.sendToServerCountry();

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					CityCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By
																						// clicking
																						// on
																						// a
																						// value
																						// within
																						// the
																						// combobox,
																						// the
																						// city
																						// will
																						// be
																						// drawn//

						if (newItem != null) {
							try {
								clientMemberController.sendToServercity(CityCbx.getValue().toString());
								synchronized (lock) {

									try {
										lock.wait(500);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									// RegistrationInfo[9]=
									// CityCbx.getValue().toString();

								}

								clientMemberController.sendToServerGetAllPOIByCity(CityCbx.getValue().toString());

							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {

						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		MapCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By
																		// clicking
																		// on a
																		// value
																		// within
																		// the
																		// combobox,
																		// the
																		// city
																		// will
																		// be
																		// drawn//

			if (newItem != null) {
				try {
					POICbx.getItems().clear();
					clientMemberController.sendToServerGetMap(MapCbx.getValue().toString());
					clientMemberController.sendToServerGetMapId(MapCbx.getValue().toString());


					synchronized (lock) {

						try {
							lock.wait(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						clientMemberController.getPOIInMap(curMap.getId(), CityCbx.getValue());
						clientMemberController.sendToServerGetMapIntrePlaces(RegistrationInfo[7]);
						loadPOIComboBox1();
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

			}
		});

		POICbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By
																		// clicking
																		// on a
																		// value
																		// within
																		// the
																		// combobox,
																		// the
																		// city
																		// will
																		// be
																		// drawn//

			if (newItem != null) {
				uploadPOI(POICbx.getValue().toString());

			} else {

			}
		});

	}

	// -------------------------------------------------------------------------------------------//
	// Cases of events from
	// GUI------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Radio button no.
	 *
	 * @param event the event
	 */
	@FXML
	void noRadOnClick(ActionEvent event) {
		noRadbtn.setSelected(true);
		yesRadbtn.setSelected(false);
		RegistrationInfo[8] = "No accessibility.";

	}

	/**
	 * Radio button yes.
	 *
	 * @param event the event
	 */
	@FXML
	void yesRadOnClick(ActionEvent event) {
		yesRadbtn.setSelected(true);
		noRadbtn.setSelected(false);
		RegistrationInfo[8] = "Yes accessibility.";
	}

	/**
	 * When checking checkbox.
	 * Re-ordering and changing GUI according to whether user checked the 'Create new place' checkbox.
	 *
	 * @param event the event
	 */
	@FXML
	void onCheckClick(MouseEvent event) {
		if (!createNewBox.isSelected()) { 
			POICbx.setValue(null);
			POICbx.setDisable(true);
			addressTxt.setEditable(true);
			name_place.setEditable(true);
			timeTxt.setEditable(true);
			description_Txt.setEditable(true);
			yesRadbtn.setDisable(false);
			noRadbtn.setDisable(false);
			typeCbx.setDisable(false);
			ast1.setVisible(true);
			ast2.setVisible(true);
			ast3.setVisible(true);
			ast4.setVisible(true);
			ast5.setVisible(true);
			addressTxt.clear();
			name_place.clear();
			timeTxt.clear();
			description_Txt.clear();
			yesRadbtn.setSelected(false);
			noRadbtn.setSelected(false);
			typeCbx.setValue(null);
		}

		else {
			POICbx.setDisable(false);
			addressTxt.setEditable(false);
			name_place.setEditable(false);
			timeTxt.setEditable(false);
			description_Txt.setEditable(false);
			yesRadbtn.setDisable(true);
			noRadbtn.setDisable(true);
			ast1.setVisible(false);
			ast2.setVisible(false);
			ast3.setVisible(false);
			ast4.setVisible(false);
			ast5.setVisible(false);
			typeCbx.setDisable(true);
		}

	}

	/**
	 * Msg click. Notifies user of information on checkbox.
	 *
	 * @param event the event
	 */
	@FXML
    void msgClick(MouseEvent event) {

		ValidationTests.printInfoMsg("Information", "Check this box to create a new place of interest that doesn't currently exist.");
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
	 * Back on click.
	 *
	 * @param event the event
	 */
	@FXML
	void backOnClick(MouseEvent event) {
		EditMapContent.flag3 = 0;
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
	 * Click add.
	 * When the button is clicked the information array is filled to be sent to the Server. The user is then notified if the action was a success.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void Click_add(MouseEvent event) throws IOException {

		if (createNewBox.isSelected())
		{
			if (checkFields()) {
			String[] strArr=new String[9];
			if(yesRadbtn.isSelected())
				strArr[0]="Yes";
			else strArr[0]="No";
			strArr[1]=typeCbx.getValue().toString();
			strArr[2]=description_Txt.getText();
			strArr[3]=timeTxt.getText();
			strArr[4]=addressTxt.getText();
			strArr[5]=Double.toString(imgX);
			strArr[6]=Double.toString(imgY);
			strArr[7]=RegistrationInfo[7];
			strArr[8]=name_place.getText();
			clientMemberController.sendToServerInterested(strArr); // Sending data to server
			ValidationTests.printInfoMsg("Success", "New place of interest created successfully!");
			}
		}
		else
		{
		if (checkFields()) {
			InsertDetailsInfoToArray();

			if (POICbx.getSelectionModel().getSelectedIndex() == -1) {
				clientMemberController.sendToServerInterested(RegistrationInfo, POIarr.get(0), "No");
			}

			if (POICbx.getSelectionModel().getSelectedItem().toString().equals(null) == false) {
				for (int i = 0; i < POIarr.size(); i++) {
					if (POIarr.get(i).getName()
							.equals(POICbx.getSelectionModel().getSelectedItem().toString()) == true) {
						clientMemberController.sendToServerInterested(RegistrationInfo, POIarr.get(i), "Yes");
					}
				}

			}

			clear_value_from_text();
			a.setImage(null);
			ValidationTests.printInfoMsg("Place of interest added", "Place of Interest successfully added!");
		}
		}
	}

	/**
	 * Zoom in.
	 *
	 * @param event the event
	 */
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
	 * Image on clicke. Handler for interacting with the map image.
	 * Includes settings for width and height layouts and interacting with the anchor pane.
	 *
	 * @param event the event
	 */
	@FXML
	void imageOnClicke(MouseEvent event) {
		a.setLayoutX(event.getX() - 9);
		a.setLayoutY(event.getY() - 28);

		a.setFitHeight(30.0);
		a.setFitWidth(25.0);

		a.setPickOnBounds(true);
		a.setPreserveRatio(true);
		a.setSmooth(true);

		a.setImage(image);

		// We need to execute this to avoid from
		// "java.lang.IllegalArgumentException" that says "Children: duplicate
		// children added: parent = Pane[id=pane2]".
		// That exception called because when we click on the map to add image
		// of interesting place on the first time , and after seconds we decided
		// to change
		// the image of interesting place to different one, out goal is to
		// remove the first image and replace him with new one. So we need to
		// remove from the pane
		// the first image and add the new image to the new position.
		anchorPaneScroll.getChildren().remove(a);
		// add to pane
		anchorPaneScroll.getChildren().add(a);

		imgX = event.getX();
		imgY = event.getY();

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
	 * Insert details info to array. Used for sending information to server.
	 */
	// -------------------------------------------------------------------------------------------//
	public void InsertDetailsInfoToArray() {
		RegistrationInfo[0] = addressTxt.getText();
		RegistrationInfo[1] = name_place.getText();
		RegistrationInfo[2] = typeCbx.getValue().toString();
		RegistrationInfo[3] = timeTxt.getText();
		RegistrationInfo[4] = description_Txt.getText();
		RegistrationInfo[5] = Double.toString(imgX);
		RegistrationInfo[6] = Double.toString(imgY);
	}

	/**
	 * Insert map id.
	 *
	 * @param mapId the map id
	 */
	public void InsertMapId(String mapId) {
		curMap=new Map();
		curMap.setId(Integer.parseInt(mapId));
		RegistrationInfo[7] = mapId;
	}

	/**
	 * Zoom.
	 *
	 * @param scaleValue the scale value
	 */
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
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					countryList = FXCollections.observableArrayList(arr);
					CountryCbx.setItems(countryList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	//////////////// Loading a city list into the
	/**
	 * Load city combo box.
	 *
	 * @param arr the arr
	 */
	//////////////// combobox////////////////////////
	public void loadComboBox1(ArrayList<String> arr) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					cityList = FXCollections.observableArrayList(arr);
					CityCbx.setItems(cityList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	//////////////// Loading a POI list into the
	/**
	 * Load POI combo box 1.
	 */
	//////////////// combobox////////////////////////
	public void loadPOIComboBox1() {

		for(int i=0;i<POIarr.size();i++)
			for(int j=0;j<curMap.getPOIList().size();j++)
				if(POIarr.get(i).getName()==curMap.getPOIList().get(j).getName())
					POIarr.remove(i);

		for (int i = 0; i < POIarr.size(); i++)
				POIinfo.add(POIarr.get(i).getName());
		Collections.sort(POIinfo);
		POIList = FXCollections.observableArrayList(POIinfo);
		POICbx.setItems(POIList);
		POIarr.clear();
		POIinfo.clear();
	}

	//////////////// Loading a map list into the
	/**
	 * Load map combo box.
	 *
	 * @param arr the arr
	 */
	//////////////// combobox////////////////////////
	public void loadComboBox2(ArrayList<String> arr) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					mapList = FXCollections.observableArrayList(arr);
					MapCbx.setItems(mapList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Sets the map image view using OutputStream, File and Image objects, and appropriately changing zoom.
	 *
	 * @param imageFile the new map image view
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void setMapImageView(byte[] imageFile) throws IOException {
		File targetFile = new File("targetFile.PNG");
		FileOutputStream fos = new FileOutputStream(targetFile);
		fos.write(imageFile);

		BufferedImage bufferedImage = ImageIO.read(targetFile);
		Image image = SwingFXUtils.toFXImage(bufferedImage, null);
		mapImage.setImage(image);

		zoom_slider.setVisible(true);
		zoomInbtn.setVisible(true);
		zoomOutbtn.setVisible(true);
		map_scrollpane.setVisible(true);

	}

	/**
	 * Clear value from text on page when reset is needed.
	 */
	public void clear_value_from_text() {
		CountryCbx.setValue("");
		CityCbx.setValue("");
		description_Txt.setText("");
		mapImage.imageProperty().set(null);
		zoom_slider.setVisible(false);
		zoomInbtn.setVisible(false);
		zoomOutbtn.setVisible(false);
		map_scrollpane.setVisible(false);

	}

	/**
	 * New POI inserted.
	 */
	public void newPOIinserted()
	{

	}

	/**
	 * Map places by map ID. This method maps the required map to the image.
	 *
	 * @param mapCoord the map coord
	 */
	public void MapPlacesByMapID(ArrayList<String> mapCoord) {
		ArrayList<ImageView> imgArr = new ArrayList<ImageView>();

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				int j = 0;
				anchorPaneLocImg.getChildren().clear();// reset the points.
				for (int i = 0; i < mapCoord.size(); i += 2) {

					imgArr.add(new ImageView());

					imgArr.get(j).setLayoutX((Double.parseDouble(mapCoord.get(i)) - 9));
					imgArr.get(j).setLayoutY((Double.parseDouble(mapCoord.get(i + 1)) - 28));

					imgArr.get(j).setFitHeight(30.0);
					imgArr.get(j).setFitWidth(25.0);


					imgArr.get(j).setPickOnBounds(true);
					imgArr.get(j).setPreserveRatio(true);
					imgArr.get(j).setSmooth(true);

					imgArr.get(j).setImage(image);
					anchorPaneLocImg.getChildren().add(imgArr.get(j));
					j++;

				}
			}
		});
	}

	/**
	 * Check fields.
	 *
	 * @return true, if successful
	 */
	public boolean checkFields() {
		if (ValidationTests.isFieldEmpty(name_place.getText()) || ValidationTests.isFieldEmpty(addressTxt.getText())
				|| ValidationTests.isFieldEmpty(timeTxt.getText())
				|| ValidationTests.isFieldEmpty(description_Txt.getText()))
			return false;
		
		if (!ValidationTests.isAddressValid(addressTxt.getText())) {
			return false;
		}
		return true;

	}

	/**
	 * Save all POI info of city.
	 *
	 * @param Poi the poi
	 */
	public void saveAllPOIInfoOfCity(ArrayList<String> Poi) {
		int size = Poi.size();

		for (int i = 0; i < size / 7; i++) {
			POIarr.add(new PointOfInterest());

			POIarr.get(i).setIdPOI(Poi.get(0));
			Poi.remove(0);
			POIarr.get(i).setName(Poi.get(0));
			Poi.remove(0);
			POIarr.get(i).setType(Poi.get(0));
			Poi.remove(0);
			POIarr.get(i).setDescription(Poi.get(0));
			Poi.remove(0);
			POIarr.get(i).setAccessible(Poi.get(0));
			Poi.remove(0);
			POIarr.get(i).setTime(Poi.get(0));
			Poi.remove(0);
			POIarr.get(i).setAddress(Poi.get(0));
			Poi.remove(0);
		}
	}

	/**
	 * Set POI information.
	 *
	 * @param POIname the PO iname
	 */
	public void uploadPOI(String POIname) {
		for (int i = 0; i < POIarr.size(); i++) {
			if (POIarr.get(i).getName().equals(POIname)) {
				typeCbx.setValue(POIarr.get(i).getType());
				addressTxt.setText(POIarr.get(i).getAddress());
				if (POIarr.get(i).getAccessible().equals("No")) {
					noRadbtn.setSelected(true);
					yesRadbtn.setSelected(false);
				}
				if (POIarr.get(i).getAccessible().equals("Yes")) {
					yesRadbtn.setSelected(true);
					noRadbtn.setSelected(false);
				}

				name_place.setText(POIarr.get(i).getName());
				timeTxt.setText(POIarr.get(i).getTime());
				description_Txt.setText(POIarr.get(i).getDescription());
			}

		}
	}

	/**
	 * Sets POI list in local Map object.
	 *
	 * @param poiList the new in map
	 */
	public void setInMap(ArrayList<PointOfInterest> poiList)
	{
		curMap.setPOIList(poiList);

	}

}
