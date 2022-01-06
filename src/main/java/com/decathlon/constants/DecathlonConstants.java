package com.decathlon.constants;
/**
 *@author Rohit Bothe 
 */
public enum DecathlonConstants {
	RUN_100_METER(1, 25.4347d, 18d, 1.81d), 
	LONG_JUMP(2, 0.14354d, 220d, 1.4d),
	SHOT_PUT(3, 51.39d, 1.5d, 1.05d), 
	HIGH_JUMP(4, 0.8465d, 75d, 1.42d),
	RUN_400_METER(5,1.53775d, 82d, 1.81d),
	RUN_110_METER_HUDDLES(6, 5.74352d, 28.5d, 1.92d),
	DISC_THROW(7, 12.91d, 4d, 1.1d), 
	POLE_VAULT(8, 0.2797d, 100d, 1.35d),
	JAVELIN_THROW(9, 10.14d, 7d, 1.08d), 
	RUN_1500_METER(10, 0.03768d, 480d, 1.85d);

	public final Integer sequence;
	private Double A;
	private Double B;
	private Double C;

	private DecathlonConstants(Integer sequence, Double a, Double b, Double c) {
		this.sequence = sequence;
		A = a;
		B = b;
		C = c;
	}

	public Integer getSequence() {
		return sequence;
	}

	public Double getA() {
		return A;
	}

	public Double getB() {
		return B;
	}

	public Double getC() {
		return C;
	}

}
