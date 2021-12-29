/**
 * This code tests the interface Payable.
 * 
 * @author Jungsoo (Cairon) Han
 * @see PayableInterfaceTest.java
 * @since JDK 11
 */
public class PayableInterfaceTest {
	public static void main(String[] args) {

		// SIX-ELEMENTS Payable array
		Payable[] payableObjects = new Payable[6];

		payableObjects[0] = new Invoice("45343", "break", 3, 350);
		payableObjects[1] = new Invoice("85634", "pedal", 5, 60.99);
		payableObjects[2] = new SalariedWaiter("Ada", "Chukwu", "345-67-8901", 610);
		payableObjects[3] = new HourlyWaiter("Blessing", "Oluwa", "234-56-7890", 18.95, 40);
		payableObjects[4] = new CommissionWaiter("Peter", "John", "123-45-6789", 27500, 0.44);
		payableObjects[5] = new BasePlusCommissionWaiter("Itunu", "Ebere", "102-34-5678", 2500, 0.04, 720);

		// POPULATE THE ARRAY WITH OBJECTS THAT IMPLEMENT Payable.

		System.out.println("Invoices and Waiters are processed polymorphically:\n");

		// generically process each element in array payableObjects
		for (Payable currentPayable : payableObjects) {
			// output currentPayable and its appropriate payment amount
			System.out.printf("%s \n", currentPayable.toString());

			if (currentPayable instanceof BasePlusCommissionWaiter) {
				// downcast Payable reference to
				// BasePlusCommissionWaiter reference
				BasePlusCommissionWaiter waiter = (BasePlusCommissionWaiter) currentPayable;

				double oldBaseSalary = waiter.getBaseSalary();
				waiter.setBaseSalary(1.10 * oldBaseSalary);
				System.out.printf("new base salary with 10%% increase is: $%,.2f\n", waiter.getBaseSalary());
			}

			System.out.printf("%s: $%,.2f\n", "payment due", currentPayable.getPaymentAmount());
			System.out.println("");
		}
	}
}
