

/**
 * BasePlusCommissionWaiter class extends CommissionWaiter.
 * @author Jungsoo (Cairon) Han
 * @see BasePlusCommissionWaiter.java
 * @since JDK 11
 */
public class BasePlusCommissionWaiter extends CommissionWaiter {
	private double baseSalary; // base salary per week

	/**
	 * Constructor of BasePlusCommissionWaiter Class 
	 * @param firstName            the super class parameter
	 * @param lastName             the super class parameter
	 * @param socialSecurityNumber the super class parameter
	 * @param grossSales           the super class parameter
	 * @param commissionRate       the super class parameter
	 * @param baseSalary           the base salary
	 */
	public BasePlusCommissionWaiter(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

		if (baseSalary < 0.0) { // validate baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	/**
	 * set base salary between 0.0 and 1.0
	 * @param baseSalary Base salary amount per week
	 */
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) { // validate baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	/**
	 * Get method to get base salary
	 * @return base salary
	 */
	public double getBaseSalary() {
		return baseSalary;
	}

	/**
	 * To calculate earning
	 * @return calculate earnings; override method earnings in CommissionWaiter
	 */
	@Override
	public double earnings() {
		return getBaseSalary() + super.earnings();
	}

	/**
	 * Presentation method to print base-salaried commission waiter
	 * @return String representation of BasePlusCommissionWaiter object
	 */
	@Override
	public String toString() {
		return String.format("base-salaried commission waiter: %s %s: $%,.2f", super.toString(), "base salary",	getBaseSalary());
	}

	/**
	 * Presentation method to print payment amount
	 * @return String representation of payment amount
	 */
	@Override
	public double getPaymentAmount() {
		return super.getPaymentAmount() + getBaseSalary();
	}

}
