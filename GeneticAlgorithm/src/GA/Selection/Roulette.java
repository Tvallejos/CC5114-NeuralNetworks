package GA.Selection;

import GA.Functions.IFitnessFunction;
import GA.Individual;

import java.util.ArrayList;
import java.util.Random;

// TODO urgente
public class Roulette implements ISelection {
    private IFitnessFunction fitnessFunction;

    public Roulette(IFitnessFunction fitnessFunction) {
        this.fitnessFunction = fitnessFunction;
    }

    @Override
    public ArrayList<Individual> process(ArrayList<Individual> individuals, int numberToSelect) {
        ArrayList<Integer> fits = getFitnessArray(individuals);
        int sum = getFitnessArraySum(fits);
        Random r = new Random();
        int selected;
        ArrayList<Individual> selectedIndividuals = new ArrayList<>();
        for (int i = 0; i < numberToSelect; i++) {
            selected = r.nextInt(sum);
            Individual selectedIndividual = getSelectedIndividual(fits, individuals, selected);
            selectedIndividuals.add(selectedIndividual);
        }
        return selectedIndividuals;
    }

    private Individual getSelectedIndividual(ArrayList<Integer> fits, ArrayList<Individual> individuals, int selected) {
        int acc = 0;
        for (int i = 0; i < individuals.size(); i++) {
            acc += fits.get(i);
            if (acc >= selected) {
                return individuals.get(i);
            }
        }
        return null;
    }


    private ArrayList<Integer> getFitnessArray(ArrayList<Individual> individuals) {
        ArrayList<Integer> fits = new ArrayList<>();
        for (Individual i : individuals) {
            fits.add(fitnessFunction.run(i));
        }
        return fits;
    }

    private int getFitnessArraySum(ArrayList<Integer> fitnessArray) {
        int sum = 0;
        for (Integer num : fitnessArray) {
            sum += num;
        }
        return sum;
    }
}
