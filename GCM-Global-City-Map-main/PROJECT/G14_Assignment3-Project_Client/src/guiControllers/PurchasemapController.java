package guiControllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import java.util.Optional;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import entities.Location;
import entities.Map;
import entities.Payment;
import entities.PointOfInterest;
import entities.Purchase;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systemFunctionality.ClientMemberController;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.event.ActionEvent;


// TODO: Auto-generated Javadoc
/**
 * PurchasemapController - GUI controller for "Purchasemap.fxml"
 */
public class PurchasemapController extends Thread{
//-------------------------------------------------------------------------------------------//
// GUI components attribute------------------------------------------------------------------//
/** The back btn. */
//-------------------------------------------------------------------------------------------//
    @FXML
    private Button backBtn;

    /** The btn view catalg. */
    @FXML
    private Button btnView_Catalg;

    /** The btn edit prfile. */
    @FXML
    private Button btnEdit_Prfile;

    /** The sale img. */
    @FXML
    private ImageView saleImg;

    /** The Country cbx. */
    @FXML
    private ComboBox<String> CountryCbx;

    /** The City cbx. */
    @FXML
    private ComboBox<String> CityCbx;

    /** The purchase map table. */
    @FXML
    private TableView<Map> purchaseMapTable;

    /** The map name col. */
    @FXML
    private TableColumn<Map, String> mapNameCol;

    /** The rate col. */
    @FXML
    private TableColumn<Map, Double> rateCol;

    /** The sub rate col. */
    @FXML
    private TableColumn<Map, Double> subRateCol;

    /** The No of POI col. */
    @FXML
    private TableColumn<Map , Integer> NoOfPOICol;

    /** The total no of maps. */
    @FXML
    private Label totalNoOfMaps;

    /** The total no of POI. */
    @FXML
    private Label totalNoOfPOI;

    /** The total price. */
    @FXML
    private Label totalPrice;

    /** The one time purch. */
    @FXML
    private RadioButton oneTimePurch;

    /** The Sub purch. */
    @FXML
    private RadioButton SubPurch;

    /** The buy nowbtn. */
    @FXML
    private Button buyNowbtn;

    /** The download btn. */
    @FXML
    private Button downloadBtn;

    /** The months cbx. */
    @FXML
    private ComboBox<String> monthsCbx;

    /** The monthlbl. */
    @FXML
    private Label monthlbl;

//-------------------------------------------------------------------------------------------//
// Internal Class attributes-----------------------------------------------------------------//
/** The client member controller. */
//-------------------------------------------------------------------------------------------//
    private ClientMemberController clientMemberController;
    
    /** The purchasemap controller. */
    public static PurchasemapController purchasemapController;
    
    /** The POI list. */
    public ArrayList<PointOfInterest> POIList = new ArrayList<PointOfInterest>();
    
    /** The purchase list. */
    public ArrayList<Purchase> purchaseList = new ArrayList<Purchase>();
    
    /** The lock. */
    private Object lock = new Object();
	
	/** The my runnable. */
	MyRunnable myRunnable = new MyRunnable();
	
	/** The pop thread. */
	Thread popThread = new Thread(myRunnable);
	
	/** The country list. */
	ObservableList<String> countryList;
	
	/** The city list. */
	ObservableList<String> cityList;
	
	/** The total one pricelbl. */
	double totalOnePricelbl = 0 ;
	
	/** The total sub pricelbl. */
	double totalSubPricelbl = 0 ;
	
	/** The Monthly payment. */
	double MonthlyPayment = 0;
	
	/** The flag. */
	int flag;
	
	/** The total PO ilbl. */
	int totalPOIlbl = 0 ;
	
	/** The total mapslbl. */
	int totalMapslbl = 0;
	
	/** The city name. */
	String cityName;
	
	/** The on this pag. */
	public boolean onThisPag = false;
	
	/** The user have this city map. */
	public boolean userHaveThisCityMap = false;
	
