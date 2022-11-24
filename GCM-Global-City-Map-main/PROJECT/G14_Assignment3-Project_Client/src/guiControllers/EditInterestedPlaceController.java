package guiControllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.util.Duration;
import javax.imageio.ImageIO;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systemFunctionality.ClientMemberController;
import systemFunctionality.ValidationTests;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// TODO: Auto-generated Javadoc
/**
 * The Class EditInterestedPlaceController.
 */
public class EditInterestedPlaceController {
	
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

	/** The Tab menu. */
	@FXML
	private HBox TabMenu;

	/** The Country cbx. */
	@FXML
	private ComboBox<String> CountryCbx;

	/** The City cbx. */
	@FXML
	private ComboBox<String> CityCbx;

	/** The Map cbx. */
	@FXML
	private ComboBox<String> MapCbx;

	/** The type cbx. */
	@FXML
	private ComboBox<String> typeCbx;

	/** The Name cbx. */
	@FXML
	private ComboBox<String> NameCbx;

	/** The address txt. */
	@FXML
	private TextField addressTxt;

	/** The time txt. */
	@FXML
	private TextField timeTxt;

	/** The description txt. */
	@FXML
	private TextArea descriptionTxt;

	/** The edit btn. */
	@FXML
	private Button editBtn;

	/** The map scrollpane. */
	@FXML
	private ScrollPane map_scrollpane;

	/** The anchor pane scroll. */
	@FXML
	private AnchorPane anchorPaneScroll; // add the new POI to the map.

	/** The map image. */
	@FXML
	private ImageView mapImage;

	/** The anchor pane loc img. */
	@FXML
	private AnchorPane anchorPaneLocImg; // pane for the exist poi and add to map.

	/** The Image loc img. */
	@FXML
	private ImageView ImageLocImg;

	/** The zoom outbtn. */
	@FXML
	private Button zoomOutbtn;

	/** The zoom inbtn. */
	@FXML
	private Button zoomInbtn;

	/** The zoom slider. */
	@FXML
	private Slider zoom_slider;

	// -------------------------------------------------------------------------------------------//
	// Internal Class
	// attributes-----------------------------------------------------------------//
	/** The client member controller. */
	// -------------------------------------------------------------------------------------------//
	private ClientMemberController clientMemberController;
	
	/** The edit interested place controller. */
	public static EditInterestedPlaceController editInterestedPlaceController;
	
	/** The country list. */
	ObservableList<String> countryList;
	
	/** The city list. */
	ObservableList<String> cityList;
	
	/** The map list. */
	ObservableList<String> mapList;
	
	/** The palce name list. */
	ObservableList<String> palce_nameList;
	
	/** The type list. */
	ObservableList<String> typeList;
	
	/** The Registration info. */
	private String[] RegistrationInfo = new String[2];
	
	/** The place. */
	private String[] place = new String[3];   //place[0]=placename , place[1]=cordx , place[2]=cordy


	/** The file. */
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

