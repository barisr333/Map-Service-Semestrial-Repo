package entities;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class Purchase.
 */
public class Purchase 
{
	
	/** The idpurchase. */
	/*enum Type
	{
		Subscription, OneTime;
	}*/
	private int idpurchase;
	
	/** The type. */
	private String type;
	
	/** The price. */
	private double price;
	
	/** The date. */
	private String date;
	
	/** The purchased city. */
	private String purchasedCity;
	
	/** The sub and time. */
	private String subAndTime;
	
	/** The sub time. */
	private int subTime;
	
	/** The customer username. */
	private String customerUsername;
	
	/**
	 * Instantiates a new purchase.
	 *
	 * @param type the type
	 * @param city the city
	 * @param date the date
	 * @param price the price
	 * @param subTime the sub time
	 */
	public Purchase(String type, String city, String date, double price, String subTime)
	{
		super();
		this.purchasedCity=city;
		this.date=date;
		this.price=price;
		if(type.equals("Subscription"))
			this.type="Subscription - "+subTime+" months";
		else
			this.type=type;
	}
	
	/**
	 * Instantiates a new purchase.
	 */
	public Purchase()
	{

	}

	/**
	 * Gets the idpurchase.
	 *
	 * @return the idpurchase
	 */
	public int getIdpurchase() {
		return idpurchase;
	}
	
	/**
	 * Sets the idpurchase.
	 *
	 * @param idpurchase the new idpurchase
	 */
	public void setIdpurchase(int idpurchase) {
		this.idpurchase = idpurchase;
	}
	
	/**
	 * Gets the sub time.
	 *
	 * @return the sub time
	 */
	public int getSubTime() {
		return subTime;
	}

	/**
	 * Sets the sub time.
	 *
	 * @param subTime the new sub time
	 */
	public void setSubTime(int subTime) {
		this.subTime = subTime;
	}

	/**
	 * Gets the customer username.
	 *
	 * @return the customer username
	 */
	public String getCustomerUsername() {
		return customerUsername;
	}

	/**
	 * Sets the customer username.
	 *
	 * @param customerUsername the new customer username
	 */
	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
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
	 * Gets the purchased city.
	 *
	 * @return the purchased city
	 */
	public String getPurchasedCity() {
		return purchasedCity;
	}
	
	/**
	 * Sets the purchased city.
	 *
	 * @param purchasedCity the new purchased city
	 */
	public void setPurchasedCity(String purchasedCity) {
		this.purchasedCity = purchasedCity;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the sub and time.
	 *
	 * @return the sub and time
	 */
	public String getSubAndTime() {
		return subAndTime;
	}

	/**
	 * Sets the sub and time.
	 *
	 * @param subAndTime the new sub and time
	 */
	public void setSubAndTime(String subAndTime) {
		this.subAndTime = subAndTime;
	}
	
	
	
	
}
