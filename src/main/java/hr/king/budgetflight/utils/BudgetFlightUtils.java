package hr.king.budgetflight.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Component;

import hr.king.budgetflight.exception.BudgetFlightException;

@Component
public class BudgetFlightUtils {

	public String oneWayToString(Boolean oneWay) {
		return oneWay ? "Yes" : "No";
	}
	
	public String nonHomogeneousToString(Boolean nonHomogeneous) {
		return nonHomogeneous ? "Yes" : "No";
	}
	
	public String instantTicketingToString(Boolean instantTicketing) {
		return instantTicketing ? "Yes" : "No";
	}
	
	public String dbDateToString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");  
		String strDate = dateFormat.format(date);  
		return strDate;
	}
	
	public String dbDateTimeToString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");  
		String strDate = dateFormat.format(date);  
		return strDate;
	}
	
	public Date amadeusDateTimeStringToDate(String date) {
		Instant instant = Instant.parse(date+"Z");
		return Date.from(instant);
	}

	public Date amadeusDateStringToDate(String date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			throw new BudgetFlightException(e.getMessage());
		}
	}
	
	public String dateToAmadeusString(Date date){
		DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
		return targetFormat.format(date);
	}
	
	
}
