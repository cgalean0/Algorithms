package com.knapsack;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import java.util.List;
import java.util.LinkedList;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.knapsack.Article;

/**
 * Test for the changeProblem class
 * using parameterized tests.
 * 
 * @author cgalean0
 * */
public class KnapSackTest {

    public static Stream<Arguments> argumentProvider() {
       return Stream.of(
            Arguments.of(
                new Article[] {new Article("Computadora", 20, 500),
                               new Article("Joyas", 5, 1000),
                               new Article("Dientes de la abuela", 2, 300),
                               new Article("Televisor", 50, 3000),
                               new Article("Aspiradora", 10, 60)
                                }, 30, new LinkedList<String>(List.of("Joyas", "Computadora", "Dientes de la abuela"))),
            Arguments.of(
                new Article[] {new Article("Computadora", 5, 800),
                               new Article("Joyas", 3, 1000),
                               new Article("Dientes de la abuela", 2, 300),
                               new Article("Televisor", 50, 3000),
                               new Article("Aspiradora", 10, 60)
                                }, 50, new LinkedList<String>(List.of("Televisor"))),
            Arguments.of(
                new Article[] {new Article("Computadora", 25, 800),
                               new Article("Joyas", 3, 1000),
                               new Article("Dientes de la abuela", 3, 300),
                               new Article("Televisor", 50, 3000),
                               new Article("Aspiradora", 10, 60)
                                }, 3, new LinkedList<String>(List.of("Joyas"))),
            Arguments.of(
                new Article[] {new Article("Computadora", 25, 800),
                               new Article("Joyas", 3, 1000),
                               new Article("Dientes de la abuela", 3, 300),
                               new Article("Televisor", 50, 3000),
                               new Article("Aspiradora", 10, 60)
                                }, 0, null)
        );
    }


    @ParameterizedTest
    @MethodSource("argumentProvider")
    public void knapsackGreedyTest(Article[] articles, int bagWeight, List<String> expected) {
        List<String> result = KnapSack.knapsackGreedy(articles, bagWeight);
        assertEquals(result, expected);
    }
}