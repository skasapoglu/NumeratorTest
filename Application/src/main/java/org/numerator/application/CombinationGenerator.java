package org.numerator.application;

import java.util.LinkedList;
import java.util.List;

/**
 * This class generates possible combination of alphabets for the numeric that
 * you see in a telephone dial pad.
 *
 */
public class CombinationGenerator {

	public static String varMap[][] = { { "0" }, { "1" }, { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" },
			{ "J", "K", "L" }, { "M", "N", "O" }, { "P", "Q", "R", "S" }, { "T", "U", "V" }, { "W", "X", "Y", "Z" } };

	public static void methodXYZ(List<String> varABC, String varPref, String varRemain) {
		int varDig = Integer.parseInt(varRemain.substring(0, 1));

		if (varRemain.length() == 1) {
			for (int i = 0; i < varMap[varDig].length; i++) {
				varABC.add(varPref + varMap[varDig][i]);
			}
		} else {
			for (int i = 0; i < varMap[varDig].length; i++) {
				methodXYZ(varABC, varPref + varMap[varDig][i], varRemain.substring(1));
			}
		}
	}

	public static List<String> methodXY(String varPN) {

		List<String> varABC = new LinkedList<String>();

		methodXYZ(varABC, "", varPN);

		return varABC;
	}

}
