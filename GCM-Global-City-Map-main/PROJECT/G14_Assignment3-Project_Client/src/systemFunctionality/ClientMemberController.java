package systemFunctionality;

import java.awt.geom.FlatteningPathIterator;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import client.*;
import entities.PointOfInterest;
import guiControllers.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientMemberController.
 * This class is responsible for linking GUI controllers on the client side to OCSF client functionality. An object of this controller
 * is instantiated in each Client GUI controller and it directly sends the request from the Client to the server using the Main Client OCSF class.
 */
public class ClientMemberController {
	// -------------------------------------------------------------------------------------------//
	// Internal Class
	// attributes-----------------------------------------------------------------//
	/** The main client. */
	// -------------------------------------------------------------------------------------------//
	private MainClient mainClient;
	
	/** The client member controller. */
	private static ClientMemberController clientMemberController;
	
	/** The Register controller. */
	private registerController RegisterController;
	
	/** The Gcm main controller. */
	private gcmMainController GcmMainController;
	
	/** The edit profile controller. */
	private EditProfileController editProfileController;
	
	/** The create new city controller. */
	private CreateNewCityController createNewCityController;
	
	/** The add new map to city controller. */
	private AddNewMapToCityController addNewMapToCityController;
	
	/** The add interested place controller. */
	private AddInterestedPlaceController addInterestedPlaceController;
	
	/** The deleteinterestedplace controller. */
	private DeleteinterestedplaceController deleteinterestedplaceController;
	
	/** The edit interested place controller. */
	private EditInterestedPlaceController editInterestedPlaceController;
	
	/** The add new tour to city controllers. */
	private AddNewTourToCityControllers addNewTourToCityControllers;
	
	/** The update map rates controller. */
	private UpdateMapRatesController updateMapRatesController;
	
	/** The view catalog controller. */
	private ViewCatalogController viewCatalogController;
	
	/** The managment client info controller. */
	private ManagmentClientInfoController managmentClientInfoController;
	
	/** The view report controller. */
	private ViewReportController viewReportController;
	
	/** The member main controller. */
	public MemberMainController memberMainController;
	
	/** The purchasemap controller. */
	private PurchasemapController purchasemapController;
	
	/** The maps download controller. */
	private MapsDownloadController mapsDownloadController;
	
	/** The class query identification. */
	private ClassQueryIdentification classQueryIdentification;
	
	/** The edit new tour city controller. */
	private EditNewTourToCityController editNewTourCityController;
	
	/** The gcm manager controller. */
	private GcmManagerController gcmManagerController;
	
	/** The content department employee. */
	private ContentDepartmentEmployee contentDepartmentEmployee;
	
	/** The content department manger controller. */
	private ContentDepartmentMangerController contentDepartmentMangerController;
	
	/** The publish new version of map controller. */
	private PublishNewVersionOfMapController publishNewVersionOfMapController;

	// -------------------------------------------------------------------------------------------//
	// Class
	// constructor-------------------------------------------------------------------------//
	/**
	 * Instantiates a new client member controller.
	 */
	// -------------------------------------------------------------------------------------------//
	private ClientMemberController() {
		clientMemberController = this;

		classQueryIdentification = ClassQueryIdentification.GetClassQueryIdentification();
		classQueryIdentification.setClientMemberController(this);

		editProfileController = EditProfileController.GetEditProfileController();
		editProfileController.setClientMemberController(this);

		addInterestedPlaceController = AddInterestedPlaceController.GetAddInterestedPlaceController();
		addInterestedPlaceController.setClientMemberController(this);

		createNewCityController = CreateNewCityController.GetCreateNewCityController();
		createNewCityController.setClientMemberController(this);

		addNewMapToCityController = AddNewMapToCityController.GetAddNewMapToCityController();
		addNewMapToCityController.setClientMemberController(this);

		deleteinterestedplaceController = DeleteinterestedplaceController.GetDeleteinterestedplaceController();
		deleteinterestedplaceController.setClientMemberController(this);

		editInterestedPlaceController = EditInterestedPlaceController.GetEditInterestedPlaceController();
		editInterestedPlaceController.setClientMemberController(this);

		addNewTourToCityControllers = AddNewTourToCityControllers.GetAddNewTourToCityControllers();
		addNewTourToCityControllers.setClientMemberController(this);

		updateMapRatesController = UpdateMapRatesController.GetUpdateMapRatesController();
		updateMapRatesController.setClientMemberController(this);

		gcmManagerController = GcmManagerController.GetGcmManagerController();
		gcmManagerController.setClientMemberController(this);

		contentDepartmentEmployee = ContentDepartmentEmployee.GetContentDepartmentEmployee();
		contentDepartmentEmployee.setClientMemberController(this);

		contentDepartmentMangerController = ContentDepartmentMangerController.GetContentDepartmentMangerController();
		contentDepartmentMangerController.setClientMemberController(this);

		viewCatalogController = ViewCatalogController.GetViewCatalogController();
		viewCatalogController.setClientMemberController(this);

		managmentClientInfoController = ManagmentClientInfoController.GetManagmentClientInfoController();
		managmentClientInfoController.setClientMemberController(this);

		viewReportController = ViewReportController.GetViewReportController();
		viewReportController.setClientMemberController(this);

		editNewTourCityController = EditNewTourToCityController.GetEditNewTourToCityControllers();
		editNewTourCityController.setClientMemberController(this);

		purchasemapController = PurchasemapController.GetPurchasemapController();
		purchasemapController.setClientMemberController(this);

		memberMainController = MemberMainController.GetMemberMainController();
		memberMainController.setClientMemberController(this);

		mapsDownloadController = MapsDownloadController.GetMapsDownloadController();
		mapsDownloadController.setClientMemberController(this);

		publishNewVersionOfMapController = PublishNewVersionOfMapController.GetPublishNewVersionOfMapController();
		publishNewVersionOfMapController.setClientMemberController(this);//

		mainClient = MainClient.GetClient();
		mainClient.SetClientMemberController(this);

	}

	// -------------------------------------------------------------------------------------------//
	// Getters and
	// setters-----------------------------------------------------------------------//
	/**
	 * Sets the client window controller.
	 *
	 * @param gcmMainController the new client window controller
	 */
	// -------------------------------------------------------------------------------------------//
	public void setClientWindowController(gcmMainController gcmMainController) {
		this.setGcmMainController(gcmMainController);
	}

	/**
	 * Sets the client register window controller.
	 *
	 * @param RegisterController the new client register window controller
	 */
	public void setClientRegisterWindowController(registerController RegisterController) {
		this.setRegisterController(RegisterController);
	}

	/**
	 * Sets the client edit profile window controller.
	 *
	 * @param editProfileController the new client edit profile window controller
	 */
	public void setClientEditProfileWindowController(EditProfileController editProfileController) {
		this.setEditProfileController(editProfileController);
	}

