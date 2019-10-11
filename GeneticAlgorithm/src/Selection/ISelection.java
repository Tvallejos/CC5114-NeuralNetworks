package Selection;

import GA.Individual;

import java.util.ArrayList;

public interface ISelection {
    void Process(ArrayList<Individual> individuals);
    boolean isSelected(Individual individual);
}
