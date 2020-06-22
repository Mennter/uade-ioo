package helpers;

import java.util.Date;

public class IdGenerator {
	
	public static Long get() {
		Date date = new Date();
		return date.getTime();
	}

}
