package com.decathlon.constants;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DecathlonConstantsTest {

	@Test
	public void verify100MeterRun() {
		Double a=25.4347d, b=18d, c=1.81d;
		assertEquals(a,DecathlonConstants.RUN_100_METER.getA());
		assertEquals(b,DecathlonConstants.RUN_100_METER.getB());
		assertEquals(c,DecathlonConstants.RUN_100_METER.getC());
	}
	
	@Test
	public void verifyLongJump() {
		Double a=0.14354d, b=220d, c=1.4d;
		assertEquals(a,DecathlonConstants.LONG_JUMP.getA());
		assertEquals(b,DecathlonConstants.LONG_JUMP.getB());
		assertEquals(c,DecathlonConstants.LONG_JUMP.getC());
	}
	
	@Test
	public void verifyShotPut() {
		Double a=51.39d, b=1.5d, c=1.05d;
		assertEquals(a,DecathlonConstants.SHOT_PUT.getA());
		assertEquals(b,DecathlonConstants.SHOT_PUT.getB());
		assertEquals(c,DecathlonConstants.SHOT_PUT.getC());
	}
	
	@Test
	public void verifyHighJump() {
		Double a=0.8465d, b=75d, c=1.42d;
		assertEquals(a,DecathlonConstants.HIGH_JUMP.getA());
		assertEquals(b,DecathlonConstants.HIGH_JUMP.getB());
		assertEquals(c,DecathlonConstants.HIGH_JUMP.getC());
	}
	
	@Test
	public void verify400MeterRun() {
		Double a=1.53775d, b=82d, c=1.81d;
		assertEquals(a,DecathlonConstants.RUN_400_METER.getA());
		assertEquals(b,DecathlonConstants.RUN_400_METER.getB());
		assertEquals(c,DecathlonConstants.RUN_400_METER.getC());
	}
	
	@Test
	public void verify100MeterHuddlesRun() {
		Double a=5.74352d, b=28.5d, c=1.92d;
		assertEquals(a,DecathlonConstants.RUN_110_METER_HUDDLES.getA());
		assertEquals(b,DecathlonConstants.RUN_110_METER_HUDDLES.getB());
		assertEquals(c,DecathlonConstants.RUN_110_METER_HUDDLES.getC());
	}
	
	@Test
	public void verifyDiscThrow() {
		Double a=12.91d, b=4d, c=1.1d;
		assertEquals(a,DecathlonConstants.DISC_THROW.getA());
		assertEquals(b,DecathlonConstants.DISC_THROW.getB());
		assertEquals(c,DecathlonConstants.DISC_THROW.getC());
	}
	
	@Test
	public void verifyPoleVault() {
		Double a=0.2797d, b=100d, c=1.35d;
		assertEquals(a,DecathlonConstants.POLE_VAULT.getA());
		assertEquals(b,DecathlonConstants.POLE_VAULT.getB());
		assertEquals(c,DecathlonConstants.POLE_VAULT.getC());
	}
	
	@Test
	public void verifyJavalinThrow() {
		Double a=10.14d, b=7d, c=1.08d;
		assertEquals(a,DecathlonConstants.JAVELIN_THROW.getA());
		assertEquals(b,DecathlonConstants.JAVELIN_THROW.getB());
		assertEquals(c,DecathlonConstants.JAVELIN_THROW.getC());
	}
	
	@Test
	public void verify1500MeterRun() {
		Double a=0.03768d, b=480d, c=1.85d;
		assertEquals(a,DecathlonConstants.RUN_1500_METER.getA());
		assertEquals(b,DecathlonConstants.RUN_1500_METER.getB());
		assertEquals(c,DecathlonConstants.RUN_1500_METER.getC());
	}
	
}
