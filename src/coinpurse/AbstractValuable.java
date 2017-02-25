package coinpurse;

/**
 * Abstract class for Valuable interface to avoid duplicate code.
 * @author Kanchanok Kannee
 *
 */
public abstract class AbstractValuable implements Valuable {

	/** Value of the coin. */
	protected double value;
	/** The currency, of course. */
	protected String currency;
	
	public AbstractValuable() {
		super();
	}

	/**
	 * Initialize a AbstractValuable with given value and currency.
	 * @param value is the value of money.
	 * @param currency is the currency of money.
	 */
	public AbstractValuable ( double value, String currency ) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Return the value of the money.
	 * 
	 * @return the value.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Return the currency of the money.
	 * 
	 * @return the currency.
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Compare two money by value and currency. They are equal if the value and
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
		Valuable other = (Valuable) arg;
		return this.value == other.getValue() && this.currency == other.getCurrency();
	}

	/**
	 * If the currency is the same, order values by values 
	 * If the currency is not the same, sort the currency.
	 * @return < 0 when this value is less than other value,
	 *         = 0 when this value equals other value and
	 *         > 0 when this value is more than other value.
	 */
	@Override
	public int compareTo(Valuable other) {
	if ( other == null ) {
		return -1;
	} else if ( this.getCurrency().equals( other.getCurrency()) ) {
		return (int) Math.signum( this.getValue() - other.getValue() );
	} else return this.getCurrency().compareTo( other.getCurrency() );
	}

}