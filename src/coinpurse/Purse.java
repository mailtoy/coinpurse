package coinpurse;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Kanchanok Kannee
 */
public class Purse {

	private int countCoin;
	private double balance;
	/** Collection of objects in the purse. */
	private List<Coin> money = new ArrayList<Coin>();

	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;

	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return countCoin;
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
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
		if (countCoin < capacity) {
			return false;
		}
		return true;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		if (isFull() || coin.getValue() <= 0) {
			return false;
		}
		money.add(coin);
		countCoin++;
		balance += coin.getValue();
		Collections.sort(money);
		Collections.reverse(money);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Coin[] withdraw(double amount) {
		ArrayList<Coin> withdraw = new ArrayList<Coin>();
		if (amount < 0) {
			return null;
		}
		if (amount > 0) {
			for (int i = 0; i < money.size(); i++) {
				Coin coin = money.get(i);
				if (coin.getValue() <= amount) {
					amount = amount - coin.getValue();
					withdraw.add(coin);
				}
				if (amount == 0) {
					for (Coin bCoin : withdraw) {
						this.money.remove(bCoin);
						balance -= bCoin.getValue();
					}
					Coin[] remove = new Coin[withdraw.size()];
					withdraw.toArray(remove);
					return remove;
				}
			}
			return null;
		}
		return null;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return this.capacity + " coins with value " + this.balance;
	}

	public static void main(String[] arg) {
		Purse purse = new Purse(3);
		System.out.println(purse.getBalance());
		System.out.println(purse.count());
		System.out.println(purse.isFull());
		System.out.println(purse.insert(new Coin(5)));
		System.out.println(purse.insert(new Coin(10)));
		System.out.println(purse.insert(new Coin(0)));
		System.out.println(purse.insert(new Coin(1)));
		System.out.println(purse.insert(new Coin(5)));
		System.out.println(purse.count());
		System.out.println(purse.isFull());
		System.out.println(purse.getBalance());
		System.out.println(purse.toString());
		System.out.println(purse.withdraw(12));
		System.out.println(Arrays.toString(purse.withdraw(11)));
	}
}
