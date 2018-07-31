package info.dawidfilip.phone.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import info.dawidfilip.phone.entity.Camera;
import info.dawidfilip.phone.entity.Matrix;
import info.dawidfilip.phone.entity.Phone;
import info.dawidfilip.phone.entity.Resolution;
import info.dawidfilip.phone.entity.Sensor;
import info.dawidfilip.phone.entity.User;

public class PhoneBuilder {
	
	private PhoneBuilder() {
	}
	
	public static Phone creatDummyPhone() {
		return new Phone("Sony", "Xperia Z1 Compact", "L39h, Xperia Z1 HSPA", (short)3000, (short)16, (short)2, null, 
				new Camera("Sony IMX220", Matrix._13PX, Resolution._1920x1080),
				new Camera("Sony IMX220B", Matrix._20_7PX, Resolution._2560x1440)
		);
	}
	
	public static Phone createDummyRandomPhone() {
		return new Phone("Sony_"+randomInt(), "Model_"+randomInt(), "N/A", (short)3000, (short)16, (short)2, null, 
				new Camera("Sony IMX_"+randomInt(), Matrix.getRandomValue(), Resolution.getRandomValue()),
				new Camera("Sony IMX_"+randomInt(), Matrix.getRandomValue(), Resolution.getRandomValue())
		);
	}
	public static Phone createDummyRandomPhoneAndSensor() {
		Phone p = new Phone("Sony_"+randomInt(), "Model_"+randomInt(), "N/A", (short)3000, (short)16, (short)2, null, null, null);
		p.setSensor(new Sensor(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean()));
		p.setCameraFront(new Camera("Sony IMX_"+randomInt(), Matrix.getRandomValue(), Resolution.getRandomValue()));
		p.setCameraBack(new Camera("Sony IMX_"+randomInt(), Matrix.getRandomValue(), Resolution.getRandomValue())); 
		return p;
	}
	
	public static List<Phone> commitDummyPhoneList() {
		Phone phone1 = new Phone("Sony", "Xperia Z1 Compact", "L39h, Xperia Z1 HSPA", (short)3000, (short)16, (short)2, null, null, null);
		Phone phone2 = new Phone("Nokia", "Supra", "-", (short)2400, (short)32, (short)4, null, null, null);
		Phone phone3 = new Phone("LG", "A7", "-", (short)2200, (short)64, (short)6, null, null, null);
		Phone phone4 = new Phone("Xiaomi", "Redmi 4X", "-", (short)3500, (short)128, (short)8, null, null, null);
		Phone phone5 = new Phone("Vita", "WG1", "-", (short)3700, (short)24, (short)3, null, null, null);

		List<Phone> phones = new ArrayList<Phone>();
		phones.add(phone1);
		phones.add(phone2);
		phones.add(phone3);
		phones.add(phone4);
		phones.add(phone5);
		
		return phones;
	}

	public static List<Phone> commitDummyPhoneAndSensorList() {
		List<Phone> phones = commitDummyPhoneList();
		for (Phone p : phones) {
			p.setSensor(new Sensor(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean()));
		}
		return phones;
	}

	private static int randomInt() {
		return new Random().nextInt(100) + 1;
	}
	private static boolean randomBoolean() {
		return new Random().nextBoolean();
	}
	
}
