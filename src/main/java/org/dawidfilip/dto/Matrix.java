package org.dawidfilip.dto;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public enum Matrix {
	
	M_1PX("1 Mpx"),
	M_2PX("2 Mpx"),
	M_3PX("3 Mpx"),
	M_5PX("5 Mpx"),
	M_13PX("13 Mpx"),
	M_20_7PX("20.7 Mpx");
	
	private final String value;

	Matrix(final String value) {
		this.value = value;
	}

	public static Matrix getRandomValue() {
		List<Matrix> somethingList = new ArrayList<Matrix>(EnumSet.allOf(Matrix.class));
		int random = new Random().nextInt(somethingList.size());
		return somethingList.get(random);
	}
	
	@Override
	public String toString() {
		return value;
	}
	
}
