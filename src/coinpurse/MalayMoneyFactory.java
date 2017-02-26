package coinpurse;

/**
 * MalayMoneyFactory is a class that creates money of Malaysia.
 * 
 * @author Kanchanok Kannee
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	
	private static final String CURRENCY =  "Ringgit";
	private static final String currencyCoin = "Sen";

	/**
	 * Create money of Malaysia.
	 * 
	 * @param value is a value that you want to create.
	 * @return the Valuable object.
	 * @throws IllegalArgumentException if value is not valid.
	 */
	@Override
	protected Valuable createMoney(double value) {
		
		Valuable valuable;
		if ( value < 1 ) {
			valuable = new Coin(value , currencyCoin);
		}
		else if ( value >= 1) {
			valuable = new BankNote(value, CURRENCY,  this.nextSerialNumber++);
		}
		else {
			throw new IllegalArgumentException();
		}
		return valuable;
	}
	
	public static void main (String [] arg) {
		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney(5);
		System.out.println(m.toString());
		Valuable m3 = factory.createMoney(0.05);
		System.out.println(m3.toString());
		Valuable m2 = factory.createMoney("1000.0");
		System.out.println(m2.toString());
	}

}
