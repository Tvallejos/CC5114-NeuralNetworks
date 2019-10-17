package GA.Functions;

import GA.Allele;
import GA.Genes.IGene;
import GA.Genes.StringGene;
import GA.IIndividual;
import GA.Individual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneGenerationFunctionTest {
    private wordGeneGenerationFunction geneGenerationFunction;

    @BeforeEach
    void Setup() {
        String s = "1 10 20";
        ArrayList<String> abc = new ArrayList<String>(Arrays.asList(s.split(" ")));
        Allele alleleValues = new Allele(abc);
        geneGenerationFunction = new wordGeneGenerationFunction(alleleValues, 5);
    }

    @Test
    void expectedGenerationTest() {
        ArrayList<IIndividual> generatedIndividuals = geneGenerationFunction.initializePopulation(0, 3);
        IGene one = new StringGene("1");
        IGene ten = new StringGene("10");
        IGene twenty = new StringGene("20");
        Allele expectedAllelle = new Allele(new ArrayList<>(List.of("1", "10", "20")));
        assertTrue(expectedAllelle.equals(geneGenerationFunction.getAlleleValues()));

        ArrayList<IGene> expected1 = new ArrayList<>(List.of(ten, ten, one, one, twenty));
        ArrayList<IGene> expected2 = new ArrayList<>(List.of(ten, one, one, twenty, twenty));
        ArrayList<IGene> expected3 = new ArrayList<>(List.of(ten, one, ten, twenty, twenty));

        ArrayList<IIndividual> expectedIndividuals = new ArrayList<>(
                List.of(
                        new Individual(expected1),
                        new Individual(expected2),
                        new Individual(expected3)));
        assertEquals(expectedIndividuals, generatedIndividuals);
    }

}
