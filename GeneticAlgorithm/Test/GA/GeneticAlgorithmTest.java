package GA;

import GA.Functions.wordFitnessFunction;
import GA.Functions.wordGeneGenerationFunction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

//TODO implement GA Tests

public class GeneticAlgorithmTest {
    private GeneticAlgorithm wordGA;

    @BeforeEach
    void setUp() {
        wordGA = new GeneticAlgorithm(5,
                new wordFitnessFunction("cat"),
                new wordGeneGenerationFunction(
                        new Allele(
                                new ArrayList<>(List.of("a", "b", "c", "d", "t"))),
                        3),
                0.4,
                10, 0);
    }

    @Test
    void constructorTest() {
        assertEquals(5, wordGA.getPopulationSize());
        assertEquals(5, wordGA.getIndividuals().size());
        assertEquals(10, wordGA.getMaxIter());
    }

    @Test
    void evaluateFitness() {
        wordGA.evaluateFitness();
        ArrayList<Integer> expectedFits = new ArrayList<>(List.of(0, 0, 1, 1, 0));
        assertEquals(expectedFits, wordGA.getFits());
        assertFalse(wordGA.isSolutionFound());
    }

    @Test
    void selection() {
        wordGA.selection();
        assertEquals(2, wordGA.getIndividuals().size());
        ;
    }

    @Test
    void reproduction() {
        wordGA.reproduction();
        assertEquals(5, wordGA.getIndividuals().size());
    }

    // TODO assert run test of GA
    /*@Test
    void run() {
        wordGA.run();
    }
    
     */
}
