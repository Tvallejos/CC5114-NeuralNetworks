package GA.Functions;

import GA.Functions.IFitnessFunction;
import GA.Genes.IGene;
import GA.Individual;

import java.util.ArrayList;

public class wordFitnessFunction implements IFitnessFunction {
    private String secretWord;

    public wordFitnessFunction(String secretWord) {
        this.secretWord = secretWord;
    }

    @Override
    public int run(Individual i) {
        String input = inputToString(i.getGenes());
        return fitnessCalculation(input);
    }

    private int fitnessCalculation(String input){
        int fitness = 0;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == input.charAt(i)) {
                fitness++;
            }
        }
        return fitness;
    }

    @Override
    public boolean solutionFound(int fitness) {
        return fitness == secretWord.length();
    }

    private String inputToString(ArrayList<IGene> s) {
        String ans = "";//opsies i didnt used string builder
        for (IGene gene : s) {
            ans = ans + gene.getStringValue();
        }
        return ans;
    }
}
