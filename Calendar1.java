/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	public static void main(String args[]) {
		
	    int debugDaysCounter = 0; 
		int countFirst = 0;
	    
	 	while (year < 2000) {
			// print days with or without sunday
	 		if(dayOfWeek % 7 == 1){
				System.out.println(dayOfMonth + "/" + month + "/" + year + " sunday");
				// compute if the first day of mouth is sunday
				if(dayOfMonth == 1){
					countFirst++;
				}
			}
			else{
				System.out.println(dayOfMonth + "/" + month + "/" + year);
			}
			debugDaysCounter++;
			advance();
        }
		System.out.println("During the 20th century, " + countFirst + " Sundays fell on the first day of the month");
	 	System.out.println(debugDaysCounter);
	 }
	
	 private static void advance() {
		// add one day to month
		dayOfMonth++;
		// add a day from 1 - 7
		if(dayOfWeek <7){
			dayOfWeek++;
		}
		else{
			dayOfWeek = 1;
		}
		// change month and change the day of the month to zero
		if(dayOfMonth > nDaysInMonth(month, year)){
			// if the year ends add one to year and change month to 1
			if(month == 12){
				year++;
				month = 1;
			}
			// add one to month
			else{
				month++;
			}
			// restart day of month
			dayOfMonth = 1;
		}
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    boolean isLeapYear;
		// Checks if the year is divisible by 400
		isLeapYear = ((year % 400) == 0);

		// Then checks if the year is divisible by 4 but not by 100
		isLeapYear = isLeapYear || (((year % 4) == 0) && ((year % 100) != 0));

		return isLeapYear;
	}
	 
	
	private static int nDaysInMonth(int month, int year) {
		int numOfDay = 0;
		switch (month) {
			case 1: numOfDay = 31;
			break;
			case 2: if(isLeapYear(year))
						numOfDay = 29; // leap year
					else 
						numOfDay = 28;
			break;
			case 3: numOfDay = 31;
			break;
			case 4: numOfDay = 30;
			break;
			case 5: numOfDay = 31;
			break;
			case 6: numOfDay = 30;
			break;
			case 7: numOfDay = 31;
			break;
			case 8: numOfDay = 31;
			break;
			case 9: numOfDay = 30;
			break;
			case 10: numOfDay = 31;
			break;
			case 11: numOfDay = 30;
			break;
			case 12: numOfDay = 31;
			break;
	}
	return numOfDay;
	}
}

