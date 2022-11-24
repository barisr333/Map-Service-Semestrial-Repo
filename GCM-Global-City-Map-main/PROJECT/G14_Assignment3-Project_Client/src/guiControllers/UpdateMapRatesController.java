package guiControllers;

import java.io.IOException;
import javafx.scene.layout.HBox;
import javafx.scene.layout.AnchorPane;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateMapRatesController.
 */
public class UpdateMapRatesController {

    /** The back btn. */
    @FXML
    private Button backBtn;

    /** The btn view catalg. */
    @FXML
    private Button btnView_Catalg;

    /** The btn edit prfile. */
    @FXML
    private Button btnEdit_Prfile;

    /** The Country cbx. */
    @FXML
    private ComboBox<String> CountryCbx;

    /** The City cbx. */
    @FXML
    private ComboBox<String> CityCbx;

    /** The Map cbx. */
    @FXML
    private ComboBox<String> MapCbx;

    /** The rate txt. */
    @FXML
    private TextField rateTxt;

    /** The subrate. */
    @FXML
    private TextField subrate;

    /** The update btn. */
    @FXML
    private Button updateBtn;


    /** The btn publish new version. */
    @FXML
    private Button btn_Publish_New_Version;


    /** The gcm manager. */
    @FXML
    private ImageView gcmManager;

    /** The content manager. */
    @FXML
    private ImageView content_manager;

    /** The Tab menu. */
    @FXML
    private HBox TabMenu;

    /** The anchor pane. */
    @FXML
    private AnchorPane anchorPane;

    /** The client member controller. */
    private ClientMemberController clientMemberController;
    
    /** The update map rates controller. */
    public static UpdateMapRatesController updateMapRatesController;
    
    /** The country list. */
    ObservableList<String> countryList;
    
    /** The city list. */
    ObservableList<String> cityList;
    
    /** The map list. */
    ObservableList<String> mapList;
    
    /** The Registration info. */
    private String[] RegistrationInfo = new String[3];


    /**
     * Instantiates a new update map rates controller.
     */
    public UpdateMapRatesController() {
    	updateMapRatesController = this;
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
     * Gets the update map rates controller.
     *
     * @return the update map rates controller
     */
    public static UpdateMapRatesController GetUpdateMapRatesController() {
		if(updateMapRatesController == null)
			updateMapRatesController = new UpdateMapRatesController();
		return updateMapRatesController;
	}





    /**
     * Initialize.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @FXML
	void initialize() throws IOException
	 {
    	btn_Publish_New_Version.setVisible(false);
    	 if(gcmMainController.user.getPermission()==1) {
	          	TabMenu.setVisible(false);
	          	gcmManager.setVisible(true);
    	 }
	     else {
	          	TabMenu.setVisible(true);
	          	content_manager.setVisible(true);
	     }

		clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setUpdateMapRatesController(this);
		clientMemberController.sendToServerCountry();

		CountryCbx.valueProperty().addListener((obs, oldItem, newItem) -> {   //By clicking on a value within the combobox, the state will be drawn//


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
					clientMemberController.sendToServerMapDescription(MapCbx.getValue().toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

		 switch (gcmMainController.user.getPermission())
		 {
			case 1://Case of GCM Manager.
				openManagerPage(gcmMainController.user.getFirstName());
				break;
			case 3://Case of Content Department Manager.
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
    	 * Click on update.
    	 *
    	 * @param event the event
    	 * @throws IOException Signals that an I/O exception has occurred.
    	 */
    	@FXML
	    void Click_on_update(MouseEvent event) throws IOException {
	    	if(checkFields())
	    	 {
	    		 InsertDetailsInfoToArray();
		    	 clientMemberController.sendToServerNewRates(RegistrationInfo);
		    	 ValidationTests.printInfoMsg("Rate update","Map rates successfully updated!" );
	    	 }
	    	 cleartxt();
	    }

	    /**
    	 * Insert details info to array.
    	 */
    	public void InsertDetailsInfoToArray ()
		   {
	    	   RegistrationInfo[0]=rateTxt.getText();
			   RegistrationInfo[1]=subrate.getText();
			   RegistrationInfo[2]=MapCbx.getValue().toString();
		   }

	    /**
    	 * Cleartxt.
    	 */
    	public void cleartxt()
	    {
	    	rateTxt.setText(" ");
			subrate.setText(" ");
			CityCbx.setValue(" ");
			//System.out.println(CityCbx.getPromptText());
			//CityCbx.setPromptText("Select city");
			MapCbx.setPromptText(" ");
			CountryCbx.setValue(" ");
	    }


	    /**
    	 * Open manager page.
    	 *
    	 * @param userName the user name
    	 */
    	public void openManagerPage(String userName)
	    {
	    	GcmManagerController.flag4=0;
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
    	 * Open cont dep man page.
    	 *
    	 * @param userName the user name
    	 */
    	public void openContDepManPage (String userName)
	    {
	    	ContentDepartmentMangerController.flag5=0;
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
  		 * Load country combo box.
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
  			 * Load city combo box.
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
  	 		 * Load map combo box.
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
  			 * Load currently selected map rates to UI fields.
  			 *
  			 * @param arr the arr
  			 */
  			////////////////Loading a map rates list into the TextFeild////////////////////////
			  public void loadrates(ArrayList<String> arr)
			   {
				  rateTxt.setText(arr.get(0).toString());
				  subrate.setText(arr.get(1).toString());

			   }
			  
  			/**
  			 * Check fields.
  			 *
  			 * @return true, if successful
  			 */
  			public boolean checkFields()
			  {
				if(MapCbx.getValue()==null)
				{
					ValidationTests.printErrorMsg("Error", "You must select a map!");
					return false;
				}
				if(ValidationTests.isFieldEmpty(rateTxt.getText()) || ValidationTests.isFieldEmpty(subrate.getText()))
					return false;
				if(!ValidationTests.isRateDouble(rateTxt.getText()) || !ValidationTests.isRateDouble(subrate.getText()))
					return false;
				return true;
			  }
			  
			  
			  /**
  			 * Notify user of updated rates.
  			 */
  			public void updatedrates()
			  {
				 try {
						this.initialize();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	 Platform.runLater(new Runnable() {
		 			@Override
		 			public void run() {
		 				ValidationTests.printInfoMsg("Update State", "the rates map were updated,now waiting for approvement");
		 			}
		 		});
		    	 
		    	
				  
			  }


}
