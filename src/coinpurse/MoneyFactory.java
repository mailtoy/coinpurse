package coinpurse;

/**
 * MoneyFactory is a abstract class for creating Valuable items.
 * 
 * @author Kanchanok Kannee
 *
 */
public abstract class MoneyFactory {
	
	private static MoneyFactory theFactory;

	/**
	 * constructor is protected to prevent other classes from creating objects
	 * except subclass.
	 */
	protected MoneyFactory() {
	}

	/**
	 * Get an instance of MoneyFactory.
	 * 
	 * @return MoneyFactory instance.
	 */
	public static MoneyFactory getInstance() {
		 if(theFactory==null) 
			 theFactory = new MalayMoneyFactory();
			return theFactory;
	}

	/**
	 * Create a new money object in the local currency.
	 * 
	 * @param value is the value that you want to create.
	 * @return the Valuable of object.
	 * @throws IllegalArgumentException if value is not valid.
	 */
	protected abstract Valuable createMoney(double value) throws IllegalArgumentException;

	/**
	 * Accepts money value as a String and create a new money object in the
	 * local currency.
	 * 
	 * @param value is the value that you want to create.
	 * @return the Valuable of object.
	 * @throws IllegalArgument if value is not a valid number.
	 */
	protected Valuable createMoney(String value) {
		try {
			double doubleValue = Double.parseDouble(value);
			return this.createMoney(doubleValue);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Set the local factory.
	 * @param factory is the subclass of MoneyFactory.
	 */
	public static void setMoneyFactory(MoneyFactory factory) {
		theFactory = factory;

	}

}
