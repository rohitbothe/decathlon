package com.decathlon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.decathlon.constants.Constants;
import com.decathlon.constants.DecathlonConstants;
import com.decathlon.model.DecathlonAthlete;
import com.decathlon.model.DecathlonEvent;
import com.decathlon.util.DecathlonUtil;
/**
 *@author Rohit Bothe 
 */
public class DecathlonService {

	private ArrayList<DecathlonAthlete> athleteAsPerRank = new ArrayList<DecathlonAthlete>();;
	private Integer decathlonAthleterank = 1;
	private Integer decathlonAthleteScore = 0;

	/** 
     * This method creates list of DecathlonAthlete from list of CSV rows. 
     * @param rowsFromCSV Takes input as list of rows form CSV file.
     * @return List<DecathlonAthlete> Gives output as list of DecathlonAthlete.
     */  
	public List<DecathlonAthlete> getDecathlonAthleteList(List<String> rowsFromCSV) {
		List<DecathlonAthlete> decathlonAthletes = new ArrayList<DecathlonAthlete>();
		rowsFromCSV.forEach(rowFromCSV -> {
			decathlonAthletes.add(this.addDecathlonAthleteInList(rowFromCSV));
		});
		decathlonAthletes.sort((decathlonAthlete1, decathlonAthlete2) -> decathlonAthlete2.getAthleteScore()
				.compareTo(decathlonAthlete1.getAthleteScore()));
		this.addRankToDecathlonAthletes(decathlonAthletes);
		return this.athleteAsPerRank;
	}

	/** 
     * This method gives output as single athlete with his total score and includes events information including event score from result. 
     * @param rowFromCSV Takes input as single row form CSV file.
     * @return DecathlonAthlete Gives output as single athlete. 
     */  
	public DecathlonAthlete addDecathlonAthleteInList(String rowFromCSV) {
		String decathlonAthleteName = rowFromCSV.split(Constants.CSV_SEPERATOR.getSeperator())[0];
		String eventResults = rowFromCSV.substring(1 + rowFromCSV.indexOf(Constants.CSV_SEPERATOR.getSeperator()));
		List<DecathlonEvent> decathlonAthleteEventList = new ArrayList<DecathlonEvent>();
		this.decathlonAthleteScore = 0;
		Integer index = 0;
		for (String decathlonEvent : eventResults.split(Constants.CSV_SEPERATOR.getSeperator())) {
			decathlonAthleteEventList.add(this.buildEvent(decathlonEvent, index++));
		}
		return new DecathlonAthlete(decathlonAthleteName, decathlonAthleteEventList, this.decathlonAthleteScore, "0");
	}

	/** 
     * This method add rank to athlete based on his athleteScore.
     * @param decathlonAthletesOldList Takes input as list of all athlete which includes total athleteScore.
     */  
	private void addRankToDecathlonAthletes(List<DecathlonAthlete> decathlonAthletesOldList) {
		List<DecathlonAthlete> decathlonAthletesList = (List<DecathlonAthlete>) decathlonAthletesOldList.stream()
				.filter(decathlonAthlete -> decathlonAthlete.getAthleteRank().compareToIgnoreCase("0") == 0
						&& !this.athleteAsPerRank.contains(decathlonAthlete))
				.collect(Collectors.toList());
		if (decathlonAthletesList != null && decathlonAthletesList.size() > 0) {
			List<DecathlonAthlete> decathlonAthleteWithDuplicateScore = decathlonAthletesOldList.stream()
					.filter(decathlonAthlete -> decathlonAthlete.getAthleteScore()
							.compareTo(decathlonAthletesList.get(0).getAthleteScore()) == 0)
					.collect(Collectors.toList());

			if (decathlonAthleteWithDuplicateScore.size() > 0) {
				String response = "";
				Integer size = this.decathlonAthleterank + decathlonAthleteWithDuplicateScore.size();
				for (Integer i = this.decathlonAthleterank; i < size; i++) {
					response = response + i.toString() + "-";
				}
				response = response.substring(0, response.length() - 1);
				for (Integer i = 0; i < decathlonAthleteWithDuplicateScore.size(); i++) {
					decathlonAthleteWithDuplicateScore.get(i).setAthleteRank(response);
				}
				this.athleteAsPerRank.addAll(decathlonAthleteWithDuplicateScore);
				this.decathlonAthleterank = this.decathlonAthleterank + decathlonAthleteWithDuplicateScore.size();
			} else {
				decathlonAthletesList.get(0).setAthleteRank(this.decathlonAthleterank.toString());
				this.athleteAsPerRank.add(decathlonAthletesList.get(0));
				this.decathlonAthleterank++;
			}
			this.addRankToDecathlonAthletes(decathlonAthletesOldList);
		}
	}

	/** 
     * This method event for athlete and calculate event score and total athleteScore..
     * @param result Takes input as single event result of an athlete.
     * @param index Takes input as sequence number of event.
     */  
	private DecathlonEvent buildEvent(String result, Integer index) {
		DecathlonConstants event = DecathlonConstants.values()[index];
		Integer score = 0;
		switch (event) {
		case RUN_100_METER:
			score = DecathlonUtil.trackEventsScoreCalculation(event.getA(), event.getB(), event.getC(),
					DecathlonUtil.getSecond(result));
			break;
		case LONG_JUMP:
			score = DecathlonUtil.fieldEventsScoreCalculation(event.getA(), event.getB(), event.getC(),
					DecathlonUtil.getCentimeterFromMeter(result));
			break;
		case SHOT_PUT:
			score = DecathlonUtil.fieldEventsScoreCalculation(event.getA(), event.getB(), event.getC(),
					Double.parseDouble(result));
			break;
		case HIGH_JUMP:
			score = DecathlonUtil.fieldEventsScoreCalculation(event.getA(), event.getB(), event.getC(),
					DecathlonUtil.getCentimeterFromMeter(result));
			break;
		case RUN_400_METER:
			score = DecathlonUtil.trackEventsScoreCalculation(event.getA(), event.getB(), event.getC(),
					DecathlonUtil.getSecond(result));
			break;
		case RUN_110_METER_HUDDLES:
			score = DecathlonUtil.trackEventsScoreCalculation(event.getA(), event.getB(), event.getC(),
					DecathlonUtil.getSecond(result));
			break;
		case DISC_THROW:
			score = DecathlonUtil.fieldEventsScoreCalculation(event.getA(), event.getB(), event.getC(),
					Double.parseDouble(result));
			break;
		case POLE_VAULT:
			score = DecathlonUtil.fieldEventsScoreCalculation(event.getA(), event.getB(), event.getC(),
					DecathlonUtil.getCentimeterFromMeter(result));
			break;
		case JAVELIN_THROW:
			score = DecathlonUtil.fieldEventsScoreCalculation(event.getA(), event.getB(), event.getC(),
					Double.parseDouble(result));
			break;
		case RUN_1500_METER:
			score = DecathlonUtil.trackEventsScoreCalculation(event.getA(), event.getB(), event.getC(),
					DecathlonUtil.getSecondsFromMinutesWithSeconds(result));
			break;
		}
		decathlonAthleteScore = decathlonAthleteScore + score;
		return new DecathlonEvent(event.toString(), result, score);
	}
}
