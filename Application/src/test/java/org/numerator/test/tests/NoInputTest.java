package org.numerator.test.tests;

import org.junit.Test;
import org.numerator.application.CombinationGenerator;

public class NoInputTest {
	
	@Test(expected = Exception.class)
	public void emptryStringInEntryExceptionThrown() {
		
		//GIVEN
		String testInput = "";
		
		//WHEN
		CombinationGenerator.methodXY(testInput);
	}

}
