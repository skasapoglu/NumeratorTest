package org.numerator.test.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.numerator.application.CombinationGenerator;

@RunWith(Parameterized.class)
public class NonNumericInputTest {

	private String testInput;

	public NonNumericInputTest(String inputEntry) {
		this.testInput = inputEntry;
	}

	@Test(expected = Exception.class)
	public void nonNumericFieldsInEntryExceptionThrown() {
		//WHEN
		CombinationGenerator.methodXY(testInput);
	}

	//GIVEN
	@Parameterized.Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] { { "1@23" }, { "1 23" }, { "-127" } });
	}
}
