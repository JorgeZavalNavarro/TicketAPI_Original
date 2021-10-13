package com.enlacetpe.ticketapi.caMapper.serviceDesk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Period;

import com.enlacetpe.ticketapi.response.CATicket;



public class CADate {	
	
	public static String unixDate(Date date) {
		Long l = date.getTime()/1000;
		return l.toString();
	}
	
	public static String convertCADate(String caDate) {
		String userDate = null;
		Long parsed = Long.parseLong(caDate);
		Date javaDate = new Date(parsed * 1000L);
		SimpleDateFormat formatter = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		userDate = formatter.format(javaDate);
		return userDate;
	}

	public static ArrayList<CATicket> filterTicketsByDate(ArrayList<CATicket> list, Integer year, Integer month) throws ParseException {		
		ArrayList<CATicket> listFiltered = new ArrayList<CATicket>();
		for(CATicket ticket: list) {
			SimpleDateFormat formatter = 
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = formatter.parse(ticket.getOpenTime());
			DateTime time = new DateTime(date);
			if(time.getYear() == year 
					&& time.getMonthOfYear() == month)
				listFiltered.add(ticket);
		}
		
		DateTime date = new DateTime();
		date.getYear();
		date.getMonthOfYear();
		
		return listFiltered;
	}
	
	public static String secToTime(String sec) {
		System.out.println(sec);
		Period period = Period.seconds(Integer.parseInt(sec)).normalizedStandard();
		System.out.println(period);
		String hour = twoDigits("" + period.getHours());
		String min = twoDigits("" + period.getMinutes());
		String seconds = twoDigits("" + period.getSeconds());		
		return "" + hour + ":" + min + ":" + seconds;		
	}
	
	private static String twoDigits(String string) {
		String converted = string;
		if(string.length() < 2) {
			converted = "0" + converted;
		}
		return converted;
	}
}
