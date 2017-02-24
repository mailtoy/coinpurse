package coinpurse;

import java.util.Comparator;

/**
 * An interface for object having a monetary value and currency.
 * @author Kanchanok Kannee
 *
 */
public interface Valuable extends Comparable<Valuable> {
	
	/**
	 * Get the monetary value of this object, in its own currency.
	 * @return the value of this object
	 */
	public double getValue();
	
	/**
	 * Get the currency of this object.
	 * @return the currency of this object
	 */
	public String getCurrency();

}
