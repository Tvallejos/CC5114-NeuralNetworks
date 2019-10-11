package GA;

import GA.Genes.IGene;
import GA.Genes.StringGene;

import java.util.ArrayList;

public class Individual {

    private ArrayList<IGene> chromosome;

    public Individual(ArrayList<IGene> Genes) {
        this.chromosome = Genes;
    }


    public ArrayList<IGene> getGenes(){
        return chromosome;
    }

    public boolean equals(Object o){
        if(o instanceof Individual){
            boolean accumulated = true;
            for(int i = 0; i<chromosome.size();i++){
                accumulated = accumulated && chromosome.get(i).equals(((Individual) o).getGenes().get(i));
            }
            return accumulated;
        }
        return false;
    }
}