	/**
	 * Sets the client create new city controller.
	 *
	 * @param createNewCityController the new client create new city controller
	 */
	public void setClientCreateNewCityController(CreateNewCityController createNewCityController) {
		this.setCreateNewCityController(createNewCityController);
	}

	/**
	 * Sets the client add interested place controller.
	 *
	 * @param addInterestedPlaceController the new client add interested place controller
	 */
	public void setClientAddInterestedPlaceController(AddInterestedPlaceController addInterestedPlaceController) {
		this.setAddInterestedPlaceController(addInterestedPlaceController);
	}

	/**
	 * Sets the client update map rates controller.
	 *
	 * @param updateMapRatesController the new client update map rates controller
	 */
	public void setClientUpdateMapRatesController(UpdateMapRatesController updateMapRatesController) {
		this.setUpdateMapRatesController(updateMapRatesController);
	}

	/**
	 * Sets the client add new map to city controller.
	 *
	 * @param addNewMapToCityController the new client add new map to city controller
	 */
	public void setClientAddNewMapToCityController(AddNewMapToCityController addNewMapToCityController) {
		this.setAddNewMapToCityController(addNewMapToCityController);
	}

	/**
	 * Sets the client deleteinterestedplace controller.
	 *
	 * @param deleteinterestedplaceController the new client deleteinterestedplace controller
	 */
	public void setClientDeleteinterestedplaceController(
			DeleteinterestedplaceController deleteinterestedplaceController) {
		this.setDeleteinterestedplaceController(deleteinterestedplaceController);
	}

	/**
	 * Sets the client edit interested place controller.
	 *
	 * @param editInterestedPlaceController the new client edit interested place controller
	 */
	public void setClientEditInterestedPlaceController(EditInterestedPlaceController editInterestedPlaceController) {
		this.setEditInterestedPlaceController(editInterestedPlaceController);
	}

	/**
	 * Sets the client add new tour to city controllers.
	 *
	 * @param addNewTourToCityControllers the new client add new tour to city controllers
	 */
	public void setClientAddNewTourToCityControllers(AddNewTourToCityControllers addNewTourToCityControllers) {
		this.setAddNewTourToCityControllers(addNewTourToCityControllers);
	}

	/**
	 * Sets the client view catalog controller.
	 *
	 * @param viewCatalogController the new client view catalog controller
	 */
	public void setClientViewCatalogController(ViewCatalogController viewCatalogController) {
		this.setViewCatalogController(viewCatalogController);
	}

	/**
	 * Sets the client managment client info controller.
	 *
	 * @param managmentClientInfoController the new client managment client info controller
	 */
	public void setClientManagmentClientInfoController(ManagmentClientInfoController managmentClientInfoController) {
		this.setManagmentClientInfoController(managmentClientInfoController);
	}

	/**
	 * Sets the client view report controller.
	 *
	 * @param viewReportController the new client view report controller
	 */
	public void setClientViewReportController(ViewReportController viewReportController) {
		this.setViewReportController(viewReportController);
	}

	/**
	 * Sets the client purchasemap controller.
	 *
	 * @param purchasemapController the new client purchasemap controller
	 */
	public void setClientPurchasemapController(PurchasemapController purchasemapController) {
		this.setPurchasemapController(purchasemapController);
	}

	/**
	 * Sets the client member controller.
	 *
	 * @param memberMainController the new client member controller
	 */
	public void setClientMemberController(MemberMainController memberMainController) {
		this.setMemberMainController(memberMainController);
	}

	/**
	 * Sets the client maps download controller.
	 *
	 * @param mapsDownloadController the new client maps download controller
	 */
	public void setClientMapsDownloadController(MapsDownloadController mapsDownloadController) {
		this.setMapsDownloadController(mapsDownloadController);
	}

	/**
	 * Sets the client gcm manager controller.
	 *
	 * @param gcmManagerController the new client gcm manager controller
	 */
	public void setClientGcmManagerController(GcmManagerController gcmManagerController) {
		this.setGcmManagerController(gcmManagerController);
	}

	/**
	 * Sets the client content department employee.
	 *
	 * @param contentDepartmentEmployee the new client content department employee
	 */
	public void setClientContentDepartmentEmployee(ContentDepartmentEmployee contentDepartmentEmployee) {
		this.setContentDepartmentEmployee(contentDepartmentEmployee);
	}

	/**
	 * Sets the client content department manger controller.
	 *
	 * @param contentDepartmentMangerController the new client content department manger controller
	 */
	public void setClientContentDepartmentMangerController(
			ContentDepartmentMangerController contentDepartmentMangerController) {
		this.setContentDepartmentMangerController(contentDepartmentMangerController);
	}

	/**
	 * Sets the client publish new version of map controller.
	 *
	 * @param publishNewVersionOfMapController the new client publish new version of map controller
	 */
	public void setClientPublishNewVersionOfMapController(
			PublishNewVersionOfMapController publishNewVersionOfMapController) {
		this.setPublishNewVersionOfMapController(publishNewVersionOfMapController);
	}

	/**
	 * Gets the creates the new city controller.
	 *
	 * @return the creates the new city controller
	 */
	public CreateNewCityController getCreateNewCityController() {
		return createNewCityController;
	}

	/**
	 * Sets the creates the new city controller.
	 *
	 * @param createNewCityController the new creates the new city controller
	 */
	public void setCreateNewCityController(CreateNewCityController createNewCityController) {
		this.createNewCityController = createNewCityController;
	}

	/**
	 * Gets the adds the interested place controller.
	 *
	 * @return the adds the interested place controller
	 */
	public AddInterestedPlaceController getAddInterestedPlaceController() {
		return addInterestedPlaceController;
	}

	/**
	 * Gets the adds the new tour to city controllers.
	 *
	 * @return the adds the new tour to city controllers
	 */
	public AddNewTourToCityControllers getAddNewTourToCityControllers() {
		return addNewTourToCityControllers;
	}

	/**
	 * Sets the adds the interested place controller.
	 *
	 * @param addInterestedPlaceController the new adds the interested place controller
	 */
	public void setAddInterestedPlaceController(AddInterestedPlaceController addInterestedPlaceController) {
		this.addInterestedPlaceController = addInterestedPlaceController;
	}

	/**
	 * Sets the adds the new tour to city controllers.
	 *
	 * @param addNewTourToCityControllers the new adds the new tour to city controllers
	 */
	public void setAddNewTourToCityControllers(AddNewTourToCityControllers addNewTourToCityControllers) {
		this.addNewTourToCityControllers = addNewTourToCityControllers;
	}

