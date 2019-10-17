package GA;

import GA.Genes.IGene;
import GA.Genes.StringGene;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IndividualTest {

    private Individual individual;

    @BeforeEach
    void Setup(){
        StringGene[] stringGenes = {new StringGene("red"),new StringGene("red"),new StringGene("blue")};
        ArrayList<IGene> genesList = new ArrayList<>(Arrays.asList(stringGenes));
        individual = new Individual(genesList);
    }

    @Test
    void checkGenesTest(){
        ArrayList<IGene> stringGenes = individual.getGenes();
        assertEquals("red", stringGenes.get(0).getStringValue());
        assertEquals("red", stringGenes.get(1).getStringValue());
        assertEquals("blue", stringGenes.get(2).getStringValue());
    }

    @Test
    void equalTest(){
        StringGene[] sameGenes = {new StringGene("red"),new StringGene("red"),new StringGene("blue")};
        ArrayList<IGene> genesList = new ArrayList<>(Arrays.asList(sameGenes));
        Individual otherIndividual = new Individual(genesList);
        assertTrue(individual.equals(otherIndividual));

    }
}
