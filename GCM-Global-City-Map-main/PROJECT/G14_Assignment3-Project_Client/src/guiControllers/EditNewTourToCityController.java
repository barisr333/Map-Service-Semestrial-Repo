package guiControllers;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;

import entities.PointOfInterest;
import entities.Tour;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systemFunctionality.ClientMemberController;
import systemFunctionality.QueryCreator;
import systemFunctionality.ValidationTests;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextArea;

// TODO: Auto-generated Javadoc
/**
 * The Class EditNewTourToCityController.
 */
public class EditNewTourToCityController {

	/** The image content emp. */
	@FXML
    private ImageView image_content_emp;

    /** The gcm manager. */
    @FXML
    private ImageView gcm_manager;

    /** The image gcm content manger. */
    @FXML
    private ImageView image_gcm_content_manger;

	/** The name of tour txt. */
	@FXML
	private TextField name_of_tour_Txt;

	/** The Country cbx. */
	@FXML
	private ComboBox<String> CountryCbx;

	/** The City cbx. */
	@FXML
	private ComboBox<String> CityCbx;

	/** The exist name cbx. */
	@FXML
	private ComboBox<String> existNameCbx;

	/** The apply order btn. */
	@FXML
	private Button applyOrderBtn;

	/** The exist order txt. */
	@FXML
	private TextField existOrderTxt;

	/** The Tour cbx. */
	@FXML
	private ComboBox<String> TourCbx;

	/** The new name cbx. */
	@FXML
	private ComboBox<String> newNameCbx;

	/** The new order txt. */
	@FXML
	private TextField newOrderTxt;

	/** The new add btn. */
	@FXML
	private Button newAddBtn;

	/** The Tab menu. */
	@FXML
	private HBox TabMenu;

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

	/** The time area. */
	@FXML
	private TextArea timeArea;

	/** The desc area. */
	@FXML
	private TextArea descArea;

	/** The back btn. */
	@FXML
	private Button backBtn;

	/** The apply info btn. */
	@FXML
	private Button applyInfoBtn;

	/** The delete btn. */
	@FXML
	private Button deleteBtn;

	/** The delete tour btn. */
	@FXML
	private Button deleteTourBtn;

	/** The client member controller. */
	private ClientMemberController clientMemberController;
	
	/** The edit new tour to city controller. */
	public static EditNewTourToCityController editNewTourToCityController;
	
	/** The on this page. */
	public boolean onThisPage = false;
	
	/** The country list. */
	ObservableList<String> countryList;
	
	/** The city list. */
	ObservableList<String> cityList;
	
	/** The Name palce list. */
	ObservableList<String> NamePalceList;
	
	/** The Tour list. */
	ObservableList<String> TourList;
	
	/** The tour places list. */
	ObservableList<String> tourPlacesList;
	
	/** The existing places list. */
	ObservableList<String> existingPlacesList;
	
	/** The cur tour. */
	public Tour curTour;
	
	/** The lock. */
	Object lock = new Object();
	
	/** The in city list. */
	public ArrayList<PointOfInterest> inCityList;

