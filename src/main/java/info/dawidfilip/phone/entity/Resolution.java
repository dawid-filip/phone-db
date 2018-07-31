package info.dawidfilip.phone.entity;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public enum Resolution {
	
	_640x480("640×480"),
	_1280x720("1280×720 px"),
	_1920x1080("1920x1080 px"),
	_2560x1440("2560x1440 px");
	
	private String value;

	Resolution(final String value) {
		this.value = value;
	}
	
	public static Resolution getRandomValue() {
		List<Resolution> somethingList = new ArrayList<Resolution>(EnumSet.allOf(Resolution.class));
		int random = new Random().nextInt(somethingList.size());
		return somethingList.get(random);
	}
	
	@Override
	public String toString() {
		return value + " test test";
	}

}
