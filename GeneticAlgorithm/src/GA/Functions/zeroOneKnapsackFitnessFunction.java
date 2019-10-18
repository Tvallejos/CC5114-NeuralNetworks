package GA.Functions;

import GA.Allele;
import GA.IIndividual;

import java.util.ArrayList;

public class zeroOneKnapsackFitnessFunction implements IFitnessFunction {
    private final int capacity;
    private int maximumValue;
    private ArrayList<Pair> items;

    class Pair {
        private int weight;
        private int value;

        public Pair(String s) {
            String[] wv = s.split(",");
            weight = Integer.parseInt(wv[0]);
            value = Integer.parseInt(wv[1]);
        }

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }
    }

    public zeroOneKnapsackFitnessFunction(Allele alleleValues, int capacity) {
        items = getPairList(alleleValues);
        maximumValue = getMaximumValue();
        this.capacity = capacity;
    }

    private int getMaximumValue() {
        return getSumOfValues(items);
    }

    private ArrayList<Pair> getPairList(Allele alleleValues) {
        ArrayList<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < alleleValues.getSize(); i++) {
            pairList.add(new Pair(alleleValues.get(i)));
        }
        return pairList;
    }

    private int getSumOfValues(ArrayList<Pair> pairList) {
        int acc = 0;
        for (int i = 0; i < pairList.size(); i++) {
            acc += pairList.get(i).value;
        }
        return acc;
    }

    @Override
    public int run(IIndividual ind) {
        int value = 0;
        int weight = 0;

        for (int i = 0; i < items.size(); i++) {
            value += items.get(i).getValue() * ind.getGenes().get(i).getIntValue();
            weight += items.get(i).getWeight() * ind.getGenes().get(i).getIntValue();
        }

        if (weight <= capacity) {
            return value;
        } else return 0;

    }

    @Override
    public boolean solutionFound(int fitness) {
        return fitness == maximumValue;
    }
}
