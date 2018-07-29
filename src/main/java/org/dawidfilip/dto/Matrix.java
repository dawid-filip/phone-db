package org.dawidfilip.dto;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public enum Matrix {
	
	_1PX("1 Mpx"),
	_2PX("2 Mpx"),
	_3PX("3 Mpx"),
	_5PX("5 Mpx"),
	_13PX("13 Mpx"),
	_20_7PX("20.7 Mpx"),
	_21PX("21 Mpx");
	
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
