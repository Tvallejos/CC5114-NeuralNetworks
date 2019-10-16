package GA;

import GA.Genes.IGene;

import java.util.ArrayList;

public class Individual implements IIndividual {

    private ArrayList<IGene> chromosome;

    public Individual(ArrayList<IGene> Genes) {
        this.chromosome = Genes;
    }


    public ArrayList<IGene> getGenes(){
        return chromosome;
    }

    @Override
    public int getGenesSize() {
        return chromosome.size();
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
