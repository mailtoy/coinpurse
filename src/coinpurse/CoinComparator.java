package coinpurse;

import java.util.Comparator;

/**
 * The compare method order coins by currency.
 * 
 * @author Kanchanok Kannee
 */
public class CoinComparator implements Comparator<Coin> {

	/**
	 * Comparator instance and use it to sort the coins.
	 * 
	 * @return order coins by currency.
	 */
	@Override
	public int compare(Coin o1, Coin o2) {
		return o1.getCurrency().compareTo(o2.getCurrency());
	}
}
