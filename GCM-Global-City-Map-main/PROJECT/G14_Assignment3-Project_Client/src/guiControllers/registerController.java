package guiControllers;

import java.io.IOException;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import systemFunctionality.ClientMemberController;
import systemFunctionality.QueryCreator;
import systemFunctionality.ValidationTests;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.DatePicker;
import entities.Customer;
import entities.Employee;
import entities.Payment;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// TODO: Auto-generated Javadoc
/**
 * registerController - GUI controller for "registerFXML.fxml"
 */

public class registerController {
	// -------------------------------------------------------------------------------------------//
	// GUI components
	// attribute------------------------------------------------------------------//
	/** The user name txt. */
	// -------------------------------------------------------------------------------------------//
	@FXML
	private TextField userNameTxt;

	/** The first name txt. */
	@FXML
	private TextField firstNameTxt;

	/** The password txt. */
	@FXML
	private TextField passwordTxt;

	/** The email txt. */
	@FXML
	private TextField emailTxt;

	/** The last name txt. */
	@FXML
	private TextField lastNameTxt;

	/** The address txt. */
	@FXML
	private TextField addressTxt;

	/** The card number txt. */
	@FXML
	private TextField cardNumberTxt;

	/** The date card txt. */
	@FXML
	private DatePicker dateCardTxt;

	/** The card cvv txt. */
	@FXML
	private TextField cardCvvTxt;

	/** The register btn. */
	@FXML
	private Button registerBtn;

	/** The back btn. */
	@FXML
	private Button backBtn;

	/** The Phonenumber txt. */
	@FXML
	private TextField PhonenumberTxt;

	/** The anchor pane. */
	@FXML
	private AnchorPane anchorPane;

	/** The card company cbx. */
	@FXML
	private ComboBox<String> cardCompanyCbx;

	/** The information name. */
	@FXML
	private ImageView information_name;

	/** The information username. */
	@FXML
	private ImageView information_username;

	/** The information password. */
	@FXML
	private ImageView information_password;

	/** The information email. */
	@FXML
	private ImageView information_Email;

	/** The information address. */
	@FXML
	private ImageView information_Address;

	/** The information credit. */
	@FXML
	private ImageView information_credit;

	/** The information phonenumber. */
	@FXML
	private ImageView information_phonenumber;

	// -------------------------------------------------------------------------------------------//
	// Internal Class
	// attributes-----------------------------------------------------------------//
	/** The card type cbx. */
	// -------------------------------------------------------------------------------------------//
	ObservableList<String> cardTypeCbx;
	
	/** The client member controller. */
	private ClientMemberController clientMemberController;
	
	/** The Registration info. */
	private String[] RegistrationInfo = new String[12];
	
	/** The register failed. */
	public static boolean registerFailed=false;
	// -------------------------------------------------------------------------------------------//
	// Initialize method - Happens when the fxml file
	// load---------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Initialize.
	 */
	@FXML
	void initialize() {
		cardTypeCbx = FXCollections.observableArrayList("Master card", "Visa");
		cardCompanyCbx.setValue("Master card");
		cardCompanyCbx.setItems(cardTypeCbx);


	}

