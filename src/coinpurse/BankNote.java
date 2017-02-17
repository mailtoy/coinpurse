package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Kanchanok Kannee
 *
 */
public class BankNote implements Valuable {
	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency = "Baht";
	private long serialNumber;
	
	public BankNote(double value) {
		this.value = value;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;
	}
	
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public String getCurrency() {
		return this.currency;
	}
	
	public long getSerialNumber() {
		return this.serialNumber;
	}
	
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	/**
	 * Compare two coins by value and currency. They are equal if the value and
	 * currency matches.
	 * 
	 * @param arg is another Object to compare to this one.
	 * @return true if the value is same and the currency is same, false
	 *         otherwise.
	 */
	@Override
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		BankNote other = (BankNote) arg;
		return this.value == other.value && this.currency == other.currency;
	}
	
	public String toString() {
		return this.value + "-" + this.currency + " note [" + this.serialNumber + "]";
	}
	
}
