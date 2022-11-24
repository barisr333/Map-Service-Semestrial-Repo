package guiControllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systemFunctionality.ClassQueryIdentification;
import systemFunctionality.ClientMemberController;
import systemFunctionality.ValidationTests;
import javafx.scene.control.Label;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import entities.*;
// TODO: Auto-generated Javadoc
/**
 *
 * EditProfileController - GUI controller for "EditProfile.fxml"
 */
public class EditProfileController {
//-------------------------------------------------------------------------------------------//
// GUI components attribute------------------------------------------------------------------//
/** The back btn. */
//-------------------------------------------------------------------------------------------//
	@FXML
    private Button backBtn;

	/** The user name txt. */
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

    /** The updatebtn. */
    @FXML
    private Button updatebtn;

    /** The card company cbx. */
    @FXML
    private ComboBox<String> cardCompanyCbx;

    /** The user namelbl. */
    @FXML
    private Label userNamelbl;

    /** The helpbtn. */
    @FXML
    private Button helpbtn;

    /** The anchor pane. */
    @FXML
    private AnchorPane anchorPane;

    /** The information name. */
    @FXML
    private ImageView information_name;

    /** The Phonenumber txt. */
    @FXML
    private TextField PhonenumberTxt;

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

    /** The information phonenumber. */
    @FXML
    private ImageView information_phonenumber;

    /** The information credit. */
    @FXML
    private ImageView information_credit;
//-------------------------------------------------------------------------------------------//
// Internal Class attributes-----------------------------------------------------------------//
/** The user name. */
//-------------------------------------------------------------------------------------------//
    public String userName;
    
    /** The client member controller. */
    private ClientMemberController clientMemberController;
    
    /** The edit profile controller. */
    public static EditProfileController editProfileController;
    
    /** The Update info. */
    private String[] UpdateInfo = new String[12];
    
