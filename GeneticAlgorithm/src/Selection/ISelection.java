package Selection;

import GA.Individual;

import java.util.ArrayList;

public interface ISelection {
    ArrayList<Individual> process(ArrayList<Individual> individuals,int numberToSelect);
}
