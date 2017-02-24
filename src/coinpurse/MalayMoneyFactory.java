package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {

	@Override
	protected Valuable createMoney(double value) throws IllegalArgumentException {
		Valuable valuable;
		String currency =  "Ringgit";
		String currencyCoin = "Sen";
		if ( value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50 ) {
			valuable = new Coin(value , currencyCoin);
		}
		else if ( value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100 ) {
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
		Valuable m3 = factory.createMoney(0.05);
		System.out.println(m3.toString());
		Valuable m2 = factory.createMoney("1000.0");
		System.out.println(m2.toString());
	}

}
