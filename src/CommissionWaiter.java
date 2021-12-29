/**
 * CommissionWaiter class extends CommissionWaiter.
 * 
 * @author Jungsoo (Cairon) Han
 * @see CommissionWaiter.java
 * @since JDK 11
 */
public class CommissionWaiter extends Waiter {
	private double grossSales; // gross weekly sales
	private double commissionRate; // commission percentage

	/**
	 * Constructor of CommissionWaiter Class
	 * @param firstName            the super class parameter
	 * @param lastName             the super class parameter
	 * @param socialSecurityNumber the super class parameter
	 * @param grossSales           the amount of gross sales
	 * @param commissionRate       the rate to calculate of commission based on
	 *                             grossSales
	 */
	public CommissionWaiter(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate) {
		super(firstName, lastName, socialSecurityNumber);

		if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}

		if (grossSales < 0.0) { // validate
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}

		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	/**
	 * set gross sales amount
	 * @param grossSales The sales amount that the sales Rep. sold
	 */
	public void setGrossSales(double grossSales) {
		if (grossSales < 0.0) { // validate
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}

		this.grossSales = grossSales;
	}

	/**
	 * @return gross sales amount
	 */
	public double getGrossSales() {
		return grossSales;
	}

	/**
	 * set commission rate
	 * @param commissionRate The rate must be between 0 and 1
	 */
	public void setCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}

		this.commissionRate = commissionRate;
	}

	/**
	 * @return commission rate
	 */
	public double getCommissionRate() {
		return commissionRate;
	}

	/**
	 * @return calculate earnings; override abstract method earnings in Waiter
	 */
	@Override
	public double earnings() {
		return getCommissionRate() * getGrossSales();
	}

	/**
	 * @return String representation of CommissionWaiter object
	 */
	@Override
	public String toString() {

		return String.format("commission waiter: %s \n%s: $%,.2f; %s: %.2f", super.toString(), "gross sales", getGrossSales(), "commission rate", getCommissionRate());
	}
	
	/**
	 * @return calculate payment amount; override abstract method getPaymentAmount
	 *         in Waiter
	 */
	@Override
	public double getPaymentAmount() {
		return getGrossSales() * getCommissionRate(); // calculate total cost
	}
	
}
