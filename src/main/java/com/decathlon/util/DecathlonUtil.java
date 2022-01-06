package com.decathlon.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *@author Rohit Bothe 
 */
public class DecathlonUtil {

	/** 
     * Calculates score of track event based on formula A*(B-P)^C. 
     * @param a,b,c, and p where a,b, and c are standard constants and p is result of event.
     * @return score of track event.
     */  
	public static Integer trackEventsScoreCalculation(double a, double b, double c, double p) {
		return (int) Math.round(a * (Math.pow(DecathlonUtil.substract(b, p), c)));
	}

	/** 
     * Calculates score of field event based on formula A*(P-B)^C. 
     * @param a,b,c, and p where a,b, and c are standard constants and p is result of event.
     * @return score of track event.
     */  
	public static Integer fieldEventsScoreCalculation(double a, double b, double c, double p) {
		return (int) Math.round(a * (Math.pow(DecathlonUtil.substract(p, b), c)));
	}

	/** 
     * Basic substraction method. 
     * @param a,b input of substraction.
     * @return result of substraction.
     */
	public static double substract(double a, double b) {
		if (a > b) {
			return a - b;
		} else {
			return b - a;
		}
	}

	/** 
     * Converts meter to centimeter. 
     * @param input in meter.
     * @return result in centimeter.
     */
	public static Double getCentimeterFromMeter(String meter) {
		return 100 * Double.parseDouble(meter);
	}

	/** 
     * Get seconds form minutes + seconds. 
     * @param time in string.
     * @return time in seconds.
     */
	public static Double getSecondsFromMinutesWithSeconds(String result) {

		Double seconds = 0d;
		try {
			Calendar calender = Calendar.getInstance();
			calender.setTime(new SimpleDateFormat("mm.ss.SS").parse(result));
			seconds = calender.get(Calendar.MINUTE) * 60 + calender.get(Calendar.SECOND)
					+ ((double) calender.get(Calendar.MILLISECOND)) / 100;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//System.out.println(result+" "+seconds);
		return seconds;
	}

	/** 
     * Get seconds in double. 
     * @param time in string.
     * @return time in only seconds.
     */
	public static Double getSecond(String result) {
		return Double.parseDouble(result);
	}
}
