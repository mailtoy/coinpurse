package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Kanchanok Kannee
 */
public class Coin implements Valuable {

	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private double value;
	/** The currency, of course. */
	private String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;

	}

	/**
	 * Return the value of the coin.
	 * 
	 * @return the value.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Return the currency of the coin.
	 * 
	 * @return the currency.
	 */
	public String getCurrency() {
		return currency;
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
		Coin other = (Coin) arg;
		return this.value == other.value && this.currency == other.currency;
	}

	/**
	 * Return a string representation of this Coin
	 * 
	 * @return string that describes the coin
	 * 
	 */
	public String toString() {
		return this.value + "-" + this.currency;
	}
}
