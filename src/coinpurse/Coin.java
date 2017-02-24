package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Kanchanok Kannee
 */
public class Coin extends AbstractValuable {

	public static final String DEFAULT_CURRENCY = "Baht";
	private double newvalue;
	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value is the value of coin.
	 */
	public Coin(double value) {
		this(value, DEFAULT_CURRENCY);
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value is the value of coin.
	 * @param currency is the currency of coin.
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;

	}

	/**
	 * Return a string representation of this Coin
	 * 
	 * @return string that describes the coin
	 * 
	 */
	public String toString() {
		setNewvalue(value);
		return String.format("%.0f - %s coin",this.newvalue,this.currency);
	}


	public void setNewvalue(double newvalue) {
		if ( this.value < 1 ) {
		this.newvalue = value*100;
		} else this.newvalue = value;
			
		
	}
}
