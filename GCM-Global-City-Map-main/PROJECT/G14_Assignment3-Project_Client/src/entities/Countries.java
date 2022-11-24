package entities;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Countries.
 */
public class Countries {
	
	/** The countryname. */
	private String countryname;
	
	/** The city list. */
	private List<City> cityList;
	
	
	
	/**
	 * Gets the countryname.
	 *
	 * @return the countryname
	 */
	public  String getCountryname() 
	{
		return countryname;
	}

	/**
	 * Sets the countryname.
	 *
	 * @param countryname the new countryname
	 */
	public  void setCountryname(String countryname) 
	{
		this.countryname = countryname;
	}

	/**
	 * Gets the city list.
	 *
	 * @return the city list
	 */
	public List<City> getCityList() {
		return cityList;
	}

	/**
	 * Sets the city list.
	 *
	 * @param cityList the new city list
	 */
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}	
}