	/** The df 2. */
	private DecimalFormat df2 = new DecimalFormat("##.##");
	
	/** The months numbers. */
	ObservableList<String> monthsNumbers ;

//-------------------------------------------------------------------------------------------//
// Getters and setters methods---------------------------------------------------------------//
//-------------------------------------------------------------------------------------------//

    /**
 * Instantiates a new purchasemap controller.
 */
public PurchasemapController() {
    	purchasemapController = this;
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
	 * Gets the purchasemap controller.
	 *
	 * @return the purchasemap controller
	 */
	public static PurchasemapController GetPurchasemapController() {
		if(purchasemapController == null)
			purchasemapController = new PurchasemapController();
		return purchasemapController;
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
		    //downloadBtn.setVisible(false);
			clientMemberController = ClientMemberController.GetClientMemberController();
			clientMemberController.setClientPurchasemapController(this);
			onThisPag = true;
			clientMemberController.sendToServerGetAllPurchase();
			clientMemberController.sendToServerGetAllPOI();
			loadCountryCmx();
			popThread.start();

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

			mapNameCol.setCellValueFactory(new PropertyValueFactory<Map, String>("description"));
			rateCol.setCellValueFactory(new PropertyValueFactory<Map, Double>("rate"));
			subRateCol.setCellValueFactory(new PropertyValueFactory<Map, Double>("subRate"));
			NoOfPOICol.setCellValueFactory(new PropertyValueFactory<Map, Integer>("numPOI"));
			purchaseMapTable.setStyle("-fx-focus-color: transparent;");



			CountryCbx.valueProperty().addListener((obs, oldItem, newItem) -> {   //By clicking on a value within the combobox, the state will be drawn//


		            if (newItem != null) {
		            	 monthsCbx.setValue(null);
		    	    	 monthsCbx.setDisable(true);
		            	 purchaseMapTable.getItems().clear();
		     	    	 oneTimePurch.setSelected(false);
		    	    	 SubPurch.setSelected(false);
		    	    	 totalPrice.setText("-");
		                 loadCityCbx(CountryCbx.getValue().toString());


		            } else {

		            }
		        });

			CityCbx.valueProperty().addListener((obs, oldItem, newItem) -> {   //By clicking on a value within the combobox, the state will be drawn//


	            if (newItem != null) {
	            	 monthsCbx.setValue(null);
	    	    	 monthsCbx.setDisable(true);
	            	 purchaseMapTable.getItems().clear();
	     	    	 oneTimePurch.setSelected(false);
	    	    	 SubPurch.setSelected(false);
	    	    	 totalPrice.setText("-");
	    	    	 cityName = CityCbx.getValue().toString();
	                 loadMapsByCity(CityCbx.getValue().toString());
	                 } else {

	            }
	        });

			monthsCbx.valueProperty().addListener((obs, oldItem, newItem) -> {   //By clicking on a value within the combobox, the state will be drawn//


	            if (newItem != null) {
	            	MonthlyPayment = totalSubPricelbl;
	            	MonthlyPayment = MonthlyPayment * Double.parseDouble(monthsCbx.getValue());
	            	totalPrice.setText(df2.format(MonthlyPayment)+" $");
	            } else {

	            }
	        });

		 }




	//-------------------------------------------------------------------------------------------//
// Cases of events from GUI------------------------------------------------------------------//
//-------------------------------------------------------------------------------------------//


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
		popThread.stop();
		VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/MemberMain.fxml"));
		Scene scene = new Scene(root,850,650);
		scene.getStylesheets().add(getClass().getResource("/fxml/MemberMain.css").toExternalForm());
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Member Main Window");
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
    	 * On time radio.
    	 *
    	 * @param event the event
    	 */
    	@FXML
	    void onTimeRadio(MouseEvent event)
	    {
	    	monthsCbx.setValue(null);
	    	monthsCbx.setDisable(true);
	    	oneTimePurch.setSelected(true);
	    	SubPurch.setSelected(false);
	    	totalPrice.setText(df2.format(totalOnePricelbl)+" $");
	    	//totalPrice.setText(Double.toString(totalOnePricelbl)+" $");
	    }

	    /**
    	 * Subscription radio.
    	 *
    	 * @param event the event
    	 */
    	@FXML
	    void subscriptionRadio(MouseEvent event)
	    {
	    	totalPrice.setText("-");
	    	//totalSubPricelbl = totalSubPricelbl* Double.parseDouble(monthsCbx.getValue());
	    	monthsCbx.setDisable(false);
	    	SubPurch.setSelected(true);
	    	oneTimePurch.setSelected(false);
	    	//totalPrice.setText(df2.format(totalSubPricelbl)+" $");
	    	//totalPrice.setText(Double.toString(totalSubPricelbl)+" $");
	    }

	    /**
    	 * buyNowbtn(MouseEvent event) - started when the user click on the Buy button.
    	 *
    	 * @param event - That event actually started when the user click on Buy button.
    	 * @throws IOException Signals that an I/O exception has occurred.
    	 */
	    @FXML
	    void buyNowbtn(MouseEvent event) throws IOException
	    {
	    	int cnt = 1;
	    	flag=0;

	    	if(oneTimePurch.isSelected()==true || SubPurch.isSelected()==true)// check if radiobtn is pressed.
	    	{

	    		if (oneTimePurch.isSelected()==true)// check if it one time purchase.
	    		{
	    			if (!Bindings.isEmpty(purchaseMapTable.getItems()).get())//check if the table does not empty. need only for the query.
	    			{
	    				Alert alert = new Alert(AlertType.CONFIRMATION);
	    			    alert.setTitle("Delete File");
	    			    alert.setHeaderText("Are you sure want to buy and download this maps collection?");
	    			    alert.setContentText(null);

	    			    Optional<ButtonType> option = alert.showAndWait();

	    			      if (option.get() == ButtonType.OK) // Check promt message
	    			      {
	  	    				ArrayList<String> purchInfo = new ArrayList<String>();
		    				purchInfo.add("One time purchase");
		    				purchInfo.add(Double.toString(totalOnePricelbl));
		    				purchInfo.add(cityName);
		    				purchInfo.add(Integer.toString(0));
		    				purchInfo.add(gcmMainController.user.getUserName());
		    				clientMemberController.sendToServerInsertCustomerPurchase(purchInfo);
		    				clientMemberController.sendToServerInsertCustomerDownload(purchInfo);

		    				totalNoOfMaps.setText("0");
		    		    	totalNoOfPOI.setText("0");
		    		    	totalPrice.setText("-");
		    		    	monthsCbx.setValue(null);
		    	  	    	monthsCbx.setDisable(true);
		    	          	purchaseMapTable.getItems().clear();
		    	   	    	oneTimePurch.setSelected(false);
		    	  	    	SubPurch.setSelected(false);
		    	  	    	CountryCbx.setValue(null);
		    	  	    	CityCbx.setValue(null);

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
					    			System.out.println(gcmMainController.MapList.get(i).getCityName());
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
	    			      } else if (option.get() == ButtonType.CANCEL)
	    			      {
	    			        // this.label.setText("Cancelled!");
	    			      } else
	    			      {
	    			       //  this.label.setText("-");
	    			      }

	    			}
	    			 else {
	    				 System.out.println("No Map");
	    			}
	    		}
	    		else
	    		{
	    			Alert alert = new Alert(AlertType.CONFIRMATION);
    			    alert.setTitle("Maps");
    			    alert.setHeaderText("Are you sure you want to subscribe to this maps collection??");
    			    alert.setContentText(null);

    			    Optional<ButtonType> option = alert.showAndWait();

    			     if (option.get() == ButtonType.OK)
    			      {
    			    	  if(purchaseList.size() == 0)
    			    	  {
    			    		    ArrayList<String> purchInfo = new ArrayList<String>();
			    				purchInfo.add("Subscription");
			    				purchInfo.add(Double.toString(MonthlyPayment));
			    				purchInfo.add(cityName);
			    				purchInfo.add(monthsCbx.getValue());
			    				purchInfo.add(gcmMainController.user.getUserName());
			    				clientMemberController.sendToServerInsertCustomerPurchase(purchInfo);

				   	 			downloadBtn.setDisable(false);
				   	 			totalNoOfMaps.setText("0");
					    	    totalNoOfPOI.setText("0");
					    	    totalPrice.setText("-");
					    	    monthsCbx.setValue(null);
				  	    	    monthsCbx.setDisable(true);
				          	    purchaseMapTable.getItems().clear();
				   	    	    oneTimePurch.setSelected(false);
				  	    	    SubPurch.setSelected(false);
			    	  	    	CountryCbx.setValue(null);
			    	  	    	CityCbx.setValue(null);
    			    	  }
    			    	  else {

    			  			Platform.runLater(new Runnable()
    				    	 {
    				 			@Override
    				 			public void run()
    				 			{
    				 				try
    				 				{
    				 					clientMemberController.sendToServerGetAllPurchase();
    				 				}
    				 			catch(Exception e)
    				 				{
    				 					e.printStackTrace();
    				 				}
    				 			}
    				 		});

    	    			    	// Check if the customer have the city that want to buy
      		    			// and if he have , we tell him that he already purchase.
    			    	  		for (int i = 0; i < purchaseList.size(); i++)
    			      		    	{
    			      		    		userHaveThisCityMap=false;
    			      					if(purchaseList.get(i).getPurchasedCity().equals(cityName)==true)
    			      						{
    			      							if(purchaseList.get(i).getType().equals("Subscription")==true && purchaseList.get(i).getCustomerUsername().equals(gcmMainController.user.getUserName()))
    			      								{
    			      									userHaveThisCityMap = true;
    			      									i = 1000;
    			      								}
    			      						}
    			      				}





      		    			if(userHaveThisCityMap == true)
  							{
      		    				System.out.println();
      		    				Alert alert1 = new Alert(AlertType.INFORMATION);
      							alert1.setTitle("Map collection");
      							alert1.setHeaderText(null);
      							alert1.setHeaderText("The map collection you are trying to purchase has already been purchased");
      							alert1.showAndWait();

      							totalNoOfMaps.setText("0");
      		    		 	    totalNoOfPOI.setText("0");
      		    		 	    totalPrice.setText("-");
      		    		 	    monthsCbx.setValue(null);
      		    		 	    monthsCbx.setDisable(true);
      		    		 	    purchaseMapTable.getItems().clear();
      		    		 	    oneTimePurch.setSelected(false);
      		    		 	    SubPurch.setSelected(false);
    		    	  	    	CountryCbx.setValue(null);
    		    	  	    	CityCbx.setValue(null);

      		    			}else if(userHaveThisCityMap == false)
      		    			{
      		    				 ArrayList<String> purchInfo = new ArrayList<String>();
      		    				purchInfo.add("Subscription");
      		    				purchInfo.add(Double.toString(MonthlyPayment));
      		    				purchInfo.add(cityName);
      		    				purchInfo.add(monthsCbx.getValue());
      		    				purchInfo.add(gcmMainController.user.getUserName());

      		    				clientMemberController.sendToServerInsertCustomerPurchase(purchInfo);
      		    		 		downloadBtn.setDisable(false);
      		    		 	    totalNoOfMaps.setText("0");
      		    		 	    totalNoOfPOI.setText("0");
      		    		 	    totalPrice.setText("-");
      		    		 	    monthsCbx.setValue(null);
      		    		 	    monthsCbx.setDisable(true);
      		    		 	    purchaseMapTable.getItems().clear();
      		    		 	    oneTimePurch.setSelected(false);
      		    		 	    SubPurch.setSelected(false);
    		    	  	    	CountryCbx.setValue(null);
    		    	  	    	CityCbx.setValue(null);
      		    			}
    			    	  }
    			      }else if (option.get() == ButtonType.CANCEL)
    			      {
	    			        // this.label.setText("Cancelled!");
	    			  }

	    		}
	    	}
	    }

//-------------------------------------------------------------------------------------------//
// Internal functions------------------------------------------------------------------------//
//-------------------------------------------------------------------------------------------//

	    /**
	     * MyRunnable implements Runnable and start the sale pop up.
	     *
	     */
	    public class MyRunnable implements Runnable
	    {
	    	
	    	/** The exit. */
	    	boolean exit = false;

	    	/**
	    	 * Run.
	    	 */
	    	public void run()
	        {
		    	boolean saleImageVisible = false;
		    	while (!exit)
		    	{
		    		try {
						Thread.sleep(800);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		if(saleImageVisible== true)
		    		{
		    			saleImg.setVisible(true);
		    			saleImageVisible = false;
		    		}
		    		else
		    		{
		    			saleImg.setVisible(false);
		    			saleImageVisible = true;
		    		}
		    	}
	        }

	        /**
        	 * Stop.
        	 *
        	 * @throws InterruptedException the interrupted exception
        	 */
        	public void stop() throws InterruptedException
	        {
	            exit = true;
	        }
	    }


	    /**
    	 * Load country combo box.
    	 */
    	public void loadCountryCmx()
	    {
	    	ArrayList <String> country = new ArrayList<String>();
	    	for (int i = 0; i < gcmMainController.CountryList.size(); i++)
	    	{
	    		country.add(gcmMainController.CountryList.get(i).getCountryname());
			}
	    	 countryList = FXCollections.observableArrayList(country);
	 		 CountryCbx.setItems(countryList);
	    }

	    /**
    	 * Load city combo bbx.
    	 *
    	 * @param countryName the country name
    	 */
    	public void loadCityCbx(String countryName)
	    {
	    	ArrayList <String> city = new ArrayList<String>();
	    	for (int i = 0; i < gcmMainController.CityList.size(); i++)
	    	{
				if(gcmMainController.CityList.get(i).getCountry().equals(countryName))
				{
					city.add(gcmMainController.CityList.get(i).getName());
				}
			}
	    	cityList = FXCollections.observableArrayList(city);
	    	CityCbx.setItems(cityList);

	    }

	    /**
	     * loadMapsByCity (String city) - return all the maps that belongs to this city and shows only the maps
	     * with the status "Published".
	     * @param city - This param is from the  city combo box that return all the maps that belongs to this city and shows only the maps
	     * with the status "Published".
	     */
	    public void loadMapsByCity (String city)
	    {
	    	totalOnePricelbl = 0 ;
	    	totalSubPricelbl = 0 ;
	    	totalPOIlbl = 0 ;
	    	totalMapslbl = 0;

	    	for (int i = 0; i < gcmMainController.MapList.size(); i++)
	    	{
	    		if(gcmMainController.MapList.get(i).getCityName().equals(city)==true && gcmMainController.MapList.get(i).getStatus().equals("Published"))
	    		{
	    			purchaseMapTable.getItems().add(gcmMainController.MapList.get(i));
	    			totalMapslbl++;
	    			totalPOIlbl += gcmMainController.MapList.get(i).getNumPOI();
	    			totalOnePricelbl += gcmMainController.MapList.get(i).getRate();
	    			totalSubPricelbl += gcmMainController.MapList.get(i).getSubRate();
	    		}
			}

	    	totalNoOfMaps.setText(Integer.toString(totalMapslbl));
	    	totalNoOfPOI.setText(Integer.toString(totalPOIlbl));
	    }


	    /////////////////////////////////////////////////////////////
		  ////////////////////////////////////////////////////////////
		  //////////////////////////////////////////////////////////

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


}
