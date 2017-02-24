package coinpurse;

import java.util.*;

/**
 * Some Coin and Valuable utility methods for practice using Lists and
 * Comparator.
 * 
 * @author Kanchanok Kannee
 */
public class CoinUtil {

	/**
	 * Method that examines all the value in a List and returns only the value
	 * that have a currency that matches the parameter value.
	 * 
	 * @param coinlist is a List of Coin objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist that have
	 *         the requested currency.
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> coinlist, String currency) {
		List<Valuable> list = new ArrayList<>();
		for (Valuable value : coinlist) {
			if (value.getCurrency().equals(currency)) {
				list.add(value);
			}
		}
		return list;
	}

	/**
	 * Method to sort a list of value by currency. On return, the list (coins)
	 * will be ordered by currency.
	 * 
	 * @param value is a List of valuable we want to sort.
	 * 
	 */
	public static void sortByCurrency(List<Valuable> value) {
		Collections.sort(value, new CompareByCurrency());
	}

	/**
	 * Sum value by currency and print the sum for each currency. Print one line
	 * for the sum of each currency. For example: coins = { Coin(1,"Baht"),
	 * Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") } then
	 * sumByCurrency(value) would print:
	 * 
	 * 11.00 Baht 20.50 Ringgit
	 * 
	 * Hint: this is easy if you sort the coins by currency first. :-)
	 */
	public static void sumByCurrency(List<Valuable> value) {
		Map<String, Double> map = new HashMap<>();
		for (Valuable c : value) {
			map.put(c.getCurrency(), map.getOrDefault(c.getCurrency(), 0.0) + c.getValue());
		}
		for (String currency : map.keySet()) {
			System.out.println(map.get(currency) + " " + currency);
		}
	}
	// Map<String,Double> map = new HashMap<String,Double>();
	// Iterator<Valuable> iterator = value.iterator();
	// while (iterator.hasNext()) {
	// Valuable valuable = iterator.next();
	// if (map.containsKey(valuable.getCurrency() ) ) {
	// map.put(valuable.getCurrency(), map.get(valuable.getCurrency()) +
	// valuable.getValue());
	// }
	// else map.put(valuable.getCurrency(), valuable.getValue());
	// }
	// for(String key : map.keySet()) {
	// // print the key (string) and value (integer)
	// System.out.println(key + " : " + map.get(key));
	// }

	// sortByCurrency(coins);
	// String currency = coins.get(0).getCurrency();
	// double sum = 0.0;
	// for (Valuable curr : coins) {
	// if (curr.getCurrency().equals(currency)) {
	// sum += curr.getValue();
	// } else {
	// System.out.printf("%.2f %s\n", sum, currency);
	// sum = 0;
	// sum = sum + curr.getValue();
	// currency = curr.getCurrency();
	// }
	// }
	// System.out.printf("%.2f %s\n", sum, currency);
	// }

	// Map<String, Double> map = new HashMap<>();
	// for (Coin c : coins) {
	// map.put(c.getCurrency(), map.getOrDefault(c.getCurrency(), 0.0) +
	// c.getValue());
	// }
	// for (String currency : map.keySet()) {
	// System.out.println(map.get(currency) + " " + currency);
	// }

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of " + currency);
		List<Valuable> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		List<Valuable> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (coins.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		sortByCurrency(coins);
		System.out.print("RESULT: ");
		printList(coins, " ");

		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= ");
		printList(coins, " ");
		sumByCurrency(coins);
	}

	/** Make a list of money containing different currencies. */
	public static List<Valuable> makeInternationalCoins() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of value using given values. */
	public static List<Valuable> makeCoins(String currency, double... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (double value : values)
			list.add(new Coin(value, currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext())
				System.out.print(separator);

		}
		System.out.println(); // end the line
	}
}
