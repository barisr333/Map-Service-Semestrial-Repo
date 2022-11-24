package guiControllers;
/**
 * MapsDownloadController - GUI controller for "MapsDownload.fxml"
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.ParseException;
import javafx.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javafx.scene.control.Label;
import entities.Location;
import entities.Map;
import entities.PointOfInterest;
import entities.Purchase;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systemFunctionality.ClientMemberController;
import javafx.scene.layout.HBox;
import java.util.Date;
import java.util.Optional;
import java.time.LocalDate ;
import java.time.Period;
import java.time.ZoneId;
// TODO: Auto-generated Javadoc
//-------------------------------------------------------------------------------------------//
//GUI components attribute------------------------------------------------------------------//
/**
 * The Class MapsDownloadController.
 */
//-------------------------------------------------------------------------------------------//
public class MapsDownloadController {

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

    /** The download map table. */
    @FXML
    private TableView<Map> downloadMapTable;

    /** The map name col. */
    @FXML
    private TableColumn<Map, String> mapNameCol;

    /** The No of POI col. */
    @FXML
    private TableColumn<Map, Integer> NoOfPOICol;

    /** The City cbx. */
    @FXML
    private ComboBox<String> CityCbx;

    /** The download btn. */
    @FXML
    private Button downloadBtn;

    /** The monthlbl. */
    @FXML
    private Label monthlbl;

    /** The months cbx. */
    @FXML
    private ComboBox<String> monthsCbx;

    /** The total no of maps. */
    @FXML
    private Label totalNoOfMaps;

    /** The total no of POI. */
    @FXML
    private Label totalNoOfPOI;

    /** The total price. */
    @FXML
    private Label totalPrice;

    /** The renew btn. */
    @FXML
    private Button renewBtn;

    /** The total price discount. */
    @FXML
    private Label totalPriceDiscount;

//-------------------------------------------------------------------------------------------//
// Internal Class attributes-----------------------------------------------------------------//
/** The client member controller. */
//-------------------------------------------------------------------------------------------//
    private ClientMemberController clientMemberController;
    
    /** The maps download controller. */
    public static MapsDownloadController mapsDownloadController;
    
    /** The purchase list. */
    public ArrayList<Purchase> purchaseList = new ArrayList<Purchase>();
    
    /** The POI list. */
    public ArrayList<PointOfInterest> POIList = new ArrayList<PointOfInterest>();
    
    /** The city list. */
    ObservableList<String> cityList;
    
    /** The lock. */
    private Object lock = new Object();
    
    /** The on this pag. */
    public boolean onThisPag = false;
    
    /** The city name. */
    String cityName;
    
    /** The date. */
    Date date = new Date();
    
    /** The local date. */
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    
    /** The month today. */
    int monthToday = localDate.getMonthValue();
    
    /** The monthh buy. */
    int monthhBuy;
    
    /** The months numbers. */
    ObservableList<String> monthsNumbers ;
	
	/** The total PO ilbl. */
	int totalPOIlbl = 0 ;
	
	/** The total mapslbl. */
	int totalMapslbl = 0;
	
	/** The total sub pricelbl. */
	double totalSubPricelbl = 0 ;
	
	/** The Monthly payment. */
	double MonthlyPayment = 0;
	
	/** The df 2. */
	private DecimalFormat df2 = new DecimalFormat("##.##");
	
	/** The sub time to renew. */
	String subTimeToRenew;
	
	/** The city to renew. */
	String cityToRenew;
	
	/** The temp amount. */
	double tempAmount;
	
	/** The purchase id. */
	int purchaseId;
	
