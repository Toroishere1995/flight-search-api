package com.learning.flightsearchapi.util;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.learning.flightsearchapi.dto.FlightConnectingResult;

/**
 * Util class that converts String to Time and handles if wait is between 1 to
 * 10 hours.
 * 
 * @author ayushsaxena
 *
 */
public class ConversionUtil {

	/**
	 * Method that converts string to time and do the processing job.
	 * 
	 * @param connectingResult
	 * @return
	 */
	public static int convertToTimeAndAddDuration(FlightConnectingResult connectingResult) {
		String sourceTime = connectingResult.getFlightTimeAtSource();
		String midTime = connectingResult.getFlightTimeAtMid();
		sourceTime = sourceTime.substring(0, 2) + ":" + sourceTime.substring(2);
		midTime = midTime.substring(0, 2) + ":" + midTime.substring(2);
		connectingResult.setFlightTimeAtSource(sourceTime);
		connectingResult.setFlightTimeAtMid(midTime);
		DateFormat formatter = new SimpleDateFormat("HH:mm");
		try {
			double timeTillMid = connectingResult.getTimeFromSource() * 60 * 60 * 1000;
			long timeTillMidJunction = (long) timeTillMid;
			long addedJourneyFromStartToMid = formatter.parse(sourceTime).getTime() + timeTillMidJunction;
			long time = formatter.parse(midTime).getTime() - addedJourneyFromStartToMid;
			System.out.println(time);
			long diffSec = time / 1000;
			double min = (double) (diffSec) / 60;
			double hours = ((min)) / 60;

			if (hours < 1.0 || hours > 10.0) {
				return 0;
			}
			connectingResult.setTotalTime(connectingResult.getTotalTime() + hours);
			System.out.println(hours);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
}
