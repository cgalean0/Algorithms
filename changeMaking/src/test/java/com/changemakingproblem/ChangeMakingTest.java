package com.changemakingproblem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ChangeMakingTest {
	
	private static Stream<Arguments> changeMakingProviderDivide() {
		return Stream.of(
			Arguments.of(new int[]{1, 5, 10, 15}, 10, 1),
			Arguments.of(new int[]{1, 5,10, 20}, 13, 4)
		);
	}

	private static Stream<Arguments> changeMakingProviderPD() {
		return Stream.of(
			Arguments.of(new int[]{1, 5, 10, 500}, 1500, 3),
			Arguments.of(new int[]{1, 10, 20, 100}, 150, 4),
			Arguments.of(new int[]{1, 3, 4}, 6, 2)
		);
	}


	@ParameterizedTest
	@MethodSource("changeMakingProviderDivide")
	public void changeMakingTestDivide(int[] denominations, int change, int expected) {
		int cmr = ChangeMaking.changemakingproblemDivideAndConquer(denominations, change);
		assertEquals(expected, cmr);
	}

	@ParameterizedTest
	@MethodSource("changeMakingProviderPD")
	public void changeMakingTestPD(int[] denominations, int change, int expected) {
		int cmr = ChangeMaking.changemakingproblemPD(denominations, change);
		assertEquals(expected, cmr);
	}

}
