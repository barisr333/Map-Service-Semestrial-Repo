package entities;

import java.time.LocalTime;

// TODO: Auto-generated Javadoc
/**
 * The Class PointOfInterest.
 */
public class PointOfInterest {

	/*enum Type
	{
		HistorcalSite, Museum, Hotel, Resturaunt, Park, PublicPlace, Store, MovieTheater;
	}*/

	/** The id. */
	private int id;
	
	/** The id POI. */
	private String idPOI;
	
	/** The name. */
	private String name;
	
	/** The type. */
	private String type;
	
	/** The description. */
	private String description;
	
	/** The accessible. */
	private String accessible;
	
	/** The time. */
	private String time;
	
	/** The address. */
	private String address;
	
	/** The idmap. */
	private String idmap;
	
	/** The location. */
	private Location location;
	
	/** The PO ilocation. */
	private Location POIlocation;

	/** The tour index. */
	private int tourIndex;



	/**
	 * Instantiates a new point of interest.
	 *
	 * @param id the id
	 * @param name the name
	 * @param type the type
	 * @param description the description
	 * @param accessible the accessible
	 * @param time the time
	 * @param address the address
	 * @param index the index
	 */
	public PointOfInterest(int id, String name, String type, String description, String accessible,
			String time, String address, int index) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.accessible = accessible;
		this.address = address;
		this.time = time;
		this.id=id;
		this.tourIndex=index;
	}

	/**
	 * Instantiates a new point of interest.
	 *
	 * @param name the name
	 * @param index the index
	 * @param id the id
	 */
	public PointOfInterest(String name, int index, int id)
	{
		super();
		this.id=id;
		this.name=name;
		this.tourIndex=index;
	}

	/**
	 * Instantiates a new point of interest.
	 *
	 * @param name the name
	 * @param type the type
	 * @param description the description
	 * @param accessible the accessible
	 * @param time the time
	 * @param address the address
	 */
	public PointOfInterest(String name, String type, String description,String accessible,String time,String address)
	{
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.accessible = accessible;
		this.time = time;
		this.address = address;

	}

	/**
	 * Instantiates a new point of interest.
	 */
	public PointOfInterest()
	{

	}

	/**
	 * Instantiates a new point of interest.
	 *
	 * @param id the id
	 * @param name the name
	 */
	public PointOfInterest(int id, String name)
	{
		super();
		this.id=id;
		this.name=name;
	}


	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}



	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the id POI.
	 *
	 * @return the id POI
	 */
	public String getIdPOI() {
		return idPOI;
	}

	/**
	 * Sets the id POI.
	 *
	 * @param idPOI the new id POI
	 */
	public void setIdPOI(String idPOI) {
		this.idPOI = idPOI;
	}

	/**
	 * Gets the accessible.
	 *
	 * @return the accessible
	 */
	public String getAccessible() {
		return accessible;
	}


	/**
	 * Sets the accessible.
	 *
	 * @param accessible the new accessible
	 */
	public void setAccessible(String accessible) {
		this.accessible = accessible;
	}

	/**
	 * Gets the idmap.
	 *
	 * @return the idmap
	 */
	public String getIdmap() {
		return idmap;
	}

	/**
	 * Sets the idmap.
	 *
	 * @param idmap the new idmap
	 */
	public void setIdmap(String idmap) {
		this.idmap = idmap;
	}

	/**
	 * Gets the PO ilocation.
	 *
	 * @return the PO ilocation
	 */
	public Location getPOIlocation() {
		return POIlocation;
	}

	/**
	 * Sets the PO ilocation.
	 *
	 * @param pOIlocation the new PO ilocation
	 */
	public void setPOIlocation(Location pOIlocation) {
		POIlocation = pOIlocation;
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
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(Location location) {
		this.location = location;
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
	 * Gets the time.
	 *
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * Sets the time.
	 *
	 * @param time the new time
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Prints the all.
	 */
	public void printAll()
	{
		System.out.println("POI INFO: "+ id+" "+name+" " +type+" "+ description + " "+ accessible+" "+ address+" "+time);
	}
	
	/**
	 * Gets the tour index.
	 *
	 * @return the tour index
	 */
	public int getTourIndex() {
		return tourIndex;
	}
	
	/**
	 * Sets the tour index.
	 *
	 * @param tourIndex the new tour index
	 */
	public void setTourIndex(int tourIndex) {
		this.tourIndex = tourIndex;
	}


}
