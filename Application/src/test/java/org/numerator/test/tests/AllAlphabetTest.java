package org.numerator.test.tests;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.numerator.application.CombinationGenerator;
import org.numerator.test.framework.TestRunner;


public class AllAlphabetTest {

	@Test
	public void eachNumberInEntryAllAlphaCharsOccursAtLeastOnce() {

		// GIVEN
		List<String> inputs = Arrays.asList(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" });

		// WHEN
		List<String> testResults = new LinkedList<String>();
		for (int i = 0; i < inputs.size(); i++) {
			testResults.addAll(CombinationGenerator.methodXY(inputs.get(i)));
		}

		// THEN
		Assert.assertTrue("There is missing alphabet element between [A-Z]", TestRunner.isAllAlphabetical(testResults));

	}

}
