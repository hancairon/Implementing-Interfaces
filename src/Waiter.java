/**
 * Waiter abstract superclass implements Payable.
 * 
 * @author Jungsoo (Cairon) Han
 * @see Waiter.java
 * @since JDK 11
 */

public abstract class Waiter implements Payable {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;

	/**
	 * Constructor of Waiter Class
	 * 
	 * @param firstName            the first name of waiter
	 * @param lastName             the last name of waiter
	 * @param socialSecurityNumber the social security number of waiter
	 * @param salary               the amount of salary
	 */
	public Waiter(String first, String last, String ssn) {
		firstName = first;
		lastName = last;
		socialSecurityNumber = ssn;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the socialSecurityNumber
	 */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param socialSecurityNumber the socialSecurityNumber to set
	 */
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	/**
	 * @return zero
	 */
	public double earnings() {
		return 0;
	}


	/**
	 *@return String representation of Waiter object
	 */
	@Override
	public String toString() {
		return String.format("%s %s\nsocial security number: %s", getFirstName(), getLastName(), getSocialSecurityNumber());
	}


}
