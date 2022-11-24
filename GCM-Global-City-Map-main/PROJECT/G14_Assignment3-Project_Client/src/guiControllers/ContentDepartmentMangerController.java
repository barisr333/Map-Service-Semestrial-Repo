package guiControllers;

import entities.Customer;
import entities.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systemFunctionality.ClientMemberController;
import systemFunctionality.ValidationTests;
import javafx.scene.control.Label;




// TODO: Auto-generated Javadoc
/**
 * The Class ContentDepartmentMangerController.
 */
public class ContentDepartmentMangerController {

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


    /** The btn publis version. */
    @FXML
    private Button btn_Publis_version;

    /** The btn edit map. */
    @FXML
    private Button btn_Edit_Map;

    /** The btn update map rate. */
    @FXML
    private Button btn_update_map_rate;

    /** The username. */
    @FXML
    private Label username;

    /** The btn view report. */
    @FXML
    private Button btn_View_Report;

    /** The flag 5. */
    public static int  flag5=0;


    /** The client member controller. */
    private ClientMemberController clientMemberController;
    
    /** The content department manger controller. */
    public static ContentDepartmentMangerController contentDepartmentMangerController;

  //-------------------------------------------------------------------------------------------//
 // Getters and setters methods---------------------------------------------------------------//
 /**
   * Instantiates a new content department manger controller.
   */
  //-------------------------------------------------------------------------------------------//
 	    public ContentDepartmentMangerController() {
 	    	contentDepartmentMangerController = this;
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
    	  * Gets the content department manger controller.
    	  *
    	  * @return the content department manger controller
    	  */
    	 public static ContentDepartmentMangerController GetContentDepartmentMangerController() {
 			if(contentDepartmentMangerController == null)
 				contentDepartmentMangerController = new ContentDepartmentMangerController();
 			return contentDepartmentMangerController;
 		}
 //-------------------------------------------------------------------------------------------//
 // Initialize method - Happens when the fxml file load---------------------------------------//
 //-------------------------------------------------------------------------------------------//




    /**
  * Initialize.
  */
 @FXML
   void initialize() {
    	username.setText("Welcome "+gcmMainController.user.getFirstName()+" "+gcmMainController.user.getLastName()+" to Global city map system."+" userName: "+"\n");
    	clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setClientContentDepartmentMangerController(this);
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


	    /**
    	 * On click update map rate.
    	 *
    	 * @param event the event
    	 */
    	@FXML
	    void On_Click_update_map_rate(MouseEvent event) {
	    	flag5=1;
	    	 try
				{
					VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/UpdateMapRates.fxml"));
					Scene scene = new Scene(root,850,650);
					scene.getStylesheets().add(getClass().getResource("/fxml/UpdateMapRates.css").toExternalForm());
					Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					primaryStage.setScene(scene);
					primaryStage.setTitle("UpdateMapRates Window");
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
    	 * On click publish version.
    	 *
    	 * @param event the event
    	 */
    	@FXML
	    void On_Click_Publish_version(MouseEvent event) {
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



}


