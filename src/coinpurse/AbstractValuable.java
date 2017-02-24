package coinpurse;

public abstract class AbstractValuable implements Valuable {

	/** Value of the coin. */
	protected double value;
	/** The currency, of course. */
	protected String currency;

	public AbstractValuable() {
		super();
	}
	
	public AbstractValuable ( double value, String currency ) {
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
		Valuable other = (Valuable) arg;
		return this.value == other.getValue() && this.currency == other.getCurrency();
	}

	@Override
	public int compareTo(Valuable other) {
		if ( this.getCurrency().equals(other.getCurrency())) {
		if ( other == null ) return -1;
		return (int) Math.signum( this.getValue() - other.getValue() );
		}
		return this.getCurrency().compareTo(other.getCurrency());
	}

}