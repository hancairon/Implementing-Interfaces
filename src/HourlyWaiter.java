/**
 * HourlyWaiter class extends Waiter
 * @author Jungsoo (Cairon) Han
 * @see HourlyWaiter.java
 * @since JDK 11
 */
public class HourlyWaiter extends Waiter {
	private double wage; // wage per hour
	private double hours; // hours worked for week

	/**
	 * Constructor of HourlyWaiter Class
	 * 
	 * @param firstName            the super class parameter
	 * @param lastName             the super class parameter
	 * @param socialSecurityNumber the super class parameter
	 * @param wage                 the amount per hour of wage
	 * @param hours                the worked hours
	 */
	public HourlyWaiter(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);

		if (wage < 0.0) { // validate wage
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}

		if ((hours < 0.0) || (hours > 168.0)) { // validate hours
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}

		this.wage = wage;
		this.hours = hours;
	}

	/**
	 * set wage
	 * @param wat the wage per hour
	 */
	public void setWage(double wage) {
		if (wage < 0.0) { // validate wage
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}

		this.wage = wage;
	}

	/**
	 * @return wage
	 */
	public double getWage() {
		return wage;
	}

	/**
	 * set hours worked
	 * @param hours worked hours in this week
	 */
	public void setHours(double hours) {
		if ((hours < 0.0) || (hours > 168.0)) { // validate hours
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}

		this.hours = hours;
	}

	/**
	 * @return hours worked
	 */
	public double getHours() {
		return hours;
	}

	/**
	 * @return calculate earnings; override abstract method earnings in Waiter
	 */
	@Override
	public double earnings() {
		if (getHours() <= 40) { // no overtime
			return getWage() * getHours();
		} else {
			return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
		}
	}

	/**
	 * @return String representation of HourlyWaiter object
	 */
	@Override
	public String toString() {
		return String.format("hourly waiter: %s%n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", getWage(), "hours worked", getHours());
	}

	/**
	 * @return payment amount by multiplying wage with worked hours
	 */
	@Override
	public double getPaymentAmount() {
		return getWage() * getHours();
	}
}
