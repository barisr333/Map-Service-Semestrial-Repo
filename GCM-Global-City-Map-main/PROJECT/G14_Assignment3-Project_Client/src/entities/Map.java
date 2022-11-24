package entities;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Map.
 */
public class Map {

	/** The id. */
	private int id;
	
	/** The rate. */
	private double rate;
	
	/** The sub rate. */
	private double subRate;
	
	/** The status. */
	private String status;
	
	/** The city name. */
	private String cityName;
	
	/** The description. */
	private String description;
	
	/** The image file. */
	private byte[] imageFile;
	
	/** The POI list. */
	private List<PointOfInterest> POIList;
	
	/** The tour list. */
	private List<Tour> tourList;
	
	/** The num POI. */
	private int numPOI;

	/**
	 * Instantiates a new map.
	 *
	 * @param id the id
	 * @param poiList the poi list
	 */
	public Map(int id, List<PointOfInterest> poiList)
	{
		super();
		this.id=id;
		POIList=new ArrayList<PointOfInterest>();
		this.POIList=poiList;

	}



	/**
	 * Instantiates a new map.
	 */
	public Map() {
		super();
		POIList=new ArrayList<PointOfInterest>();
	}



	/**
	 * Gets the num POI.
	 *
	 * @return the num POI
	 */
	public int getNumPOI() {
		return numPOI;
	}
	
	/**
	 * Sets the num POI.
	 *
	 * @param numPOI the new num POI
	 */
	public void setNumPOI(int numPOI) {
		this.numPOI = numPOI;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the rate.
	 *
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}
	
	/**
	 * Sets the rate.
	 *
	 * @param rate the new rate
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	/**
	 * Gets the sub rate.
	 *
	 * @return the sub rate
	 */
	public double getSubRate() {
		return subRate;
	}
	
	/**
	 * Sets the sub rate.
	 *
	 * @param subRate the new sub rate
	 */
	public void setSubRate(double subRate) {
		this.subRate = subRate;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Gets the city name.
	 *
	 * @return the city name
	 */
	public String getCityName() {
		return cityName;
	}
	
	/**
	 * Sets the city name.
	 *
	 * @param cityName the new city name
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the image file.
	 *
	 * @return the image file
	 */
	public byte[] getImageFile() {
		return imageFile;
	}
	
	/**
	 * Sets the image file.
	 *
	 * @param imageFile the new image file
	 */
	public void setImageFile(byte[] imageFile) {
		this.imageFile = imageFile;
	}
	
	/**
	 * Gets the POI list.
	 *
	 * @return the POI list
	 */
	public List<PointOfInterest> getPOIList() {
		return POIList;
	}
	
	/**
	 * Sets the POI list.
	 *
	 * @param pOIList the new POI list
	 */
	public void setPOIList(List<PointOfInterest> pOIList) {
		POIList = pOIList;
	}
	
	/**
	 * Gets the tour list.
	 *
	 * @return the tour list
	 */
	public List<Tour> getTourList() {
		return tourList;
	}
	
	/**
	 * Sets the tour list.
	 *
	 * @param tourList the new tour list
	 */
	public void setTourList(List<Tour> tourList) {
		this.tourList = tourList;
	}



}
