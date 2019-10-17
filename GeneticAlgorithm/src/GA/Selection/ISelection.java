package GA.Selection;

import GA.IIndividual;

import java.util.ArrayList;

public interface ISelection {
    ArrayList<IIndividual> process(ArrayList<IIndividual> individuals, int numberToSelect);
}
