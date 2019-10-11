package GA;

import GA.Genes.IGene;
import GA.Genes.StringGene;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


//TODO Population multi individual test
public class PopulationTest {
    private Population population;

    @BeforeEach
    void setUp() {
        population = new Population(5,3, new ArrayList<>(List.of("1", "10", "20")),0);
    }

    @Test
    void constructorTest(){
        assertEquals(5,population.getChromosomeLength());
        assertEquals(3,population.getPopulationSize());
        IGene one = new StringGene("1");
        IGene ten = new StringGene("10");
        IGene twenty = new StringGene("20");
        Allele expectedAllelle = new Allele(new ArrayList<>(List.of("1","10","20")));

        expectedAllelle.equals(population.getAlleleValues());
        assertEquals(expectedAllelle,population.getAlleleValues());

        ArrayList<IGene> expected1 = new ArrayList<>(List.of(ten,ten,one,one,twenty));
        ArrayList<IGene> expected2 = new ArrayList<>(List.of(ten,one,one,twenty,twenty));
        ArrayList<IGene> expected3 = new ArrayList<>(List.of(ten,one,ten,twenty,twenty));

        ArrayList<Individual> expectedIndividuals = new ArrayList<>(
                List.of(
                        new Individual(expected1),
                        new Individual(expected2),
                        new Individual(expected3)));
        assertEquals(expectedIndividuals,population.getIndividuals());
    }

}
