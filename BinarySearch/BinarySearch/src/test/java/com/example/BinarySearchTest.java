package com.example;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    @ParameterizedTest
    @MethodSource("provideBinarySearchTestData")
    void testBinarySearch(int[] array, int target, int expected) {
        assertEquals(expected, BinarySearch.search(array, target));
    }

    @ParameterizedTest
    @MethodSource("provideBinarySearchTestData")
    void testRecursiveBinarySearch(int[] array, int target, int expected) {
        assertEquals(expected, RecursiveBinarySearch.recursivesearch(array, target));
    }

    private static Stream<Arguments> provideBinarySearchTestData() {
        return Stream.of(
            // Basic functionality tests (1-10)
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 3, 2),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 1, 0),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 5, 4),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, 1),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 4, 3),
            
            // Element not found tests (11-15)
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 6, -1),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 0, -1),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, -1, -1),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 10, -1),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, -5, -1),
            
            // Edge cases with empty and single-element arrays (16-20)
            Arguments.of(new int[]{}, 1, -1),
            Arguments.of(new int[]{}, 0, -1),
            Arguments.of(new int[]{1}, 1, 0),
            Arguments.of(new int[]{1}, 2, -1),
            Arguments.of(new int[]{1}, 0, -1),
            
            // Even-sized arrays (21-25)
            Arguments.of(new int[]{1, 2, 3, 4}, 1, 0),
            Arguments.of(new int[]{1, 2, 3, 4}, 2, 1),
            Arguments.of(new int[]{1, 2, 3, 4}, 3, 2),
            Arguments.of(new int[]{1, 2, 3, 4}, 4, 3),
            Arguments.of(new int[]{1, 2, 3, 4}, 5, -1),
            
            // Odd-sized arrays (26-30)
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 4, 3),
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 1, 0),
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 7, 6),
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 8, -1),
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 0, -1),
            
            // Large arrays (31-35)
            Arguments.of(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}, 11, 5),
            Arguments.of(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}, 1, 0),
            Arguments.of(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}, 19, 9),
            Arguments.of(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}, 8, -1),
            Arguments.of(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}, 20, -1),
            
            // Negative numbers (36-40)
            Arguments.of(new int[]{-5, -4, -3, -2, -1}, -3, 2),
            Arguments.of(new int[]{-5, -4, -3, -2, -1}, -5, 0),
            Arguments.of(new int[]{-5, -4, -3, -2, -1}, -1, 4),
            Arguments.of(new int[]{-5, -4, -3, -2, -1}, 0, -1),
            Arguments.of(new int[]{-5, -4, -3, -2, -1}, -6, -1),
            
            // Mixed positive and negative numbers (41-45)
            Arguments.of(new int[]{-3, -2, -1, 0, 1, 2, 3}, 0, 3),
            Arguments.of(new int[]{-3, -2, -1, 0, 1, 2, 3}, -3, 0),
            Arguments.of(new int[]{-3, -2, -1, 0, 1, 2, 3}, 3, 6),
            Arguments.of(new int[]{-3, -2, -1, 0, 1, 2, 3}, -1, 2),
            Arguments.of(new int[]{-3, -2, -1, 0, 1, 2, 3}, 4, -1),
            
            // Large value tests (46-50)
            Arguments.of(new int[]{100, 200, 300, 400, 500}, 300, 2),
            Arguments.of(new int[]{100, 200, 300, 400, 500}, 100, 0),
            Arguments.of(new int[]{100, 200, 300, 400, 500}, 500, 4),
            Arguments.of(new int[]{100, 200, 300, 400, 500}, 250, -1),
            Arguments.of(new int[]{100, 200, 300, 400, 500}, 600, -1)
        );
    }

    // // Additional test method for duplicate elements (if your implementation handles them)
    // @ParameterizedTest
    // @MethodSource("provideDuplicateElementsTestData")
    // void testBinarySearchWithDuplicates(int[] array, int target, int expected) {
    //     // Note: Binary search behavior with duplicates may vary
    //     // This test assumes it returns any valid index where the element is found
    //     int result = BinarySearch.search(array, target);
    //     if (expected != -1) {
    //         assertTrue(result >= 0 && result < array.length);
    //         assertEquals(target, array[result]);
    //     } else {
    //         assertEquals(-1, result);
    //     }
    // }

    // private static Stream<Arguments> provideDuplicateElementsTestData() {
    //     return Stream.of(
    //         Arguments.of(new int[]{1, 2, 2, 2, 3}, 2, 2), // Should find one of the 2's
    //         Arguments.of(new int[]{1, 1, 1, 1, 1}, 1, 2), // All elements same
    //         Arguments.of(new int[]{1, 2, 3, 3, 4, 5}, 3, 3), // Duplicate in middle
    //         Arguments.of(new int[]{1, 1, 2, 3, 4}, 1, 1), // Duplicate at beginning
    //         Arguments.of(new int[]{1, 2, 3, 4, 4}, 4, 4)  // Duplicate at end
    //     );
    // }
}