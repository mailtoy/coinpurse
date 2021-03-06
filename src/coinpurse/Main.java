package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Kanchanok Kannee
 */
public class Main {

	private static int CAPACITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) 
	{
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory factory = null;
		try {
			factory = (MoneyFactory)Class.forName(factoryclass).newInstance();
		}
		catch (ClassCastException cce) {
			System.out.println(factoryclass + " is not type MoneyFactor");
		}
		catch (Exception ex) {
			System.out.println("Error creating MoneyFactory " + ex.getMessage());
		}
		if (factory == null ) 
			System.exit(1);
		else 
			MoneyFactory.setMoneyFactory(factory);
		
		Purse purse = new Purse(CAPACITY);
		ConsoleDialog ui = new ConsoleDialog(purse, "Thailand");
		ui.run();
		
	}
}