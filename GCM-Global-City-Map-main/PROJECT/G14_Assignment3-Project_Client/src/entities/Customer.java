package entities;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Customer.
 */
public class Customer extends User 
{
	
	/** The pur history. */
	private List<Purchase> purHistory;


	/**
	 * Gets the pur history.
	 *
	 * @return the pur history
	 */
	public List<Purchase> getPurHistory() {
		return purHistory;
	}

	/**
	 * Sets the pur history.
	 *
	 * @param purHistory the new pur history
	 */
	public void setPurHistory(List<Purchase> purHistory) {
		this.purHistory = purHistory;
	
	}
}