	// -------------------------------------------------------------------------------------------//
	// Getters and setters
	// methods---------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Instantiates a new edits the interested place controller.
	 */
	public EditInterestedPlaceController() {
		editInterestedPlaceController = this;
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
	 * Gets the edit interested place controller.
	 *
	 * @return the edits the interested place controller
	 */
	public static EditInterestedPlaceController GetEditInterestedPlaceController() {
		if (editInterestedPlaceController == null)
			editInterestedPlaceController = new EditInterestedPlaceController();
		return editInterestedPlaceController;
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
		clientMemberController.setClientEditInterestedPlaceController(this);
		clientMemberController.sendToServerCountry();
		typeList = FXCollections.observableArrayList("HistorcalSite", "Museum", "Hotel", "Resturaunt", "Park",
				"PublicPlace", "Store", "MovieTheater", "Other");
		typeCbx.setItems(typeList);

		CountryCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By clicking on a value inside the
																			// combobox, we will print to ////

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

		CityCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By clicking on a value within the combobox,
																			// the city will be drawn//

			if (newItem != null) {
				try {
					clientMemberController.sendToServercity(CityCbx.getValue().toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

			}
		});

		MapCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By clicking on a value within the combobox,
																		// the city will be drawn//
			if (newItem != null) {
				try {
					clientMemberController.sendToServerMap(MapCbx.getValue().toString());
					clientMemberController.sendToServerGetMap(MapCbx.getValue().toString());
					clientMemberController.sendToServerGetMapId(MapCbx.getValue().toString());
					synchronized (lock) {

						try {
							lock.wait(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						clientMemberController.sendToServerGetMapIntrePlaces(RegistrationInfo[0]);
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

			}
		});

		NameCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By clicking on a value within the combobox,
																			// the city will be drawn//

			if (newItem != null) {

				try {
					clientMemberController.sentToServerGetMapCoord(NameCbx.getValue().toString());
					place[0]=NameCbx.getValue();
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
	// -------------------------------------------------------------------------------------------//


	
	/**
	 * Edits the map on click.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void EditMapOnClick(MouseEvent event) throws IOException {

		String[] arr = new String[7];
		arr[0] = place[0];
		arr[1] = typeCbx.getValue();
		arr[2] = addressTxt.getText();
		arr[3] = timeTxt.getText();
		arr[4] = descriptionTxt.getText();
		arr[5] = place[1];
		arr[6] = place[2];
		
		clientMemberController.sendToServerUpdatePOI(arr);

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
	 * Image on clicke.
	 *
	 * @param event the event
	 */
	@FXML
	void imageOnClicke(MouseEvent event) {

		System.out.println(event.getX());
		System.out.println(event.getY());
		;
		a.setLayoutX(event.getX() - 9);
		a.setLayoutY(event.getY() - 28);

		a.setFitHeight(30.0);
		a.setFitWidth(25.0);

		a.setPickOnBounds(true);
		a.setPreserveRatio(true);
		a.setSmooth(true);

		a.setImage(image);

		// We need to execute this to avoid from "java.lang.IllegalArgumentException"
		// that says "Children: duplicate children added: parent = Pane[id=pane2]".
		// That exception called because when we click on the map to add image of
		// interesting place on the first time , and after seconds we decided to change
		// the image of interesting place to different one, out goal is to remove the
		// first image and replace him with new one. So we need to remove from the pane
		// the first image and add the new image to the new position.
		anchorPaneScroll.getChildren().remove(a);
		// add to pane
		anchorPaneScroll.getChildren().add(a);

		imgX = event.getX();
		imgY = event.getY();

	}

	/**
	 * Back on click.
	 *
	 * @param event the event
	 */
	@FXML
	void backOnClick(MouseEvent event) {
		EditMapContent.flag8 = 0;
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
			Scene scene = new Scene(root, 850, 698);
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
	 * Sets the map co-ordinates animation using Timeline and KeyValue objects.
	 *
	 * @param arr the new map coord animation
	 */
	// -------------------------------------------------------------------------------------------//
	public void setMapCoordAnimation(ArrayList<String> arr) {

		// animation scroll to new position
		double mapWidth = zoomGroup.getBoundsInLocal().getWidth();
		double mapHeight = zoomGroup.getBoundsInLocal().getHeight();
		double scrollH = Double.parseDouble(arr.get(0)) / mapWidth;
		double scrollV = Double.parseDouble(arr.get(1)) / mapHeight;
		place[1]=arr.get(0);
		place[2]=arr.get(1);
		final Timeline timeline = new Timeline();
		final KeyValue kv1 = new KeyValue(map_scrollpane.hvalueProperty(), scrollH);
		final KeyValue kv2 = new KeyValue(map_scrollpane.vvalueProperty(), scrollV);
		final KeyFrame kf = new KeyFrame(Duration.millis(500), kv1, kv2);
		timeline.getKeyFrames().add(kf);
		timeline.play();
	}

	/**
	 * Insert map id.
	 *
	 * @param mapId the map id
	 */
	public void InsertMapId(String mapId) {
		RegistrationInfo[0] = mapId;
	}

	/**
	 * Zoom settings.
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
	 * Load map combo box.
	 *
	 * @param arr the arr
	 */
	//////////////// Loading a map list into the combobox////////////////////////
	public void loadComboBox2(ArrayList<String> arr) {

		mapList = FXCollections.observableArrayList(arr);
		MapCbx.setItems(mapList);
	}

	//////////////// Loading a place name list into the
	/**
	 * Load POI combo box.
	 *
	 * @param arr the arr
	 */
	//////////////// combobox////////////////////////
	public void laodplace(ArrayList<String> arr) {

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					palce_nameList = FXCollections.observableArrayList(arr);
					NameCbx.setItems(palce_nameList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Sets the map image view.
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
	 * Set map width, height layouts and interact with anchor pane to display map.
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
// Setting 'Location' parameters for width and height layouts
					imgArr.get(j).setLayoutX((Double.parseDouble(mapCoord.get(i)) - 9));
					imgArr.get(j).setLayoutY((Double.parseDouble(mapCoord.get(i + 1)) - 28));

					imgArr.get(j).setFitHeight(30.0);
					imgArr.get(j).setFitWidth(25.0);
					System.out.println("x" + Double.parseDouble(mapCoord.get(i)));
					System.out.println("y" + Double.parseDouble(mapCoord.get(i + 1)));
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
    * Notify user of successful POI update.
    */
   public void UpdatedPOI() {
	   
	   try {
			this.initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 Platform.runLater(new Runnable() {
		@Override
		public void run() {
			ValidationTests.printInfoMsg("Update State", "the POI was updated successfully");
		}
	});
	 
	   
   }
}

