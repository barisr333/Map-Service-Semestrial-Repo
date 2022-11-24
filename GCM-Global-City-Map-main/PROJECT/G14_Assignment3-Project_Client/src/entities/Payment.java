package entities;

// TODO: Auto-generated Javadoc
/**
 * The Class Payment.
 */
public class Payment 
{

	/** The card ID. */
	private String cardID;
	
	/** The card company name. */
	private String cardCompanyName;
	
	/** The expiry date. */
	private String expiryDate;
	
	/** The cvv. */
	private int CVV;
	
	/** The card user name. */
	private String cardUserName;
	
	/**
	 * Instantiates a new payment.
	 *
	 * @param cardID the card ID
	 * @param cardCompanyName the card company name
	 * @param expiryDate the expiry date
	 * @param cVV the c VV
	 * @param cardUserName the card user name
	 */
	public Payment(String cardID, String cardCompanyName, String expiryDate, int cVV, String cardUserName) {
		super();
		this.cardID = cardID;
		this.cardCompanyName = cardCompanyName;
		this.expiryDate = expiryDate;
		CVV = cVV;
		this.cardUserName = cardUserName;
	}

	/**
	 * Gets the card ID.
	 *
	 * @return the card ID
	 */
	public String getCardID() {
		return cardID;
	}

	/**
	 * Sets the card ID.
	 *
	 * @param cardID the new card ID
	 */
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	/**
	 * Gets the card company name.
	 *
	 * @return the card company name
	 */
	public String getCardCompanyName() {
		return cardCompanyName;
	}

	/**
	 * Sets the card company name.
	 *
	 * @param cardCompanyName the new card company name
	 */
	public void setCardCompanyName(String cardCompanyName) {
		this.cardCompanyName = cardCompanyName;
	}

	/**
	 * Gets the expiry date.
	 *
	 * @return the expiry date
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Sets the expiry date.
	 *
	 * @param expiryDate the new expiry date
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * Gets the cvv.
	 *
	 * @return the cvv
	 */
	public int getCVV() {
		return CVV;
	}

	/**
	 * Sets the cvv.
	 *
	 * @param cVV the new cvv
	 */
	public void setCVV(int cVV) {
		CVV = cVV;
	}

	/**
	 * Gets the card user name.
	 *
	 * @return the card user name
	 */
	public String getCardUserName() {
		return cardUserName;
	}

	/**
	 * Sets the card user name.
	 *
	 * @param cardUserName the new card user name
	 */
	public void setCardUserName(String cardUserName) {
		this.cardUserName = cardUserName;
	}
	
	

}
