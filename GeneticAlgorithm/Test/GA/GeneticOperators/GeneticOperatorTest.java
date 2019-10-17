package GA.GeneticOperators;

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
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GeneticOperatorTest {
    private GeneticOperator geneticOperator;
    private ArrayList<IIndividual> individuals;
    private IGene red,green,blue;

    @BeforeEach
    void Setup() {
        ArrayList<String> allele = new ArrayList<>(Arrays.asList("red", "green", "blue"));
        geneticOperator = new GeneticOperator(0.5, new Allele(allele));

        red = new StringGene("red");
        green = new StringGene("green");
        blue = new StringGene("blue");

        ArrayList<IGene> genes1 = new ArrayList<>(List.of(red, red, red));
        ArrayList<IGene> genes2 = new ArrayList<>(List.of(green,green,green));
        ArrayList<IGene> genes3 = new ArrayList<>(List.of(blue,blue,blue));

        individuals = new ArrayList<>(
                List.of(
                        new Individual(genes1),
                        new Individual(genes2),
                        new Individual(genes3)));
    }

    @Test
    void reproduceSizeTest() {
        ArrayList<IIndividual> reproducedIndividuals = geneticOperator.reproduce(individuals,5,0);
        assertEquals(individuals.size()+5,reproducedIndividuals.size());
    }

    @Test
    void crossOver() {
        // on seed 0 first random int value with 3 as limit
        // 0

        IIndividual crossOverIndividual = geneticOperator.crossOver(individuals.get(0),individuals.get(1),0);
        IIndividual expectedIndividual = new Individual(new ArrayList<>(List.of(green,green,green)));
        assertEquals(expectedIndividual,crossOverIndividual);

        // on seed 2 first random int value with 3 as limit is
        // 1

        IIndividual crossOverIndividual2 = geneticOperator.crossOver(individuals.get(1),individuals.get(2),2);
        IIndividual expectedIndividual2 = new Individual(new ArrayList<>(List.of(green,blue,blue)));
        assertEquals(expectedIndividual2,crossOverIndividual2);

    }


    @Test
    void mutation() {
        IIndividual notExpectedToMutate = new Individual(new ArrayList<>(List.of(red,red,red)));
        IIndividual notMutated = geneticOperator.mutation(individuals.get(0),0);
        assertEquals(notExpectedToMutate,notMutated);

        IIndividual expectedIndividual = new Individual(new ArrayList<>(List.of(green,red,red)));
        IIndividual mutatedIndividual = geneticOperator.mutation(individuals.get(0),1);
        assertEquals(expectedIndividual,mutatedIndividual);
    }
}