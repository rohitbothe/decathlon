package com.decathlon.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DecathlonUtilTest {

	@Test
	public void trackEventsScoreCalculationTest() {
		double a = 25.4347, b = 18.0, c = 1.81, p = 12.61;
		Integer score1 = 537;
		Integer score = DecathlonUtil.trackEventsScoreCalculation(a, b, c, p);
		assertEquals(score1, score);
	}

	@Test
	public void fieldEventsScoreCalculationTest() {
		double a = 12.91, b = 4.0, c = 1.1, p = 24.89;
		Integer score1 = 365;
		Integer score = DecathlonUtil.fieldEventsScoreCalculation(a, b, c, p);
		assertEquals(score1, score);
	}

	@Test
	public void substractTest() {
		Double a = 20.5, b = 10.0;
		Double score1 = 10.5;
		Double score = DecathlonUtil.substract(a, b);
		assertEquals(score1, score);
	}

	@Test
	public void getCentimeterFromMeterTest() {
		String meter = "400";
		Double centimeter = (double) 40000;
		assertEquals(centimeter,DecathlonUtil.getCentimeterFromMeter(meter));
	}

	@Test
	public void getSecondsFromMinutesWithSecondsTest() {
		String result = "6.50.76";
		Double centimeter = 410.76;
		assertEquals(centimeter,DecathlonUtil.getSecondsFromMinutesWithSeconds(result));
	}

	@Test
	public void getSecondTest() {
		String result = "66.06";
		Double centimeter = 66.06;
		assertEquals(centimeter,DecathlonUtil.getSecond(result));
	}

}
