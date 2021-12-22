package lesson3.exercise_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
		
		Date date = dateFromLocalDate(LocalDate.of(1970, 1, 1));
		int numHours = -1; //implement
		//output numHours to the console
		LocalDate ldate = LocalDate.of(1970, 1, 2);
		System.out.println(dateFromLocalDate(ldate));

	}

	public static Date dateFromLocalDate(LocalDate localDate) {
		//implement
		GregorianCalendar calendar = gregorianCalendarFromLocalDate(localDate);
		Date d = calendar.getTime();		
		return d;
	}
	
	public static GregorianCalendar gregorianCalendarFromLocalDate(LocalDate locDate) {
		return new GregorianCalendar(locDate.getYear(), locDate.getMonth().getValue()-1, locDate.getDayOfMonth());
	}
}
