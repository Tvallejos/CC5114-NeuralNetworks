package GA;

import GA.Genes.IGene;

import java.util.ArrayList;

public interface IIndividual {

    ArrayList<IGene> getGenes();
    int getGenesSize();
}
