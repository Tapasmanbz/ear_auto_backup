package com.eargo.automation.steps;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		String x = "$3,272.95";
		String y = x.replaceAll("[^.0-9]", ""); 
		DecimalFormat df = new DecimalFormat("###.#");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
//		double a = Double.parseDouble(y);
		String formattedAmount = df.format(Double.parseDouble(y.replaceAll("[^.0-9]", "")));
		double a =  Double.parseDouble(formattedAmount);
		System.out.println(a);
		
		int scale = (int) Math.pow(10, 1);
	    double b = (double) Math.round(3272.95 * scale) / scale;
	    System.out.println(b);

	}
}
