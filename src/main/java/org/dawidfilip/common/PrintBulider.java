package org.dawidfilip.common;

import java.util.List;

public class PrintBulider {
	public static final void print(Object object) {
		System.out.println(object.toString());
	}
	public static final void print(List<?> list) {
		System.out.println(list.toString());
	}
}
