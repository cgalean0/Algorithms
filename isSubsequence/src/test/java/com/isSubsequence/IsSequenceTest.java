package com.isSubsequence;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class IsSequenceTest {
	
	public static Stream<Arguments> testProvider() {
		return Stream.of(
			Arguments.of("abc", "ahbgdc", true),
			Arguments.of("aex", "ahbgdc", false),
			Arguments.of("axc", "ahbgdc", false),
			Arguments.of("acb", "ahbgdc", false)
		);
	}


	@ParameterizedTest
	@MethodSource("testProvider")
	public void greedyIsSequenceTest(String s, String t, boolean expected) {
		boolean respGreedy = IsSubsequence.isSubsequenceGreedy(s, t);
		assertEquals(expected, respGreedy);
	}
	@ParameterizedTest
	@MethodSource("testProvider")
	public void pdIsSequenceTest(String s, String t, boolean expected) {
		boolean respDP = IsSubsequence.isSubsequenceDP(s, t);
		assertEquals(expected, respDP);
	}
}