package coinpurse;
import java.util.ResourceBundle;
public abstract class MoneyFactory {
	private static MoneyFactory factory;
	
	
	public static MoneyFactory getInstance() {
		setMoneyFactory();
		return factory;
		
	}
	
	protected abstract Valuable createMoney ( double value ) throws IllegalArgumentException;
	
	protected Valuable createMoney ( String value ) {
		Double newvalue;
		try {
			newvalue = Double.parseDouble(value);
			
		}
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
		return createMoney(newvalue);
		
		
	}

	public static void setMoneyFactory() {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		try {
			factory = (MoneyFactory)Class.forName(factoryclass).newInstance();
		}
		catch (ClassCastException cce) {
			System.out.println(factoryclass + " is not type MoneyFactor");
		}
		catch (Exception ex) {
			System.out.println("Error creating MoneyFactory " + ex.getMessage());
		}
		if (factory == null ) System.exit(1);
	}
	


}