	// -------------------------------------------------------------------------------------------//
	// Cases of events from
	// GUI------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	/**
	 * Back on click.
	 *
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	void backOnClick(MouseEvent event) throws IOException {
		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("/fxml/gcmFXML.fxml"));
			Scene scene = new Scene(root, 850, 650);
			scene.getStylesheets().add(getClass().getResource("/fxml/gcmCSS.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("GCM System");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
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
		registerFailed=false;
		clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setClientRegisterWindowController(this);
		// registerBtn.setDisable(true);

		if (checkFields()) {
			InsertRegisterInfoToArray();
			clientMemberController.RegistrationNewUser(RegistrationInfo);
		}
	}

	/**
	 * Insert register info to array.
	 */
	public void InsertRegisterInfoToArray() {
		RegistrationInfo[0] = userNameTxt.getText();
		RegistrationInfo[1] = firstNameTxt.getText();
		RegistrationInfo[2] = lastNameTxt.getText();
		RegistrationInfo[3] = passwordTxt.getText();
		RegistrationInfo[4] = emailTxt.getText();
		RegistrationInfo[5] = addressTxt.getText();
		RegistrationInfo[6] = cardCompanyCbx.getValue().toString();
		RegistrationInfo[7] = cardNumberTxt.getText();
		RegistrationInfo[8] = dateCardTxt.getValue().toString();
		RegistrationInfo[9] = cardCvvTxt.getText();
		RegistrationInfo[10] = PhonenumberTxt.getText();

	}

	/**
	 * Prints the user exists.
	 */
	@FXML
	public void printUserExists() {
		ValidationTests.printErrorMsg("Error", "Username or email already exists!");
	}

	/**
	 * Register.
	 *
	 * @param str the str
	 */
	public void Register(String str) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					if (str.equals("1062")) {
						ValidationTests.printErrorMsg("Error", "Username or email already exists!");
						registerFailed=true;
					}

					else {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Registration complete");
						alert.setHeaderText("You are registered as: " + userNameTxt.getText());
						alert.showAndWait();
						
						VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/MemberMain.fxml"));
						Scene scene = new Scene(root,850,650);
						Stage primaryStage = (Stage) anchorPane.getScene().getWindow();
						primaryStage.setScene(scene);
						primaryStage.setResizable(false);
						primaryStage.setTitle("GCM System");
						primaryStage.show();

				/*	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MemberMain.fxml"));
					Parent root = (Parent) loader.load();

					MemberMainController mb = loader.getController();
					Stage primaryStage = (Stage) anchorPane.getScene().getWindow();
					primaryStage.setScene(new Scene(root));
					primaryStage.show();
					
					*/
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Sets the entetie.
	 *
	 * @param userInfo the new entetie
	 */
	public void setEntetie(ArrayList<String> userInfo) {
		/**
		 * me. msg[2] - Last name. msg[3] - Password. msg[4] - Email. msg[5] -
		 * Address. msg[6] - Permission. msg[7] - Phone number. msg[8] - cardid.
		 * msg[9] - cardcompanyname. msg[10] - cardvaliddate. msg[11] - cardcvv.
		 */
		for (int i = 0; i < userInfo.size(); i++) {
			System.out.println(userInfo.get(i));
		}

		if (userInfo.get(6).equals("0")) {
			gcmMainController.user = new Customer();
			Payment payment = new Payment(userInfo.get(8), userInfo.get(9), userInfo.get(10),
					Integer.parseInt(userInfo.get(11)), userInfo.get(0));
			gcmMainController.user.setPaymentDetails(payment);
			gcmMainController.user.setUserName(userInfo.get(0));
			gcmMainController.user.setFirstName(userInfo.get(1));
			gcmMainController.user.setLastName(userInfo.get(2));
			gcmMainController.user.setPassword(userInfo.get(3));
			gcmMainController.user.setEmail(userInfo.get(4));
			gcmMainController.user.setAddress(userInfo.get(5));
			gcmMainController.user.setPermission(Integer.parseInt(userInfo.get(6)));
			gcmMainController.user.setPhoneNumber(userInfo.get(7));
		}

	}

	/**
	 * checkFields - Method to check the that all fields are filled and valid.
	 *
	 * @return - true if all valid, false if not
	 */
	public boolean checkFields() { // Check validity of fields
		boolean flag = true; // Using flag to print every error that occured rather than just one at a time
		if (!(userNameTxt.getText().isEmpty() == false && firstNameTxt.getText().isEmpty() == false
				&& passwordTxt.getText().isEmpty() == false && emailTxt.getText().isEmpty() == false
				&& lastNameTxt.getText().isEmpty() == false
				&& addressTxt.getText().isEmpty() == false && cardNumberTxt.getText().isEmpty() == false
				&& cardCvvTxt.getText().isEmpty() == false))
			flag = false;
		if(dateCardTxt.getValue()==null)
		{
			ValidationTests.printErrorMsg("Error", "Credit card expiry date is empty!");
			flag=false;
		}
		else
			if(!ValidationTests.isCCDateValid(dateCardTxt.getValue()))
				flag=false;

		if (!(ValidationTests.isFirstNameValid(firstNameTxt.getText())))
			flag = false;
		if (!(ValidationTests.isLastNameValid(lastNameTxt.getText())))
			flag = false;
		if (!(ValidationTests.isUsernameValid(userNameTxt.getText())))
			flag = false;
		if (!(ValidationTests.isValidPassword(passwordTxt.getText())))
			flag = false;
		if (!(ValidationTests.isEmailValid(emailTxt.getText())))
			flag = false;
		if (!(ValidationTests.isAddressValid(addressTxt.getText())))
			flag = false;
		if (!(ValidationTests.isCCValid(cardNumberTxt.getText(), cardCvvTxt.getText())))
			flag = false;
		if(!PhonenumberTxt.getText().isEmpty())
				if(!ValidationTests.isPhoneNumValid(PhonenumberTxt.getText()))
					flag=false;
		return flag;

	}

	/**
	 * Click information name.
	 *
	 * @param event the event
	 */
	@FXML
	void Click_information_name(MouseEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Name requirements");
		alert.setHeaderText("Names must be at most 20 characters long and only contain letters");
		alert.showAndWait();
	}

	/**
	 * Click information address.
	 *
	 * @param event the event
	 */
	@FXML
	void Click_information_Address(MouseEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Address requirements");
		alert.setHeaderText("Address must be at most 20 characters long and only contain letters and numbers");
		alert.showAndWait();
	}

	/**
	 * Click information email.
	 *
	 * @param event the event
	 */
	@FXML
	void Click_information_Email(MouseEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Email requirements");
		alert.setHeaderText("Email example: aaaaaa@gmail.com");
		alert.showAndWait();
	}

	/**
	 * Click information password.
	 *
	 * @param event the event
	 */
	@FXML
	void Click_information_password(MouseEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Password requirements");
		alert.setHeaderText("Password must be 6-12 characters long and contain both letters and numbers");
		alert.showAndWait();
	}

	/**
	 * Click information username.
	 *
	 * @param event the event
	 */
	@FXML
	void Click_information_username(MouseEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Username requirements");
		alert.setHeaderText("Username must be at most 12 characters long and only contain letters or numbers");
		alert.showAndWait();
	}

	/**
	 * Click information phone number.
	 *
	 * @param event the event
	 */
	@FXML
	void Click_information_phone_number(MouseEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Phone number requirements");
		alert.setHeaderText("Phone number must be at 10 numbers long and only contain numbers");
		alert.showAndWait();
	}

	/**
	 * Click informatin credit.
	 *
	 * @param event the event
	 */
	@FXML
	void Click_informatin_credit(MouseEvent event) {
		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("/fxml/HelpPopUp.fxml"));
			Scene scene = new Scene(root, 525, 400);
			// scene.getStylesheets().add(getClass().getResource("/fxml/MemberMain.css").toExternalForm());
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Help Window");
			primaryStage.setX(650);
			primaryStage.setY(300);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * CVV help pop up.
	 *
	 * @param event the event
	 */
	@FXML
	void ClickOnCVVTxt(MouseEvent event) {
		registerBtn.setDisable(false);
	}

}
