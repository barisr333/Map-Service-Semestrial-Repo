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
 * The Class ContentDepartmentEmployee.
 */
public class ContentDepartmentEmployee {

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

    /** The username. */
    @FXML
    private Label username;


    /** The client member controller. */
    private ClientMemberController clientMemberController;
    
    /** The content department employee. */
    public static ContentDepartmentEmployee contentDepartmentEmployee;

  //-------------------------------------------------------------------------------------------//
 // Getters and setters methods---------------------------------------------------------------//
 /**
   * Instantiates a new content department employee.
   */
  //-------------------------------------------------------------------------------------------//
 	    public ContentDepartmentEmployee() {
 	    	contentDepartmentEmployee = this;
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
    	  * Gets the content department employee.
    	  *
    	  * @return the content department employee
    	  */
    	 public static ContentDepartmentEmployee GetContentDepartmentEmployee() {
 			if(contentDepartmentEmployee == null)
 				contentDepartmentEmployee = new ContentDepartmentEmployee();
 			return contentDepartmentEmployee;
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
		clientMemberController.setClientContentDepartmentEmployee(this);
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



}


