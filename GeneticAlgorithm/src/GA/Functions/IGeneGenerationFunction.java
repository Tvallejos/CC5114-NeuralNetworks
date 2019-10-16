package GA.Functions;

import GA.Allele;
import GA.Genes.IGene;

import java.util.ArrayList;

public interface IGeneGenerationFunction {
    IGene generateGene();
    ArrayList<IGene> generateGenes(int numberOfGenes);
}
