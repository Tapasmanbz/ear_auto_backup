package com.eargo.automation.steps;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		int x = 4;
		x += (x++) + (++x) + x;
		System.out.println(x);
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEEEE, MMMMM d, yyyy");
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);
	}
}
