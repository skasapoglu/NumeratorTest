package org.numerator.test.framework;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Class to represent the test executor to go over the test steps and verify the
 * expected conditions
 * 
 * @author Sabahattin Kasapoglu
 *
 */
public class TestRunner {

	private static TreeBuilder treeBuilder;

	/**
	 * Method to populate the
	 * 
	 * @param string
	 */
	public static void populateWith(String inputEntry) {

		if (Pattern.matches("\\D", inputEntry)) {
			throw new IllegalArgumentException("Each of given entry values has to be between [0-9]");
		}

		int firstElement = Integer.parseInt(inputEntry.substring(0, 1));
		treeBuilder = new TreeBuilder(firstElement);

		for (int i = 1; i < inputEntry.length(); i++) {
			treeBuilder.addNumber(Integer.parseInt(inputEntry.substring(i, i + 1)));
		}

	}

	/**
	 * Counts all of the possible combinations
	 * 
	 * @return number of possible combinations for given entry
	 * @throws TestFrameworkException if no element exists
	 */
	public static int totalPopulatedElements() {
		int result = 0;

		if (treeBuilder != null) {

			result = treeBuilder.countOfCombinations();

		} else {
			throw new NoSuchElementException("Tree builder has not populated with input entry");
		}

		return result;
	}

	/**
	 * Calculates the possible combinations with multiplying the Cartesian of each
	 * numbers.
	 * 
	 * @param entry the input entry
	 * @return the possible combination count with given entry
	 */
	public static int totalExpectedCombinations(String entry) {

		int totalCount = 1;

		for (int i = 0; i < entry.length(); i++) {

			totalCount *= TestUtil.elementsOf(Integer.parseInt(entry.substring(i, i + 1))).length;
		}

		return totalCount;
	}

	/**
	 * Verifies if the generated test results are matched with the calculated
	 * results
	 * 
	 * @param testResults given list of combinations
	 * @return {@True} if all the elements match {@False} otherwise
	 */
	public static boolean isExactMatch(List<String> testResults) {

		List<String> generatedCombinations = treeBuilder.getCombinations();

		generatedCombinations.removeIf(testResults::contains);

		return generatedCombinations.size() == 0;
	}

	/**
	 * Verifies if the elements generated as test results are unique
	 * 
	 * @param testResults given list of combinations
	 * @return {@True} if all elements unique {@False} otherwise
	 */
	public static boolean hasAllUniqueItems(List<String> testResults) {

		List<String> generatedCombinations = treeBuilder.getCombinations();

		Set<String> set = new LinkedHashSet<String>();
		set.addAll(testResults);

		return set.size() == generatedCombinations.size();
	}

	/**
	 * Verifies if all the alphabet elements including "0" & "1" are exists
	 * 
	 * @param testResults
	 * @return {@link True} if all the elements have the alphabetic characters
	 */
	public static boolean isAllAlphabetical(List<String> testResults) {

		List<String> alphabets = TestUtil.getAlphabets();

		alphabets.removeIf(testResults::contains);

		return alphabets.size() == 0;
	}

}
