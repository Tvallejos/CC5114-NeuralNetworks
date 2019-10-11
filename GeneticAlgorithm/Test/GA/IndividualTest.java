package GA;

import GA.Genes.StringGene;
import GA.WordExcercise.Individual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndividualTest {

    private Individual individual;

    @BeforeEach
    void Setup(){
        StringGene[] stringGenes = {new StringGene("red"),new StringGene("red"),new StringGene("blue")};
        ArrayList<StringGene> genesList = new ArrayList<>(Arrays.asList(stringGenes));
        individual = new Individual(genesList);
    }

    @Test
    void checkGenesTest(){
        ArrayList<StringGene> stringGenes = individual.getGenes();
        assertEquals("red", stringGenes.get(0).getStringValue());
        assertEquals("red", stringGenes.get(1).getStringValue());
        assertEquals("blue", stringGenes.get(2).getStringValue());
    }
}
