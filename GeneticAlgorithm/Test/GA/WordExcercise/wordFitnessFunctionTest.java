package GA.WordExcercise;

import GA.Functions.IFitnessFunction;
import GA.Functions.wordFitnessFunction;
import GA.Genes.StringGene;
import GA.Individual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class wordFitnessFunctionTest {
    private IFitnessFunction wff;
    private Individual cow;

    @BeforeEach
    void setUp() {
        wff = new wordFitnessFunction("cat");

        cow = new Individual(new ArrayList<>(List.of(
                new StringGene("c"),
                new StringGene("o"),
                new StringGene("w"))));
    }

    @Test
    void run() {
        Individual poz = new Individual(new ArrayList<>(List.of(
                new StringGene("p"),
                new StringGene("o"),
                new StringGene("z"))));

        Individual gaz = new Individual(new ArrayList<>(List.of(
                new StringGene("g"),
                new StringGene("a"),
                new StringGene("z"))));


        assertEquals(1, wff.run(cow));
        assertEquals(0, wff.run(poz));
        assertEquals(1, wff.run(gaz));
    }

    @Test
    void solutionFound() {
        assertFalse(wff.solutionFound(wff.run(cow)));

        Individual cat = new Individual(new ArrayList<>(List.of(
                new StringGene("c"),
                new StringGene("a"),
                new StringGene("t"))));

        assertTrue(wff.solutionFound(wff.run(cat)));
    }
}