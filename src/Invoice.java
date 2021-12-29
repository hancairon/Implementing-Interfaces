/**
 * Invoice class implements Payable.
 * 
 * @author Jungsoo (Cairon) Han
 * @see Invoice.java
 * @since JDK 11
 */
public class Invoice implements Payable {
	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;

	/**
	 * Constructor of Invoice Class
	 * 
	 * @param part        the name of part
	 * @param description the description of the part
	 * @param count       the number of the existing part
	 * @param price       the part price
	 */
	public Invoice(String part, String description, int count, double price) {
		partNumber = part;
		partDescription = description;
		setQuantity(count); // validate and store quantity
		setPricePerItem(price); // validate and store price per item
	}

	/**
	 * @return part number
	 */
	public String getPartNumber() {
		return partNumber;
	}

	/**
	 * @return description
	 */
	public String getPartDescription() {
		return partDescription;
	}

	/**
	 * @retrun quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return price per item
	 */
	public double getPricePerItem() {
		return pricePerItem;
	}

	/**
	 * set part number
	 */
	public void setPartNumber(String part) {
		partNumber = part; // should validate
	}

	/**
	 * set description
	 */
	public void setPartDescription(String description) {
		partDescription = description; // should validate
	}

	/**
	 * set quantity
	 */
	public void setQuantity(int count) {
		quantity = (count < 0) ? 0 : count; // quantity cannot be negative
	}

	/**
	 * set price per item
	 */
	public void setPricePerItem(double price) {
		pricePerItem = (price < 0.0) ? 0.0 : price; // validate price
	}

	/**
	 * @return String representation of Invoice object
	 */
	@Override
	public String toString() {
		return String.format("%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f", "invoice", "part number", getPartNumber(), getPartDescription(), "quantity", getQuantity(), "price per item", getPricePerItem());
	}

	/**
	 * method required to carry out contract with interface Payable
	 * 
	 * @return total cost
	 */
	@Override
	public double getPaymentAmount() {
		return getQuantity() * getPricePerItem(); // calculate total cost
	}
}
