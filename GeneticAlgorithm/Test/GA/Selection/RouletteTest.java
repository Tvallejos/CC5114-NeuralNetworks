package GA.Selection;

import GA.Allele;
import GA.Functions.wordFitnessFunction;
import GA.Genes.IGene;
import GA.Genes.StringGene;
import GA.GeneticOperators.GeneticOperator;
import GA.IIndividual;
import GA.Individual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RouletteTest {
    private ArrayList<IIndividual> individuals;
    private IGene red, green, blue;
    private Roulette roulette;

    @BeforeEach
    void setUp() {
        setUpIndividuals();
        setUpRoulette();
    }

    void setUpRoulette() {
        roulette = new Roulette(new wordFitnessFunction("rrb"));
    }

    void setUpIndividuals() {
        red = new StringGene("r");
        green = new StringGene("g");
        blue = new StringGene("b");

        ArrayList<IGene> genes1 = new ArrayList<>(List.of(red, red, red));
        ArrayList<IGene> genes2 = new ArrayList<>(List.of(green, green, green));
        ArrayList<IGene> genes3 = new ArrayList<>(List.of(blue, blue, blue));

        individuals = new ArrayList<>(
                List.of(
                        new Individual(genes1),
                        new Individual(genes2),
                        new Individual(genes3)));
    }

    @Test
    void process() {
        ArrayList<IIndividual> expectedSelected = new ArrayList<>(List.of(
                new Individual(new ArrayList<>(List.of(red, red, red))),
                new Individual(new ArrayList<>(List.of(blue, blue, blue))))
        );
        ArrayList<IIndividual> selectedIndividuals = roulette.process(individuals,2,0);
        assertEquals(expectedSelected,selectedIndividuals);
    }
}