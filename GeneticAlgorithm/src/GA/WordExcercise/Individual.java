package GA.WordExcercise;

import GA.Genes.StringGene;

import java.util.ArrayList;

public class Individual {

    private ArrayList<StringGene> chromosome;

    public Individual(ArrayList<StringGene> stringGenes) {
        this.chromosome = stringGenes;
    }

    public ArrayList<StringGene> getGenes(){
        return chromosome;
    }
}
