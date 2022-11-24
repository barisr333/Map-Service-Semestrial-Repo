package guiControllers;


import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.HBox;

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteinterestedplaceController.
 */
public class DeleteinterestedplaceController {

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

    /** The Name cbx. */
    @FXML
    private ComboBox<String> NameCbx;

    /** The delete btn. */
    @FXML
    private Button delete_Btn;


	  //-------------------------------------------------------------------------------------------//
	 // Internal Class attributes-----------------------------------------------------------------//
	 /** The client member controller. */
  	//-------------------------------------------------------------------------------------------//
	     private ClientMemberController clientMemberController;
	     
     	/** The deleteinterestedplace controller. */
     	public static DeleteinterestedplaceController deleteinterestedplaceController;
	     
     	/** The country list. */
     	ObservableList<String> countryList;
	     
     	/** The city list. */
     	ObservableList<String> cityList;
	     
     	/** The map list. */
     	ObservableList<String> mapList;
	     
     	/** The palce name list. */
     	ObservableList<String> palce_nameList;
	     
     	/** The Registration info. */
     	private String[] RegistrationInfo = new String[2];
	 //-------------------------------------------------------------------------------------------//
	 // Getters and setters methods---------------------------------------------------------------//
	 //-------------------------------------------------------------------------------------------//

	     /**
 	 * Instantiates a new deleteinterestedplace controller.
 	 */
 	public DeleteinterestedplaceController() {
	    	 deleteinterestedplaceController = this;
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
     	 * Gets the deleteinterestedplace controller.
     	 *
     	 * @return the deleteinterestedplace controller
     	 */
     	public static DeleteinterestedplaceController GetDeleteinterestedplaceController() {
	 		if(deleteinterestedplaceController == null)
	 			deleteinterestedplaceController = new DeleteinterestedplaceController();
	 		return deleteinterestedplaceController;
	 	}

		 //-------------------------------------------------------------------------------------------//
		 // Initialize method - Happens when the fxml file load---------------------------------------//
		 //-------------------------------------------------------------------------------------------//


    /**
 		 * Initialize.
 		 *
 		 * @throws IOException Signals that an I/O exception has occurred.
 		 */
 		@FXML
    void initialize() throws IOException {

    	  if(gcmMainController.user.getPermission()==1)
          	TabMenu.setVisible(false);
          else
          	TabMenu.setVisible(true);


      	if ((gcmMainController.user.getPermission() == 2)|| (gcmMainController.user.getPermission() == 3)) {
  			btn_Edit_Map.setVisible(false);
  			btn_Publish_New_Version.setVisible(false);
  		}

      	if(gcmMainController.user.getPermission()==1)
        	gcm_manager.setVisible(true);
        if(gcmMainController.user.getPermission()==2)
        	image_content_emp.setVisible(true);
        if(gcmMainController.user.getPermission()==3)
        	image_gcm_content_manger.setVisible(true);


    	    clientMemberController = ClientMemberController.GetClientMemberController();
	 		clientMemberController.setClientDeleteinterestedplaceController(this);
	     	clientMemberController.sendToServerCountry();


	     	CountryCbx.valueProperty().addListener((obs, oldItem, newItem) -> {   //By clicking on a value inside the combobox, we will print to ////

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



			CityCbx.valueProperty().addListener((obs, oldItem, newItem) -> {    //By clicking on a value within the combobox, the city will be drawn//

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


			MapCbx.valueProperty().addListener((obs, oldItem, newItem) -> {    //By clicking on a value within the combobox, the city will be drawn//

	            if (newItem != null) {
	                 try {
						clientMemberController.sendToServerMap(MapCbx.getValue().toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            } else {

	            }
	        });


			NameCbx.valueProperty().addListener((obs, oldItem, newItem) -> {    //By clicking on a value within the combobox, the city will be drawn//

	            if (newItem != null) {
	                 delete_Btn.setDisable(false);
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
		  EditMapContent.flag7=0;
	    	try
			{
	    		VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/EditMapContent.fxml"));
				Scene scene = new Scene(root,850,650);
				scene.getStylesheets().add(getClass().getResource("/fxml/EditMapContent.css").toExternalForm());
				Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				primaryStage.setScene(scene);
				primaryStage.setTitle("Edit Map Content");
				primaryStage.show();
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
				Scene scene = new Scene(root,850,650);
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
    	 * Click on delete.
    	 *
    	 * @param event the event
    	 * @throws IOException Signals that an I/O exception has occurred.
    	 */
    	@FXML
	    void Click_on_delete(MouseEvent event) throws IOException {
	    	RegistrationInfo[0]=MapCbx.getValue().toString();
	    	RegistrationInfo[1]=NameCbx.getValue().toString();
	    	clientMemberController.sendToServerdelete(RegistrationInfo);
	    	ValidationTests.printInfoMsg("POI Deletion","Place of Interest successfully deleted!" );
	    	CountryCbx.setValue(null);
	    	CityCbx.setValue(null);
	    	MapCbx.setValue(null);
	    	NameCbx.setValue(null);
	    	delete_Btn.setDisable(true);


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



	 //-------------------------------------------------------------------------------------------//
	 // Internal functions------------------------------------------------------------------------//
	 //-------------------------------------------------------------------------------------------//

	     /**
 	 * Load combo box.
 	 *
 	 * @param arr the arr
 	 */
 	////////////////Loading a country list into the combobox////////////////////////
	    public void loadComboBox(ArrayList<String> arr)
	    {

		    countryList = FXCollections.observableArrayList(arr);
			CountryCbx.setItems(countryList);
	    }


	    /**
    	 * Load combo box 1.
    	 *
    	 * @param arr the arr
    	 */
    	////////////////Loading a city list into the combobox////////////////////////
	 	  public void loadComboBox1(ArrayList<String> arr)
		   {

	 		 cityList = FXCollections.observableArrayList(arr);
	 		CityCbx.setItems(cityList);
		   }

          /**
           * Load combo box 2.
           *
           * @param arr the arr
           */
          ////////////////Loading a map list into the combobox////////////////////////
		  public void loadComboBox2(ArrayList<String> arr)
		   {

			  mapList = FXCollections.observableArrayList(arr);
			  MapCbx.setItems(mapList);
		   }

           /**
            * Laodplace.
            *
            * @param arr the arr
            */
           ////////////////Loading a place name list into the combobox////////////////////////
	       public void laodplace(ArrayList<String> arr)
	       {

	    	   palce_nameList = FXCollections.observableArrayList(arr);
	    	   NameCbx.setItems(palce_nameList);
	       }





	 //-------------------------------------------------------------------------------------------//
	 //-------------------------------------------------------------------------------------------//


	  }


