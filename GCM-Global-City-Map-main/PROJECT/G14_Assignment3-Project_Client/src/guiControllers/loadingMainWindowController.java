package guiControllers;


import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class loadingMainWindowController.
 */
public class loadingMainWindowController {

		/** The i. */
		public int i;
		
		/** The progress bar. */
		@FXML
	    private ProgressBar progressBar;

	    /** The label. */
    	@FXML
	    private Label label;

	    /** The loading info. */
    	@FXML
	    private Label loadingInfo;
	    
	    /** The present infolbl. */
    	@FXML
	    private Label presentInfolbl;
	    
	    /** The anchor pane. */
    	@FXML
	    private AnchorPane anchorPane;
    
	    /** The r. */
    	Random r = new Random();
	    
    	/** The low. */
    	public int low = 2;
	    
    	/** The high. */
    	public int high = 99;
	    
    	/** The stop time. */
    	public static int stopTime[] = new int[5];

	    /**
    	 * The Class bg_Thread.
    	 */
    	class bg_Thread implements Runnable 
	    {
	    	
	    	
	    	/**
	    	 * Run.
	    	 */
	    	@Override
	    	public void run()
	    	{
	    		for (i = 0; i < 101; i++) {
	    			
	    			try {
	    				Platform.runLater(() -> {
	    					presentInfolbl.setText("loading.GCMSystem.sun.gui...");
	                    });
	    				
	    				progressBar.setProgress(i / 100.0);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Logger.getLogger(loadingMainWindowController.class.getName()).log(Level.SEVERE, null, e);
					}
	    			
	    			
	    			Platform.runLater(() -> {
                        loadingInfo.setText(Integer.toString(i)+ "%");
                    });

	    			
	    			  if(stopTime[0]==i)
	    			  { 
	    					try {
	    						Platform.runLater(() -> {
	    							presentInfolbl.setText("loading.GCMSystem.scenebuilder.gui...");
	    						});
	    					
	    						Thread.sleep(2500);
	    					} catch (InterruptedException e) {
	    						// TODO Auto-generated catch block
	    						e.printStackTrace();
	    					}

	    			  }
	    			  if(stopTime[1]==i)
	    			  {
	    				  
	    				  	try {
	    				  		Platform.runLater(() -> {
	    				  			presentInfolbl.setText("loading.GCMSystem.MySQLWorkbench.8.0.table...");
	    				  		 });

	    					
	    				  		Thread.sleep(2500);
	    				  		} catch (InterruptedException e) {
	    				  			// TODO Auto-generated catch block
	    				  			e.printStackTrace();
	    				  		}
	    				 
	    			  }
	    			  if(stopTime[2]==i){

	    				  		try {
	    				  			Platform.runLater(() -> {
	    					  		presentInfolbl.setText("loading.GCMSystem.MySQLWorkbench.8.0.view...");
	    				  			 });
	    					  
	    					  		Thread.sleep(2500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

	    			  }
	    			  if(stopTime[3]==i){

	    				  try {
	    					  Platform.runLater(() -> {
	    						  presentInfolbl.setText("loading.GCMSystem.structure.library.packages...");
	    					  });   
	    					 
								Thread.sleep(2500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

	    			  }
	    			  if(stopTime[4]==i){

	    				  try {
	    					  Platform.runLater(() -> {
	    						  presentInfolbl.setText("loading.GCMSystem.structure.library.clases...");   
	    					  }); 
	    					  
								Thread.sleep(2500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

	    			  }
	    			  
	    			  if(i==100)
	    			  { 
	    				  Platform.runLater(() -> {
	                          try {
	                        	  
	                        	  	Stage primaryStage1 = (Stage) anchorPane.getScene().getWindow();
	                        	  	primaryStage1.close();
	                        	  
	                        	  	Stage primaryStage = new Stage();
	                        	  
	                              	VBox root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/gcmFXML.fxml"));
	                  				Scene scene = new Scene(root,850,650);
	                  				scene.getStylesheets().add(getClass().getResource("/fxml/gcmCSS.css").toExternalForm());
	                  				primaryStage.setScene(scene);
	                  				primaryStage.setResizable(false);
	                  				primaryStage.setTitle("GCM System");
	                  				primaryStage.show();

	                          } catch (IOException ex) {
	                              Logger.getLogger(loadingMainWindowController.class.getName()).log(Level.SEVERE, null, ex);
	                          }
	                      });
	    			  }
	    			  
	    			}
				}
	    	
	    		
	    	}
	    
	    
	  
	    /**
    	 * Generate stop time.
    	 */
    	public void generateStopTime() 
	    {

	    	for (int j = 0; j < stopTime.length; j++) 
	    	{
	    		stopTime[j] = r.nextInt(high-low) + low;
			}
	    	
	    }
	    
	    
	    
	    /**
    	 * Initialize.
    	 *
    	 * @param url the url
    	 * @param rb the rb
    	 */
    	public void initialize(URL url,ResourceBundle rb) 
	    {
	    	progressBar.setProgress(0.0);
	    	loadingInfo.setText("");
	    }
	    
	    /**
    	 * Initialize.
    	 */
    	@FXML
	    void initialize() {
	    	generateStopTime();
	    	Thread th = new Thread(new bg_Thread());
	    	th.start();
	    }
	
}