	// -------------------------------------------------------------------------------------------//
	// Getters and setters
	// methods---------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Instantiates a new edits the new tour to city controller.
	 */
	public EditNewTourToCityController() {
		editNewTourToCityController = this;
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
	 * Gets the edit new tour to city controllers.
	 *
	 * @return the edits the new tour to city controller
	 */
	public static EditNewTourToCityController GetEditNewTourToCityControllers() {
		if (editNewTourToCityController == null)
			editNewTourToCityController = new EditNewTourToCityController();
		return editNewTourToCityController;
	}

	/**
	 * Initialize.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() throws IOException {
		if (gcmMainController.user.getPermission() == 1)
			TabMenu.setVisible(false);
		else
			TabMenu.setVisible(true);

		if ((gcmMainController.user.getPermission() == 2)|| (gcmMainController.user.getPermission() == 3)) {
			btn_Edit_Map.setVisible(false);
			btn_Publish_New_Version.setVisible(false);
		}

		if(gcmMainController.user.getPermission()==1)
			image_content_emp.setVisible(true);
        if(gcmMainController.user.getPermission()==2)
        	gcm_manager.setVisible(true);
        if(gcmMainController.user.getPermission()==3)
        	image_gcm_content_manger.setVisible(true);


		onThisPage = true;
		applyOrderBtn.setDisable(true);
		deleteBtn.setDisable(true);
		newAddBtn.setDisable(true);
		deleteTourBtn.setDisable(true);
		applyInfoBtn.setDisable(true);
		clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setClientEditNewTourToCityControllers(this);
		clientMemberController.sendToServerCountry();

		CountryCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By
																			// clicking
																			// on
																			// a
																			// value
																			// within
																			// the
			// combobox, the state will be drawn//

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
			// combobox, the tours and POI's will be drawn//

			if (newItem != null) {
				try {
					// clientMemberController.sendToServer_get_poi_by_city(CityCbx.getValue().toString());
					clientMemberController.sendToServerGetTourByCity(CityCbx.getValue().toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

			}
		});

		TourCbx.valueProperty().addListener(
				(obs, oldItem, newItem) -> { /*
												 * Clicking on value in combobox
												 * loads places in tour cbx
												 */

					if (newItem != null) {
						try {
							existNameCbx.getItems().clear();
							existOrderTxt.setText("");
							newNameCbx.getItems().clear();
							newOrderTxt.setText("");
							deleteTourBtn.setDisable(false);
							applyInfoBtn.setDisable(false);
							clientMemberController.sendToServerGetTourInfo(TourCbx.getValue().toString()); // Retrieve
																											// unique
																											// id
																											// of
																											// selected
																											// tour

							synchronized (lock) {
								try {
									lock.wait(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								clientMemberController.sendToServerGetPOIByTour(Integer.toString(curTour.getID()));
								String[] strArr = new String[2];
								strArr[0] = Integer.toString(curTour.getID());
								strArr[1] = CityCbx.getValue().toString();
								clientMemberController.sendToServerGetOtherPOI(strArr);
							}

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {

					}

				});

		existNameCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By
			// clicking
			// on
			// a
			// value
			// within
			// the
			// combobox, POI's index will be drawn//

			if (newItem != null) {
				for (int i = 0; i < curTour.getPOIList().size(); i++)
					if (curTour.getPOIList().get(i).getName().equals(existNameCbx.getValue().toString())) {
						existOrderTxt.setText(Integer.toString(curTour.getPOIList().get(i).getTourIndex()));
						break;
					}
				applyOrderBtn.setDisable(false);
				deleteBtn.setDisable(false);
			} else {

			}
		});

		newNameCbx.valueProperty().addListener((obs, oldItem, newItem) -> { // By
			// clicking
			// on
			// a
			// value
			// within
			// the
			// combobox, we can add a new POI to tour//

			if (newItem != null) {
				newAddBtn.setDisable(false);

			} else {

			}
		});
	}

