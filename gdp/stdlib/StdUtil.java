package gdp.stdlib;

public class StdUtil {
	
	public static void randomSleep(int scale)  {
		try {
			Thread.sleep((int)(Math.random() * scale));
		}
		catch (Exception ex) {}	
	}
	
}
