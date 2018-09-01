package org.numerator.test.framework;

import java.util.LinkedList;
import java.util.List;

public class TestUtil {

	public static String alphaMap[][] = { { "0" }, { "1" }, { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" },
			{ "J", "K", "L" }, { "M", "N", "O" }, { "P", "Q", "R", "S" }, { "T", "U", "V" }, { "W", "X", "Y", "Z" } };

	/**
	 * Returns the one possible alphabetical items for the number
	 * 
	 * @param number
	 *            given number
	 * @return array of alphabetical items
	 */
	public static String[] elementsOf(int number) {

		return alphaMap[number];

	}

	/**
	 * Returns the list of elements in given telephone pad map
	 * 
	 * @return
	 */

	public static List<String> getAlphabets() {

		List<String> alphabetList = new LinkedList<String>();

		for (int i = 0; i < alphaMap.length; i++) {
			for (int j = 0; j < alphaMap[i].length; j++) {
				alphabetList.add(alphaMap[i][j]);
			}
		}

		return alphabetList;
	}

}
