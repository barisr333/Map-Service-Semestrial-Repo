package guiControllers;

import java.io.IOException;

import javax.swing.text.View;

import entities.Employee;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systemFunctionality.ClientMemberController;
import systemFunctionality.ValidationTests;
import javafx.scene.control.Label;

// TODO: Auto-generated Javadoc
/**
 * The Class GcmManagerController.
 */
public class GcmManagerController {

	/** The logout. */
	@FXML
    private Button logout;

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

    /** The btn update map rates. */
    @FXML
    private Button btn_Update_map_rates;

    /** The btn managment client info. */
    @FXML
    private Button btn_Managment_client_info;

    /** The btn view report. */
    @FXML
    private Button btn_View_Report;

    /** The anchor pane. */
    @FXML
    private AnchorPane anchorPane;

    /** The user name. */
    public String userName;

    /** The user name. */
    @FXML
    private Label user_name;

    /** The flag 4. */
    public static int  flag4=0;

    /** The primary stage 1. */
    Stage primaryStage1;

    /** The client member controller. */
    private ClientMemberController clientMemberController;
    
    /** The gcm manager controller. */
    public static GcmManagerController gcmManagerController;

  //-------------------------------------------------------------------------------------------//
 // Getters and setters methods---------------------------------------------------------------//
 /**
   * Instantiates a new gcm manager controller.
   */
  //-------------------------------------------------------------------------------------------//
 	    public GcmManagerController() {
 	    	gcmManagerController = this;
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
    	  * Gets the gcm manager controller.
    	  *
    	  * @return the gcm manager controller
    	  */
    	 public static GcmManagerController GetGcmManagerController() {
 			if(gcmManagerController == null)
 				gcmManagerController = new GcmManagerController();
 			return gcmManagerController;
 		}
 //-------------------------------------------------------------------------------------------//
 // Initialize method - Happens when the fxml file load---------------------------------------//
 //-------------------------------------------------------------------------------------------//



    /**
  * Initialize.
  */
 @FXML
    void initialize() {
    	user_name.setText("Hello"+" "+gcmMainController.user.getFirstName()+" "+gcmMainController.user.getLastName() );
    	clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setClientGcmManagerController(this);

    }


    /**
     * On click edit prfile.
     *
     * @param event the event
     */
    @FXML
    void OnClick_Edit_Prfile(MouseEvent event) {
    	try
		{

			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/EditProfile.fxml"));
			Scene scene = new Scene(root,850,650);
			scene.getStylesheets().add(getClass().getResource("/fxml/EditProfile.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Edit Profile Window");
			primaryStage.show();
		}
	catch(Exception e)
		{
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
		  ViewCatalogController.flag11=1;
		  try
			{
				VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/ViewCatalog.fxml"));
				Scene scene = new Scene(root,850,695);
				scene.getStylesheets().add(getClass().getResource("/fxml/ViewCatalog.css").toExternalForm());
				Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				primaryStage.setScene(scene);
				primaryStage.setTitle("View Catalog Window");
				primaryStage.show();
			}
		catch(Exception e)
			{
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

		  try
			{
				VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/PublishNewVersionOfMap.fxml"));
				Scene scene = new Scene(root,1225,670);
				scene.getStylesheets().add(getClass().getResource("/fxml/PublishNewVersionOfMap.css").toExternalForm());
				Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				primaryStage.setScene(scene);
				primaryStage.setTitle("Publish New Version Of Map Window");
				primaryStage.show();
			}
		catch(Exception e)
			{
				e.printStackTrace();
			}


	    }


	  /**
  	 * On click managment client info.
  	 *
  	 * @param event the event
  	 */
  	@FXML
	    void On_Click_Managment_client_info(MouseEvent event) {

	    	 try
				{
					VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/ManagmentClientInfo.fxml"));
					Scene scene = new Scene(root,850,650);
					scene.getStylesheets().add(getClass().getResource("/fxml/ManagmentClientInfo.css").toExternalForm());
					Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					primaryStage.setScene(scene);
					primaryStage.setTitle("Managment Client Info Window");
					primaryStage.show();
				}
			catch(Exception e)
				{
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
	    	n = (Button)event.getSource();
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
	    	n = (Button)event.getSource();
	    	n.setStyle("-fx-background-color : #BDBBC3");
	    }







    /**
     * Logout on click.
     *
     * @param event the event
     */
    @FXML
    void logoutOnClick(MouseEvent event) {
	 try
	 {
	    if(!ValidationTests.printConfirmMsg("Logging out", "Are you sure you want to log out??"))
	    	event.consume();
	    else
	    {
		clientMemberController.sendToServerLogOut();
		VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/gcmFXML.fxml"));
		Scene scene = new Scene(root,850,650);
		scene.getStylesheets().add(getClass().getResource("/fxml/gcmCSS.css").toExternalForm());
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.setTitle("GCM System");
		primaryStage.show();
	    }
    	}
catch(Exception e)
	{
		e.printStackTrace();
	}
   }


	  /**
  	 * On click update map rates.
  	 *
  	 * @param event the event
  	 */
  	@FXML
	    void On_Click_Update_map_rates(MouseEvent event) {
	    	flag4=1;
	    	 try
				{
					VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/UpdateMapRates.fxml"));
					Scene scene = new Scene(root,850,650);
					scene.getStylesheets().add(getClass().getResource("/fxml/UpdateMapRates.css").toExternalForm());
					Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					primaryStage.setScene(scene);
					primaryStage.setTitle("Update Map Rates Window");
					primaryStage.show();
				}
			catch(Exception e)
				{
					e.printStackTrace();
				}

	    }



	  /**
  	 * On click view report.
  	 *
  	 * @param event the event
  	 */
  	@FXML
	    void On_Click_View_Report(MouseEvent event) {
	    	ViewReportController.flag13=1;
	    	 try
				{
					VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/ViewReport.fxml"));
					Scene scene = new Scene(root,850,650);
					scene.getStylesheets().add(getClass().getResource("/fxml/ViewReport.css").toExternalForm());
					Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					primaryStage.setScene(scene);
					primaryStage.setTitle("View Report Window");
					primaryStage.show();
				}
			catch(Exception e)
				{
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

	    	 try
				{
					VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/EditMapContent.fxml"));
					Scene scene = new Scene(root,850,650);
					scene.getStylesheets().add(getClass().getResource("/fxml/EditMapContent.css").toExternalForm());
					Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					primaryStage.setScene(scene);
					primaryStage.setTitle("Edit Map Content Window");
					primaryStage.show();
				}
			catch(Exception e)
				{
					e.printStackTrace();
				}

	    }




}
