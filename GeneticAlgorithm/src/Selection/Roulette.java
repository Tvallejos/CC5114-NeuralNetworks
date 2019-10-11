package Selection;

import GA.Individual;

import java.util.ArrayList;
// TODO urgente
public class Roulette implements ISelection{
    private ArrayList<Integer> probs;

    @Override
    public void Process(ArrayList<Individual> individuals) {

    }

    @Override
    public boolean isSelected(Individual individual) {
        return false;
    }
}
