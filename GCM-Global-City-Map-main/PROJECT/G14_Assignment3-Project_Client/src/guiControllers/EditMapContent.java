package guiControllers;



import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class EditMapContent.
 */
public class EditMapContent {
	
	/** The image gcm content. */
	@FXML
    private ImageView image_gcm_content;

    /** The image content emp. */
    @FXML
    private ImageView image_content_emp;

    /** The gcm manager. */
    @FXML
    private ImageView gcm_manager;

	/** The back btn. */
	@FXML
    private Button backBtn;

	/** The btn view catalg. */
	@FXML
    private Button btnView_Catalg;

    /** The btn edit prfile. */
    @FXML
     private Button btnEdit_Prfile;

    /** The btn edit map. */
    @FXML
    private Button btn_Edit_Map;

    /** The Btn create new city. */
    @FXML
    private Button Btn_Create_new_city;

    /** The Btn add new map to city. */
    @FXML
    private Button Btn_Add_new_map_to_city;

    /** The Btn add new tour to city. */
    @FXML
    private Button Btn_Add_new_tour_to_city;

    /** The Btn edit tour to city. */
    @FXML
    private Button Btn_Edit_tour_to_city;

    /** The Btn edit interested place. */
    @FXML
    private Button Btn_Edit_interested_place;

    /** The Btn delete tour of city. */
    @FXML
    private Button Btn_Delete_tour_of_city;

    /** The Btn delete interested place. */
    @FXML
    private Button Btn_Delete_interested_place;

    /** The Btn add interested place. */
    @FXML
    private Button Btn_Add_interested_place;

    /** The anchor pane. */
    @FXML
    private AnchorPane anchorPane;

    /** The Tab menu. */
    @FXML
    private HBox TabMenu;

    /** The flag 9. */
    public static int flag1=0,flag2=0,flag3=0,flag7=0,flag8=0,flag9=0;

    /**
     * Initialize.
     */
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize()
    {
        if(gcmMainController.user.getPermission()==1)
        	TabMenu.setVisible(false);
        else
        	TabMenu.setVisible(true);

        btn_Edit_Map.setVisible(false);

        if(gcmMainController.user.getPermission()==1)
        	gcm_manager.setVisible(true);
        if(gcmMainController.user.getPermission()==2)
		{
        	image_content_emp.setVisible(true);
			Btn_Delete_interested_place.setVisible(false);
			
		}
        if(gcmMainController.user.getPermission()==3)
        	image_gcm_content.setVisible(true);

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



    /**
     * On click create new city.
     *
     * @param event the event
     */
    @FXML
    void OnClick_Create_New_city(MouseEvent event) {
    	flag1=1;

    	try
		{
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/CreateNewCity.fxml"));
			Scene scene = new Scene(root,850,650);
			scene.getStylesheets().add(getClass().getResource("/fxml/CreateNewCity.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Create New City Window");
			primaryStage.show();
		}
	catch(Exception e)
		{
			e.printStackTrace();
		}


    }

    /**
     * On klick add new tour to city.
     *
     * @param event the event
     */
    @FXML
    void OnKlick_Add_new_tour_to_city(MouseEvent event) {
    	flag9=1;
    	try
		{
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/AddNewTourToCity.fxml"));
			Scene scene = new Scene(root,850,650);
			scene.getStylesheets().add(getClass().getResource("/fxml/AddNewTourToCity.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Add New Tour To City Window");
			primaryStage.show();
		}
	catch(Exception e)
		{
			e.printStackTrace();
		}


    }

    /**
     * On klick edit tour to city.
     *
     * @param event the event
     */
    @FXML
    void OnKlick_Edit_tour_to_city(MouseEvent event) {

    	try
		{
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/EditNewTourToCity.fxml"));
			Scene scene = new Scene(root,850,650);
			scene.getStylesheets().add(getClass().getResource("/fxml/EditNewTourToCity.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Edit New Tour To City Window");
			primaryStage.show();
		}
	catch(Exception e)
		{
			e.printStackTrace();
		}


    }


    /**
     * On klick edit interested place.
     *
     * @param event the event
     */
    @FXML
    void OnKlick_Edit_interested_place(MouseEvent event) {
    	flag8=1;
    	try
		{
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/EditInterestedPlace.fxml"));
			Scene scene = new Scene(root,850,650);
			scene.getStylesheets().add(getClass().getResource("/fxml/EditInterestedPlace.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Edit Interested Place Window");
			primaryStage.show();
		}
	catch(Exception e)
		{
			e.printStackTrace();
		}


    }

    /**
     * On klick delete tour of city.
     *
     * @param event the event
     */
    @FXML
    void OnKlick_Delete_tour_of_city(MouseEvent event) {

    	try
		{
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/DeleteTourofCity.fxml"));
			Scene scene = new Scene(root,850,650);
			scene.getStylesheets().add(getClass().getResource("/fxml/DeleteTourofCity.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Delete Tour of City Window");
			primaryStage.show();
		}
	catch(Exception e)
		{
			e.printStackTrace();
		}


    }

    /**
     * On klick add new map to city.
     *
     * @param event the event
     */
    @FXML
    void OnKlick_Add_new_map_to_city(MouseEvent event) {
            	flag2=1;

				try
				{
					VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/AddNewMapToCity.fxml"));
					Scene scene = new Scene(root,850,650);
					scene.getStylesheets().add(getClass().getResource("/fxml/AddNewMapToCity.css").toExternalForm());
					Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					primaryStage.setScene(scene);
					primaryStage.setTitle("Add New Map To City Window");
					primaryStage.show();
				}
			catch(Exception e)
				{
					e.printStackTrace();
				}
   }


    /**
     * On klick delete interested place.
     *
     * @param event the event
     */
    @FXML
    void OnKlick_Delete_interested_place(MouseEvent event) {
    	flag7=1;
    	try
		{
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/Deleteinterestedplace.fxml"));
			Scene scene = new Scene(root,850,650);
			scene.getStylesheets().add(getClass().getResource("/fxml/Deleteinterestedplace.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Delete interested place Window");
			primaryStage.show();
		}
	catch(Exception e)
		{
			e.printStackTrace();
		}


    }


    /**
     * On klick add interested place.
     *
     * @param event the event
     */
    @FXML
    void OnKlick_Add_interested_place(MouseEvent event) {
    	 flag3=1;
    	try
		{
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/AddInterestedPlace.fxml"));
			Scene scene = new Scene(root,850,783);
			scene.getStylesheets().add(getClass().getResource("/fxml/AddInterestedPlace.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Add interested place Window");
			primaryStage.show();
		}
	catch(Exception e)
		{
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
    	switch (gcmMainController.user.getPermission())
		{
		case 1://Case of GCM Manager.
				openManagerPage(gcmMainController.user.getFirstName());
				break;
		case 2://Case of Content Department Employee.
				openContDepEmpPage(gcmMainController.user.getFirstName());
				break;
		case 3://Case of Content Department Employee.
			openContDepManPage(gcmMainController.user.getFirstName());
			break;
		default:
			break;
		}
    }

    /**
     * Open manager page.
     *
     * @param userName the user name
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

    /**
     * Open cont dep emp page.
     *
     * @param userName the user name
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
			//		scene.getStylesheets().add(getClass().getResource("/fxml/ContentDepartmentManger.css").toExternalForm());
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



    }