	/**
	 * Gets the adds the new map to city controller.
	 *
	 * @return the adds the new map to city controller
	 */
	public AddNewMapToCityController getAddNewMapToCityController() {
		return addNewMapToCityController;

	}

	/**
	 * Sets the adds the new map to city controller.
	 *
	 * @param addNewMapToCityController the new adds the new map to city controller
	 */
	public void setAddNewMapToCityController(AddNewMapToCityController addNewMapToCityController) {
		this.addNewMapToCityController = addNewMapToCityController;
	}

	/**
	 * Sets the deleteinterestedplace controller.
	 *
	 * @param deleteinterestedplaceController the new deleteinterestedplace controller
	 */
	public void setDeleteinterestedplaceController(DeleteinterestedplaceController deleteinterestedplaceController) {
		this.deleteinterestedplaceController = deleteinterestedplaceController;
	}

	/**
	 * Sets the edits the interested place controller.
	 *
	 * @param editInterestedPlaceController the new edits the interested place controller
	 */
	public void setEditInterestedPlaceController(EditInterestedPlaceController editInterestedPlaceController) {
		this.editInterestedPlaceController = editInterestedPlaceController;
	}

	/**
	 * Sets the update map rates controller.
	 *
	 * @param updateMapRatesController the new update map rates controller
	 */
	public void setUpdateMapRatesController(UpdateMapRatesController updateMapRatesController) {
		this.updateMapRatesController = updateMapRatesController;
	}

	/**
	 * Sets the view catalog controller.
	 *
	 * @param viewCatalogController the new view catalog controller
	 */
	public void setViewCatalogController(ViewCatalogController viewCatalogController) {
		this.viewCatalogController = viewCatalogController;
	}

	/**
	 * Sets the managment client info controller.
	 *
	 * @param managmentClientInfoController the new managment client info controller
	 */
	public void setManagmentClientInfoController(ManagmentClientInfoController managmentClientInfoController) {
		this.managmentClientInfoController = managmentClientInfoController;
	}

	/**
	 * Sets the gcm manager controller.
	 *
	 * @param gcmManagerController the new gcm manager controller
	 */
	public void setGcmManagerController(GcmManagerController gcmManagerController) {
		this.gcmManagerController = gcmManagerController;
	}

	/**
	 * Sets the content department employee.
	 *
	 * @param contentDepartmentEmployee the new content department employee
	 */
	public void setContentDepartmentEmployee(ContentDepartmentEmployee contentDepartmentEmployee) {
		this.contentDepartmentEmployee = contentDepartmentEmployee;
	}

	/**
	 * Sets the content department manger controller.
	 *
	 * @param contentDepartmentMangerController the new content department manger controller
	 */
	public void setContentDepartmentMangerController(
			ContentDepartmentMangerController contentDepartmentMangerController) {
		this.contentDepartmentMangerController = contentDepartmentMangerController;
	}

	/**
	 * Sets the view report controller.
	 *
	 * @param viewReportController the new view report controller
	 */
	public void setViewReportController(ViewReportController viewReportController) {
		this.viewReportController = viewReportController;
	}

	/**
	 * Sets the publish new version of map controller.
	 *
	 * @param publishNewVersionOfMapController the new publish new version of map controller
	 */
	public void setPublishNewVersionOfMapController(PublishNewVersionOfMapController publishNewVersionOfMapController) {
		this.publishNewVersionOfMapController = publishNewVersionOfMapController;
	}

	/**
	 * Gets the client member controller.
	 *
	 * @return the client member controller
	 */
	public static ClientMemberController GetClientMemberController() {
		if (clientMemberController == null)
			clientMemberController = new ClientMemberController();
		return clientMemberController;
	}

	/**
	 * Gets the gcm main controller.
	 *
	 * @return the gcm main controller
	 */
	public gcmMainController getGcmMainController() {
		return GcmMainController;
	}

	/**
	 * Sets the gcm main controller.
	 *
	 * @param gcmMainController the new gcm main controller
	 */
	public void setGcmMainController(gcmMainController gcmMainController) {
		GcmMainController = gcmMainController;
	}

	/**
	 * Gets the register controller.
	 *
	 * @return the register controller
	 */
	public registerController getRegisterController() {
		return RegisterController;
	}

	/**
	 * Sets the register controller.
	 *
	 * @param registerController the new register controller
	 */
	public void setRegisterController(registerController registerController) {
		RegisterController = registerController;
	}

	/**
	 * Gets the edits the profile controller.
	 *
	 * @return the edits the profile controller
	 */
	public EditProfileController getEditProfileController() {
		return editProfileController;
	}

	/**
	 * Sets the edits the profile controller.
	 *
	 * @param editProfileController the new edits the profile controller
	 */
	public void setEditProfileController(EditProfileController editProfileController) {
		this.editProfileController = editProfileController;

	}

	/**
	 * Sets the client edit new tour to city controllers.
	 *
	 * @param editNewTourCityController the new client edit new tour to city controllers
	 */
	public void setClientEditNewTourToCityControllers(EditNewTourToCityController editNewTourCityController) {
		this.editNewTourCityController = editNewTourCityController;
	}

	/**
	 * Gets the purchasemap controller.
	 *
	 * @return the purchasemap controller
	 */
	public PurchasemapController getPurchasemapController() {
		return purchasemapController;
	}

	/**
	 * Sets the purchasemap controller.
	 *
	 * @param purchasemapController the new purchasemap controller
	 */
	public void setPurchasemapController(PurchasemapController purchasemapController) {
		this.purchasemapController = purchasemapController;
	}

	/**
	 * Gets the member main controller.
	 *
	 * @return the member main controller
	 */
	public MemberMainController getMemberMainController() {
		return memberMainController;
	}

	/**
	 * Sets the member main controller.
	 *
	 * @param memberMainController the new member main controller
	 */
	public void setMemberMainController(MemberMainController memberMainController) {
		this.memberMainController = memberMainController;
	}

	/**
	 * Gets the maps download controller.
	 *
	 * @return the maps download controller
	 */
	public MapsDownloadController getMapsDownloadController() {
		return mapsDownloadController;
	}

	/**
	 * Sets the maps download controller.
	 *
	 * @param mapsDownloadController the new maps download controller
	 */
	public void setMapsDownloadController(MapsDownloadController mapsDownloadController) {
		this.mapsDownloadController = mapsDownloadController;
	}

	/**
	 * Gets the publish new version of map controller.
	 *
	 * @return the publish new version of map controller
	 */
	public PublishNewVersionOfMapController getPublishNewVersionOfMapController() {
		return publishNewVersionOfMapController;
	}

