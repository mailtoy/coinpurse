package coinpurse;

/**
 * Banknote represents coinage (money) with a fixed value and currency.
 * 
 * @author Kanchanok Kannee
 *
 */
public class BankNote extends AbstractValuable {
//	private static long nextSerialNumber = 1000000;
	private long serialNumber;

	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value is the value of banknote.
	 * @param currency is the currency of banknote.
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
	}

	/**
	 * A banknote with given value and currency.
	 * 
	 * @param value is the value of banknote.
	 * @param currency is the currency of banknote.
	 * @param serialNumber is the serial number of banknote
	 */
	public BankNote(double value, String currency, long serialNumber) {
		super(value, currency);
		this.serialNumber = serialNumber;
	}

	/**
	 * Return the serialnumber of the banknote.
	 * 
	 * @return the serialnumber.
	 */
	public long getSerialNumber() {
		return this.serialNumber;
	}

	/**
	 * set the number of serialnumber
	 * 
	 * @param hint is the text that you want to change
	 */
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * Return a string representation of this BankNote
	 * 
	 * @return string that describes the banknote
	 * 
	 */
	public String toString() {
		return String.format("%.0f %s note [%d]",this.value,this.currency,this.serialNumber);
	}
	
}
