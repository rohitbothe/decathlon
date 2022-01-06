package com.decathlon.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.decathlon.constants.DecathlonConstants;
import com.decathlon.model.DecathlonAthlete;

public class DecathlonServiceTest {

	DecathlonService service;
	List<String> rowsFromCSV;

	@Before
	public void init() {
		service = new DecathlonService();
		rowsFromCSV = new ArrayList<String>();
		rowsFromCSV.add("John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72");
		rowsFromCSV.add("Jane Doe;13.04;4.53;7.79;1.55;64.72;18.74;24.20;2.40;28.20;6.50.76");
		rowsFromCSV.add("Jaan Lepp;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75");
		rowsFromCSV.add("Foo Bar;13.43;4.35;8.64;1.50;66.06;19.05;24.89;2.20;33.48;6.51.01");
	}

	@Test
	public void getDecathlonAthleteListTest() {
		try {
			List<DecathlonAthlete> athletes = service.getDecathlonAthleteList(this.rowsFromCSV);
			assertNotNull(athletes);
			assumeTrue(athletes.size() > 1);
			Integer score = 4205;
			assertEquals( "John Smith",athletes.get(0).getAthleteName());
			assertEquals( "1",athletes.get(0).getAthleteRank());
			assertEquals(score,athletes.get(0).getAthleteScore());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addDecathlonAthleteInListTest() {
		DecathlonAthlete athlete = service.addDecathlonAthleteInList(rowsFromCSV.get(0));
		assertNotNull(athlete);
		Integer score = 4205;
		assumeTrue(athlete.getAthleteName() != null);
		assertEquals( "John Smith",athlete.getAthleteName());
		assertEquals( "0",athlete.getAthleteRank());
		assertEquals(score,athlete.getAthleteScore());
		assertNotNull(athlete.getEvents());
		assumeTrue(athlete.getEvents().size() == 10);
	}
	
	@Test
	public void decathlonAthleteInEventsSequenceTest() {
		DecathlonAthlete athlete = service.addDecathlonAthleteInList(rowsFromCSV.get(0));
		assertNotNull(athlete);
		assumeTrue(athlete.getEvents().size() == 10);
		assertEquals(athlete.getEvents().get(0).getName(), DecathlonConstants.RUN_100_METER.toString());
		assertEquals(athlete.getEvents().get(1).getName(), DecathlonConstants.LONG_JUMP.toString());
		assertEquals(athlete.getEvents().get(2).getName(), DecathlonConstants.SHOT_PUT.toString());
		assertEquals(athlete.getEvents().get(3).getName(), DecathlonConstants.HIGH_JUMP.toString());
		assertEquals(athlete.getEvents().get(4).getName(), DecathlonConstants.RUN_400_METER.toString());
		assertEquals(athlete.getEvents().get(5).getName(), DecathlonConstants.RUN_110_METER_HUDDLES.toString());
		assertEquals(athlete.getEvents().get(6).getName(), DecathlonConstants.DISC_THROW.toString());
		assertEquals(athlete.getEvents().get(7).getName(), DecathlonConstants.POLE_VAULT.toString());
		assertEquals(athlete.getEvents().get(8).getName(), DecathlonConstants.JAVELIN_THROW.toString());
		assertEquals(athlete.getEvents().get(9).getName(), DecathlonConstants.RUN_1500_METER.toString());
	}
	
	@After
	public void destroy() {
		rowsFromCSV = null;
	}
}