	// -------------------------------------------------------------------------------------------//
	// Internal
	// functions------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------------------//

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////// User
	/**
	 * Log in validation.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////// LogIn//////////////////////////////////////////////////////////////////////////////////
	public void logInValidation(String userName, String password) throws IOException {

		mainClient.sendToServer(QueryCreator.logInCustomerByUserName(userName, password));
		mainClient.sendToServer(QueryCreator.logInEmployeesByUserName(userName, password));
	}

	/**
	 * Gets the login.
	 *
	 * @param queryResult the query result
	 * @return the login
	 */
	public void getLogin(ArrayList<String> queryResult) {
		GcmMainController.loginIdentification(queryResult);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////// Client
	/**
	 * Registration new user.
	 *
	 * @param RegisterInfo the register info
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// registration/////////////////////////////////////////////////////////////////////////
	public void RegistrationNewUser(String[] RegisterInfo) throws IOException {
		mainClient.sendToServer(QueryCreator.insertCustomer(RegisterInfo));
		if (!registerController.registerFailed) {
			mainClient.sendToServer(QueryCreator.insertCC(RegisterInfo));
			mainClient.sendToServer(QueryCreator.GetCustomerByUsername(RegisterInfo[0]));
		}
	}

	/**
	 * Registration result.
	 *
	 * @param str the str
	 */
	public void RegistrationResult(String str) {
		RegisterController.Register(str);
	}

	/**
	 * Registration credit card.
	 */
	public void RegistrationCreditCard() {

	}

	/**
	 * Gets the customer.
	 *
	 * @param queryResult the query result
	 * @return the customer
	 */
	public void getCustomer(ArrayList<String> queryResult) {
		RegisterController.setEntetie(queryResult);
	}

	/**
	 * Registration failed.
	 *
	 * @param error the error
	 */
	public void registrationFailed(String error) {
		RegisterController.printUserExists();
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// Update Customer
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// Info////////////////////////////////////////////////////////////////

	/**
	 * Send to server update customer info.
	 *
	 * @param UpdateCustomerInfo the update customer info
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerUpdateCustomerInfo(String[] UpdateCustomerInfo) throws IOException {
		mainClient.sendToServer(QueryCreator.updateCustomerInfo(UpdateCustomerInfo));
		mainClient.sendToServer(QueryCreator.updateCCInfo(UpdateCustomerInfo));
	}

	/**
	 * Recive update customert info.
	 */
	public void reciveUpdateCustomertInfo() {
		editProfileController.InsertCustomerTextFields();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// Update Employee
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// Info//////////////////////////////////////////////////////////////

	/**
	 * Send to server update employee info.
	 *
	 * @param UpdateEmployeeInfo the update employee info
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerUpdateEmployeeInfo(String[] UpdateEmployeeInfo) throws IOException// updateEmployeeInfo
	{
		mainClient.sendToServer(QueryCreator.updateEmployeeInfo(UpdateEmployeeInfo));
		mainClient.sendToServer(QueryCreator.updateCCInfo(UpdateEmployeeInfo));
	}

	/**
	 * Recive update employee info.
	 */
	public void reciveUpdateEmployeeInfo() {
		editProfileController.InsertEmployeeTextFields();
	}

	/**
	 * Temp function.
	 *
	 * @param userInfo the user info
	 */
	public void tempFunction(ArrayList<String> userInfo) {
		GcmMainController.loginIdentification(userInfo);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// Insert new
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// city//////////////////////////////////////////////////////////////

	/**
	 * Send to server city.
	 *
	 * @param str the str
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerCity(String[] str) throws IOException {

		mainClient.sendToServer(QueryCreator.insertCity(str));
	}

	/**
	 * City.
	 */
	public void city() {

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// load Country
	/**
	 * Send to server country.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// Box//////////////////////////////////////////////////////////////
	public void sendToServerCountry() throws IOException {
		mainClient.sendToServer(QueryCreator.selectAllCountries());
	}

	/**
	 * Load country box.
	 *
	 * @param arr the arr
	 */
	public void loadCountryBox(ArrayList<String> arr) {
		if (EditMapContent.flag1 == 1)
			createNewCityController.loadComboBox(arr);
		if (EditMapContent.flag2 == 1)
			addNewMapToCityController.loadComboBox(arr);
		if (EditMapContent.flag3 == 1)
			addInterestedPlaceController.loadComboBox(arr);
		if (GcmManagerController.flag4 == 1)
			updateMapRatesController.loadComboBox(arr);
		if (ContentDepartmentMangerController.flag5 == 1)
			updateMapRatesController.loadComboBox(arr);
		if (gcmMainController.flag6 == 1)
			GcmMainController.loadComboBox(arr);
		if (EditMapContent.flag7 == 1)
			deleteinterestedplaceController.loadComboBox(arr);
		if (EditMapContent.flag8 == 1)
			editInterestedPlaceController.loadComboBox(arr);
		if (EditMapContent.flag9 == 1)
			addNewTourToCityControllers.loadComboBox(arr);
		if (ViewCatalogController.flag11 == 1)
			viewCatalogController.loadComboBox(arr);
		if (viewReportController.flag13 == 1)
			viewReportController.loadComboBox(arr);
		if (editNewTourCityController.onThisPage)
			editNewTourCityController.loadCountryBox(arr);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// Insert Interested
	/**
	 * Send to server interested.
	 *
	 * @param details the details
	 * @param POI the poi
	 * @param status the status
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////
	public void sendToServerInterested(String[] details, PointOfInterest POI, String status) throws IOException {

		mainClient.sendToServer(QueryCreator.insertInterestedPlace(details, POI, status));
	}

	/**
	 * Send to server interested.
	 *
	 * @param arr the arr
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerInterested(String[] arr) throws IOException {

		mainClient.sendToServer(QueryCreator.insertNewPOI(arr));

	}
	
    /**
     * Send to server update POI.
     *
     * @param arr the arr
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void sendToServerUpdatePOI(String[] arr) throws IOException {
		
		mainClient.sendToServer(QueryCreator.updatePOI(arr));
		
	}
   
    /**
     * Updated POI.
     */
    public void UpdatedPOI() {
		this.editInterestedPlaceController.UpdatedPOI();
	}

	/**
	 * Insert interested.
	 */
	public void InsertInterested() {

	}

	/**
	 * Insert new POI.
	 */
	public void insertNewPOI()
	{
		addInterestedPlaceController.newPOIinserted();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////// Displays a city by clicking on a
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////// comboBox//////////////////////////////////////////////

	/**
	 * Send to server state.
	 *
	 * @param state the state
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerState(String state) throws IOException {
		mainClient.sendToServer(QueryCreator.filterCityByCountry(state));
	}

	/**
	 * Load city box.
	 *
	 * @param arr the arr
	 */
	public void loadCityBox(ArrayList<String> arr) {
		if (EditMapContent.flag2 == 1)
			addNewMapToCityController.loadComboBox1(arr);
		if (EditMapContent.flag3 == 1)
			addInterestedPlaceController.loadComboBox1(arr);
		if (GcmManagerController.flag4 == 1)
			updateMapRatesController.loadComboBox1(arr);
		if (ContentDepartmentMangerController.flag5 == 1)
			updateMapRatesController.loadComboBox1(arr);
		if (gcmMainController.flag6 == 1)
			GcmMainController.loadComboBox1(arr);
		if (EditMapContent.flag7 == 1)
			deleteinterestedplaceController.loadComboBox1(arr);
		if (EditMapContent.flag8 == 1)
			editInterestedPlaceController.loadComboBox1(arr);
		if (EditMapContent.flag9 == 1)
			addNewTourToCityControllers.loadComboBox1(arr);
		if (ViewCatalogController.flag11 == 1)
			viewCatalogController.loadComboBox1(arr);
		if (ViewReportController.flag13 == 1)
			viewReportController.loadComboBox1(arr);
		if (editNewTourCityController.onThisPage)
			editNewTourCityController.loadCityBox(arr);

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// Insert map to city
	/**
	 * Send to server insert map.
	 *
	 * @param maps the maps
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////
	public void sendToServerInsertMap(String[] maps) throws IOException {
		mainClient.sendToServer(QueryCreator.insertMap(maps));
	}
	
	
	/**
	 * Aftermapadded.
	 */
	public void aftermapadded() {
		
		this.addNewMapToCityController.aftermapadded();

	}

	/**
	 * Send to servercity.
	 *
	 * @param city the city
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServercity(String city) throws IOException {
		mainClient.sendToServer(QueryCreator.SelectMapByCity(city));
	}

	/**
	 * Send to server map.
	 *
	 * @param map the map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerMap(String map) throws IOException {
		mainClient.sendToServer(QueryCreator.selectPOIByMapDesc(map));
	}

	/**
	 * Load maps box.
	 *
	 * @param arr the arr
	 */
	public void loadMapsBox(ArrayList<String> arr) {
		if (EditMapContent.flag3 == 1)
			addInterestedPlaceController.loadComboBox2(arr);
		if (GcmManagerController.flag4 == 1)
			updateMapRatesController.loadComboBox2(arr);
		if (ContentDepartmentMangerController.flag5 == 1)
			updateMapRatesController.loadComboBox2(arr);
		if (EditMapContent.flag7 == 1)
			deleteinterestedplaceController.loadComboBox2(arr);
		if (EditMapContent.flag8 == 1)
			editInterestedPlaceController.loadComboBox2(arr);
	}

	/**
	 * Send to server map description.
	 *
	 * @param description the description
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerMapDescription(String description) throws IOException {
		mainClient.sendToServer(QueryCreator.selectMapRate(description));
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// load rates to textfeild
	/**
	 * Load rates.
	 *
	 * @param arr the arr
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// /////////////////////////////////////////////////////////////
	public void loadRates(ArrayList<String> arr) {
		if (GcmManagerController.flag4 == 1)
			updateMapRatesController.loadrates(arr);
		if (ContentDepartmentMangerController.flag5 == 1)
			updateMapRatesController.loadrates(arr);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// load place name to combobox
	/**
	 * Load place name.
	 *
	 * @param arr the arr
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// /////////////////////////////////////////////////////////////
	public void loadPlaceName(ArrayList<String> arr) {
		if (EditMapContent.flag7 == 1)
			deleteinterestedplaceController.laodplace(arr);
		if (EditMapContent.flag8 == 1)
			editInterestedPlaceController.laodplace(arr);

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// delete palces
	/**
	 * Send to serverdelete.
	 *
	 * @param palces the palces
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////
	public void sendToServerdelete(String[] palces) throws IOException {
		mainClient.sendToServer(QueryCreator.deletePOIbyMap(palces));
	}

	/**
	 * Placename.
	 */
	public void placename() {

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// update Rates
	/**
	 * Send to server new rates.
	 *
	 * @param rates the rates
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////
	public void sendToServerNewRates(String[] rates) throws IOException {
		if (GcmManagerController.flag4 == 1)
			mainClient.sendToServer(QueryCreator.updateMapRate(rates));
		if (ContentDepartmentMangerController.flag5 == 1)
			mainClient.sendToServer(QueryCreator.updateMapRate(rates));
	}

    /**
     * Rates.
     */
    public void rates() {
		
		this.updateMapRatesController.updatedrates();

	}

	/**
	 * Send to serverplace name.
	 *
	 * @param input the input
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/* Guest Catalog View */
	public void sendToServerplaceName(String input) throws IOException {
		mainClient.sendToServer(QueryCreator.selectMapByPOIName(input));
	}

	/**
	 * Prints the to table.
	 *
	 * @param arr the arr
	 */
	public void printToTable(ArrayList<String> arr) {

		if (gcmMainController.flag12 == 1)
			GcmMainController.printToTable(arr);
		if (ViewCatalogController.flag11 == 1)
			viewCatalogController.printToTable(arr);

	}

	/**
	 * Send to server city name by view catalog.
	 *
	 * @param input the input
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerCityNameByViewCatalog(String input) throws IOException {
		mainClient.sendToServer(QueryCreator.viewMapCatalogGuestByCityName(input));
	}

	/**
	 * Load table.
	 *
	 * @param arr the arr
	 */
	public void loadTable(ArrayList<String> arr) {
		if (gcmMainController.flag12 == 1)
			GcmMainController.printToTable1(arr);
		if (ViewCatalogController.flag11 == 1)
			viewCatalogController.printToTable1(arr);

	}

	/**
	 * Send to server free text.
	 *
	 * @param input the input
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerFreeText(String input) throws IOException {
		mainClient.sendToServer(QueryCreator.selectMapFromText(input));
	}

	/**
	 * Show table by free text.
	 *
	 * @param arr the arr
	 */
	public void showTableByFreeText(ArrayList<String> arr) {
		if (gcmMainController.flag12 == 1)
			GcmMainController.printToTable(arr);
		if (ViewCatalogController.flag11 == 1)
			viewCatalogController.printToTable(arr);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// get map image by desc
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	/**
	 * Send to server get map.
	 *
	 * @param mapDescription the map description
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerGetMap(String mapDescription) throws IOException {
		mainClient.sendToServer(QueryCreator.getMapByMapDescription(mapDescription));
	}

	/**
	 * Sets the image from DB.
	 *
	 * @param mapImage the new image from DB
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void setImageFromDB(byte[] mapImage) throws IOException {
		if (EditMapContent.flag3 == 1)
			addInterestedPlaceController.setMapImageView(mapImage);
		if (EditMapContent.flag8 == 1)
			editInterestedPlaceController.setMapImageView(mapImage);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// get map id by desc
	/**
	 * Send to server get map id.
	 *
	 * @param mapDescription the map description
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////
	public void sendToServerGetMapId(String mapDescription) throws IOException {
		mainClient.sendToServer(QueryCreator.getMapIdByMapDescription(mapDescription));
	}

	/**
	 * Sets the map id by desc.
	 *
	 * @param mapId the new map id by desc
	 */
	public void setMapIdByDesc(String mapId) {
		if (EditMapContent.flag3 == 1)
			addInterestedPlaceController.InsertMapId(mapId);
		if (EditMapContent.flag8 == 1)
			editInterestedPlaceController.InsertMapId(mapId);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// get map interested places coordinate by map
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// id
	/**
	 * Send to server get map intre places.
	 *
	 * @param mapID the map ID
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ///////////////////////////////////=
	public void sendToServerGetMapIntrePlaces(String mapID) throws IOException {
		mainClient.sendToServer(QueryCreator.selectPOICoorByMapID(mapID));
	}

	/**
	 * Sets the map places by map ID.
	 *
	 * @param arr the new map places by map ID
	 */
	public void setMapPlacesByMapID(ArrayList<String> arr) {
		if (EditMapContent.flag3 == 1)
			addInterestedPlaceController.MapPlacesByMapID(arr);
		;
		if (EditMapContent.flag8 == 1)
			editInterestedPlaceController.MapPlacesByMapID(arr);
		;

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// get map interested specific please
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// coordinate
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// by
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// place
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// name
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////

	/**
	 * Sent to server get map coord.
	 *
	 * @param placeName the place name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sentToServerGetMapCoord(String placeName) throws IOException {
		mainClient.sendToServer(QueryCreator.selectMapCoordByPlaceName(placeName));
	}

	/**
	 * Sets the map coord.
	 *
	 * @param arr the new map coord
	 */
	public void setMapCoord(ArrayList<String> arr) {
		editInterestedPlaceController.setMapCoordAnimation(arr);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// get poi by city
	/**
	 * Send to server get poi by city.
	 *
	 * @param city the city
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////
	public void sendToServer_get_poi_by_city(String city) throws IOException {
		mainClient.sendToServer(QueryCreator.getpoibycity(city));
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// load combobox place name by poi
	/**
	 * Load place name to combox.
	 *
	 * @param arr the arr
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////
	public void loadPlaceNameToCombox(ArrayList<String> arr) {
		if (EditMapContent.flag9 == 1)
			addNewTourToCityControllers.loadComboBoxNamePlace(arr);
		if (gcmMainController.flag10 == 1)
			GcmMainController.loadComboBoxNamePlace(arr);
		if (ViewCatalogController.flag11 == 1)
			viewCatalogController.loadComboBoxNamePlace(arr);
		if (editNewTourCityController.onThisPage)
			editNewTourCityController.loadNewPOIBox(arr);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// get poi by city
	/**
	 * Send to server gat details.
	 *
	 * @param city the city
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////
	public void sendToServerGatDetails(String city) throws IOException {
		mainClient.sendToServer(QueryCreator.getpoibycity(city));
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// get maps by type purchase
	/**
	 * Send to server type purchas.
	 *
	 * @param type the type
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////
	public void sendToServerTypePurchas(String[] type) throws IOException {

		mainClient.sendToServer(QueryCreator.getPurchaseInfo(type));
	}

	/**
	 * Show table bypurchase.
	 *
	 * @param arr the arr
	 */
	public void showTableBypurchase(ArrayList<String> arr) {

		viewCatalogController.printToTableByPurchase(arr);
	}

	//////////////////// send To Server Type Purchase and
	/**
	 * Send to server history purchases.
	 *
	 * @param type the type
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//////////////////// details//////////////////////////////////////////////////////////
	public void sendToServerHistoryPurchases(String[] type) throws IOException {

		mainClient.sendToServer(QueryCreator.getUserInfo(type));
	}

	/**
	 * User info returned.
	 *
	 * @param arr the arr
	 */
	public void userInfoReturned(ArrayList<String> arr) {

		managmentClientInfoController.printInfo(arr);
	}

	/**
	 * Send to server get history.
	 *
	 * @param arr the arr
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerGetHistory(String[] arr) throws IOException {
		mainClient.sendToServer(QueryCreator.getPurchaseHistory(arr));
	}

	/**
	 * Purchase history returned.
	 *
	 * @param arr the arr
	 */
	public void purchaseHistoryReturned(ArrayList<String> arr) {
		managmentClientInfoController.printHistory(arr);
	}

	///////////////////////// Send data to the server to view report
	/**
	 * Send to server details of the reports.
	 *
	 * @param arr the arr
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	///////////////////////// information/////////////////////////////////////////////////////////
	public void sendToServerDetailsOfTheReports(String[] arr) throws IOException {
		mainClient.sendToServer(QueryCreator.getReport(arr));
	}

	/**
	 * Prints the details of maps between dates.
	 *
	 * @param arr the arr
	 */
	public void PrintDetailsOfMapsBetweenDates(ArrayList<String> arr) {
		viewReportController.PrintInformationByDate(arr);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// add\edit\delete tour
	/**
	 * Send to server tour info.
	 *
	 * @param arr the arr
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////
	public void sendToServerTourInfo(String[] arr) throws IOException {
		mainClient.sendToServer(QueryCreator.insertTour(arr));
	}

	/**
	 * Send to server get tour ID.
	 *
	 * @param name the name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerGetTourID(String name) throws IOException {
		mainClient.sendToServer(QueryCreator.getTourIDByName(name));
	}

	/**
	 * Tour.
	 */
	public void tour() {

	}

	/**
	 * Poi connected.
	 */
	public void poiConnected() {
		if (addNewTourToCityControllers.onThisPage)
			addNewTourToCityControllers.printPOIToTable();
		if (editNewTourCityController.onThisPage)
			editNewTourCityController.poiAdded();
	}

	/**
	 * Tour I dreceived.
	 *
	 * @param arr the arr
	 */
	public void tourIDreceived(ArrayList<String> arr) {
		if (addNewTourToCityControllers.onThisPage)
			addNewTourToCityControllers.setTourID(arr);
	}

	/**
	 * Send to server get poi ID.
	 *
	 * @param arr the arr
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerGetPoiID(String[] arr) throws IOException {
		mainClient.sendToServer(QueryCreator.selectPidByName(arr));
	}

	/**
	 * Send to server add POI to tour.
	 *
	 * @param arr the arr
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerAddPOIToTour(String[] arr) throws IOException {
		mainClient.sendToServer(QueryCreator.insertPOIToTour(arr));
	}

	/**
	 * POII dreceived.
	 *
	 * @param arr the arr
	 */
	public void POIIDreceived(ArrayList<String> arr) {
		addNewTourToCityControllers.setNewPOI(arr);
	}

	/**
	 * Tour names received.
	 *
	 * @param arr the arr
	 */
	public void TourNamesReceived(ArrayList<String> arr) {
		editNewTourCityController.loadTourBox(arr);
	}

	/**
	 * Send to server get POI by tour.
	 *
	 * @param id the id
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerGetPOIByTour(String id) throws IOException {
		mainClient.sendToServer(QueryCreator.selectPOIbyTour(id));
	}

	/**
	 * Send to server get tour info.
	 *
	 * @param name the name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerGetTourInfo(String name) throws IOException {
		mainClient.sendToServer(QueryCreator.selectTourInfoByName(name));
	}

	/**
	 * Tour info received.
	 *
	 * @param arr the arr
	 */
	public void TourInfoReceived(ArrayList<String> arr) {
		editNewTourCityController.setCurrentTour(arr);
	}

	/**
	 * Load POI by tour box.
	 *
	 * @param arr the arr
	 */
	public void loadPOIByTourBox(ArrayList<String> arr) {
		editNewTourCityController.loadExistingPOIBox(arr);
	}

	/**
	 * Send to server update index.
	 *
	 * @param arr the arr
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerUpdateIndex(String[] arr) throws IOException {
		mainClient.sendToServer(QueryCreator.updateTourIndex(arr));
	}

	/**
	 * Index updated.
	 */
	public void indexUpdated() {
		editNewTourCityController.updateSuccess();
	}

	/**
	 * Send to server remove POI.
	 *
	 * @param arr the arr
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerRemovePOI(String[] arr) throws IOException {
		mainClient.sendToServer(QueryCreator.deletePOIFromTour(arr));
	}

	/**
	 * Poi removed.
	 */
	public void poiRemoved() {
		editNewTourCityController.removalSuccess();
	}

	/**
	 * Send to server get other POI.
	 *
	 * @param arr the arr
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerGetOtherPOI(String[] arr) throws IOException {
		mainClient.sendToServer(QueryCreator.getPoiNotInTour(arr));
	}

	/**
	 * Load other PO is.
	 *
	 * @param arr the arr
	 */
	public void loadOtherPOIs(ArrayList<String> arr) {
		editNewTourCityController.loadOthersBox(arr);
	}

	/**
	 * Send to server del tour.
	 *
	 * @param arr the arr
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerDelTour(String[] arr) throws IOException {
		mainClient.sendToServer(QueryCreator.deleteTour(arr));
	}

	/**
	 * Tour deleted.
	 */
	public void tourDeleted() {
		editNewTourCityController.deleteSuccess();
	}

	/**
	 * Send to server update tour.
	 *
	 * @param arr the arr
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerUpdateTour(String[] arr) throws IOException {
		mainClient.sendToServer(QueryCreator.updateTourInfo(arr));
	}

	/**
	 * Tour updated.
	 */
	public void tourUpdated() {
		editNewTourCityController.infoUpdated();
	}

	/**
	 * Send to server get tour by city.
	 *
	 * @param str the str
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerGetTourByCity(String str) throws IOException {
		mainClient.sendToServer(QueryCreator.getTourByCity(str));
	}

	///////////////////////////////// *END OF ADD\EDIT\DELETE
	///////////////////////////////// tour*//////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// Get POI list by city
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	/**
	 * Send to server get all POI by city.
	 *
	 * @param cityName the city name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerGetAllPOIByCity(String cityName) throws IOException {
		mainClient.sendToServer(QueryCreator.selectAllPOIByCity(cityName));
	}

	/**
	 * Sets the all POI by city.
	 *
	 * @param arr the new all POI by city
	 */
	public void setAllPOIByCity(ArrayList<String> arr) {
		addInterestedPlaceController.saveAllPOIInfoOfCity(arr);
	}

	/**
	 * Gets the POI in map.
	 *
	 * @param mapid the mapid
	 * @param cityname the cityname
	 * @return the POI in map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void getPOIInMap(int mapid, String cityname) throws IOException
	{

		String[] strArr=new String[2];
		strArr[0]=Integer.toString(mapid);
		strArr[1]=cityname;
		mainClient.sendToServer(QueryCreator.getPOIInMap(strArr));
	}

	/**
	 * POI in map ret.
	 *
	 * @param strArr the str arr
	 */
	public void POIInMapRet(ArrayList<String> strArr)
	{
		ArrayList<PointOfInterest> POIList=new ArrayList<PointOfInterest>();
		int size=strArr.size()/2;
		for(int i=0;i<size;i++)
		{
			POIList.add(new PointOfInterest(Integer.parseInt(strArr.get(0)), strArr.get(1)));
			strArr.remove(0);
			strArr.remove(0);
		}
		addInterestedPlaceController.setInMap(POIList);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Sent to server load city info.
	 *
	 * @param str the str
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sentToServerLoadCityInfo(String str) throws IOException {
		mainClient.sendToServer(QueryCreator.filterCityByCountry(str));
	}

	/**
	 * Sets the city entity.
	 *
	 * @param City the new city entity
	 */
	public void setCityEntity(ArrayList<String> City) {
		GcmMainController.setCityEnt(City);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Send to server get map image.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void sendToServerGetMapImage() throws IOException {
		mainClient.sendToServer(QueryCreator.getMapImage());
	}

	/**
	 * Sets the map entity.
	 *
	 * @param array the new map entity
	 */
	public void setMapEntity(ArrayList<Object> array) {
		GcmMainController.setMapEnt(array);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Send to server get all POI.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerGetAllPOI() throws IOException {
		mainClient.sendToServer(QueryCreator.getAllPOI());
	}

	/**
	 * Sets the POI entity.
	 *
	 * @param array the new POI entity
	 */
	public void setPOIEntity(ArrayList<String> array) {
		if (purchasemapController.onThisPag == true)
			purchasemapController.setPOIEntity(array);
		if (mapsDownloadController.onThisPag == true)
			mapsDownloadController.setPOIEntity(array);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Send to server insert customer purchase.
	 *
	 * @param purcInfo the purc info
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void sendToServerInsertCustomerPurchase(ArrayList<String> purcInfo) throws IOException {
		mainClient.sendToServer(QueryCreator.InsertCustomerPurchase(purcInfo));
	}

	/**
	 * Msg back from server cus pur info.
	 *
	 * @param str the str
	 */
	public void msgBackFromServerCusPurInfo(String str) {

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Send to server insert customer download.
	 *
	 * @param cusDownInfo the cus down info
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void sendToServerInsertCustomerDownload(ArrayList<String> cusDownInfo) throws IOException {
		mainClient.sendToServer(QueryCreator.InsertCustomerDownload(cusDownInfo));
	}

	/**
	 * Send to server insert download.
	 *
	 * @param cusDownInfo the cus down info
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerInsertDownload(ArrayList<String> cusDownInfo) throws IOException {
		mainClient.sendToServer(QueryCreator.InsertDownload(cusDownInfo));
	}

	/**
	 * Msg back from server cus down info.
	 *
	 * @param str the str
	 */
	public void msgBackFromServerCusDownInfo(String str) {

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Send to server get all purchase.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void sendToServerGetAllPurchase() throws IOException {
		mainClient.sendToServer(QueryCreator.getAllPurchase());
	}

	/**
	 * Sets the purchase entity.
	 *
	 * @param array the new purchase entity
	 */
	public void setPurchaseEntity(ArrayList<String> array) {
		if (memberMainController.onThisPag == true)
			memberMainController.setPurchaseEntity(array);
		if (purchasemapController.onThisPag == true)
			purchasemapController.setPurchaseEntity(array);
		if (mapsDownloadController.onThisPag = true)
			mapsDownloadController.setPurchaseEntity(array);

	}

	/**
	 * Logout.
	 */
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////// LogOut//////////////////////////////////////////////////////////////////////////////////
	public void logout() {
		mainClient.logout();
	}

	/**
	 * Send to server log out.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerLogOut() throws IOException {
		mainClient.sendToServer(QueryCreator.DeleteUserName());
	}

	/**
	 * User logged out.
	 */
	public void userLoggedOut() {
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Send to server update purchase.
	 *
	 * @param subTimeToRenew the sub time to renew
	 * @param purchaseId the purchase id
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void sendToServerUpdatePurchase(String subTimeToRenew, int purchaseId) throws IOException {
		mainClient.sendToServer(QueryCreator.updatePurchaseTable(subTimeToRenew, purchaseId));
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Send to server insert purchase his.
	 *
	 * @param userName the user name
	 * @param cityName the city name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerInsertPurchaseHis(String userName, String cityName) throws IOException {
		mainClient.sendToServer(QueryCreator.insertSubRenew(userName, cityName));
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////// GET Information for
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// publish
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// new
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// version///////////////////////////////////////////////////////////////

	/**
	 * Send to server publishnewversionalltb.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerPublishnewversionalltb() throws IOException {
		mainClient.sendToServer(QueryCreator.specialrequestforpublishnewversionalltb());
	}

	/**
	 * Send to server publishnewversiontb.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerPublishnewversiontb() throws IOException {
		mainClient.sendToServer(QueryCreator.specialrequestforpublishnewversiontb());
	}

	/**
	 * Send to serveridofmaptogetoldandnewpoi.
	 *
	 * @param arr the arr
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServeridofmaptogetoldandnewpoi(String arr) throws IOException {
		mainClient.sendToServer(QueryCreator.getnewoldpoi(arr));
	}

	/**
	 * Send toserverapproverate.
	 *
	 * @param arr the arr
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void SendToserverapproverate(String arr) throws IOException {
		mainClient.sendToServer(QueryCreator.approverate(arr));
	}

	/**
	 * Send toserverapprovepoi.
	 *
	 * @param arr the arr
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void SendToserverapprovepoi(String arr) throws IOException {
		mainClient.sendToServer(QueryCreator.approvepoi(arr));
	}

	/**
	 * Listwaitingmaps.
	 *
	 * @param array the array
	 */
	public void Listwaitingmaps(ArrayList<String> array) {

		this.publishNewVersionOfMapController.fillmaplist(array);

	}

	/**
	 * Listwaitingrates.
	 *
	 * @param array the array
	 */
	public void Listwaitingrates(ArrayList<String> array) {

		this.publishNewVersionOfMapController.fillmaplistextended(array);

	}

	/**
	 * Listofoldpoi.
	 *
	 * @param array the array
	 */
	public void Listofoldpoi(ArrayList<String> array) {

		this.publishNewVersionOfMapController.filloldpoi(array);

	}

	/**
	 * Listofnewpoi.
	 *
	 * @param array the array
	 */
	public void Listofnewpoi(ArrayList<String> array) {

		this.publishNewVersionOfMapController.fillnewpoi(array);

	}

	/**
	 * Listofnewoldpoi.
	 *
	 * @param array the array
	 */
	public void Listofnewoldpoi(ArrayList<String> array) {

		int i = array.indexOf("SecondResult");
		int size = array.size();
		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();

		for (int j = 0; j < size; j++) {
			if (j < i)
				arr1.add(array.get(j));

			if (i < j)
				arr2.add(array.get(j));
		}
		this.publishNewVersionOfMapController.fillnewpoi(arr1);
		this.publishNewVersionOfMapController.filloldpoi(arr2);

	}

	/**
	 * Msg back from server approvepoi.
	 *
	 * @param array the array
	 */
	public void msgBackFromServerApprovepoi(String array) {

		this.publishNewVersionOfMapController.afterApprovedpoi(array);

	}

	/**
	 * Msg back from server approverate.
	 *
	 * @param array the array
	 */
	public void msgBackFromServerApproverate(String array) {

		this.publishNewVersionOfMapController.afterApprovedrate(array);

	}

/**
 * Gets the exp sub.
 *
 * @return the exp sub
 * @throws IOException Signals that an I/O exception has occurred.
 */
/* Methods for displaying pop ups with notifiactions */
	public void getExpSub() throws IOException {
		mainClient.sendToServer(QueryCreator.getExpiredSubs());
	}

	/**
	 * Exp subs received.
	 *
	 * @param arr the arr
	 */
	public void expSubsReceived(ArrayList<String> arr)
	{
		memberMainController.printExpPopUp(arr);
	}

	/**
	 * Gets the version updates.
	 *
	 * @return the version updates
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void getVersionUpdates() throws IOException
	{
		mainClient.sendToServer(QueryCreator.getVersionUpdates());
	}

	/**
	 * Notifications received.
	 *
	 * @param str the str
	 */
	public void notificationsReceived(String str)
	{
		memberMainController.printUpdatePopUp(str);
	}

	/**
	 * Send to server get requests.
	 *
	 * @param permission the permission
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void sendToServerGetRequests(int permission) throws IOException
	{
		mainClient.sendToServer(QueryCreator.getRequestsNum(permission));
	}

	/**
	 * Req returned.
	 *
	 * @param res the res
	 */
	public void reqReturned(String res)
	{
		GcmMainController.setReq(res);
	}

	/**
	 * Send to server add view.
	 *
	 * @param username the username
	 * @param cityname the cityname
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/* Add new city collection view */
	public void sendToServerAddView(String username, String cityname) throws IOException
	{
		String[] strArr=new String[2];
		strArr[0]=username;
		strArr[1]=cityname;
		mainClient.sendToServer(QueryCreator.addView(strArr));
	}

	/**
	 * Adds the view.
	 */
	public void addView()
	{

	}
}
