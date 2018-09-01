package org.numerator.test.tests;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.numerator.application.CombinationGenerator;
import org.numerator.test.framework.TestRunner;


@RunWith(Parameterized.class)
public class MatchTest {

	private String testInput;

	public MatchTest(String inputEntry) {
		this.testInput = inputEntry;
	}

	@Test
	public void selectedEntriesGeneratesEquallyMatchedCombinations() {

		//GIVEN
		TestRunner.populateWith(testInput);

		//WHEN
		List<String> testResults = new LinkedList<String>();
		testResults = CombinationGenerator.methodXY(testInput);

		//THEN
		Assert.assertTrue("The generated combinations do not match", TestRunner.isExactMatch(testResults));

	}
	
	

	@Parameterized.Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] { { "1" }, { "00" }, { "2" }, { "34" }, { "567" }, { "2458" }, { "34568" },
				{ "234568" }, { "9" }, { "77" }, { "027" }, { "139" }, { "047" }, { "159" }, { "067" }, { "189" } });
	}

}
