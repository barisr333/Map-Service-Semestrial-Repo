package entities;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public abstract class User 
{
	
	/** The first name. */
	private  String firstName;
	
	/** The last name. */
	private  String lastName;
	
	/** The email. */
	private  String email;
	
	/** The user name. */
	private  String userName;
	
	/** The password. */
	private  String password;
	
	/** The Address. */
	private  String Address;
	
	/** The permission. */
	private  int permission;
	
	/** The phone number. */
	private String phoneNumber;
	
	/** The payment details. */
	private  Payment paymentDetails;
	
	
	
	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}
	
	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		Address = address;
	}
	
	/**
	 * Gets the permission.
	 *
	 * @return the permission
	 */
	public int getPermission() {
		return permission;
	}
	
	/**
	 * Sets the permission.
	 *
	 * @param permission the new permission
	 */
	public void setPermission(int permission) {
		this.permission = permission;
	}
	
	/**
	 * Gets the payment details.
	 *
	 * @return the payment details
	 */
	public Payment getPaymentDetails() {
		return paymentDetails;
	}
	
	/**
	 * Sets the payment details.
	 *
	 * @param paymentDetails the new payment details
	 */
	public void setPaymentDetails(Payment paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	}
