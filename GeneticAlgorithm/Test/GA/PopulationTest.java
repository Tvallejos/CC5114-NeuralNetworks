package GA;

import GA.Functions.IGeneGenerationFunction;
import GA.Functions.stdGeneGenerationFunction;
import GA.Genes.IGene;
import GA.Genes.StringGene;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PopulationTest {
    private Population population;
    private IGeneGenerationFunction geneGenerationFunction;
    private Allele alleleValues;

    @BeforeEach
    void setUp() {
        String s = "1 10 20";
        ArrayList<String> abc = new ArrayList<String>(Arrays.asList(s.split(" ")));
        alleleValues = new Allele(abc);
        IGeneGenerationFunction geneGenerationFunction = new stdGeneGenerationFunction(alleleValues, 5);
        population = new Population( geneGenerationFunction,0);
    }

    @Test
    void constructorTest() {
        assertEquals(5, population.getChromosomeLength());
        assertEquals(0, population.getPopulationSize());
        IGene one = new StringGene("1");
        IGene ten = new StringGene("10");
        IGene twenty = new StringGene("20");
        Allele expectedAllelle = new Allele(new ArrayList<>(List.of("1", "10", "20")));

        expectedAllelle.equals(population.getAlleleValues());
        assertEquals(expectedAllelle, population.getAlleleValues());
        ArrayList<IIndividual> expectedIndividuals = new ArrayList<>();
        assertEquals(expectedIndividuals, population.getIndividuals());
    }

}
