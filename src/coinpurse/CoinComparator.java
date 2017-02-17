package coinpurse;

import java.util.Comparator;

/**
 * The compare method order coins by currency.
 * 
 * @author Kanchanok Kannee
 */
public class CoinComparator implements Comparator<Valuable> {

	/**
	 * Comparator instance and use it to sort the coins.
	 * 
	 * @return order coins by currency.
	 */
	@Override
	public int compare(Valuable o1, Valuable o2) {
		return o1.getCurrency().compareToIgnoreCase(o2.getCurrency());
	}
}
