package GA.Selection;

import GA.Functions.IFitnessFunction;
import GA.IIndividual;
import GA.Individual;

import java.util.ArrayList;
import java.util.Random;

// TODO documentation

// TODO test implementation of Roulette selection
public class Roulette implements ISelection {
    private IFitnessFunction fitnessFunction;

    public Roulette(IFitnessFunction fitnessFunction) {
        this.fitnessFunction = fitnessFunction;
    }

    @Override
    public ArrayList<IIndividual> process(ArrayList<IIndividual> individuals, int numberToSelect) {
        return process(individuals, numberToSelect, new Random().nextInt());
    }

    public ArrayList<IIndividual> process(ArrayList<IIndividual> individuals, int numberToSelect, int seed) {
        ArrayList<Integer> fits = getFitnessArray(individuals);

        int sum = getFitnessArraySum(fits);
        if (sum < 0) {
            sum = 0;
        }
        Random r = new Random(seed);
        int selected;
        ArrayList<IIndividual> selectedIndividuals = new ArrayList<>();
        for (int i = 0; i < numberToSelect; i++) {

            selected = r.nextInt(sum + 1);
            IIndividual selectedIndividual = getSelectedIndividual(fits, individuals, selected);
            selectedIndividuals.add(selectedIndividual);
        }
        return selectedIndividuals;
    }

    private IIndividual getSelectedIndividual(ArrayList<Integer> fits, ArrayList<IIndividual> individuals, int selected) {
        int acc = 0;
        for (int i = 0; i < individuals.size(); i++) {
            acc += fits.get(i);
            if (acc >= selected) {
                return individuals.get(i);
            }
        }
        return null;
    }


    private ArrayList<Integer> getFitnessArray(ArrayList<IIndividual> individuals) {
        ArrayList<Integer> fits = new ArrayList<>();
        for (IIndividual i : individuals) {
            fits.add(fitnessFunction.run(i));
        }
        return fits;
    }

    private int getFitnessArraySum(ArrayList<Integer> fitnessArray) {
        int sum = 0;
        for (Integer num : fitnessArray) {
            if (num >= 0) {
                sum += num;
            }

        }
        return sum;
    }
}
