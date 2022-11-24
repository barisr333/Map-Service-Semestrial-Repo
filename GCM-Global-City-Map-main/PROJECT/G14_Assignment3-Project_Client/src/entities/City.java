package entities;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class City.
 */
public class City {
	
	/** The name. */
	private String name;
	
	/** The rec tours. */
	private List<Tour> recTours;
	
	/** The map list. */
	private List<Map> mapList;
	
	/** The POI list. */
	private List<PointOfInterest> POIList;
	
	/** The country. */
	private String country;
	
	/** The description. */
	private String description;
	
	/** The Num of maps. */
	private int NumOfMaps;
	
	/** The Num of POI. */
	private int NumOfPOI;
	
	/** The Num of tours. */
	private int NumOfTours;
	
	/** The version N umber. */
	private String versionNUmber;
	
	
	
	
	
	/**
	 * Gets the version N umber.
	 *
	 * @return the version N umber
	 */
	public String getVersionNUmber() {
		return versionNUmber;
	}
	
	/**
	 * Sets the version N umber.
	 *
	 * @param versionNUmber the new version N umber
	 */
	public void setVersionNUmber(String versionNUmber) {
		this.versionNUmber = versionNUmber;
	}
	
	/**
	 * Gets the num of maps.
	 *
	 * @return the num of maps
	 */
	public int getNumOfMaps() {
		return NumOfMaps;
	}
	
	/**
	 * Sets the num of maps.
	 *
	 * @param numOfMaps the new num of maps
	 */
	public void setNumOfMaps(int numOfMaps) {
		NumOfMaps = numOfMaps;
	}
	
	/**
	 * Gets the num of POI.
	 *
	 * @return the num of POI
	 */
	public int getNumOfPOI() {
		return NumOfPOI;
	}
	
	/**
	 * Sets the num of POI.
	 *
	 * @param numOfPOI the new num of POI
	 */
	public void setNumOfPOI(int numOfPOI) {
		NumOfPOI = numOfPOI;
	}
	
	/**
	 * Gets the num of tours.
	 *
	 * @return the num of tours
	 */
	public int getNumOfTours() {
		return NumOfTours;
	}
	
	/**
	 * Sets the num of tours.
	 *
	 * @param numOfTours the new num of tours
	 */
	public void setNumOfTours(int numOfTours) {
		NumOfTours = numOfTours;
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
	
	/** The coordinates. */
	private Location coordinates;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the rec tours.
	 *
	 * @return the rec tours
	 */
	public List<Tour> getRecTours() {
		return recTours;
	}
	
	/**
	 * Sets the rec tours.
	 *
	 * @param recTours the new rec tours
	 */
	public void setRecTours(List<Tour> recTours) {
		this.recTours = recTours;
	}
	
	/**
	 * Gets the map list.
	 *
	 * @return the map list
	 */
	public List<Map> getMapList() {
		return mapList;
	}
	
	/**
	 * Sets the map list.
	 *
	 * @param mapList the new map list
	 */
	public void setMapList(List<Map> mapList) {
		this.mapList = mapList;
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
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Gets the coordinates.
	 *
	 * @return the coordinates
	 */
	public Location getCoordinates() {
		return coordinates;
	}
	
	/**
	 * Sets the coordinates.
	 *
	 * @param coordinates the new coordinates
	 */
	public void setCoordinates(Location coordinates) {
		this.coordinates = coordinates;
	}
	
	
}
