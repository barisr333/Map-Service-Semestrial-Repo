package guiControllers;

import java.io.IOException;
import java.util.ArrayList;

import entities.Location;
import entities.PointOfInterest;
import entities.Purchase;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
import javafx.event.ActionEvent;
// TODO: Auto-generated Javadoc
/**
 * MemberMainController - GUI controller for "MemberMain.fxml"
 */
public class MemberMainController {
//-------------------------------------------------------------------------------------------//
// GUI components attribute------------------------------------------------------------------//
/** The logout. */
//-------------------------------------------------------------------------------------------//
    @FXML
    private Button logout;

    /** The btn view catalg. */
    @FXML
    private Button btnView_Catalg;

    /** The btn edit prfile. */
    @FXML
    private Button btnEdit_Prfile;

    /** The btn notifications. */
    @FXML
    private Button btn_Notifications;

    /** The btn purchase map. */
    @FXML
    private Button btn_Purchase_map;

    /** The usernamelbl. */
    @FXML
    private Label usernamelbl;

    /** The download btn. */
    @FXML
    private Button downloadBtn;
//-------------------------------------------------------------------------------------------//
// Internal Class attributes-----------------------------------------------------------------//
/** The client member controller. */
//-------------------------------------------------------------------------------------------//
    private ClientMemberController clientMemberController;
    
    /** The member main controller. */
    public static MemberMainController memberMainController;
    
    /** The purchase list. */
    public ArrayList<Purchase> purchaseList = new ArrayList<Purchase>();
    
    /** The lock. */
    private Object lock = new Object();
    
    /** The on this pag. */
    public boolean onThisPag = false;







//-------------------------------------------------------------------------------------------//
// Getters and setters methods---------------------------------------------------------------//
//-------------------------------------------------------------------------------------------//


    /**
 * Instantiates a new member main controller.
 */
public MemberMainController() {
    	memberMainController = this;
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
	 * Gets the member main controller.
	 *
	 * @return the member main controller
	 */
	public static MemberMainController GetMemberMainController() {
		if(memberMainController == null)
			memberMainController = new MemberMainController();
		return memberMainController;
	}


//-------------------------------------------------------------------------------------------//
// Initialize method - Happens when the fxml file load---------------------------------------//
/**
 * Initialize.
 *
 * @throws IOException Signals that an I/O exception has occurred.
 */
//-------------------------------------------------------------------------------------------//
    @FXML
    void initialize() throws IOException {
    	usernamelbl.setText("Welcome "+gcmMainController.user.getFirstName()+" "+gcmMainController.user.getLastName()+" to Global city map system.");
    	clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setClientMemberController(this);
		onThisPag = true;
		clientMemberController.sendToServerGetAllPurchase();
		downloadBtn.setDisable(true);


		 synchronized (lock)
		 {

			try {
				lock.wait(50);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < purchaseList.size(); i++)
			{
				if(gcmMainController.user.getUserName().equals(purchaseList.get(i).getCustomerUsername()))
				{
					if(purchaseList.get(i).getType().equals("Subscription"))
					{
						downloadBtn.setDisable(false);
					}
				}
				else
				{

				}
			}
		}

    }



//-------------------------------------------------------------------------------------------//
// Cases of events from GUI------------------------------------------------------------------//
//-------------------------------------------------------------------------------------------//

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
     * Download on click.
     *
     * @param event the event
     */
    @FXML
    void downloadOnClick(ActionEvent event) {
    	try
   	 	{
   		VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/MapsDownload.fxml"));
   		Scene scene = new Scene(root,850,650);
   		scene.getStylesheets().add(getClass().getResource("/fxml/MapsDownload.css").toExternalForm());
   		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
   		primaryStage.setScene(scene);
   		primaryStage.setTitle("Download maps");
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
  	 * On click purchase map.
  	 *
  	 * @param event the event
  	 */
  	@FXML
	    void On_Click_Purchase_map(MouseEvent event) {

		  try
			{
				VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/Purchasemap.fxml"));
				Scene scene = new Scene(root,850,650);
				scene.getStylesheets().add(getClass().getResource("/fxml/Purchasemap.css").toExternalForm());
				Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				primaryStage.setScene(scene);
				primaryStage.setTitle("Purchase map Window");
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
     * Click on customer card.
     *
     * @param event the event
     */
    @FXML
    void Click_on_customer_card(MouseEvent event) {

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
     * Click on notifications.
     *
     * @param event the event
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @FXML
    void ClickOnNotifications(MouseEvent event) throws IOException {

    	clientMemberController.getExpSub();
		clientMemberController.getVersionUpdates();

    }

    /**
     * Prints the exp pop up.
     *
     * @param arr the arr
     */
    public void printExpPopUp(ArrayList<String> arr)
	{
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					for(int i=0;i<arr.size();i++)
						ValidationTests.printInfoMsg("Subscription notice", "Your subscription of "+arr.get(i)+" expires in 3 days!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    /**
     * Prints the update pop up.
     *
     * @param str the str
     */
    public void printUpdatePopUp(String str)
    {
    	Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					if(!str.isEmpty() && Integer.parseInt(str)!=0)
						ValidationTests.printInfoMsg("Updates notice", "There are version updates for "+str+" of your subscriptions!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }


//-------------------------------------------------------------------------------------------//
// Internal functions------------------------------------------------------------------------//
//-------------------------------------------------------------------------------------------//

    /**
 * Sets the purchase entity.
 *
 * @param array the new purchase entity
 */
public void setPurchaseEntity(ArrayList<String> array)
    {
    	 onThisPag = false;
    	 int i = 0;

		 for (int j = 0; j < array.size(); j+=7)
		 {
			 	purchaseList.add(new Purchase());

			 	purchaseList.get(i).setIdpurchase(Integer.parseInt(array.get(j)));
			 	purchaseList.get(i).setType(array.get(j+1));
			 	purchaseList.get(i).setPrice(Double.parseDouble(array.get(j+2)));
			 	purchaseList.get(i).setDate(array.get(j+3));
			 	purchaseList.get(i).setPurchasedCity(array.get(j+4));
			 	purchaseList.get(i).setSubTime(Integer.parseInt(array.get(j+5)));
			 	purchaseList.get(i).setCustomerUsername(array.get(j+6));
				i++;
		 }
    }

}
