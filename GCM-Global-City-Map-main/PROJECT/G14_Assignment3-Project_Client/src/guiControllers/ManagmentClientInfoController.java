package guiControllers;

import java.awt.image.BufferedImage;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import entities.Map;
import entities.Purchase;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.AnchorPane;

// TODO: Auto-generated Javadoc
/**
 * The Class ManagmentClientInfoController.
 */
public class ManagmentClientInfoController {

	/** The back btn. */
	@FXML
	private Button backBtn;

	/** The company lbl. */
	@FXML
	private Label companyLbl;

	/** The btn view catalg. */
	@FXML
	private Button btnView_Catalg;

	/** The btn edit prfile. */
	@FXML
	private Button btnEdit_Prfile;

	/** The usernamemain. */
	@FXML
	private Label usernamemain;

	/** The btn edit map. */
	@FXML
	private Button btn_Edit_Map;

	/** The first name label. */
	@FXML
	private Label firstNameLabel;

	/** The anchor pane. */
	@FXML
	private AnchorPane anchorPane;

	/** The username txt. */
	@FXML
	private TextField usernameTxt;

	/** The username. */
	@FXML
	private Label username;

	/** The Usernamelabel. */
	@FXML
	private Label Usernamelabel;

	/** The search btn. */
	@FXML
	private Button searchBtn;

	/** The Tab menu. */
	@FXML
	private HBox TabMenu;

	/** The loading image. */
	@FXML
	private ImageView loadingImage;

	/** The history table. */
	//////////// =====================================////////////
	@FXML
	private TableView<Purchase> historyTable;

	/** The type col. */
	@FXML
	private TableColumn<Purchase, String> typeCol;

	/** The city col. */
	@FXML
	private TableColumn<Purchase, String> cityCol;

	/** The date col. */
	@FXML
	private TableColumn<Purchase, String> dateCol;

	/** The price col. */
	@FXML
	private TableColumn<Purchase, String> priceCol;
	////////////////////// ===========================/////////////////////

	/** The last name label. */
	@FXML
	private Label lastNameLabel;

	/** The email label. */
	@FXML
	private Label emailLabel;

	/** The address label. */
	@FXML
	private Label addressLabel;

	/** The phone label. */
	@FXML
	private Label phoneLabel;

	/** The cc num label. */
	@FXML
	private Label ccNumLabel;

	/** The expiry label. */
	@FXML
	private Label expiryLabel;

	/** The cvv label. */
	@FXML
	private Label cvvLabel;

	/** The entername lbl. */
	@FXML
	private Label enternameLbl;

	// -------------------------------------------------------------------------------------------//
	// Internal Class
	// attributes-----------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/** The client member controller. */
	private ClientMemberController clientMemberController;
	
	/** The managment client info controller. */
	public static ManagmentClientInfoController managmentClientInfoController;
	
	/** The table result. */
	ObservableList<String> tableResult;
	
	/** The str arr. */
	private String[] strArr = new String[2];
	
	/** The pur list. */
	ArrayList<Purchase> purList;
	
	/** The lock. */
	Object lock = new Object();

