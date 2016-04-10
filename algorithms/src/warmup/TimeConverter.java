package warmup;

import java.util.Scanner;

public class TimeConverter {

	private static final String COLON = ":";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		sc.close();
		String hourStr = inputString.substring(0, 2);
		String min = inputString.substring(3, 5);
		String sec = inputString.substring(6, 8);
		boolean isAm = inputString.charAt(8) == 'A';
		if (isAm) {
			getAMTimeInMF(hourStr, min, sec);
		} else {
			getPMTimeInMF(hourStr, min, sec);
		}
	}

	private static void getAMTimeInMF(String hour, String min, String sec) {

		// handle boundary cases: 12 AM is mindnight 00:00:00
		if (hour.equals("12")) {
			hour = "00";
		} 
		System.out.println(hour + COLON + min + COLON + sec);
	}

	private static void getPMTimeInMF(String hour, String min, String sec) {

		// handle boundary cases 12 PM is noon 12:00:00
		if((hour + min + sec).equals("000000")){
			System.out.println("00" + COLON + min + COLON + sec);
		}
	    else if (hour.equals("12")) {
			System.out.println("12" + COLON + min + COLON + sec);
			return;
		} else {
			int hourInt = (Integer.parseInt(hour) + 12) % 24;
			System.out.println(String.valueOf(hourInt) + COLON + min + COLON + sec);
		}
	}

}