package nl.timnederhoff.testautomation.testutils;

public class Sleeper {
	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			System.out.println("Something went wrong while sleeping (InterruptedException)");
		}
	}
}