	// -------------------------------------------------------------------------------------------//
	// Getters and setters
	// methods---------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Instantiates a new managment client info controller.
	 */
	public ManagmentClientInfoController() {
		managmentClientInfoController = this;
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
	 * Gets the managment client info controller.
	 *
	 * @return the managment client info controller
	 */
	public static ManagmentClientInfoController GetManagmentClientInfoController() {
		if (managmentClientInfoController == null)
			managmentClientInfoController = new ManagmentClientInfoController();
		return managmentClientInfoController;
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

		usernamemain.setText(
				"Welcome " + gcmMainController.user.getFirstName() + " " + gcmMainController.user.getLastName());

		purList = new ArrayList<Purchase>();
		typeCol.setCellValueFactory(new PropertyValueFactory<Purchase, String>("type"));
		cityCol.setCellValueFactory(new PropertyValueFactory<Purchase, String>("purchasedCity"));
		dateCol.setCellValueFactory(new PropertyValueFactory<Purchase, String>("date"));
		priceCol.setCellValueFactory(new PropertyValueFactory<Purchase, String>("price"));
		historyTable.setStyle("-fx-focus-color: transparent;");

		clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setClientManagmentClientInfoController(this);

		switch (gcmMainController.user.getPermission()) {
		case 0:// Case of Client member.
			btn_Edit_Map.setVisible(false);
			enternameLbl.setVisible(false);
			usernameTxt.setVisible(false);
			searchBtn.setVisible(false);
			historyTable.getItems().clear();
			strArr[0] = gcmMainController.user.getUserName();
			strArr[1] = Integer.toString(gcmMainController.user.getPermission());
			clientMemberController.sendToServerHistoryPurchases(strArr);
			clientMemberController.sendToServerGetHistory(strArr);
			break;
		case 1:// Case of GCM Manager.
			enternameLbl.setVisible(true);
			btn_Edit_Map.setVisible(false);
			usernameTxt.setVisible(true);
			searchBtn.setVisible(true);
			break;
		case 2:// Case of employee.
			enternameLbl.setVisible(false);
			btn_Edit_Map.setVisible(false);
			usernameTxt.setVisible(false);
			searchBtn.setVisible(false);
			historyTable.getItems().clear();
			strArr[0] = gcmMainController.user.getUserName();
			strArr[1] = Integer.toString(gcmMainController.user.getPermission());
			System.out.println(strArr[0] + " " + strArr[1]);
			clientMemberController.sendToServerHistoryPurchases(strArr);
			break;
		case 3:// Case of Content department manager.
			enternameLbl.setVisible(true);
			btn_Edit_Map.setVisible(false);
			usernameTxt.setVisible(true);
			searchBtn.setVisible(true);
			break;
		default:
			break;
		}

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
	void backOnClick(MouseEvent event) {
		switch (gcmMainController.user.getPermission()) {
		case 0:// Case of member.
			opencustorPage(gcmMainController.user.getFirstName());
			break;
		case 1:// Case of GCM Manager.
			openManagerPage(gcmMainController.user.getFirstName());
			break;
		case 2:// Case of Content Department Employee.
			openContDepEmpPage(gcmMainController.user.getFirstName());
			break;
		case 3:// Case of Content Department manager.
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
	 * Click on search.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void Click_on_search(MouseEvent event) throws IOException {
		if (!ValidationTests.isFieldEmpty(usernameTxt.getText())) {
			historyTable.getItems().clear();
			loadingImage.setVisible(true);
			historyTable.setVisible(false);
			strArr[0] = usernameTxt.getText();
			strArr[1] = "0";
			clientMemberController.sendToServerHistoryPurchases(strArr);
			clientMemberController.sendToServerGetHistory(strArr);
			clear_page();
		}
	}

	/**
	 * Onclicktextfeild.
	 *
	 * @param event the event
	 */
	@FXML
	void onclicktextfeild(MouseEvent event) {
		searchBtn.setDisable(false);
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
	 * Clear page and reset fields.
	 */
	public void clear_page() { // Clear GUI fields
		historyTable.getItems().clear();
		usernameTxt.clear();
		firstNameLabel.setText("");
		lastNameLabel.setText("");
		emailLabel.setText("");
		addressLabel.setText("");
		phoneLabel.setText("");
		Usernamelabel.setText("");
		ccNumLabel.setText("");
		companyLbl.setText("");
		cvvLabel.setText("");
		expiryLabel.setText("");

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
	 * Open cont dep emp page.
	 *
	 * @param userName the user name
	 */
	public void openContDepEmpPage(String userName) {
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
	 * Opencustor page.
	 *
	 * @param userName the user name
	 */
	public void opencustorPage(String userName) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					VBox root = (VBox) FXMLLoader.load(getClass().getResource("/fxml/MemberMain.fxml"));
					Scene scene = new Scene(root, 850, 650);
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

	/* Other methods */

	/**
	 * Prints the info of current user or the Username typed in by manager to the appropriate fields in GUI.
	 *
	 * @param arr the arr
	 */
	public void printInfo(ArrayList<String> arr) { // Returning the information requested to the GUI
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (arr.isEmpty())
					ValidationTests.printErrorMsg("Error", "Customer does not exist!");
				else {
					firstNameLabel.setText(arr.get(1));
					Usernamelabel.setText(arr.get(0));
					lastNameLabel.setText(arr.get(2));
					emailLabel.setText(arr.get(4));
					addressLabel.setText(arr.get(5));
					String temp = new String();
					temp += arr.get(7).substring(0, arr.get(7).length() - 4) + "****";
					ccNumLabel.setText(temp);
					companyLbl.setText(arr.get(8));
					expiryLabel.setText(arr.get(9));
					cvvLabel.setText("***");
					phoneLabel.setText(arr.get(11));
				}
			}
		});
	}

	/**
	 * Prints the purchase history of either current user or Username typed in by manager (if exists) to the history table.
	 *
	 * @param arr the arr
	 */
	public void printHistory(ArrayList<String> arr) { // Printing purchase history
		if (!arr.isEmpty()) {
			int size = arr.size() / 5;
			for (int i = 0; i < size; i++) {
				purList.add(
						new Purchase(arr.get(0), arr.get(1), arr.get(2), Double.parseDouble(arr.get(3)), arr.get(4)));
				for (int j = 0; j < 5; j++)
					arr.remove(0);
			}

			synchronized (lock) {

				try {
					lock.wait(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (purList != null) {
					loadingImage.setVisible(false);
					historyTable.setVisible(true);
					historyTable.getItems().clear();
					System.out.println(purList.size());

					for (int i = 0; i < purList.size(); i++) {

						historyTable.getItems().add(purList.get(i));
					}
					purList.clear();

				}
			}
		}
		loadingImage.setVisible(false);
		historyTable.setVisible(true);


	}

}