	/** The temp. */
	String temp;


//-------------------------------------------------------------------------------------------//
// Getters and setters methods---------------------------------------------------------------//
/**
 * Instantiates a new maps download controller.
 */
//-------------------------------------------------------------------------------------------//
    public MapsDownloadController() {
    	mapsDownloadController = this;
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
	 * Gets the maps download controller.
	 *
	 * @return the maps download controller
	 */
	public static MapsDownloadController GetMapsDownloadController() {
		if(mapsDownloadController == null)
			mapsDownloadController = new MapsDownloadController();
		return mapsDownloadController;
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
    void initialize() throws IOException
    {
    	monthsNumbers = FXCollections.observableArrayList("1","2","3","4","5","6");
    	monthsCbx.setItems(monthsNumbers);

    	if (gcmMainController.user.getPermission() == 1)
			TabMenu.setVisible(false);
		else
			TabMenu.setVisible(true);


    	clientMemberController = ClientMemberController.GetClientMemberController();
		clientMemberController.setClientMapsDownloadController(this);
		onThisPag = true;
		clientMemberController.sendToServerGetAllPOI();
		clientMemberController.sendToServerGetAllPurchase();

		mapNameCol.setCellValueFactory(new PropertyValueFactory<Map, String>("description"));
		NoOfPOICol.setCellValueFactory(new PropertyValueFactory<Map, Integer>("numPOI"));

		downloadMapTable.setStyle("-fx-focus-color: transparent;");

		 synchronized (lock)
		 {

			try {
				lock.wait(50);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			loadCityCbx();
		}



 				 CityCbx.valueProperty().addListener((obs, oldItem, newItem) -> {   //By clicking on a value within the combobox, the state will be drawn//


 		            if (newItem != null) {

 					        temp = CityCbx.getValue().toString();
 					        downloadBtn.setDisable(false);
 					        downloadMapTable.getItems().clear();
 					        cityName = CityCbx.getValue().toString();
 						 	setNoMonth(CityCbx.getValue().toString());
 					        loadMapsByCity(CityCbx.getValue().toString());
 					        LocalDate temp=LocalDate.parse(monthlbl.getText());
 					        if(temp.isBefore(LocalDate.now()))
 					        	downloadBtn.setDisable(true);
 					        else
 					        	downloadBtn.setDisable(false);


 		            } else {

 		            }

 		});


		 monthsCbx.valueProperty().addListener((obs, oldItem, newItem) -> {   //By clicking on a value within the combobox, the state will be drawn//


	            if (newItem != null) {
	            	subTimeToRenew = monthsCbx.getValue();
	            	renewBtn.setDisable(false);
	            	MonthlyPayment = totalSubPricelbl;
	            	MonthlyPayment = MonthlyPayment * Double.parseDouble(monthsCbx.getValue());
	            	totalPrice.setText(df2.format(MonthlyPayment)+" $");
	            	tempAmount = MonthlyPayment*0.1;
	            	totalPriceDiscount.setText(df2.format(MonthlyPayment-tempAmount)+" $");
	            } else {

	            }
	        });




    }


//-------------------------------------------------------------------------------------------//
// Cases of events from GUI------------------------------------------------------------------//
/**
 * Download on click.
 *
 * @param event the event
 * @throws IOException Signals that an I/O exception has occurred.
 */
//-------------------------------------------------------------------------------------------//
    @FXML
    void downloadOnClick(MouseEvent event)  throws IOException
    {
    	int cnt = 1;

		if (!Bindings.isEmpty(downloadMapTable.getItems()).get())//check if the table does not empty. need only for the query.
		{
			ArrayList<String> purchInfo = new ArrayList<String>();
			purchInfo.add(gcmMainController.user.getUserName());
			purchInfo.add(cityName);
			clientMemberController.sendToServerInsertDownload(purchInfo);

			for (int i = 0; i < gcmMainController.MapList.size(); i++)
	    	{
	    		if(gcmMainController.MapList.get(i).getCityName().equals(cityName)==true && gcmMainController.MapList.get(i).getStatus().equals("Published"))
	    		{
	    			String userHomeFolder = System.getProperty("user.home") + "/Desktop"+"/"+gcmMainController.MapList.get(i).getCityName()+" maps";
	    			Path path = Paths.get(userHomeFolder);
	    			if (!Files.exists(path))
	    			{
	    	            Files.createDirectory(path);
	    	            System.out.println("Directory created");
	    	        } else {
	    	            System.out.println("Directory already exists");
	    	        }

	    			File targetFile = new File(userHomeFolder, gcmMainController.MapList.get(i).getDescription()+".PNG");
	    			FileOutputStream fos = new FileOutputStream(targetFile);
	    			fos.write(gcmMainController.MapList.get(i).getImageFile());

	    			//////////////////////write text file///////////////////////////////////////
	    			File f = new File(path+"/"+cityName+" all POI"+".txt");
	    			for (int j = 0; j < POIList.size(); j++)
	    			{
	    				if(gcmMainController.MapList.get(i).getId() == Integer.parseInt(POIList.get(j).getIdmap()))
	    				{
	    					BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
			    		    String content = cnt+")"+POIList.get(j).getDescription();
			    		    bw.write(content);
			    		    bw.newLine();
			    		    bw.write("=======================================");
			    		    bw.newLine();
			    		    bw.close();
			    		    cnt++;
	    				}
	    			fos.close();
	    			}
	    		}
	    	}
		}
		 else {
			 System.out.println("No Map");
		}

    }

    /**
     * Renew on click.
     *
     * @param event the event
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @FXML
    void renewOnClick(ActionEvent event) throws IOException
    {

		    	Alert alert = new Alert(AlertType.CONFIRMATION);
			    alert.setTitle("Delete File");
			    alert.setHeaderText("Are you sure want to buy and download this maps collection?");
			    alert.setContentText(null);

			    Optional<ButtonType> option = alert.showAndWait();

			      if (option.get() == ButtonType.OK)
			      {
			    	  CityCbx.setValue(null);
			    	  monthlbl.setText("0");
			    	  downloadBtn.setDisable(false);
			    	  monthsCbx.setValue(null);
			    	  monthsCbx.setDisable(false);
			    	  totalNoOfMaps.setText("0");
			    	  totalNoOfPOI.setText("0");
			    	  totalPrice.setText("0");
			    	  totalPriceDiscount.setText("0");
			    	  renewBtn.setDisable(false);
			    	  ///////////////////////////////////////////////////////// check the id of the purchase.
			    	  for (int i = 0; i < purchaseList.size(); i++)
			    	  {
						if(purchaseList.get(i).getPurchasedCity().equals(temp)&& purchaseList.get(i).getType().equals("Subscription"))
						{
								purchaseId = purchaseList.get(i).getIdpurchase();
		        				LocalDate temp = LocalDate.parse(purchaseList.get(i).getDate());
		        				temp = temp.plusMonths(Integer.parseInt(subTimeToRenew));
		        				purchaseList.get(i).setDate(temp.toString());
						}
					  }
			    	  try {
						clientMemberController.sendToServerUpdatePurchase(subTimeToRenew,purchaseId);
						clientMemberController.sendToServerInsertPurchaseHis(gcmMainController.user.getUserName(),cityName);



					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			      }else if (option.get() == ButtonType.CANCEL)
			      {
				        // this.label.setText("Cancelled!");
				  }

    }

    /**
     * Back on click.
     *
     * @param event the event
     */
    @FXML
	    void backOnClick(MouseEvent event) {
	    	try
			{
	    		 onThisPag = false;
	    		VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/MemberMain.fxml"));
				Scene scene = new Scene(root,850,650);
				scene.getStylesheets().add(getClass().getResource("/fxml/MemberMain.css").toExternalForm());
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



//-------------------------------------------------------------------------------------------//
// Internal functions------------------------------------------------------------------------//
//-------------------------------------------------------------------------------------------//


	    /**
 * Load city combo box.
 */
public void loadCityCbx()
	    {
	    	ArrayList <String> mapsInfo = new ArrayList<String>();

	    	for (int i = 0; i < purchaseList.size(); i++)
	    	{
				if(gcmMainController.user.getUserName().equals(purchaseList.get(i).getCustomerUsername()))
				{
					
						if(purchaseList.get(i).getType().equals("Subscription"))
						{
							mapsInfo.add(purchaseList.get(i).getPurchasedCity());
						}
					
				}
			}
	    	cityList = FXCollections.observableArrayList(mapsInfo);
	    	CityCbx.setItems(cityList);
	    }


	    /**
    	 * Sets the purchase entity.
    	 *
    	 * @param array the new purchase entity
    	 */
    	public void setPurchaseEntity(ArrayList<String> array)
	    {
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

	    /**
    	 * Sets the POI entity.
    	 *
    	 * @param array the new POI entity
    	 */
    	public void setPOIEntity(ArrayList<String> array)
		  {
	    	
			  int i = 0;

			 for (int j = 0; j < array.size(); j+=10)
			 {
				 	POIList.add(new PointOfInterest());

				 	POIList.get(i).setIdPOI(array.get(j));
				 	POIList.get(i).setName(array.get(j+1));
				 	POIList.get(i).setType(array.get(j+2));
				 	POIList.get(i).setDescription(array.get(j+3));
				 	POIList.get(i).setAccessible(array.get(j+4));
				 	POIList.get(i).setTime(array.get(j+5));
				 	POIList.get(i).setAddress(array.get(j+6));
				 	POIList.get(i).setIdmap(array.get(j+7));
				 	Location mapLocation = new Location();
				 	mapLocation.setLocationX(array.get(j+8));
				 	mapLocation.setLocationY(array.get(j+9));
				 	POIList.get(i).setPOIlocation(mapLocation);
					i++;
			 }
		  }

	    /**
    	 * Load maps by city.
    	 *
    	 * @param city the city
    	 */
    	public void loadMapsByCity (String city)
	    {

	    	for (int i = 0; i < gcmMainController.MapList.size(); i++)
	    	{
	    		if(gcmMainController.MapList.get(i).getCityName().equals(city)==true && gcmMainController.MapList.get(i).getStatus().equals("Published"))
	    		{
	    			downloadMapTable.getItems().add(gcmMainController.MapList.get(i));
	    		}
			}

	    }

	    /**
    	 * This method uses Java's LocalDate and Period classes to check the periods between expiry date and current date,
    	 * And to display to the user the correct expiry date for his currently selected subscription using information pulled from the DB.
    	 *
    	 * @param city the new no month
    	 */
    	public void setNoMonth(String city)
	    {
	    	totalSubPricelbl = 0 ;
	    	totalPOIlbl = 0 ;
	    	totalMapslbl = 0;

	 			    	for (int i = 0; i < purchaseList.size(); i++)
	 		        	{
	 		        		if(purchaseList.get(i).getPurchasedCity().equals(city) && purchaseList.get(i).getType().equals("Subscription"))
	 		        		{
	 		        				LocalDate temp = LocalDate.parse(purchaseList.get(i).getDate());
	 		        				temp = temp.plusMonths(purchaseList.get(i).getSubTime());
	 		        				Period period=Period.between(LocalDate.now(), temp); // 
	 		        				monthlbl.setText(temp.toString());
	 		        				int elapsedDays=period.getDays();
	 		        				int elapsedMonths=period.getMonths();

	 		        				if(elapsedMonths<=1 && elapsedDays>=0 && elapsedDays<=30)
	 		        				{
	 		        					monthsCbx.setDisable(false);
	 		        				}else {
	 		        					monthsCbx.setDisable(true);
	 		        				}

	 		        				for (int j = 0; j < gcmMainController.MapList.size(); j++)
	 		        				{
	 		        					if(gcmMainController.MapList.get(j).getCityName().equals(city)==true)
	 		        		    		{
	 		        		    			totalMapslbl++;
	 		        		    			totalPOIlbl += gcmMainController.MapList.get(j).getNumPOI();
	 		        		    			totalSubPricelbl += gcmMainController.MapList.get(j).getSubRate();
	 		        		    		}
	 								}
	 		        				totalNoOfMaps.setText(Integer.toString(totalMapslbl));
	 		        				totalNoOfPOI.setText(Integer.toString(totalPOIlbl));

	 		        		}
	 					}

	    }

	    /**
    	 * Check subscription renewal.
    	 */
    	public void checkSubscriptionRenewal()
	    {

	    }
  }

