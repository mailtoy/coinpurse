package coinpurse;

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
	public static void main(String[] args) {
		Purse mai = new Purse(10);
		ConsoleDialog ui = new ConsoleDialog(mai);
		ui.run();
	}
}