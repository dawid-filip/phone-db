package org.dawidfilip.dto;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public enum Resolution {
	
	VGA_640x480("640×480"),
	HD_1280x720("1280×720 px"),
	FHD_1920x1080("1920x1080 px"),
	WQHD_2560x1440("2560x1440 px");
	
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
		return value;
	}

}
