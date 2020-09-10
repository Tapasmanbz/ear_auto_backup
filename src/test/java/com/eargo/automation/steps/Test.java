package com.eargo.automation.steps;

import java.util.Scanner;

public class Test {
	String str, nstr = "";
	char ch;
	int c, i, l = 0;

	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String:");
		str = sc.nextLine();
		sc.close();
	}

	void compute() {
		str = ". " + str;
		l = str.length();
		for (i = 0; i < l; i++) {
			ch = str.charAt(i);
			if (ch == ' ') {
				c = c + 1;
				if ((c == 1) || (c==2))
					nstr = nstr + str.charAt(i + 1) + ".";
				if ((c == 3))
					nstr = nstr + str.substring(i + 1, l);
			}			
		}
	}

	void display() {
		System.out.println("New String=" + nstr);
	}

	public static void main(String[] args) {
		Test ob = new Test();
		ob.input();
		ob.compute();
		ob.display();
	}
}
