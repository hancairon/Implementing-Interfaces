/**
 * SalariedWaiter class extends Waiter, which implements Payable.
 * 
 * @author Jungsoo (Cairon) Han
 * @see SalariedWaiter.java
 * @since JDK 11
 */
public class SalariedWaiter extends Waiter {
	private double weeklySalary;

	/**
	 * Constructor of SalariedWaiter Class
	 * 
	 * @param firstName            the super class parameter
	 * @param lastName             the super class parameter
	 * @param socialSecurityNumber the super class parameter
	 * @param salary               the amount of salary
	 */
	public SalariedWaiter(String first, String last, String ssn, double salary) {
		super(first, last, ssn); // pass to Waiter constructor
		setWeeklySalary(salary); // validate and store salary
	}

	/**
	 * set salary
	 * @param salary annual salary 
	 */
	public void setWeeklySalary(double salary) {
		weeklySalary = salary < 0.0 ? 0.0 : salary;
	}

	/**
	 * @return salary
	 */
	public double getWeeklySalary() {
		return weeklySalary;
	}

	/**
	 * @return calculate earnings; override abstract method earnings in Waiter.
	 */
	@Override
	public double earnings() {
		return getWeeklySalary();
	}

	/**
	 * @return String representation of SalariedWaiter object
	 */
	@Override
	public String toString() {
		return String.format("salaried waiter: %s\n%s: $%,.2f", super.toString(), "weekly salary", getWeeklySalary());
	}

	/**
	 * @return weekly salary
	 */
	@Override
	public double getPaymentAmount() {
		return getWeeklySalary();
	}
}