	/**
	 * Back on click.
	 *
	 * @param event the event
	 */
	@FXML
	void backOnClick(MouseEvent event) {
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
	 * Click on add.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void ClickOnAdd(MouseEvent event) throws IOException {
		if (checkNewOrder()) {
			String[] strArr = new String[5];
			int i;
			for (i = 0; i < inCityList.size(); i++)
				if (inCityList.get(i).getName().equals(newNameCbx.getValue().toString())) {
					inCityList.get(i).setTourIndex(Integer.parseInt(newOrderTxt.getText()));
					break;
				}

			strArr[2] = Integer.toString(curTour.getID());
			strArr[3] = newOrderTxt.getText();
			strArr[4] = Integer.toString(inCityList.get(i).getId());
			clientMemberController.sendToServerAddPOIToTour(strArr);
			curTour.getPOIList().add(inCityList.get(i));
			inCityList.remove(i);
			ArrayList<String> temp = new ArrayList<String>();
			for (i = 0; i < curTour.getPOIList().size(); i++)
				temp.add(curTour.getPOIList().get(i).getName());

			Collections.sort(temp);
			existingPlacesList = FXCollections.observableArrayList(temp);
			existNameCbx.getItems().clear();
			existNameCbx.setItems(existingPlacesList);
			existOrderTxt.clear();
			newAddBtn.setDisable(true);
			newOrderTxt.clear();
			newNameCbx.getItems().remove(newNameCbx.getValue());
			ValidationTests.printInfoMsg("Success", "Place successfully added to tour!");
		}

	}

	/**
	 * Click on apply existing.
	 * Find the existing POI and set it's tour index. Send server request to update index appropriately.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void ClickOnApplyExisting(MouseEvent event) throws IOException {
		int i;
		if (checkOrder()) {
			for (i = 0; i < curTour.getPOIList().size(); i++)
				if (curTour.getPOIList().get(i).getName().equals(existNameCbx.getValue().toString())) {
					curTour.getPOIList().get(i).setTourIndex(Integer.parseInt(existOrderTxt.getText()));
					break;
				}
			String[] strArr = new String[3];
			strArr[0] = existOrderTxt.getText();
			strArr[1] = Integer.toString(curTour.getPOIList().get(i).getId());
			strArr[2] = Integer.toString(curTour.getID());
			clientMemberController.sendToServerUpdateIndex(strArr);
			ValidationTests.printInfoMsg("Success", "Index successfully updated!");

		}

	}

	/**
	 * Click on delete.
	 * In the process, manage the lists of POI's in tour and other POI's. We need to add and delete values from appropriate POI object lists
	 * so that we can use them to properly load and remove elements from POI combo boxes as needed.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void ClickOnDelete(MouseEvent event) throws IOException {

		String[] strArr = new String[2];
		for (int i = 0; i < curTour.getPOIList().size(); i++) 
			if (curTour.getPOIList().get(i).getName().equals(existNameCbx.getValue().toString())) {
				strArr[0] = Integer.toString(curTour.getPOIList().get(i).getId());
				strArr[1] = Integer.toString(curTour.getID());
				clientMemberController.sendToServerRemovePOI(strArr);
				inCityList.add(curTour.getPOIList().get(i));
				curTour.getPOIList().remove(i);
				break;
			}
		applyOrderBtn.setDisable(true);
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < inCityList.size(); i++)
			temp.add(inCityList.get(i).getName());
		Collections.sort(temp); // Sort new list
		NamePalceList = FXCollections.observableArrayList(temp);
		newNameCbx.getItems().clear();
		newNameCbx.setItems(NamePalceList);
		existOrderTxt.clear();
		existNameCbx.getItems().remove(existNameCbx.getValue());
		deleteBtn.setDisable(true);
		ValidationTests.printInfoMsg("Success", "Place successfully removed from tour!");

	}

	/**
	 * Click on apply info.
	 * Set needed information in String array and send it to Server. Notify user of success.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void clickOnApplyInfo(MouseEvent event) throws IOException {
// Apply changes to tour info
		if (checkFields()) {
			String[] strArr = new String[4];
			strArr[0] = name_of_tour_Txt.getText();
			strArr[1] = descArea.getText();
			strArr[2] = timeArea.getText();
			strArr[3] = Integer.toString(curTour.getID());
			clientMemberController.sendToServerUpdateTour(strArr);
			ValidationTests.printInfoMsg("Success", "Tour information successfully updated!");
			clearPage();
			deleteTourBtn.setDisable(true);
			applyInfoBtn.setDisable(true);
		}

	}

	/**
	 * Click on del tour.
	 * When selected, the system prompts the user to confirm his choice and only proceeds if he clicks OK.
	 * Also modifies UI to constraint user to re-select from combo boxes.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void ClickOnDelTour(MouseEvent event) throws IOException {
		if (ValidationTests.printConfirmMsg("Confirmation", "Are you sure you want to delete the tour?")) { // Confirmation message
			String[] strArr=new String[2];
			strArr[0]=Integer.toString(curTour.getID());
			strArr[1]=CityCbx.getValue();
			clientMemberController.sendToServerDelTour(strArr);
			ValidationTests.printInfoMsg("Success", "Tour deleted successfully!");
			clearPage();
			deleteTourBtn.setDisable(true); // Disable button until tour is selected again
		}

	}

	/**
	 * Load country combo box.
	 *
	 * @param arr the arr
	 */
	/* Methods to load combo boxes */
	public void loadCountryBox(ArrayList<String> arr) {
		countryList = FXCollections.observableArrayList(arr);
		CountryCbx.setItems(countryList);
	}

	/**
	 * Load city combo box.
	 *
	 * @param arr the arr
	 */
	public void loadCityBox(ArrayList<String> arr) {

		cityList = FXCollections.observableArrayList(arr);
		CityCbx.setItems(cityList);
	}

	/**
	 * Load new POI combo box.
	 *
	 * @param arr the arr
	 */
	public void loadNewPOIBox(ArrayList<String> arr) {
		NamePalceList = FXCollections.observableArrayList(arr);
		newNameCbx.setItems(NamePalceList);
	}

	/**
	 * Load tour combo box.
	 *
	 * @param arr the arr
	 */
	public void loadTourBox(ArrayList<String> arr) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				TourList = FXCollections.observableArrayList(arr);
				try {
				TourCbx.setItems(TourList);
				}
				catch(NullPointerException e)
				{

				}
			}
		});

	}

	/**
	 * Load existing POI combo box.
	 *
	 * @param arr the arr
	 */
	public void loadExistingPOIBox(ArrayList<String> arr) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				int size = arr.size() / 3;
				for (int i = 0; i < size; i++) {
					curTour.getPOIList().add(new PointOfInterest(arr.get(0), Integer.parseInt(arr.get(1)),
							Integer.parseInt(arr.get(2))));
					for (int j = 0; j < 3; j++)
						arr.remove(0);
				}
				ArrayList<String> temp = new ArrayList<String>();
				for (int i = 0; i < curTour.getPOIList().size(); i++)
					temp.add(curTour.getPOIList().get(i).getName());

				existingPlacesList = FXCollections.observableArrayList(temp);
				existNameCbx.setItems(existingPlacesList);
			}
		});

	}

	/* Other methods */

	/**
	 * Sets the current tour ID and it's POI's in our own Tour entity object.
	 *
	 * @param arr the new current tour
	 */
	public void setCurrentTour(ArrayList<String> arr) {

		// [0]=idtour, [1]=tour name, [2]=description, [3]=time
		curTour = new Tour(arr.get(1), arr.get(2), arr.get(3), CityCbx.getValue().toString());
		curTour.setID(Integer.parseInt(arr.get(0)));
		name_of_tour_Txt.setText(curTour.getName());
		timeArea.setText(curTour.getRecTime());
		descArea.setText(curTour.getDescription());
	}

	/**
	 * Check fields.
	 *
	 * @return true, if successful
	 */
	public boolean checkFields() {
		if (ValidationTests.isFieldEmpty(name_of_tour_Txt.getText()) || ValidationTests.isFieldEmpty(timeArea.getText())
				|| ValidationTests.isFieldEmpty(descArea.getText()))
			return false;
		return true;
	}

	/**
	 * Check order of POI to see if valid.
	 *
	 * @return true, if successful
	 */
	public boolean checkOrder() {
		if (ValidationTests.isFieldEmpty(existOrderTxt.getText()))
			return false;
		if (!ValidationTests.isNumeric(existOrderTxt.getText())) {
			ValidationTests.printErrorMsg("Error", "Index must be a number!");
			return false;
		}
		for (int i = 0; i < curTour.getPOIList().size(); i++)
			if (curTour.getPOIList().get(i).getTourIndex() == Integer.parseInt(existOrderTxt.getText())) {
				ValidationTests.printErrorMsg("Error", "This index already exists in tour!");
				return false;
			}
		return true;
	}

	/**
	 * Check new order of POI to see if it is valid.
	 *
	 * @return true, if successful
	 */
	public boolean checkNewOrder() {
		if (ValidationTests.isFieldEmpty(newOrderTxt.getText()))
			return false;
		if (!ValidationTests.isNumeric(newOrderTxt.getText())) {
			ValidationTests.printErrorMsg("Error", "Index must be a number!");
			return false;
		}
		for (int i = 0; i < curTour.getPOIList().size(); i++)
			if (Integer.parseInt(newOrderTxt.getText()) == curTour.getPOIList().get(i).getTourIndex()) {
				ValidationTests.printErrorMsg("Error",
						"Place index already taken in tour: " + curTour.getPOIList().get(i).getName() + ""
								+ " is already " + curTour.getPOIList().get(i).getTourIndex()
								+ " in the visiting order!");
				return false;
			}
		return true;
	}

	/**
	 * Update success.
	 */
	public void updateSuccess() {
		// ValidationTests.printInfoMsg("Success", "Index successfully
		// updated!");
	}

	/**
	 * Removal success.
	 */
	public void removalSuccess() {

	}

	/**
	 * Load combo box of POI's not in currently selected tour.
	 *
	 * @param arr the arr
	 */
	public void loadOthersBox(ArrayList<String> arr) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				int size = arr.size() / 2;
				inCityList = new ArrayList<PointOfInterest>();
				for (int i = 0; i < size; i++) {
					inCityList.add(new PointOfInterest(arr.get(0), 0, Integer.parseInt(arr.get(1))));
					for (int j = 0; j < 2; j++)
						arr.remove(0);
				}
				ArrayList<String> temp = new ArrayList<String>();
				for (int i = 0; i < inCityList.size(); i++)
					temp.add(inCityList.get(i).getName());
				NamePalceList = FXCollections.observableArrayList(temp);
				newNameCbx.setItems(NamePalceList);
			}
		});
	}

	/**
	 * Poi added.
	 */
	public void poiAdded() {

	}

	/**
	 * Delete success.
	 */
	public void deleteSuccess() {

	}

	/**
	 * Info updated.
	 */
	public void infoUpdated() {

	}

	/**
	 * Clear and reset page.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void clearPage() throws IOException {
		TourCbx.getItems().clear();
		existNameCbx.getItems().clear();
		newNameCbx.getItems().clear();
		CityCbx.getItems().clear();
		CountryCbx.getItems().clear();
		name_of_tour_Txt.clear();
		descArea.clear();
		timeArea.clear();
		newOrderTxt.clear();
		existOrderTxt.clear();
		newAddBtn.setDisable(true);
		deleteBtn.setDisable(true);
		applyOrderBtn.setDisable(true);
		applyInfoBtn.setDisable(true);
		deleteTourBtn.setDisable(true);
		clientMemberController.sendToServerCountry();

	}

}
