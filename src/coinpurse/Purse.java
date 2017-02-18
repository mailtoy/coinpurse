package coinpurse;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Kanchanok Kannee
 */
public class Purse {

	/** Collection of objects in the purse. */
	private List<Valuable> money;

	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		this.money = new ArrayList<>();

	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance = 0;
		for (Valuable c : this.money) {
			balance += c.getValue();
		}
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		return money.size() >= capacity;
	}

	/**
	 * Insert a value into the purse. The value is only inserted if the purse
	 * has space for it and the value has positive value. No worthless values!
	 * 
	 * @param value is a Valuable to insert into purse
	 * @return true if value inserted, false if can't insert
	 */
	public boolean insert(Valuable value) {
		if (value.getValue() <= 0) {
			return false;
		}
		if (!isFull()) {
			this.money.add(value);
			Collections.sort(money, new Comparator<Valuable>() {
				@Override
				public int compare(Valuable o1, Valuable o2) {
					return Double.compare(o1.getValue(), o2.getValue());
				}
			});
			return true;
		}
		return false;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuable
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount is the amount to withdraw
	 * @return array of Valuable for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		List<Valuable> withdraw = new ArrayList<Valuable>();
		for (int i = money.size() - 1; i >= 0; i--) {
			Valuable value = this.money.get(i);
			if (value.getValue() <= amount) {
				amount = amount - value.getValue();
				withdraw.add(value);
			}
		}
		if (amount == 0) {
			for (Valuable bValue : withdraw) {
				this.money.remove(bValue);

			}
			Valuable[] remove = new Valuable[withdraw.size()];
			withdraw.toArray(remove);
			return remove;
		}
		return null;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return this.money.size() + " items with value " + this.getBalance();
	}

	public static void main(String[] arg) {
		Purse purse = new Purse(10);
		System.out.println(purse.getBalance());
		System.out.println(purse.count());
		System.out.println(purse.isFull());
		System.out.println(purse.insert(new Coin(20)));
		System.out.println(purse.insert(new Coin(12)));
		System.out.println(purse.insert(new Coin(25)));
		System.out.println(purse.insert(new BankNote(12)));
		System.out.println(purse.insert(new BankNote(14)));
		System.out.println(purse.insert(new BankNote(62)));
		System.out.println(purse.money);
		// System.out.println(purse.count());
		// System.out.println(purse.isFull());
		// System.out.println(purse.getBalance());
		// System.out.println(purse.toString());
		// System.out.println(purse.withdraw(12));
		// System.out.println(Arrays.toString(purse.withdraw(11)));
	}

}