    /** The card name list. */
    ObservableList<String> cardNameList ;
//-------------------------------------------------------------------------------------------//
// Getters and setters methods---------------------------------------------------------------//
/**
 * Instantiates a new edits the profile controller.
 */
//-------------------------------------------------------------------------------------------//
    public EditProfileController() {
    	editProfileController = this;
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
     * Gets the edit profile controller.
     *
     * @return the edits the profile controller
     */
    public static EditProfileController GetEditProfileController() {
		if(editProfileController == null)
			editProfileController = new EditProfileController();
		return editProfileController;
	}
//-------------------------------------------------------------------------------------------//
// Initialize method - Happens when the fxml file load---------------------------------------//
/**
 * Initialize.
 */
//-------------------------------------------------------------------------------------------//
    @FXML
    void initialize() {

    	cardNameList = FXCollections.observableArrayList("MasterCard","Visa");
    	cardCompanyCbx.setItems(cardNameList);
    	userNameTxt.setDisable(true);


    	switch (gcmMainController.user.getPermission())
		{
		case 0://Case of GCM customer.
				InsertCustomerTextFieldsGUI();
				break;
		case 1://Case of GCM Manager.
				InsertEmployeeTextFieldsGUI();
				break;
		case 2://Case of Content Department Employee.
				InsertEmployeeTextFieldsGUI();
				break;
		case 3://Case of Content Department Manager.
			InsertEmployeeTextFieldsGUI();
			break;
		default:
			break;
		}
    }
//-------------------------------------------------------------------------------------------//
// Cases of events from GUI------------------------------------------------------------------//
/**
 * Back on click.
 *
 * @param event the event
 * @throws IOException Signals that an I/O exception has occurred.
 */
//-------------------------------------------------------------------------------------------//
    @FXML
    void backOnClick(MouseEvent event) throws IOException
    {

    	switch (gcmMainController.user.getPermission())
		{
		case 0://Case of GCM customer.
				openCustomerPage(gcmMainController.user.getFirstName());
				break;
		case 1://Case of GCM Manager.
				openManagerPage(gcmMainController.user.getFirstName());
				break;
		case 2://Case of Content Department Employee.
				openContDepEmpPage(gcmMainController.user.getFirstName());
				break;
		case 3://Case of Content Department Manger.
			openContDepManPage(gcmMainController.user.getFirstName());
			break;
		default:
			break;
		}
    }

    /**
     * Help popup.
     *
     * @param event the event
     */
    @FXML
    void helpPopup(ActionEvent event) {
    	try
		{
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/HelpPopUp.fxml"));
			Scene scene = new Scene(root,525,400);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Help Window");
			primaryStage.setX(650);
			primaryStage.setY(300);
			primaryStage.show();
		}
	catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    /**
     * Update on C lick.
     *
     * @param event the event
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @FXML
    void updateOnCLick(ActionEvent event) throws IOException {

    	clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setClientEditProfileWindowController(this);

		if(checkFields())
		{
			InsertRegisterInfoToArray();

			if(gcmMainController.user.getPermission()== 0)
				{
					clientMemberController.sendToServerUpdateCustomerInfo(UpdateInfo);
				}
			else if(gcmMainController.user.getPermission()== 1 || gcmMainController.user.getPermission()== 2 || gcmMainController.user.getPermission()== 3)
				{
					clientMemberController.sendToServerUpdateEmployeeInfo(UpdateInfo);
				}
		}
    }
//-------------------------------------------------------------------------------------------//
// Internal functions------------------------------------------------------------------------//
/**
 * Insert register info to array.
 */
//-------------------------------------------------------------------------------------------//
    public void InsertRegisterInfoToArray ()
    {
    	UpdateInfo[0] =  userNameTxt.getText();
    	UpdateInfo[1] =  firstNameTxt.getText();
    	UpdateInfo[2] =  lastNameTxt.getText();
    	UpdateInfo[3] =  passwordTxt.getText();
    	UpdateInfo[4] =  emailTxt.getText();
    	UpdateInfo[5] =  addressTxt.getText();
    	UpdateInfo[6] =  cardCompanyCbx.getValue().toString();
    	UpdateInfo[7] =  cardNumberTxt.getText();
    	UpdateInfo[8] =  dateCardTxt.getValue().toString();
    	UpdateInfo[9] =  cardCvvTxt.getText();
    	UpdateInfo[10] =  PhonenumberTxt.getText();
    }
  //-------------------------------------------------------------------------------------------//
  //-------------------------------------------------------------------------------------------//

    /**
   * Insert customer text fields.
   * Set necessary information in static user object used to hold current User's information.
   */
  public void InsertCustomerTextFields() // If customer
    {
    	Platform.runLater(new Runnable() {
  			@Override
  			public void run() {
  				try
  				{
  					Alert alert = new Alert(AlertType.INFORMATION);
  					alert.setTitle("Success");
  					alert.setHeaderText("Profile updated successfully!");
  					alert.showAndWait();

  			    	userNameTxt.setText(UpdateInfo[0]);
  			    	firstNameTxt.setText(UpdateInfo[1]);
  			    	lastNameTxt.setText(UpdateInfo[2]);
  			    	passwordTxt.setText(UpdateInfo[3]);
  			    	emailTxt.setText(UpdateInfo[4]);
  			    	addressTxt.setText(UpdateInfo[5]);
  			    	cardCompanyCbx.setValue(UpdateInfo[6]);
  			    	cardNumberTxt.setText(UpdateInfo[7]);
  			    	dateCardTxt.setPromptText(UpdateInfo[8]);
  			    	cardCvvTxt.setText(UpdateInfo[9]);
  			    	PhonenumberTxt.setText(UpdateInfo[10]);

  			    	Payment payment = new Payment(UpdateInfo[7], UpdateInfo[6], UpdateInfo[8],Integer.parseInt(UpdateInfo[9]),UpdateInfo[0]);
  			    	gcmMainController.user.setPaymentDetails(payment);
  			    	gcmMainController.user.setUserName(UpdateInfo[0]);
  			    	gcmMainController.user.setFirstName(UpdateInfo[1]);
  			    	gcmMainController.user.setLastName(UpdateInfo[2]);
  			    	gcmMainController.user.setPassword(UpdateInfo[3]);
  			    	gcmMainController.user.setEmail(UpdateInfo[4]);
  			    	gcmMainController.user.setAddress(UpdateInfo[5]);
  			    	gcmMainController.user.setPhoneNumber(UpdateInfo[10]);

  		        	InsertCustomerTextFieldsGUI(); // Print current details to GUI
  				}
  			catch(Exception e)
  				{
  					e.printStackTrace();
  				}
  			}
  		});

    }
  //-------------------------------------------------------------------------------------------//
  //-------------------------------------------------------------------------------------------//

    /**
   * Insert employee text fields.
   * Set necessary information in static user object used to hold current User's information.
   */
  public void InsertEmployeeTextFields() // If employee
    {
    	Platform.runLater(new Runnable() {
  			@Override
  			public void run() {
  				try
  				{
  					Alert alert = new Alert(AlertType.INFORMATION);
  					alert.setTitle("Employee update");
  					alert.setHeaderText("You update your profile");
  					alert.showAndWait();

  			    	userNameTxt.setText(UpdateInfo[0]);
  			    	firstNameTxt.setText(UpdateInfo[1]);
  			    	lastNameTxt.setText(UpdateInfo[2]);
  			    	passwordTxt.setText(UpdateInfo[3]);
  			    	emailTxt.setText(UpdateInfo[4]);
  			    	addressTxt.setText(UpdateInfo[5]);
  			    	cardCompanyCbx.setValue(UpdateInfo[6]);
  			    	cardNumberTxt.setText(UpdateInfo[7]);
  			    	dateCardTxt.setPromptText(UpdateInfo[8]);
  			    	cardCvvTxt.setText(UpdateInfo[9]);
  			    	PhonenumberTxt.setText(UpdateInfo[10]);
  			    	Payment payment = new Payment(UpdateInfo[7], UpdateInfo[6], UpdateInfo[8],Integer.parseInt(UpdateInfo[9]),UpdateInfo[0]);
  			    	gcmMainController.user.setPaymentDetails(payment);
  			    	gcmMainController.user.setUserName(UpdateInfo[0]);
  			    	gcmMainController.user.setFirstName(UpdateInfo[1]);
  			    	gcmMainController.user.setLastName(UpdateInfo[2]);
  			    	gcmMainController.user.setPassword(UpdateInfo[3]);
  			    	gcmMainController.user.setEmail(UpdateInfo[4]);
  			    	gcmMainController.user.setAddress(UpdateInfo[5]);
  			    	gcmMainController.user.setPhoneNumber(UpdateInfo[10]);

  			    	InsertEmployeeTextFieldsGUI();
  				}
  			catch(Exception e)
  				{
  					e.printStackTrace();
  				}
  			}
  		});

    }


//-------------------------------------------------------------------------------------------//
//-------------------------------------------------------------------------------------------//
    /**
     * openManagerPage(String userName) - Method that called from loginIdentification.
     * This method open GCM Manager scene.
     * @param userName - Name of the person who logged in.
     */
    public void openManagerPage(String userName)
    {
    	Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try
				{
    				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GcmManager.fxml"));
    				Parent root = (Parent) loader.load();

    				Stage primaryStage = (Stage) anchorPane.getScene().getWindow();
    				primaryStage.setScene(new Scene(root));
    				primaryStage.show();

				}
			catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
    }
//-------------------------------------------------------------------------------------------//
//-------------------------------------------------------------------------------------------//
    /**
     * openCustomerPage (String userName)  - Method that called from loginIdentification.
     * This method open GCM member main scene.
     * @param userName - Name of the person who logged in.
     */
    public void openCustomerPage (String userName)
    {
    	Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try
				{
    				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MemberMain.fxml"));
    				Parent root = (Parent) loader.load();

    				MemberMainController mb = loader.getController();
    				
    				Stage primaryStage = (Stage) anchorPane.getScene().getWindow();
    				primaryStage.setScene(new Scene(root));
    				primaryStage.show();

				}
			catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
    }
//-------------------------------------------------------------------------------------------//
//-------------------------------------------------------------------------------------------//
    /**
     * openContDepEmpPage (String userName) - Method that called from loginIdentification.
     * This method open Content Department Employee scene.
     * @param userName - Name of the person who logged in.
     */
    public void openContDepEmpPage (String userName)
    {
    	Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try
				{
					VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/ContentDepartmentEmployee.fxml"));
					Scene scene = new Scene(root,850,650);
					scene.getStylesheets().add(getClass().getResource("/fxml/ContentDepartmentEmployee.css").toExternalForm());
					Stage primaryStage = (Stage) anchorPane.getScene().getWindow();
					primaryStage.setScene(scene);
					primaryStage.setTitle("Content Department Employee");
					primaryStage.show();
				}
			catch(Exception e)
				{
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
    public void openContDepManPage (String userName)
    {
    	Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try
				{
					VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/ContentDepartmentManger.fxml"));
					Scene scene = new Scene(root,1123,648);
					Stage primaryStage = (Stage) anchorPane.getScene().getWindow();
					primaryStage.setScene(scene);
					primaryStage.setTitle("Content Department Manger");
					primaryStage.show();
				}
			catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
    }
  //-------------------------------------------------------------------------------------------//
  /**
   * Insert customer text fields GUI.
   */
  //-------------------------------------------------------------------------------------------//
    public void InsertCustomerTextFieldsGUI () // GUI printing
    {
    	userNamelbl.setText("Hello"+" "+gcmMainController.user.getFirstName()+" "+gcmMainController.user.getLastName());
    	firstNameTxt.setText(gcmMainController.user.getFirstName());
    	lastNameTxt.setText(gcmMainController.user.getLastName());
    	userNameTxt.setText(gcmMainController.user.getUserName());
    	passwordTxt.setText(gcmMainController.user.getPassword());
    	emailTxt.setText(gcmMainController.user.getEmail());
    	addressTxt.setText(gcmMainController.user.getAddress());
    	PhonenumberTxt.setText(gcmMainController.user.getPhoneNumber());
    	cardCompanyCbx.setValue(gcmMainController.user.getPaymentDetails().getCardCompanyName());
    	cardNumberTxt.setText(gcmMainController.user.getPaymentDetails().getCardID());
    	dateCardTxt.setValue(LocalDate.parse(gcmMainController.user.getPaymentDetails().getExpiryDate()));
    	cardCvvTxt.setText(Integer.toString(gcmMainController.user.getPaymentDetails().getCVV()));

    }

    /**
     * Insert employee text fields GUI.
     */
    public void InsertEmployeeTextFieldsGUI ()
    {
    	userNamelbl.setText("Hello"+" "+gcmMainController.user.getFirstName()+" "+gcmMainController.user.getLastName());
    	firstNameTxt.setText(gcmMainController.user.getFirstName());
    	lastNameTxt.setText(gcmMainController.user.getLastName());
    	userNameTxt.setText(gcmMainController.user.getUserName());
    	passwordTxt.setText(gcmMainController.user.getPassword());
    	emailTxt.setText(gcmMainController.user.getEmail());
    	addressTxt.setText(gcmMainController.user.getAddress());
    	PhonenumberTxt.setText(gcmMainController.user.getPhoneNumber());
    	cardCompanyCbx.setValue(gcmMainController.user.getPaymentDetails().getCardCompanyName());
    	cardNumberTxt.setText(gcmMainController.user.getPaymentDetails().getCardID());
    	dateCardTxt.setValue(LocalDate.parse(gcmMainController.user.getPaymentDetails().getExpiryDate()));
    	cardCvvTxt.setText(Integer.toString(gcmMainController.user.getPaymentDetails().getCVV()));
    }
  //-------------------------------------------------------------------------------------------//
  //-------------------------------------------------------------------------------------------//

    /**
   * checkFields - Method to check the that all fields are filled and valid.
   *
   * @return - true if all valid, false if not
   */
    public boolean checkFields() // Testing validity of input
    {
    	boolean flag=true;
    		if (ValidationTests.isFieldEmpty(userNameTxt.getText()) || ValidationTests.isFieldEmpty(firstNameTxt.getText())
        			|| ValidationTests.isFieldEmpty(passwordTxt.getText()) || ValidationTests.isFieldEmpty(emailTxt.getText())
        			|| ValidationTests.isFieldEmpty(lastNameTxt.getText()) || ValidationTests.isFieldEmpty(cardNumberTxt.getText())
        		    || ValidationTests.isFieldEmpty(cardCvvTxt.getText())) {
				flag = false;
			}

    	if(dateCardTxt.getValue()==null)
    		{
    			ValidationTests.printErrorMsg("Error", "Credit card expiry date is empty!");
    			flag=false;
    		}
    	else
    		if(!ValidationTests.isCCDateValid(dateCardTxt.getValue()))
    			flag=false;

    	if(!(ValidationTests.isFirstNameValid(firstNameTxt.getText())))
    		flag=false;
    	if(!(ValidationTests.isLastNameValid(lastNameTxt.getText())))
    		flag=false;
    	if(!(ValidationTests.isUsernameValid(userNameTxt.getText())))
    		flag=false;
    	if(!(ValidationTests.isValidPassword(passwordTxt.getText())))
    		flag=false;
    	if(!(ValidationTests.isEmailValid(emailTxt.getText())))
    		flag=false;
    	if(!(ValidationTests.isAddressValid(addressTxt.getText())))
    		flag=false;
    	if(!(ValidationTests.isCCValid(cardNumberTxt.getText(), cardCvvTxt.getText())))
    		flag=false;
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
     * Click information username.
     *
     * @param event the event
     */
    @FXML
    void Click_information_username(MouseEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle("Info");
		 alert.setHeaderText("Username is permanent and cannot be changed.");
		 alert.showAndWait();
   }

    /**
     * Click informatin credit.
     *
     * @param event the event
     */
    @FXML
    void Click_informatin_credit(MouseEvent event) {
    	try
		{
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/HelpPopUp.fxml"));
			Scene scene = new Scene(root,525,400);
			//scene.getStylesheets().add(getClass().getResource("/fxml/MemberMain.css").toExternalForm());
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Help Window");
			primaryStage.setX(650);
			primaryStage.setY(300);
			primaryStage.show();
		}
	catch(Exception e)
		{
			e.printStackTrace();
		}

    }



}





