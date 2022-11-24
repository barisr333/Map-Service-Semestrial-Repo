package entities;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Tour.
 */
public class Tour {

	/** The id. */
	private int ID;
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The rec time. */
	private String recTime;
	
	/** The cityname. */
	private String cityname;
	
	/** The num POI. */
	private int numPOI;
	
	/** The POI list. */
	private ArrayList<PointOfInterest> POIList;

	/**
	 * Instantiates a new tour.
	 *
	 * @param name the name
	 * @param desc the desc
	 * @param time the time
	 * @param cityname the cityname
	 */
	public Tour(String name, String desc, String time, String cityname)
	{
		this.name=name;
		this.description=desc;
		this.recTime=time;
		this.cityname=cityname;
		this.POIList=new ArrayList<PointOfInterest>();
		numPOI=0;
	}
	
	/**
	 * Gets the cityname.
	 *
	 * @return the cityname
	 */
	public String getCityname() {
		return cityname;
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
	 * Sets the cityname.
	 *
	 * @param cityname the new cityname
	 */
	public void setCityname(String cityname) {
		this.cityname = cityname;
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
	 * Gets the rec time.
	 *
	 * @return the rec time
	 */
	public String getRecTime() {
		return recTime;
	}
	
	/**
	 * Sets the rec time.
	 *
	 * @param recTime the new rec time
	 */
	public void setRecTime(String recTime) {
		this.recTime = recTime;
	}
	
	/**
	 * Gets the POI list.
	 *
	 * @return the POI list
	 */
	public ArrayList<PointOfInterest> getPOIList() {
		return POIList;
	}
	
	/**
	 * Sets the POI list.
	 *
	 * @param pOIList the new POI list
	 */
	public void setPOIList(ArrayList<PointOfInterest> pOIList) {
		POIList = pOIList;
	}
	
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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param iD the new id
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Inc num.
	 */
	public void incNum()
	{
		this.numPOI++;
	}



}
