package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory {

	@Override
	protected Valuable createMoney(double value) throws IllegalArgumentException {
		Valuable valuable;
		String currency =  "Baht";
		if ( value == 1 || value == 2 || value == 5 || value == 10 ) {
			valuable = new Coin(value , currency);
		}
		else if ( value == 20 || value == 50 || value == 100 || value == 500 || value == 1000 ) {
			valuable = new BankNote(value , currency);
		}
		else {
			throw new IllegalArgumentException();
		}
		return valuable;
	}
	public static void main (String [] arg) {
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney(5);
		System.out.println(m.toString());
		Valuable m2 = factory.createMoney("1000.0");
		System.out.println(m2.toString());
		Valuable m3 = factory.createMoney("500");
		System.out.println(m3.toString());
		Valuable m4 = factory.createMoney("20");
		System.out.println(m4.toString());
	}

}
